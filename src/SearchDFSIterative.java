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
        maxMemoryUse = path.size() * 4; //int size in java: 4 bytes
    }
}
