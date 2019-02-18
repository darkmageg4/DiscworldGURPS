package discworldgurps.data;

import java.util.ArrayList;
import java.util.Collections;

public class DataLoader {

    private final LoadCSV load = new LoadCSV();

    ArrayList<Damage> damage = new ArrayList<>();
    ArrayList<Culture> cult = new ArrayList<>();
    ArrayList<Langs> langs = new ArrayList<>();

    /**
     * Loads in the Damage.csv which gives the damage values
     */
    public void LoadDamage() {
        try {
            load.reader("/damage.csv");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        damage.clear();
        for (ItemLoader il : load.tmp) {
            damage.add(new Damage(il.a, il.b, il.c));
        }
        load.tmp.clear();
//        for (Damage a : damage) {
//            System.out.printf("Thrust : %s\n", a.thrust());
//            System.out.printf("Swing : %s\n", a.swing());
//        }
    }

    public void LoadCult() {
        try {
            load.reader("/culture.csv");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        cult.clear();
        Collections.sort(load.tmp, new ItemComparator());
        for (ItemLoader il : load.tmp) {
            cult.add(new Culture(il.a, il.b));
        }
        load.tmp.clear();
//        for (Culture a : cult) {
//            System.out.printf(a);
//        }
    }

    public void LoadLang() {
        try {
            load.reader("/lang.csv");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        langs.clear();
        Collections.sort(load.tmp, new ItemComparator());
        for (ItemLoader il : load.tmp) {
            langs.add(new Langs(il.a));
        }
        load.tmp.clear();
//        for (Culture a : cult) {
//            System.out.printf(a);
//        }
    }

    public ArrayList<Damage> getDamage() {
        return damage;
    }

    public ArrayList<Culture> getCult() {
        return cult;
    }

    public ArrayList<Langs> getLangs() {
        return langs;
    }

}
