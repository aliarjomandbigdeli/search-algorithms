/**
 * Breath First Search(BFS) algorithm
 *
 * @author Ali ArjomandBigdeli
 * @since 12.27.2018
 */
public class SearchBFS extends Search {

    public SearchBFS(boolean isGraph) {
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
            if (isGraph)
                e.add(s);
            nodeExpand++;


            for (Integer action : problem.actions(s)) {
                State child = problem.nextState(s, action);
                nodeSeen++;
                if (isGraph) {
                    if (!e.contains(child) && !f.contains(child)) {
                        if (problem.goalTest(child)) {
                            answer = child;
                            createSolutionPath(child);
                            return;
                        }
                        f.add(child);
                    }
                } else {
                    if (problem.goalTest(child)) {
                        answer = child;
                        createSolutionPath(child);
                        return;
                    }
                    f.add(child);
                }
            }

            maxNodeKeptInMemory = Integer.max(maxNodeKeptInMemory, f.size() + e.size());
        }

    }
}
