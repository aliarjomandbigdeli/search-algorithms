import java.util.LinkedList;

/**
 * this class is the parent of all searches you want to define with this interface
 *
 * @author Ali ArjomandBigdeli
 * @since 12.27.2018
 */
public abstract class Search {
    protected int nodeSeen;
    protected int nodeExpand;
    protected LinkedList<Integer> path;
    protected int pathCost;
    protected int maxNodeKeptInMemory;
    protected long nodeSize;
    protected State answer;

    protected Problem problem;
    protected boolean isGraph;
    protected LinkedList<State> f;   //frontier list
    protected LinkedList<State> e;   //explored list


    public Search(boolean isGraph) {
        this.isGraph = isGraph;
        nodeSeen = 0;
        nodeExpand = 0;
        path = new LinkedList<>();
        pathCost = 0;
        maxNodeKeptInMemory = 0;
        f = new LinkedList<>();
        e = new LinkedList<>();
    }

    public int getNodeSeen() {
        return nodeSeen;
    }

    public int getNodeExpand() {
        return nodeExpand;
    }

    public long getMaxNodeKeptInMemory() {
        return maxNodeKeptInMemory;
    }

    public void setNodeSize(long nodeSizeByte) {
        this.nodeSize = nodeSizeByte;
    }

    public LinkedList<Integer> getPath() {
        return path;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Problem getProblem() {
        return problem;
    }

    abstract public void execute();

    abstract public void search();

    protected void showLists() {
        System.out.print("frontier list: ");
        for (State state : f) {
            System.out.print(state + ", ");
        }
        System.out.print("\texplored list: ");
        for (State state : e) {
            System.out.print(state + ", ");
        }
        System.out.println();
    }

}
