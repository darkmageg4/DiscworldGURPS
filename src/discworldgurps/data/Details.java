package discworldgurps.data;

import discworldgurps.Congregation;
import discworldgurps.Contact;
import discworldgurps.Reputation;

public class Details {

    private boolean result = false;
    private String desc, cost;

    public void run(String string) {
        if (null != string) {
            switch (string) {
                case "Reputation (0)":
                    Reputation();
                    break;
                case "Congregation (0)":
                    Congregation();
                    break;
                case "Contacts (0)":
                    Contact();
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
        Reputation rep = new Reputation(null, true);
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

    public boolean isResult() {
        return result;
    }

    public String getDesc() {
        return desc;
    }

    public String getCost() {
        return cost;
    }

}
