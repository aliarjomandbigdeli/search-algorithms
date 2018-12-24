
import java.util.ArrayList;

public class Problem {
    private int[][] map;
    private State initialState;
    private State initialStateR;    //initial state for recursive mode
    private State goalState;

    public State getInitialState() {
        return initialState;
    }

    public boolean GoalTest(State state) {
        return state == goalState;
    }

    public Problem() {
        initializeProblem();
    }

    public ArrayList<Integer> nextStates(State state) {
        ArrayList<Integer> actions = new ArrayList<>();
        for (int i = 0; i < map[state.getId()].length; i++) {
            if (map[state.getId()][i] == 0)
                actions.add(i);
        }
        return actions;
    }

    public int stepCost(State firstState, State secondState) {
        if (map[firstState.getId()][secondState.getId()] != 0)
            return map[firstState.getId()][secondState.getId()];
        else
            return -1;
    }

    public int stepCost(int firstState, int secondState) {
        return stepCost(new State(firstState), new State(secondState));
    }

    public int pathCost(ArrayList<Integer> path) {
        int cost = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            cost += stepCost(path.get(i), path.get(i + 1));
        }
        return cost;
    }

    private void initializeProblem() {
        initialState = new State(0);
        goalState = new State(12);
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
