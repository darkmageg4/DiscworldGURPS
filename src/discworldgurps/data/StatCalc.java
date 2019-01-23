package discworldgurps.data;

public class StatCalc {

    private int st, dx, iq, hp, ht, will, per, fp;
    private double height;
    private int STCost = 10, HPCost = 2, sm = 0;
    private int spentST, spentDX, spentIQ, spentHT, spentHP, spentWill, spentPer, spentFP, spentBS, spentBM, spentTL;
    private double initialBS, bs;
    private int bm;
    private int points, pointsUnspent;
    private int tl;
    private int adv, dis;

    public StatCalc(int st, int dx, int iq, int hp, int ht, int will, int per, int fp, double height, double bs, int bm, int points, int tl, int adv, int dis) {
        this.st = st;
        this.dx = dx;
        this.iq = iq;
        this.hp = hp;
        this.ht = ht;
        this.will = will;
        this.per = per;
        this.fp = fp;
        this.height = height;
        this.bs = bs;
        this.bm = bm;
        this.points = points;
        this.tl = tl;
        this.adv = adv;
        this.dis = dis;
    }

    public void SizeMods() {
        if (height <= 2.5) {
            sm = -9;
        } else if (height > 2.5 && height < 3.5) {
            sm = -8;
        } else if (height >= 3.5 && height < 5) {
            sm = -7;
        } else if (height >= 5 && height < 7) {
            sm = -6;
        } else if (height >= 7 && height < 10) {
            sm = -5;
        } else if (height >= 10 && height < 18) {
            sm = -4;
        } else if (height >= 18 && height < 24) {
            sm = -3;
        } else if (height >= 24 && height < 36) {
            sm = -2;
        } else if (height >= 36 && height < 54) {
            sm = -2;
        } else if (height >= 54 && height < 78) {
            sm = -1;
        } else if (height >= 78 && height < 108) {
            STCost = 10;
            HPCost = 2;
            sm = 0;
        } else if (height >= 108 && height < 180) {
            STCost = 9;
            HPCost = 1;
            sm = 1;
        } else if (height >= 180 && height < 252) {
            STCost = 8;
            HPCost = 1;
            sm = 2;
        } else if (height >= 252 && height < 360) {
            STCost = 7;
            HPCost = 1;
            sm = 3;
        } else if (height >= 360) {
            STCost = 6;
            HPCost = 1;
            sm = 4;
        }
    }

    public void Calc() {
        SizeMods();
        spentST = (this.st - 10) * STCost;
        spentDX = (this.dx - 10) * 20;
        spentIQ = (this.iq - 10) * 20;
        spentHT = (this.ht - 10) * 10;
        spentHP = (this.hp - this.st) * HPCost;
        spentWill = (this.will - this.iq) * 5;
        spentPer = (this.per - this.iq) * 5;
        spentFP = (this.fp - this.ht) * 3;
        initialBS = (double) (this.dx + this.ht) / 4;
        spentBS = (int) ((this.bs - initialBS) * 20);
        spentBM = (this.bm - (int) Math.floor(this.bs)) * 5;
        spentTL = (this.tl - 4) * 5;
        pointsUnspent = this.points - (spentST + spentDX + spentIQ + spentHT + spentHP
                + spentWill + spentPer + spentFP + spentBS + spentBM + spentTL + adv + dis);

    }

    public int getSpentST() {
        return spentST;
    }

    public int getSpentDX() {
        return spentDX;
    }

    public int getSpentIQ() {
        return spentIQ;
    }

    public int getSpentHT() {
        return spentHT;
    }

    public int getSpentHP() {
        return spentHP;
    }

    public int getSpentWill() {
        return spentWill;
    }

    public int getSpentPer() {
        return spentPer;
    }

    public int getSpentFP() {
        return spentFP;
    }

    public int getSpentBS() {
        return spentBS;
    }

    public int getSpentBM() {
        return spentBM;
    }

    public int getPointsUnspent() {
        return pointsUnspent;
    }

    public int getSpentTL() {
        return spentTL;
    }

    public int getSm() {
        return sm;
    }

}
