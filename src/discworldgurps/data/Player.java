package discworldgurps.data;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private String playerName;
    private int points;
    private double height;
    private int weight;
    private int age;
    private int st, dx, iq, hp, ht, will, per, fp;
    private int hpCurrent, fpCurrent;
    private int mp, mpCurrent;
    private double bs;
    private int bm;
    private int tl;
    private String[] advantages, disadvantages, lang, culture, skills;
    private String magery, staff;
    private int magCost, staffCost;
    private String reactionMods;
    private int dr, parry, block;
    private String charNotes, otherNotes, equipment, otherInv;
    private int money;

    /**
     * Default values
     */
    public Player() {
        this.name = "Name";
        this.playerName = "playerName";
        this.points = 75;
        this.height = 78;
        this.weight = 120;
        this.age = 21;
        this.st = 10;
        this.dx = 10;
        this.iq = 10;
        this.hp = 10;
        this.ht = 10;
        this.will = 10;
        this.per = 10;
        this.fp = 10;
        this.hpCurrent = 10;
        this.fpCurrent = 10;
        this.mp = 0;
        this.mpCurrent = 0;
        this.bs = (this.dx + this.ht) / 4;
        this.bm = (int) this.bs;
        this.tl = 4;
        this.advantages = new String[20];
        this.disadvantages = new String[20];
        this.lang = new String[16];
        this.culture = new String[6];
        this.skills = new String[92];
        this.reactionMods = "";
        this.magery = "";
        this.magCost = 0;
        this.staff = "";
        this.staffCost = 0;
        this.dr = 0;
        this.parry = 0;
        this.block = 0;
        this.charNotes = "";
        this.otherNotes = "";
        this.money = 0;
    }

    public Player(String name, String playerName, int points, double height, int weight,
            int age, int st, int dx, int iq, int hp, int ht, int will, int per,
            int fp, int hpCurrent, int fpCurrent, int mp, int mpCurrent, double bs,
            int bm, int tl, String[] advantages, String[] disadvantages, String[] lang,
            String[] culture, String[] skills, String reactionMods, String magery,
            int magCost, String staff, int staffCost, int dr, int parry, int block,
            String charNotes, String otherNotes, int money, String equipment, String otherInv) {
        this.name = name;
        this.playerName = playerName;
        this.points = points;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.st = st;
        this.dx = dx;
        this.iq = iq;
        this.hp = hp;
        this.ht = ht;
        this.will = will;
        this.per = per;
        this.fp = fp;
        this.hpCurrent = hpCurrent;
        this.fpCurrent = fpCurrent;
        this.mp = mp;
        this.mpCurrent = mpCurrent;
        this.bs = bs;
        this.bm = bm;
        this.tl = tl;
        this.advantages = advantages;
        this.disadvantages = disadvantages;
        this.lang = lang;
        this.culture = culture;
        this.skills = skills;
        this.reactionMods = reactionMods;
        this.magery = magery;
        this.magCost = magCost;
        this.staff = staff;
        this.staffCost = staffCost;
        this.dr = dr;
        this.parry = parry;
        this.block = block;
        this.charNotes = charNotes;
        this.otherNotes = otherNotes;
        this.money = money;
        this.equipment = equipment;
        this.otherInv = otherInv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Converts inches to feet and inches
     *
     * @return String of feet and inches
     */
    public String HeighttoString() {
        int feet = (int) this.height / 12;
        int inches = (int) this.height % 12;
        return String.format("%d'%d", feet, inches);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHt() {
        return ht;
    }

    public void setHt(int ht) {
        this.ht = ht;
    }

    public int getWill() {
        return will;
    }

    public void setWill(int will) {
        this.will = will;
    }

    public int getPer() {
        return per;
    }

    public void setPer(int per) {
        this.per = per;
    }

    public int getFp() {
        return fp;
    }

    public void setFp(int fp) {
        this.fp = fp;
    }

    public int getHpCurrent() {
        return hpCurrent;
    }

    public void setHpCurrent(int hpCurrent) {
        this.hpCurrent = hpCurrent;
    }

    public int getFpCurrent() {
        return fpCurrent;
    }

    public void setFpCurrent(int fpCurrent) {
        this.fpCurrent = fpCurrent;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMpCurrent() {
        return mpCurrent;
    }

    public void setMpCurrent(int mpCurrent) {
        this.mpCurrent = mpCurrent;
    }

    public double getBs() {
        return bs;
    }

    public void setBs(double bs) {
        this.bs = bs;
    }

    public int getBm() {
        return bm;
    }

    public void setBm(int bm) {
        this.bm = bm;
    }

    public int getTl() {
        return tl;
    }

    public void setTl(int tl) {
        this.tl = tl;
    }

    public String[] getAdvantages() {
        return advantages;
    }

    public void setAdvantages(String[] advantages) {
        this.advantages = advantages;
    }

    public String[] getDisadvantages() {
        return disadvantages;
    }

    public void setDisadvantages(String[] disadvantages) {
        this.disadvantages = disadvantages;
    }

    public String[] getLang() {
        return lang;
    }

    public void setLang(String[] lang) {
        this.lang = lang;
    }

    public String[] getCulture() {
        return culture;
    }

    public void setCulture(String[] culture) {
        this.culture = culture;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String getCharNotes() {
        return charNotes;
    }

    public void setCharNotes(String charNotes) {
        this.charNotes = charNotes;
    }

    public String getOtherNotes() {
        return otherNotes;
    }

    public void setOtherNotes(String otherNotes) {
        this.otherNotes = otherNotes;
    }

    public String getMagery() {
        return magery;
    }

    public void setMagery(String magery) {
        this.magery = magery;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getReactionMods() {
        return reactionMods;
    }

    public void setReactionMods(String reactionMods) {
        this.reactionMods = reactionMods;
    }

    public int getMagCost() {
        return magCost;
    }

    public void setMagCost(int magCost) {
        this.magCost = magCost;
    }

    public int getStaffCost() {
        return staffCost;
    }

    public void setStaffCost(int staffCost) {
        this.staffCost = staffCost;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public int getParry() {
        return parry;
    }

    public void setParry(int parry) {
        this.parry = parry;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getOtherInv() {
        return otherInv;
    }

    public void setOtherInv(String otherInv) {
        this.otherInv = otherInv;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Saves the current character
     *
     * @param file passed in from Sheet.java
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void Save(File file) throws FileNotFoundException, IOException {
        FileOutputStream fo = new FileOutputStream(file);
        ObjectOutputStream output = new ObjectOutputStream(fo);
        output.writeObject(this);
        output.close();
        fo.close();
    }

    /**
     * Loads a character and sets all the details to current character on
     * Sheet.java
     *
     * @param file Selected in File Selector
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void Load(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream is = new FileInputStream(file);
        ObjectInputStream input = new ObjectInputStream(is);
        try {
            Player tmp = (Player) input.readObject();
            this.name = tmp.getName();
            this.playerName = tmp.getPlayerName();
            this.points = tmp.getPoints();
            this.height = tmp.getHeight();
            this.weight = tmp.getWeight();
            this.age = tmp.getAge();
            this.st = tmp.getSt();
            this.dx = tmp.getDx();
            this.iq = tmp.getIq();
            this.hp = tmp.getHp();
            this.ht = tmp.getHt();
            this.will = tmp.getWill();
            this.per = tmp.getPer();
            this.fp = tmp.getFp();
            this.hpCurrent = tmp.getHpCurrent();
            this.fpCurrent = tmp.getFpCurrent();
            this.mp = tmp.getMp();
            this.mpCurrent = tmp.getMpCurrent();
            this.bs = tmp.getBs();
            this.bm = tmp.getBm();
            this.advantages = tmp.getAdvantages();
            this.disadvantages = tmp.getDisadvantages();
            this.lang = tmp.getLang();
            this.culture = tmp.getCulture();
            this.skills = tmp.getSkills();
            this.reactionMods = tmp.getReactionMods();
            this.magery = tmp.getMagery();
            this.magCost = tmp.getMagCost();
            this.staff = tmp.getStaff();
            this.staffCost = tmp.getStaffCost();
            this.dr = tmp.getDr();
            this.parry = tmp.getParry();
            this.block = tmp.getBlock();
            this.charNotes = tmp.getCharNotes();
            this.otherNotes = tmp.getOtherNotes();
            this.money = tmp.getMoney();
            this.equipment = tmp.getEquipment();
            this.otherInv = tmp.getOtherInv();
        } catch (EOFException ex) {
            ex.printStackTrace();
        }
    }

}
