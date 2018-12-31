/**
 * iterative deepening Depth First Search(DFS) algorithm
 * The iterative deepening search algorithm, which repeatedly applies depth-limited search
 * with increasing limits. It terminates when a solution is found or if the depth-limited
 * search returns failure, meaning that no solution exists.
 *
 * @author Ali ArjomandBigdeli
 * @since 12.31.2018
 */
public class SearchDFSIterative extends Search {

    public SearchDFSIterative(boolean isGraph) {
        super(isGraph);
    }

    @Override
    public void execute() {

        for (int depth = 0; depth < Integer.MAX_VALUE; depth++) {
            SearchDLS searchDLS = new SearchDLS(isGraph, depth);
            searchDLS.setProblem(problem);
            int result = searchDLS.search(problem.getInitialState(), depth);
            path = searchDLS.path;
            answer = searchDLS.answer;
            nodeSeen = searchDLS.nodeSeen;
            nodeExpand = searchDLS.nodeExpand;
            maxNodeKeptInMemory = searchDLS.maxNodeKeptInMemory;
            if (searchDLS.answer != null/*find solution*/ || result == -1/*failure in search*/)
                break;

        }

    }
}
