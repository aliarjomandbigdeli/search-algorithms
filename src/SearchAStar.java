import java.util.Comparator;

public class SearchAStar extends Search {
    public SearchAStar(boolean isGraph) {
        super(isGraph);
    }

    @Override
    public void execute() {
        f.add(problem.getInitialState());
        search();
    }

    @Override
    public void search() {
        while (! f.isEmpty() ) {
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
                        if (node.equals(problem.nextState(s, action)) ) {
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
                public int compare(State o1, State o2) {
                    return 0;
                }
            });


        }
    }
}
