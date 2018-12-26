public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        NavigationProblem p = new NavigationProblem();
        System.out.println(p.stepCost(14, 15));

        Problem problem = new NavigationProblem();
//        Search search = new SearchBFS(true);
//        Search search = new SearchDFSlimited(true,6);
        Search search = new SearchDFS(true);
        search.setProblem(problem);
        search.execute();
        System.out.println("path: ");
        for (int i = 0; i < search.getPath().size() - 1; i++) {
            System.out.print(search.getPath().get(i) + " ");
        }
    }
}
