//package search;

import java.util.Comparator;

//uniform cost search
public class SearchUCS extends Search {
    public SearchUCS(boolean isGraph) {
        super(isGraph);
    }

    @Override
    public void execute() {
        f.add(problem.getInitialState());
        search();
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

                public int compare(State first, State second) {
                    return ((Integer) problem.stepCost(first.parent, first.act, first)).
                            compareTo(problem.stepCost(second.parent, second.act, second));

                }
            });

            if (isGraph)
                e.add(s);

        }
    }

}
