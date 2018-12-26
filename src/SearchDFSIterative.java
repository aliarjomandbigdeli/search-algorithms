public class SearchDFSIterative extends SearchDFSlimited {
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
    }
}
