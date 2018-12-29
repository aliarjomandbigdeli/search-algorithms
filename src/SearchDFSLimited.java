/**
 * Depth First Search(DFS) limited depth algorithm
 *
 * @author Ali ArjomandBigdeli
 * @since 12.27.2018
 */
public class SearchDFSLimited extends Search {
    protected int depth;

    public SearchDFSLimited(boolean isGraph, int depth) {
        super(isGraph);
        if (depth < 0)
            System.out.println("invalid depth");
        else
            this.depth = depth;
    }

    @Override
    public void execute() {
        search();
    }

    @Override
    public void search() {
        search(problem.getInitialState(), 0);
    }

    /**
     * @param node  refer to parent node
     * @param depth
     */
    public void search(State node, int depth) {
        if (depth > this.depth) return;

        if (problem.goalTest(node)) {
            answer = node;
            path.add(node.act);
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

            search(child, depth + 1);

            maxNodeKeptInMemory = Integer.max(maxNodeKeptInMemory, f.size() + e.size());
            if (answer != null) {
                path.add(node.act);
                return;
            }
        }
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
