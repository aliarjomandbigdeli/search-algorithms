/**
 * iterative deepening Depth First Search(DFS) algorithm
 *
 * @author Ali ArjomandBigdeli
 * @since 12.27.2018
 */
public class SearchDFSIterative extends SearchDFSLimited {
    public SearchDFSIterative(boolean isGraph) {
        super(isGraph, 0);
    }

    public void execute() {
        int depth = 1;
        while (answer == null) {
            setDepth(depth++);
            super.execute();
            if (isGraph)
                e.clear();
        }
        maxNodeKeptInMemory = path.size() * 4; //int size in java: 4 bytes
    }
}
