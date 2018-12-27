import java.util.Scanner;

public class Run {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        NavigationProblem p = new NavigationProblem();
        System.out.println(p.stepCost(0, 3));

        Problem problem = new NavigationProblem();

        System.out.print("please choose your search algorithm: ");
//        Scanner scanner = new Scanner();
//        Search search = new SearchBFS(true);
        Search search = new SearchDFS(true);
//        Search search = new SearchUCS(true);
//        Search search = new SearchAStar(true);
//        Search search = new SearchGreedyBFS(true);
        search.setProblem(problem);
        search.setNodeSize(16 + 2 * 4); //16 bytes for the header an object(parent) and two 4 bytes for two int fields
        search.execute();
        showResultOfSearch(search);
    }

    public static void showResultOfSearch(Search search) {
        System.out.print("path: ");
        for (int i = search.getPath().size() - 2; i >= 0; i--) {
            System.out.print(search.getPath().get(i) + " ");
        }
        System.out.println();
        System.out.println("path cost: " + search.getProblem().pathCost(search.getPath()));
        System.out.println("Depth of the result: " + (search.getPath().size() - 1));
        System.out.println("Number of node that has been seen: " + search.getNodeSeen());
        System.out.println("Number of node that has been expanded: " + search.getNodeExpand());
        System.out.println("Maximum memory used: " + getSize(search.getMaxMemoryUse()));
    }

    public static String getSize(long size) {
        if (size < 1024)
            return size + " Bytes";
        if (size < 1024 * 1024)
            return String.format("%.2f KB", (float) size / 1024);
        if (size < 1024 * 1024 * 1024)
            return String.format("%.2f MB", (float) size / (1024 * 1024));

        return String.format("%.2f GB", (float) size / (1024 * 1024 * 1024));
    }
}
