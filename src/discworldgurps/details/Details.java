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

    /**
     * Runs the advantages pop up
     */
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

    /**
     * Runs the disadvantages pop up
     */
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

    /**
     * Runs the Lang.java pop up
     */
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

    /**
     * Runs the appropriate pop up for the ad/dis selected
     *
     * @param string The advantage or disadvantage name
     * @param ad Whether it's an advantage or disadvantage
     */
    public void runDetails(String string, String ad) {
        this.ad = ad;
        if (null != string) {
            switch (string) {
                // Advantages
                case "Lifting ST":
                    // TO DO
                    break;
                case "Talent":
                    Talents();
                    break;
                case "Unusual Background":
                    UnusualBackground(ad);
                    break;
                case "Voice Of Command":
                    //TO DO
                    break;
                // Disadvantages
                case "Duty":
                    //TO DO
                    break;
                case "Phobias":
                    //TO DO
                    break;
                case "Physical Problems":
                    UnusualBackground(ad);
                    break;
                case "Poor Impulse Control":
                    //TO DO
                    break;
                case "Secret":
                    //TO DO
                    break;
                default:
                    DetailsGUI(string, ad);
                    break;
            }
        }
    }

    private void DetailsGUI(String string, String ad) {
        DetailsGUI od = new DetailsGUI(null, true, string, ad);
        od.setModal(true);
        od.setLocationRelativeTo(null);
        od.setVisible(true);
        if (od.closed != 1) {
            desc = od.getDesc();
            cost = od.getCost();
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

                String lvl = JOptionPane.showInputDialog("What level?", "1");
                cost = Integer.toString(Integer.parseInt(DL.getTalents().get(i).getCost()) * Integer.parseInt(lvl));
                desc = String.format("Talent: %s (lvl %s)", DL.getTalents().get(i).getName(), lvl);
                result = true;
            } else {
                result = false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void UnusualBackground(String ad) {
        UnusualBackground ub = new UnusualBackground(null, true, ad);
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
