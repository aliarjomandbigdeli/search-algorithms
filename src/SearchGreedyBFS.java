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
        search();
    }

    @Override
    public void search() {
        f.add(problem.getInitialState());
        nodeSeen++;
        while (!f.isEmpty()) {
            showLists();
            State s = f.remove();
            if (problem.goalTest(s)) {
                answer = s;
                State temp = s;
                while (temp != null) {
                    path.add(temp.act);
                    temp = temp.parent;
                }
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
                    }
                } else {
                    if (!f.contains(child)) {
                        f.add(child);
                    }
                }
            }
            f.sort(new Comparator<State>() {
                @Override
                public int compare(State s1, State s2) {
                    return ((Integer) (problem.h(s1))).compareTo(problem.h(s2));
                }
            });

            maxNodeKeptInMemory = Integer.max(maxNodeKeptInMemory, f.size() + e.size());

        }
    }
}
