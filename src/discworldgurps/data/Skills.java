package discworldgurps.data;


public class Skills {
    
    private String name, att, diff;

    public Skills(String name, String att, String diff) {
        this.name = name;
        this.att = att;
        this.diff = diff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAtt() {
        return att;
    }

    public void setAtt(String att) {
        this.att = att;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)(%s)", name, att, diff);
    }

}
