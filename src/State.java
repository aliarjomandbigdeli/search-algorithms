public abstract class State {
    protected State parent;
    protected int act;

    public State() {
        parent = null;
        act = -1;
    }

    public int getAct() {
        return act;
    }
}
