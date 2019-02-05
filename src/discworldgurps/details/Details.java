package discworldgurps.details;

import static discworldgurps.Sheet.advCount;
import static discworldgurps.Sheet.cultCount;
import static discworldgurps.Sheet.disCount;
import static discworldgurps.Sheet.skillsCount;
import discworldgurps.data.Advantages;
import discworldgurps.data.Culture;
import discworldgurps.data.DataLoader;
import discworldgurps.data.Disadvantages;
import discworldgurps.data.PIC;
import discworldgurps.data.Phobias;
import discworldgurps.data.Skills;
import discworldgurps.data.Talents;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Details {

    private boolean result = false;
    public String ad;
    private String desc, cost;
    private String lang, langSpok, langWrit;
    int[][] skillsArray = new int[4][14];
    private String skillName, skillRelLvl, skillAtt;
    private int skillLvlVal;

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

    public void runSkills() {
        DL.LoadSkills();
        JComboBox ski = new JComboBox();
        ski.removeAllItems();
        for (Skills s : DL.getSkills()) {
            ski.addItem(s);
        }
        int add = JOptionPane.showConfirmDialog(null, ski, "Which Skill?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION);
        try {
            if (add == 0) {
                skillsCount++;
                SkillsArray();
                int i = ski.getSelectedIndex();
                String lvl = JOptionPane.showInputDialog("What level?", "0");
                if (lvl != null && !"".equals(lvl)) {
                    skillLvlVal = Integer.parseInt(lvl);
                    int skillCost = 1;
                    switch (DL.getSkills().get(i).getDiff()) {
                        case "E":
                            skillCost = skillsArray[0][3 + skillLvlVal];
                            break;
                        case "A":
                            skillCost = skillsArray[1][3 + skillLvlVal];
                            break;
                        case "H":
                            skillCost = skillsArray[2][3 + skillLvlVal];
                            break;
                        case "VH":
                            skillCost = skillsArray[3][3 + skillLvlVal];
                            break;
                    }
                    int cost = skillCost;
                    skillName = String.format("%s", DL.getSkills().get(i).getName());
                    if (skillLvlVal >= 0) {
                        skillRelLvl = String.format("%s +%s", DL.getSkills().get(i).getAtt(), lvl);
                    } else {
                        skillRelLvl = String.format("%s %s", DL.getSkills().get(i).getAtt(), lvl);
                    }
                    skillAtt = DL.getSkills().get(i).getAtt();
                    this.cost = Integer.toString(cost);
                } else {
                    skillsCount--;

                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
                case "Phobias":
                    runPhobias();
                    break;
                case "Physical Problems":
                    UnusualBackground(ad);
                    break;
                case "Poor Impulse Control":
                    runPIC();
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

    public void runCulture() {
        DL.LoadCult();
        JComboBox cul = new JComboBox();
        cul.removeAllItems();
        for (Culture s : DL.getCult()) {
            cul.addItem(s);
        }
        int add = JOptionPane.showConfirmDialog(null, cul, "Which culture?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION);
        try {
            if (add == 0) {
                int i = cul.getSelectedIndex();
                cost = DL.getCult().get(i).getCost();
                if ("Other".equals(DL.getCult().get(i).getName())) {
                    String input = JOptionPane.showInputDialog("Description");
                    if (!"".equals(input)) {
                        desc = input;
                    } else {
                        JOptionPane.showMessageDialog(null, "You didn't enter a description!", "You silly goose!", JOptionPane.ERROR_MESSAGE);
                        cultCount--;
                    }
                } else {
                    desc = DL.getCult().get(i).getName();
                }
                result = true;
            } else {
                result = false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void runPhobias() {
        DL.LoadPhob();
        JComboBox pho = new JComboBox();
        pho.removeAllItems();
        for (Phobias s : DL.getPhob()) {
            pho.addItem(s);
        }
        int add = JOptionPane.showConfirmDialog(null, pho, "Which phobia?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION);
        try {
            if (add == 0) {
                int i = pho.getSelectedIndex();
                if (DL.getPhob().get(i).getName().contains("Other")) {
                    String input = JOptionPane.showInputDialog("Description");
                    if (!"".equals(input)) {
                        desc = String.format("Phobia: %s", input);
                        cost = DL.getPhob().get(i).getCost();
                    } else {
                        JOptionPane.showMessageDialog(null, "You didn't enter a description!", "You silly goose!", JOptionPane.ERROR_MESSAGE);
                        disCount--;
                    }
                } else {
                    desc = String.format("Phobia: %s", DL.getPhob().get(i).getName());
                    cost = DL.getPhob().get(i).getCost();
                }
                result = true;
            } else {
                result = false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void runPIC() {
        DL.LoadPIC();
        JComboBox pi = new JComboBox();
        pi.removeAllItems();
        for (PIC s : DL.getPic()) {
            pi.addItem(s);
        }
        int add = JOptionPane.showConfirmDialog(null, pi, "Which PIC?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION);
        try {
            if (add == 0) {
                int i = pi.getSelectedIndex();
                if (DL.getPic().get(i).getName().contains("Other")) {
                    String input = JOptionPane.showInputDialog("Description");
                    if (!"".equals(input)) {
                        desc = String.format("PIC: %s", input);
                        cost = DL.getPic().get(i).getCost();
                    } else {
                        JOptionPane.showMessageDialog(null, "You didn't enter a description!", "You silly goose!", JOptionPane.ERROR_MESSAGE);
                        disCount--;
                    }
                } else {
                    desc = String.format("PIC: %s", DL.getPic().get(i).getName());
                    cost = DL.getPic().get(i).getCost();
                }
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

    private void SkillsArray() {
        int[][] skillsArrayBuild = {
            {1, 1, 1, 1, 2, 4, 8, 12, 16, 20, 24, 28, 32, 36},
            {1, 1, 1, 2, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40},
            {1, 1, 2, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44},
            {1, 2, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48}
        };
        this.skillsArray = skillsArrayBuild;
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

    public String getSkillName() {
        return skillName;
    }

    public String getSkillRelLvl() {
        return skillRelLvl;
    }

    public String getSkillAtt() {
        return skillAtt;
    }

    public int getSkillLvlVal() {
        return skillLvlVal;
    }

}
