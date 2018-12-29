/**
 * Depth First Search(DFS) algorithm
 * this implementation is the recursive version
 *
 * @author Ali ArjomandBigdeli
 * @since 12.27.2018
 */
public class SearchDFS extends Search {
    public SearchDFS(boolean isGraph) {
        super(isGraph);
    }

    @Override
    public void execute() {
        search();
    }

    public void search() {
        search(problem.getInitialState());
    }

    /**
     * @param node refers to parent node
     */
    public void search(State node) {
        if (problem.goalTest(node)) {
            answer = node;
            path.add(node.act);
            return;
        }
        if (!isGraph && cycleDetection(node)) {
            System.out.println("cycle detected, algorithm can't solve this problem");
            return;
        }

        nodeExpand++;
        for (Integer action : problem.actions(node)) {
            State child = problem.nextState(node, action);
            nodeSeen++;
            if (isGraph) {
                if(e.contains(child)){
                    continue;
                }
                e.add(node);
            }
            search(child);

            maxNodeKeptInMemory = Integer.max(maxNodeKeptInMemory, f.size() + e.size());
            if (answer != null) {
                path.add(node.act);
                return;
            }
        }
    }


    private boolean cycleDetection(State node) {
        State temp = node;
        while (temp != null) {
            temp = temp.parent;
            if (temp != null && temp.equals(node))
                return true;
        }
        return false;
    }
}
