/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discworldgurps.details;

import javax.swing.JOptionPane;

/**
 *
 * @author mageg
 */
public class DetailsGUI extends javax.swing.JDialog {

    private double a, b, c;
    private int cost;
    private String desc;
    private static String string;
    private static String ad;

    public int closed = 0;

    /**
     * Creates new DetailsGUI. Default set-up is Contact
     *
     * @param parent
     * @param modal
     * @param string The ad/dis name
     * @param ad Whether it's an ad or dis
     */
    public DetailsGUI(java.awt.Frame parent, boolean modal, String string, String ad) {
        super(parent, modal);
        initComponents();
        this.string = string;
        this.ad = ad;
        Switch(ad);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelA = new javax.swing.JLabel();
        jLabelB = new javax.swing.JLabel();
        jLabelC = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxA = new javax.swing.JComboBox<>();
        jComboBoxB = new javax.swing.JComboBox<>();
        jComboBoxC = new javax.swing.JComboBox<>();
        jTextFieldDesc = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(null);
        setMinimumSize(null);
        setPreferredSize(new java.awt.Dimension(500, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelA.setText("Contact Skill");
        jLabelA.setMaximumSize(null);
        jLabelA.setMinimumSize(null);
        jLabelA.setPreferredSize(null);

        jLabelB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelB.setText("Reliability");
        jLabelB.setMaximumSize(null);
        jLabelB.setMinimumSize(null);
        jLabelB.setPreferredSize(null);

        jLabelC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelC.setText("Frequency");
        jLabelC.setMaximumSize(null);
        jLabelC.setMinimumSize(null);
        jLabelC.setPreferredSize(null);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Description");

        jComboBoxA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "15", "18", "21" }));
        jComboBoxA.setMaximumSize(null);
        jComboBoxA.setMinimumSize(null);
        jComboBoxA.setPreferredSize(null);

        jComboBoxB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Completely Reliable", "Usually Reliable", "Somewhat Reliable" }));
        jComboBoxB.setMaximumSize(null);
        jComboBoxB.setMinimumSize(null);
        jComboBoxB.setPreferredSize(null);

