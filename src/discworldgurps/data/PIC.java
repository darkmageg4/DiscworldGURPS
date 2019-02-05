package discworldgurps.data;

public class PIC {

    private String name, cost;

    public PIC(String name, String cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("%s (%s points)", name, cost);
    }

}
