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
        maxMemoryUse = path.size() * 4; //int size in java: 4 bytes
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
            if (isGraph) {
                boolean temp = false;
                for (State nod : e) {
                    if (nod.equals(problem.nextState(node, action))) {
                        temp = true;
                        break;
                    }
                }
                if (temp) continue;
            }
            nodeSeen++;
            if (isGraph)
                e.add(node);
            search(problem.nextState(node, action), depth + 1);
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
