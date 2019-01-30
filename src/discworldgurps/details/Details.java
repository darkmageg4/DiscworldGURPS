package discworldgurps.details;

import discworldgurps.data.DataLoader;
import discworldgurps.data.Talents;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Details {

    private boolean result = false;
    public String ad;
    private String desc, cost;
    DataLoader DL = new DataLoader();

    public void run(String string, String ad) {
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

    public void UnusualBackground() {
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

}
