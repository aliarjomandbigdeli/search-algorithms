public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        NavigationProblem p = new NavigationProblem();
        System.out.println(p.stepCost(14, 15));
        NavState s1=new NavState(3);
        NavState s2=new NavState(3);
        if(s1.equals(s2))
            System.out.println("i 'am");
        Problem problem = new NavigationProblem();
        Search search = new SearchBFS(true);
        search.setProblem(problem);
        search.execute();
        System.out.println("path: ");
        for (Integer node : search.getPath()) {
            System.out.println(node);
        }
    }
}
