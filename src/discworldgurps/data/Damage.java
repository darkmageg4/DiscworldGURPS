package discworldgurps.data;

public class Damage {

    String st, thrust, swing;

    public Damage(String st, String thrust, String swing) {
        this.st = st;
        this.thrust = thrust;
        this.swing = swing;
    }

    public String thrust() {
        return thrust;
    }

    public String swing() {
        return swing;
    }

}
