import java.util.LinkedList;

public abstract class Search {
    protected int nodeSeen;
    protected int nodeExpand;
    protected LinkedList<Integer> path;
    protected int pathCost;
    protected double maxMemoryUse;
    protected State answer;

    protected Problem problem;
    protected boolean isGraph;
    protected LinkedList<State> f;   //frontier list
    protected LinkedList<State> e;   //expand list


    public Search(boolean isGraph) {
        this.isGraph = isGraph;
        nodeSeen = 0;
        nodeExpand = 0;
        path = new LinkedList<>();
        pathCost = 0;
        maxMemoryUse = 0.0;
        f = new LinkedList<>();
        if (isGraph)
            e = new LinkedList<>();
    }

    public LinkedList<Integer> getPath() {
        return path;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    abstract public void execute();

    abstract public void search();

}
