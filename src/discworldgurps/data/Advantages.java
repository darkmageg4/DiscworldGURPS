package discworldgurps.data;

public class Advantages {

    private String name;
    private String cost;
    private String lvl;

    public Advantages(String name, String cost, String lvl) {
        this.name = name;
        this.cost = cost;
        this.lvl = lvl;
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

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    @Override
    public String toString() {
        if (!"1".equals(this.lvl)){
        return String.format("%s : %s points", this.name, this.cost);
        } else {
            return String.format("%s : %s points per level", this.name, this.cost);
        }
    }
    
    public void runAdvantages() {
    
}

}