        jComboBoxC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "15 or below", "12 or below", "9 or below", "6 or below" }));
        jComboBoxC.setMaximumSize(null);
        jComboBoxC.setMinimumSize(null);
        jComboBoxC.setPreferredSize(null);

        jButtonAdd.setText("Add");
        jButtonAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDesc)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelA, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxC, 0, 123, Short.MAX_VALUE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAdd)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        switch (string) {
            case "Reputation":
                Reputation();
                break;
            case "Congregation":
                Congregation();
                break;
            case "Patron":
                Patron();
                break;
            case "Dependents":
                Dependents();
                break;
            case "Enemies":
                Enemies();
                break;
            default:
                Contact();
                break;
        }
        if ("".equals(jTextFieldDesc.getText())) {
            JOptionPane.showMessageDialog(null, "You didn't enter a description!", "You silly goose!", JOptionPane.ERROR_MESSAGE);
        } else {
            dispose();
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        closed = 1;
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closed = 1;
    }//GEN-LAST:event_formWindowClosing

    private void Switch(String ad) {
        switch (string) {
            case "Reputation":
                jLabelA.setText("Reputation Level");
                jComboBoxA.removeAllItems();
                if ("a".equals(ad)){
                jComboBoxA.addItem("Reputation + 1");
                jComboBoxA.addItem("Reputation + 2");
                jComboBoxA.addItem("Reputation + 3");
                jComboBoxA.addItem("Reputation + 4");
                }
                else{
                jComboBoxA.addItem("Reputation - 1");
                jComboBoxA.addItem("Reputation - 2");
                jComboBoxA.addItem("Reputation - 3");
                jComboBoxA.addItem("Reputation - 4");
                }
                jLabelB.setText("People Affected");
                jComboBoxB.removeAllItems();
                jComboBoxB.addItem("Almost Everyone");
                jComboBoxB.addItem("AE except a Large Class");
                jComboBoxB.addItem("Large Class");
                jComboBoxB.addItem("Small Class");
                jComboBoxC.removeAllItems();
                jComboBoxC.addItem("All The Time");
                jComboBoxC.addItem("Occasionally");
                jComboBoxC.addItem("Sometimes");
                break;
            case "Congregation":
                jLabelA.setText("Congregation Size");
                jComboBoxA.removeAllItems();
                jComboBoxA.addItem("Small (Up to 20)");
                jComboBoxA.addItem("Medium (Up to 50)");
                jComboBoxA.addItem("Large (Up to 100)");
                jComboBoxB.setVisible(false);
                jLabelB.setVisible(false);
                break;
            case "Patron":
                jLabelA.setText("Patron Power");
                jComboBoxA.removeAllItems();
                jComboBoxA.addItem("Level 1");
                jComboBoxA.addItem("Level 2");
                jComboBoxA.addItem("Level 3");
                jComboBoxA.addItem("Level 4");
                jComboBoxA.addItem("Level 5");
                jComboBoxB.setVisible(false);
                jLabelB.setVisible(false);
                break;
            case "Dependents":
                jLabelA.setText("Competance");
                jComboBoxA.removeAllItems();
                jComboBoxA.addItem("<= 100%");
                jComboBoxA.addItem("<= 75%");
                jComboBoxA.addItem("<= 50%");
                jComboBoxA.addItem("<= 25%");
                jComboBoxA.addItem("<= 0");
                jLabelB.setText("Importance");
                jComboBoxB.removeAllItems();
                jComboBoxB.addItem("Acquaintance");
                jComboBoxB.addItem("Friend");
                jComboBoxB.addItem("Loved One");
                break;
            case "Enemies":
                jLabelA.setText("Power");
                jComboBoxA.removeAllItems();
                jComboBoxA.addItem("1 Weak");
                jComboBoxA.addItem("1 Equal");
                jComboBoxA.addItem("1 Strong");
                jComboBoxA.addItem("Group");
                jComboBoxA.addItem("Strong Group");
                jLabelB.setText("Intent");
                jComboBoxB.removeAllItems();
                jComboBoxB.addItem("Watcher");
                jComboBoxB.addItem("Rival");
                jComboBoxB.addItem("Hunter");
                break;
            default:
                break;
        }
    }

    private void Reputation() {
        String repMod = "1";
        switch (jComboBoxA.getSelectedIndex()) {
            case 0:
                a = 5;
                repMod = "1";
                break;
            case 1:
                a = 10;
                repMod = "2";
                break;
            case 2:
                a = 15;
                repMod = "3";
                break;
            case 3:
                a = 20;
                repMod = "4";
                break;
            default:
                break;
        }
        switch (jComboBoxB.getSelectedIndex()) {
            case 0:
                b = 1;
                break;
            case 1:
                b = 0.67;
                break;
            case 2:
                b = 0.5;
                break;
            case 3:
                b = 0.34;
                break;
            default:
                break;
        }
        switch (jComboBoxC.getSelectedIndex()) {
            case 0:
                c = 1;
                break;
            case 1:
                c = 0.5;
                break;
            case 2:
                c = 0.34;
                break;
            default:
                break;
        }
        if ("d".equals(this.ad)) {
            cost = (int) ((-a * b) * c);
            if (cost > -1) {
                cost = -1;
            }
            desc = String.format("Rep: %s (Mod: -%s | Freq: %s)", jTextFieldDesc.getText(), repMod, jComboBoxC.getSelectedItem().toString());
        } else {
            cost = (int) ((a * b) * c);
            if (cost < 1) {
                cost = 1;
            }
            desc = String.format("Rep: %s (Mod: +%s | Freq: %s)", jTextFieldDesc.getText(), repMod, jComboBoxC.getSelectedItem().toString());
        }
    }

    private void Congregation() {
        switch (jComboBoxA.getSelectedIndex()) {
            case 0:
                a = 10;
                break;
            case 1:
                a = 12;
                break;
            case 2:
                a = 15;
                break;
            default:
                break;
        }
        switch (jComboBoxC.getSelectedIndex()) {
            case 0:
                c = 3;
                break;
            case 1:
                c = 2;
                break;
            case 2:
                c = 1;
                break;
            case 3:
                c = 0.5;
                break;
            default:
                break;
        }

        cost = (int) (a * c);
        desc = String.format("Cong: %s (%s appears on %s)", jTextFieldDesc.getText(), jComboBoxA.getSelectedItem(), jComboBoxC.getSelectedItem());
    }

    private void Contact() {
        switch (jComboBoxA.getSelectedIndex()) {
            case 0:
                a = 1;
                break;
            case 1:
                a = 2;
                break;
            case 2:
                a = 3;
                break;
            case 3:
                a = 4;
                break;
            default:
                break;
        }
        switch (jComboBoxB.getSelectedIndex()) {
            case 0:
                b = 3;
                break;
            case 1:
                b = 2;
                break;
            case 2:
                b = 1;
                break;
            default:
                break;
        }
        switch (jComboBoxC.getSelectedIndex()) {
            case 0:
                c = 3;
                break;
            case 1:
                c = 2;
                break;
            case 2:
                c = 1;
                break;
            case 3:
                c = 0.5;
                break;
            default:
                break;
        }
        cost = (int) ((a * c) * b);
        if (cost < 1) {
            cost = 1;
        }
        desc = String.format("Cont: %s (Skill: %s | Freq: %s | Rel: %s)",
                jTextFieldDesc.getText(), jComboBoxA.getSelectedItem(), jComboBoxC.getSelectedItem(), jComboBoxB.getSelectedItem());
    }

    private void Patron() {
        switch (jComboBoxA.getSelectedIndex()) {
            case 0:
                a = 10;
                break;
            case 1:
                a = 15;
                break;
            case 2:
                a = 20;
                break;
            case 3:
                a = 25;
                break;
            case 4:
                a = 30;
                break;
            default:
                break;
        }
        switch (jComboBoxC.getSelectedIndex()) {
            case 0:
                c = 3;
                break;
            case 1:
                c = 2;
                break;
            case 2:
                c = 1;
                break;
            case 3:
                c = 0.5;
                break;
            default:
                break;
        }
        cost = (int) (a * c);
        desc = String.format("Pat: %s (%s appears on %s)", jTextFieldDesc.getText(), jComboBoxA.getSelectedItem(), jComboBoxC.getSelectedItem());
    }

    private void Dependents() {
        switch (jComboBoxA.getSelectedIndex()) {
            case 0:
                a = -1;
                break;
            case 1:
                a = -2;
                break;
            case 2:
                a = -5;
                break;
            case 3:
                a = -10;
                break;
            default:
                break;
        }
        switch (jComboBoxB.getSelectedIndex()) {
            case 0:
                b = 0.5;
                break;
            case 1:
                b = 1;
                break;
            case 2:
                b = 2;
                break;
            default:
                break;
        }
        switch (jComboBoxC.getSelectedIndex()) {
            case 0:
                c = 3;
                break;
            case 1:
                c = 2;
                break;
            case 2:
                c = 1;
                break;
            case 3:
                c = 0.5;
                break;
            default:
                break;
        }
        cost = (int) ((a * b) * c);
        if (cost > -1) {
            cost = -1;
        }
        desc = String.format("Dep: %s (Comp: %s | Freq: %s | Imp: %s)",
                jTextFieldDesc.getText(), jComboBoxA.getSelectedItem(), jComboBoxC.getSelectedItem(), jComboBoxB.getSelectedItem());
    }

    private void Enemies() {
        switch (jComboBoxA.getSelectedIndex()) {
            case 0:
                a = -5;
                break;
            case 1:
                a = -10;
                break;
            case 2:
                a = -20;
                break;
            case 3:
                a = -30;
                break;
            case 4:
                a = -40;
                break;
            default:
                break;
        }
        switch (jComboBoxB.getSelectedIndex()) {
            case 0:
                b = 0.25;
                break;
            case 1:
                b = 0.5;
                break;
            case 2:
                b = 1;
                break;
            default:
                break;
        }
        switch (jComboBoxC.getSelectedIndex()) {
            case 0:
                c = 3;
                break;
            case 1:
                c = 2;
                break;
            case 2:
                c = 1;
                break;
            case 3:
                c = 0.5;
                break;
            default:
                break;
        }
        cost = (int) ((a * b) * c);
        if (cost > -1) {
            cost = -1;
        }
        desc = String.format("Ene: %s (Pow: %s | Freq: %s | Int: %s)",
                jTextFieldDesc.getText(), jComboBoxA.getSelectedItem(), jComboBoxC.getSelectedItem(), jComboBoxB.getSelectedItem());
    }

    public String getCost() {
        return String.format("%d", cost);
    }

    public String getDesc() {
        return desc;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetailsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DetailsGUI dialog = new DetailsGUI(new javax.swing.JFrame(), true, string, ad);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JComboBox<String> jComboBoxA;
    private javax.swing.JComboBox<String> jComboBoxB;
    private javax.swing.JComboBox<String> jComboBoxC;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelA;
    private javax.swing.JLabel jLabelB;
    private javax.swing.JLabel jLabelC;
    private javax.swing.JTextField jTextFieldDesc;
    // End of variables declaration//GEN-END:variables
}
