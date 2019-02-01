package discworldgurps.data;

public class Talents {

    private String name;
    private String cost;

    public Talents(String name, String cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("%s : %s points per lvl", name,cost);
    }

}
