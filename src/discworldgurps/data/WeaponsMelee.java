package discworldgurps.data;


public class WeaponsMelee {
    String name,damage,reach,parry,cost,weight,st,dx,tl,type;

    public WeaponsMelee(String name, String damage, String reach, String parry, String cost, String weight, String st, String dx, String tl, String type) {
        this.name = name;
        this.damage = damage;
        this.reach = reach;
        this.parry = parry;
        this.cost = cost;
        this.weight = weight;
        this.st = st;
        this.dx = dx;
        this.tl = tl;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getReach() {
        return reach;
    }

    public void setReach(String reach) {
        this.reach = reach;
    }

    public String getParry() {
        return parry;
    }

    public void setParry(String parry) {
        this.parry = parry;
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

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getDx() {
        return dx;
    }

    public void setDx(String dx) {
        this.dx = dx;
    }

    public String getTl() {
        return tl;
    }

    public void setTl(String tl) {
        this.tl = tl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s : Damage %s",this.name,this.damage);
    }
    
    

}
