import java.util.Comparator;

/**
 * greedy best first search algorithm
 *
 * @author Ali ArjomandBigdeli
 * @since 12.27.2018
 */
public class SearchGreedyBFS extends Search {
    public SearchGreedyBFS(boolean isGraph) {
        super(isGraph);
    }

    @Override
    public void execute() {
        f.add(problem.getInitialState());
        search();
        maxMemoryUse = (nodeSeen - nodeExpand)* nodeSize;
    }

    @Override
    public void search() {
        while (!f.isEmpty()) {
            State s = f.remove();
            nodeExpand++;
            if (problem.goalTest(s)) {
                answer = s;
                State temp = s;
                while (temp != null) {
                    path.add(temp.act);
                    temp = temp.parent;
                }
                return;
            }

            for (Integer action : problem.actions(s)) {
                if (isGraph) {
                    boolean temp = false;
                    for (State node : e) {
                        if (node.equals(problem.nextState(s, action))) {
                            temp = true;
                            break;
                        }
                    }
                    if (temp) continue;
                }
                nodeSeen++;

                f.add(problem.nextState(s, action));
            }

            f.sort(new Comparator<State>() {
                @Override
                public int compare(State s1, State s2) {
                    return ((Integer) problem.h(s1)).
                            compareTo(problem.h(s2));
                }
            });

            if (isGraph)
                e.add(s);

        }
    }
}
