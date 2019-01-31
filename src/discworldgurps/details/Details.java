package discworldgurps.details;

import static discworldgurps.Sheet.advCount;
import static discworldgurps.Sheet.disCount;
import discworldgurps.data.Advantages;
import discworldgurps.data.DataLoader;
import discworldgurps.data.Disadvantages;
import discworldgurps.data.Talents;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Details {

    private boolean result = false;
    public String ad;
    private String desc, cost;
    private String lang, langSpok, langWrit;
    DataLoader DL = new DataLoader();

    public void runAdvantages() {
        DL.LoadAdv();
        JComboBox adv = new JComboBox();
        adv.removeAllItems();
        for (Advantages s : DL.getAdvantages()) {
            adv.addItem(s);
        }
        int add = JOptionPane.showConfirmDialog(null, adv, "Which Advantage?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION);
        try {
            if (add == 0) {
                advCount++;
                int i = adv.getSelectedIndex();
                if ("D".equals(DL.getAdvantages().get(i).getCost())) {
                    runDetails(DL.getAdvantages().get(i).getName(), "a");
                    if (result == true) {
                        desc = getDesc();
                        cost = getCost();
                    } else {
                        advCount--;
                    }
                } else {
                    if ("1".equals(DL.getAdvantages().get(i).getLvl())) {
                        String lvl = JOptionPane.showInputDialog("What level?", "1");
                        if (lvl != null && !"".equals(lvl)) {
                            int cost = Integer.parseInt(DL.getAdvantages().get(i).getCost()) * Integer.parseInt(lvl);
                            desc = String.format("%s (Level %s)", DL.getAdvantages().get(i).getName(), lvl);
                            this.cost = Integer.toString(cost);
                        } else {
                            advCount--;
                        }
                    } else {
                        desc = DL.getAdvantages().get(i).getName();
                        cost = DL.getAdvantages().get(i).getCost();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void runDisadvantages() {
        DL.LoadDis();
        JComboBox dis = new JComboBox();
        dis.removeAllItems();
        for (Disadvantages s : DL.getDisadvantages()) {
            dis.addItem(s);
        }
        int add = JOptionPane.showConfirmDialog(null, dis, "Which Disadvantage?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION);
        try {
            if (add == 0) {
                disCount++;
                int i = dis.getSelectedIndex();
                if ("D".equals(DL.getDisadvantages().get(i).getCost())) {
                    runDetails(DL.getDisadvantages().get(i).getName(), "d");
                    if (result == true) {
                        desc = getDesc();
                        cost = getCost();
                    } else {
                        disCount--;
                    }
                } else {
                    if ("1".equals(DL.getDisadvantages().get(i).getLvl())) {
                        String lvl = JOptionPane.showInputDialog("What level?", "1");
                        int cost = Integer.parseInt(DL.getDisadvantages().get(i).getCost()) * Integer.parseInt(lvl);
                        desc = String.format("%s (Level %s)", DL.getDisadvantages().get(i).getName(), lvl);
                        this.cost = Integer.toString(cost);
                    } else {
                        desc = DL.getDisadvantages().get(i).getName();
                        cost = DL.getDisadvantages().get(i).getCost();
                    }
                }
            }
        } catch (Exception ex) {
        }
    }
    
    public void runLang() {
        Lang lang = new Lang(null, true);
        lang.setModal(true);
        lang.setLocationRelativeTo(null);
        lang.setVisible(true);
        if (lang.closed != 1) {
            this.lang = lang.getLang();
            langSpok = lang.getLangSpok();
            langWrit = lang.getLangWrit();
            cost = lang.getCost();
            result = true;
        } else {
            result = false;
        }
    }

    public void runDetails(String string, String ad) {
        this.ad = ad;
        if (null != string) {
            switch (string) {
                // Advantages
                case "Reputation":
                    Reputation();
                    break;
                case "Congregation":
                    Congregation();
                    break;
                case "Contacts":
                    Contact();
                    break;
                case "Patron":
                    Patron();
                    break;
                case "Lifting ST":
                    // TO DO
                    break;
                case "Talent":
                    Talents();
                    break;
                case "Unusual Background":
                    UnusualBackground();
                    break;
                case "Voice Of Command":
                    //TO DO
                    break;
                // Disadvantages
                case "Dependents":
                    //TO DO
                    break;
                case "Enemies":
                    //TO DO
                    break;
                case "Duty":
                    //TO DO
                    break;
                case "Phobias":
                    //TO DO
                    break;
                case "Physical Problems":
                    //TO DO
                    break;
                case "Poor Impulse Control":
                    //TO DO
                    break;
                case "Secret":
                    //TO DO
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Opens Rep pop up
     *
     * @return result
     */
    private void Reputation() {
        Reputation rep = new Reputation(null, true, this.ad);
        rep.setModal(true);
        rep.setLocationRelativeTo(null);
        rep.setVisible(true);
        if (rep.closed != 1) {
            desc = rep.getRepDesc();
            cost = rep.getRepCost();
            result = true;
        } else {
            result = false;
        }
    }

    private void Congregation() {
        Congregation cong = new Congregation(null, true);
        cong.setModal(true);
        cong.setLocationRelativeTo(null);
        cong.setVisible(true);
        if (cong.closed != 1) {
            desc = cong.getCongDesc();
            cost = cong.getCongCost();
            result = true;
        } else {
            result = false;
        }
    }

    private void Contact() {
        Contact cont = new Contact(null, true);
        cont.setModal(true);
        cont.setLocationRelativeTo(null);
        cont.setVisible(true);
        if (cont.closed != 1) {
            desc = cont.getContDesc();
            cost = cont.getContCost();
            result = true;
        } else {
            result = false;
        }
    }

    private void Patron() {
        Patron pat = new Patron(null, true);
        pat.setModal(true);
        pat.setLocationRelativeTo(null);
        pat.setVisible(true);
        if (pat.closed != 1) {
            desc = pat.getPatDesc();
            cost = pat.getPatCost();
            result = true;
        } else {
            result = false;
        }
    }

    private void Talents() {
        DL.LoadTalents();
        JComboBox tal = new JComboBox();
        tal.removeAllItems();
        for (Talents s : DL.getTalents()) {
            tal.addItem(s);
        }
        int add = JOptionPane.showConfirmDialog(null, tal, "Which talent?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION);
        try {
            if (add == 0) {
                int i = tal.getSelectedIndex();
                desc = String.format("Talent: %s", DL.getTalents().get(i).getName());
                cost = DL.getTalents().get(i).getCost();
                result = true;
            } else {
                result = false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void UnusualBackground() {
        UnusualBackground ub = new UnusualBackground(null, true);
        ub.setModal(true);
        ub.setLocationRelativeTo(null);
        ub.setVisible(true);
        if (ub.closed != 1) {
            desc = ub.getUbDesc();
            cost = ub.getUbCost();
            result = true;
        } else {
            result = false;
        }
    }

    public boolean isResult() {
        return result;
    }

    public String getDesc() {
        return desc;
    }

    public String getCost() {
        return cost;
    }

    public String getAd() {
        return ad;
    }

    public String getLang() {
        return lang;
    }

    public String getLangSpok() {
        return langSpok;
    }

    public String getLangWrit() {
        return langWrit;
    }

}
