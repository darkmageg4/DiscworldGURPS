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

public class Character implements Serializable {

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
    private String[] advantages, disadvantages;

    public Character() {
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
        this.advantages = new String[10];
        this.disadvantages = new String[10];

    }

    public Character(String name, String playerName, int points, double height, int weight,
            int age, int st, int dx, int iq, int hp, int ht, int will, int per,
            int fp, int hpCurrent, int fpCurrent, int mp, int mpCurrent, double bs, int bm, int tl) {
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
        this.advantages = new String[10];
        this.disadvantages = new String[10];
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

    public void Save(File file) throws FileNotFoundException, IOException {
        FileOutputStream fo = new FileOutputStream(file);
        ObjectOutputStream output = new ObjectOutputStream(fo);
        output.writeObject(this);
        output.close();
        fo.close();
    }

    public void Load(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream is = new FileInputStream(file);
        ObjectInputStream input = new ObjectInputStream(is);

        try {
            Character tmp = (Character) input.readObject();
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

        } catch (EOFException ex) {
            ex.printStackTrace();

        }
    }

}
