public class SearchDFS extends Search {
    public SearchDFS(boolean isGraph) {
        super(isGraph);
    }

    @Override
    public void execute() {
        search();
        maxMemoryUse = path.size() * 4; //int size in java: 4 bytes
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
            search(problem.nextState(node, action));
            if (answer != null) {
                path.add(node.act);
                return;
            }
        }
    }
}
