/**
 * This class is used to model the state of each city in Navigation Problem
 *
 * @author Ali ArjomandBigdeli
 * @since 12.27.2018
 */
public class NavState extends State {
    private int id;

    /**
     * city ID
     * @return city ID
     */
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
