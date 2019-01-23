package discworldgurps.data;

import java.util.ArrayList;

public class DataLoader {

    private final LoadCSV load = new LoadCSV();

    ArrayList<Damage> damage = new ArrayList<>();
    ArrayList<Advantages> advantages = new ArrayList<>();
    ArrayList<Disadvantages> disadvantages = new ArrayList<>();
    ArrayList<Armour> armour = new ArrayList<>();
    ArrayList<WeaponsMelee> wepmel = new ArrayList<>();

    /**
     * Loads the advantages and perks
     */
    public void LoadDamage() {
        try {
            load.reader("./src/discworldgurps/resources/damage.csv");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (ItemLoader il : load.tmp) {
            damage.add(new Damage(il.a, il.b, il.c));
        }
        load.tmp.clear();
//        for (Damage a : damage) {
//            System.out.printf("Thrust : %s\n", a.thrust());
//            System.out.printf("Swing : %s\n", a.swing());
//        }
    }

    public void LoadAdv() {
        try {
            load.reader("./src/discworldgurps/resources/advantages.csv");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (ItemLoader il : load.tmp) {
            advantages.add(new Advantages(il.a, il.b, il.c));
        }
        load.tmp.clear();
//        for (Advantages a : advantages) {
//            System.out.printf("%s - %s\n", a, a.getCost());
//        }
    }
    public void LoadDis() {
        try {
            load.reader("./src/discworldgurps/resources/disadvantages.csv");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (ItemLoader il : load.tmp) {
            disadvantages.add(new Disadvantages(il.a, il.b, il.c));
        }
//        load.tmp.clear();
//        for (Disadvantages a : disadvantages) {
//            System.out.printf("%s - %s\n", a, a.getCost());
//        }
    }

    /**
     * Loads the armour
     */
    public void LoadArm() {
        try {
            load.reader("./src/discworldgurps/resources/armour.csv");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (ItemLoader il : load.tmp) {
            armour.add(new Armour(il.a, il.b, il.c, il.d, il.e));
        }
        load.tmp.clear();
//        for (Armour a : armour) {
//            System.out.printf("%s - %s\n", a, a.getCost());
//        }
    }

    /**
     * Loads the Melee Weapons
     */
    public void LoadMelWep() {
        try {
            load.reader("./src/discworldgurps/resources/meleeweapons.csv");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        for (ItemLoader il : load.tmp) {
            wepmel.add(new WeaponsMelee(il.a, il.b, il.c, il.d, il.e, il.f, il.g, il.h, il.i, il.j));
        }
        load.tmp.clear();

//        for (WeaponsMelee a : wepmel) {
//            System.out.printf("%s - %s\n", a, a.getCost());
//        }
    }

    public void LoadAll() {
        LoadDamage();
        LoadAdv();
        LoadArm();
        LoadMelWep();
    }

    public ArrayList<Damage> getDamage() {
        return damage;
    }

    public ArrayList<Advantages> getAdvantages() {
        return advantages;
    }

    public ArrayList<Armour> getArmour() {
        return armour;
    }

    public ArrayList<WeaponsMelee> getWepmel() {
        return wepmel;
    }

    public ArrayList<Disadvantages> getDisadvantages() {
        return disadvantages;
    }
    
    

}
