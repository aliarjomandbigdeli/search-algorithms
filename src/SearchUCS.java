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
                public int compare(State o1, State o2) {
                    return ((Integer) problem.stepCost(o1.parent, o1.act, o1)).
                            compareTo(problem.stepCost(o2.parent, o2.act, o2));
                }
            });

//            System.out.println("sorted f: ");
//            for (State state : f) {
//                System.out.print(((NavState) state).getId() + ", ");
//            }
//            System.out.println();

            if (isGraph)
                e.add(s);

        }
    }

}
