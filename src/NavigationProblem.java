
import java.util.ArrayList;
import java.util.List;

public class NavigationProblem extends Problem {
    private int[][] map;

    public NavigationProblem() {
        initializeProblem();
    }


    public boolean goalTest(State state) {
        return goalState.equals(state);
    }

    @Override
    public ArrayList<Integer> actions(State state) {
        ArrayList<Integer> actions = new ArrayList<>();
        for (int i = 0; i < map[((NavState) state).getId()].length; i++) {
            if (map[((NavState) state).getId()][i] != 0) {
                if (state.parent != null) {
                    if (i != ((NavState) state.parent).getId())
                        actions.add(i);
                } else
                    actions.add(i);
            }
        }
        return actions;
    }

    @Override
    public State nextState(State state, int action) {
        if (actions(state).contains(action)) {
            NavState nextState = new NavState(action);
            nextState.parent = state;
            nextState.act = action;
            return nextState;
        } else
            return null;
    }

    @Override
    public int stepCost(State firstState, int action, State secondState) {
        return stepCost(firstState, secondState);
    }

    public int stepCost(State firstState, State secondState) {
        if (firstState instanceof NavState && secondState instanceof NavState) {
            if (map[((NavState) firstState).getId()][((NavState) secondState).getId()] != 0)
                return map[((NavState) firstState).getId()][((NavState) secondState).getId()];
            else
                return -1;
        } else
            return -1;
    }

    public int stepCost(int firstState, int secondState) {
        return stepCost(new NavState(firstState), new NavState(secondState));
    }

    @Override
    public int pathCost(List<Integer> path) {
        int cost = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            cost += stepCost(path.get(i), path.get(i + 1));
        }
        return cost;
    }

    private void initializeProblem() {
        initialState = new NavState(0);
        goalState = new NavState(12);
        map = new int[][]{
                {0, 75, 0, 140, 118, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {75, 0, 71, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 71, 0, 151, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {140, 0, 151, 0, 0, 0, 0, 0, 0, 80, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0},
                {118, 0, 0, 0, 0, 111, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 111, 0, 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 70, 0, 75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 75, 0, 120, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 120, 0, 146, 138, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 80, 0, 0, 0, 0, 146, 0, 97, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 138, 97, 0, 0, 101, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0, 211, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 101, 211, 0, 90, 85, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 85, 0, 0, 98, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 98, 0, 86, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 142, 0, 0, 0, 92, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 92, 0, 87},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 87, 0}
        };
    }


}
