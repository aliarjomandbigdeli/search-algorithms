public class NavState extends State {
    private int id;

    public int getId() {
        return id;
    }

    public NavState(int id) {
        super();
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof NavState))
            return false;
        NavState other = (NavState) obj;
        return this.id == other.id;
    }
}
