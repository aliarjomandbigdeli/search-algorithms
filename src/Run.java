
public class Run {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        NavigationProblem p = new NavigationProblem();
        System.out.println(p.stepCost(0, 3));

        Problem problem = new NavigationProblem();
//        Search search = new SearchBFS(true);
//        Search search = new SearchDFS(true);
//        Search search = new SearchUCS(true);
        Search search = new SearchAStar(true);
        search.setProblem(problem);
        search.execute();
        System.out.println("path: ");
        for (int i = 0; i < search.getPath().size() - 1; i++) {
            System.out.print(search.getPath().get(i) + " ");
        }
        System.out.println("\npath cost: " + problem.pathCost(search.getPath()));
    }
}
