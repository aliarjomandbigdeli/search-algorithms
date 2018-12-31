import java.util.Comparator;

/**
 * A* search algorithm
 * It evaluates nodes by combining the cost to reach the node(pathCost),
 * and h(n), the cost to get from the node to the goal.
 *
 * @author Ali ArjomandBigdeli
 * @since 12.27.2018
 */
public class SearchAStar extends Search {
    public SearchAStar(boolean isGraph) {
        super(isGraph);
    }

    @Override
    public void execute() {
        search();
    }

    @Override
    public void search() {
        f.add(problem.getInitialState());
        nodeSeen++;
        while (!f.isEmpty()) {
            State s = f.remove();
            if (problem.goalTest(s)) {
                answer = s;
                createSolutionPath(s);
                return;
            }

            if (isGraph)
                e.add(s);
            nodeExpand++;

            for (Integer action : problem.actions(s)) {
                State child = problem.nextState(s, action);
                nodeSeen++;
                if (isGraph) {
                    if (!e.contains(child) && !f.contains(child)) {
                        f.add(child);
                    } else if (f.contains(child)) {
                        //if child is in frontier with higher PATH-COST then replace that frontier node with child
                        State temp = f.get(f.indexOf(child));
                        if (temp.pathCost > child.pathCost) {
                            temp.parent = child.parent;
                            temp.pathCost = child.pathCost;
                        }
                    }
                } else {
                    f.add(child);
                }
            }

            f.sort(new Comparator<State>() {
                @Override
                public int compare(State s1, State s2) {
                    return ((Integer) (s1.pathCost + problem.h(s1))).
                            compareTo(s2.pathCost + problem.h(s2));
                }
            });

            maxNodeKeptInMemory = Integer.max(maxNodeKeptInMemory, f.size() + e.size());

        }
    }
}
