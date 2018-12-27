import java.util.ArrayList;
import java.util.Comparator;

/**
 * A* search algorithm
 *
 * @author Ali ArjomandBigdeli
 * @since 12.27.2018
 */
public class SearchAStar extends Search {
    public SearchAStar(boolean isGraph) {
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
                public int compare(State s1, State s2) {
                    ArrayList<Integer> path1 = new ArrayList<>();
                    ArrayList<Integer> path2 = new ArrayList<>();
                    State temp = s1;
                    while (temp != null) {
                        path1.add(temp.act);
                        temp = temp.parent;
                    }
                    temp = s2;
                    while (temp != null) {
                        path2.add(temp.act);
                        temp = temp.parent;
                    }
                    return ((Integer) (problem.pathCost(path1) + problem.h(s1))).
                            compareTo(problem.pathCost(path2) + problem.h(s2));
                }
            });

            if (isGraph)
                e.add(s);

        }
    }
}
