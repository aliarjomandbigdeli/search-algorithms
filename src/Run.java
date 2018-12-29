import java.util.Scanner;

/**
 * this class is used to solve a problem with one the search algorithms
 *
 * @author Ali ArjomandBigdeli
 * @since 12.27.2018
 */
public class Run {

    public static void main(String[] args) {
        Problem problem = new NavigationProblem();
        Search search;
        System.out.println("Search Algorithms: ");
        System.out.println("1. BFS \n2. DFS\n3. DFS iterative\n4. DFS limited depth" +
                "\n5. Uniform Cost\n6. Greedy best first search\n7. A*");
        System.out.print("please choose your search algorithm: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.print("Do you want to run in graph mode(0) or tree mode(1): ");
        int graphChoice = scanner.nextInt();
        boolean isGraph = true;
        if (graphChoice == 1)
            isGraph = false;
        switch (choice) {
            case 1:
                search = new SearchBFS(isGraph);
                break;
            case 2:
                search = new SearchDFS(isGraph);
                break;
            case 3:
                search = new SearchDFSIterative(isGraph);
                break;
            case 4:
                System.out.print("please enter the depth: ");
                int depth = scanner.nextInt();
                search = new SearchDFSLimited(isGraph, depth);
                break;
            case 5:
                search = new SearchUCS(isGraph);
                break;
            case 6:
                search = new SearchGreedyBFS(isGraph);
                break;
            case 7:
                search = new SearchAStar(isGraph);
                break;
            default:
                search = new SearchAStar(isGraph);
                break;
        }
        search.setProblem(problem);
        search.execute();
        showResultOfSearch(search);
    }

    public static void showResultOfSearch(Search search) {
        System.out.println("Result of the " + search.getClass().getSimpleName());
        System.out.print("path: ");
        for (int i = search.getPath().size() - 2; i >= 0; i--) {
            System.out.print(search.getPath().get(i) + " ");
        }
        System.out.println();
        System.out.println("path cost: " + search.answer.pathCost);
        System.out.println("Depth of the result: " + (search.getPath().size() - 1));
        System.out.println("Number of node that has been seen: " + search.getNodeSeen());
        System.out.println("Number of node that has been expanded: " + search.getNodeExpand());
        System.out.println("Maximum number of nodes kept in memory: " + search.getMaxNodeKeptInMemory());
    }
}
