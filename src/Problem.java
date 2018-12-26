import java.util.ArrayList;
import java.util.List;

public abstract class Problem {
    protected State initialState;
    protected State initialStateR;  //initial state for recursive mode
    protected State goalState;

    public State getInitialState() {
        return initialState;
    }

    abstract public boolean goalTest(State state);

    abstract public ArrayList<Integer> actions(State state);

    abstract public State nextState(State state, int action);

    abstract public int stepCost(State firstState, int action, State secondState);

    abstract public int pathCost(List<Integer> path);

    //heuristic function
    public int h(State state){
        return 0;
    }
}
