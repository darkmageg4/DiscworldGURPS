package discworldgurps.details;

import static discworldgurps.Sheet.advCount;
import static discworldgurps.Sheet.cultCount;
import static discworldgurps.Sheet.disCount;
import static discworldgurps.Sheet.skillsCount;
import discworldgurps.data.Culture;
import discworldgurps.data.DataLoader;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Details {

    private boolean result = false;
    public String ad;
    private String desc, cost;
    private String lang, langSpok, langWrit;
    int[][] skillsArray = new int[4][14];
    private String skillName, skillRelLvl, skillAtt;
    private int skillLvlVal, skillLvlAdd;

    DataLoader DL = new DataLoader();

    /**
     * Runs the advantages pop up
     */
    public void runAdvantages() {
        desc = JOptionPane.showInputDialog(null, "Description");
        if (desc != null && !"".equals(desc)) {
            String otherCost = JOptionPane.showInputDialog(null, "Point Cost", "1");
            cost = otherCost;
            advCount++;
            result = true;
        } else {
            result = false;
        }
    }

    /**
     * Runs the disadvantages pop up
     */
    public void runDisadvantages() {
        desc = JOptionPane.showInputDialog(null, "Description");
        if (desc != null && !"".equals(desc)) {
            String otherCost = JOptionPane.showInputDialog(null, "Point Cost", "-1");
            if (Integer.parseInt(otherCost) > 0) {
                cost = String.format("-%s", otherCost);
                disCount++;
                result = true;
            }
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
        SkillsGUI sgui = new SkillsGUI(null, true);
        sgui.setModal(true);
        sgui.setLocationRelativeTo(null);
        sgui.setVisible(true);
        if (sgui.closed != 1) {
            skillsCount++;
            SkillsArray();
            if (sgui.getSkillLvl() != null && !"".equals(sgui.getSkillLvl())) {
                skillLvlVal = Integer.parseInt(sgui.getSkillLvl());
                skillLvlAdd = Integer.parseInt(sgui.getSkillLvlAdd());
                int skillCost = 1;
                switch (sgui.getSkillDiff()) {
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
                skillName = String.format("%s", sgui.getSkillDesc());
                if (skillLvlVal >= 0) {
                    skillRelLvl = String.format("%s +%s", sgui.getSkillContAtt(), skillLvlVal + skillLvlAdd);
                } else {
                    skillRelLvl = String.format("%s %s", sgui.getSkillContAtt(), skillLvlVal + skillLvlAdd);
                }
                skillAtt = sgui.getSkillContAtt();
                this.cost = Integer.toString(cost);
                result = true;
            } else {
                result = false;
            }
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
