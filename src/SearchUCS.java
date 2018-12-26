//package search;

import com.sun.istack.internal.Nullable;

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
            State tt=f.peek();
            State s = f.remove();
            if(tt.equals(s)){
                System.out.println("I 'm happy");
            }
            nodeExpand++;
//            if (problem.goalTest(s)) {
            if (problem.goalState == s) {
                answer = s;
                State temp = s;
                while (temp != null) {
                    path.add(temp.getAct());
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

//            f.sort(new Comparator<>);


//            f.sort([ &](const void*a, const void*b){
//			const State * first = static_cast <const State * > (a);
//			const State * second = static_cast <const State * > (b);
//                return problem -> stepCost(first -> par, first -> act, first) <
//                        problem -> stepCost(second -> par, second -> act, second);
//            });

            e.add(s);

        }
    }

}
