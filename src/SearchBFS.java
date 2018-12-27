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
        f.add(problem.getInitialState());
        search();
        maxMemoryUse = (nodeSeen - nodeExpand)* nodeSize;
    }

    @Override
    public void search() {
        while (!f.isEmpty()) {
            State s = f.remove();
//            System.out.println("id: " + ((NavState) s).getId());
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
                nodeSeen++;
//                System.out.println("action: " + action);
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
//                System.out.println("newly added: " + ((NavState) problem.nextState(s, action)).getId());
                f.add(problem.nextState(s, action));
            }

            if (isGraph)
                e.add(s);

        }

    }
}
