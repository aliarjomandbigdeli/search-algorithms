/**
 * Depth First Search(DFS) algorithm
 * Depth-first search can be viewed as a special case of depth-limited search with limit=∞(infinity).
 *
 * @author Ali ArjomandBigdeli
 * @since 12.31.2018
 */
public class SearchDFS extends SearchDLS {
    public SearchDFS(boolean isGraph) {
        super(isGraph, Integer.MAX_VALUE);
    }
}
