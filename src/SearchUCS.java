import java.util.Comparator;

/**
 * uniform cost search algorithm
 * it sort frontier list by pathCost and an extra check in case a shorter path to a frontier state is discovered
 *
 * @author Ali ArjomandBigdeli
 * @since 12.27.2018
 */
public class SearchUCS extends Search {
    public SearchUCS(boolean isGraph) {
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
                public int compare(State o1, State o2) {
                    return ((Integer) o1.pathCost).compareTo(o2.pathCost);
                }
            });

            maxNodeKeptInMemory = Integer.max(maxNodeKeptInMemory, f.size() + e.size());

        }
    }


}
