package discworldgurps.data;


public class Armour {
    private String armour,dr,cost,weight,tl;

    public Armour(String armour, String dr, String cost, String weight, String tl) {
        this.armour = armour;
        this.dr = dr;
        this.cost = cost;
        this.weight = weight;
        this.tl = tl;
    }

    public String getArmour() {
        return armour;
    }

    public void setArmour(String armour) {
        this.armour = armour;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTl() {
        return tl;
    }

    public void setTl(String tl) {
        this.tl = tl;
    }

    @Override
    public String toString() {
        return String.format("%s : DR %s",this.armour,this.dr);
    }


    
    

}
