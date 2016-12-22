/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guidesign;

import controller.Controller;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Miri
 */
public class Gasthinzufuegen extends javax.swing.JFrame{
    public JTextField getVorname() {
        return vnameeintragen;
    }
    public JTextField getNachname() {
        return nnameeintragen;
    }
    public JTextField getGeburtsdatum() {
        return gbteintragen;
    }
    public JTextField getTelefon() {
        return teleintragen;
    }
    public JTextField getMail() {
        return maileintragen;
    }
    public JLabel geterrorLabel() {
        return errorLabel;
    }

    /**
     * Creates new form Gasthinzufügen
     */
    public Gasthinzufuegen(Controller controller) {
        initComponents();
        gastEinfuegen.addActionListener(controller);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gastvname = new javax.swing.JLabel();
        gastnname = new javax.swing.JLabel();
        gastgbt = new javax.swing.JLabel();
        gastmail = new javax.swing.JLabel();
        gasttel = new javax.swing.JLabel();
        vnameeintragen = new javax.swing.JTextField();
        nnameeintragen = new javax.swing.JTextField();
        gbteintragen = new javax.swing.JTextField();
        teleintragen = new javax.swing.JTextField();
        maileintragen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        gastEinfuegen = new javax.swing.JToggleButton();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        gastvname.setText("Vorname");

        gastnname.setText("Nachname");

        gastgbt.setText("Geburtsdatum");

        gastmail.setText("Email");

        gasttel.setText("Telefon");

        gastEinfuegen.setText("Gast hinzufügen");
        gastEinfuegen.setActionCommand("Gast speichern");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gastvname)
                            .addComponent(gastnname)
                            .addComponent(gasttel)
                            .addComponent(gastmail)
                            .addComponent(gastgbt))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gbteintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teleintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nnameeintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maileintragen, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vnameeintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(gastEinfuegen)))
                .addGap(36, 36, 36))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {gbteintragen, maileintragen, nnameeintragen, teleintragen, vnameeintragen});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gastvname)
                    .addComponent(vnameeintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gastnname)
                    .addComponent(nnameeintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gastgbt)
                    .addComponent(gbteintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gasttel)
                    .addComponent(teleintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gastmail)
                    .addComponent(maileintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gastEinfuegen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JToggleButton gastEinfuegen;
    private javax.swing.JLabel gastgbt;
    private javax.swing.JLabel gastmail;
    private javax.swing.JLabel gastnname;
    private javax.swing.JLabel gasttel;
    private javax.swing.JLabel gastvname;
    private javax.swing.JTextField gbteintragen;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField maileintragen;
    private javax.swing.JTextField nnameeintragen;
    private javax.swing.JTextField teleintragen;
    private javax.swing.JTextField vnameeintragen;
    // End of variables declaration//GEN-END:variables
}
