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
public class Startseite extends javax.swing.JFrame {

    private final Controller controller;

    public JLabel getErrorLabel() {
        return errorLabel;
    }
    
    

    public JTextField getPartynameeintragen() {
        return partynameeintragen;
    }
    
    public JTextField getPartydatumeintragen() {
        return partydatumeintragen;
    }
    
    public JTextField getPartybudget() {
        return partybudget;
    }
    
    public JTextField getGaesteAnzahlEintragen() {
        return gaesteanzahleintragen;
    }

    /**
     * Creates new form NewJFrame
     */
    public Startseite(Controller controller) {
        this.controller = controller;
        initComponents();
        addActionListeners();
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu3 = new javax.swing.JMenu();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        partyname = new javax.swing.JLabel();
        partydatum = new javax.swing.JLabel();
        gaesteanzahl = new javax.swing.JLabel();
        budget = new javax.swing.JLabel();
        anmerkung = new javax.swing.JLabel();
        partynameeintragen = new javax.swing.JTextField();
        partydatumeintragen = new javax.swing.JTextField();
        gaesteanzahleintragen = new javax.swing.JTextField();
        partybudget = new javax.swing.JTextField();
        anermkungeintragen = new javax.swing.JTextField();
        raumbedarf = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();
        partyabbrechen = new javax.swing.JButton();
        partyEinfuegen = new javax.swing.JButton();
        gaestelisteerstellen = new javax.swing.JButton();
        einkaufslisteerstellen = new javax.swing.JButton();
        raumbedarfberechnung = new javax.swing.JButton();
        startmenue = new javax.swing.JMenuBar();
        partymenue = new javax.swing.JMenu();
        partyanzeigen = new javax.swing.JMenuItem();
        partyerstellen = new javax.swing.JMenuItem();
        gaestebuchmenue = new javax.swing.JMenu();
        gbanzeigen = new javax.swing.JMenuItem();
        warenlistemenue = new javax.swing.JMenu();
        warenanzeigen = new javax.swing.JMenuItem();
        tipps = new javax.swing.JMenu();
        kinderparty = new javax.swing.JMenuItem();
        couchparty = new javax.swing.JMenuItem();
        tanzparty = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        partyname.setText("Name");

        partydatum.setText("Datum");

        gaesteanzahl.setText("Gästeanzahl");

        budget.setText("Budget");

        anmerkung.setText("Anmerkung");

        gaesteanzahleintragen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gaesteanzahlintragenActionPerformed(evt);
            }
        });

        raumbedarf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raumbedarfActionPerformed(evt);
            }
        });

        partyabbrechen.setText("Abbrechen");

        partyEinfuegen.setText("Speichern");
        partyEinfuegen.setName(""); // NOI18N

        gaestelisteerstellen.setText("Gästeliste erstellen");

        einkaufslisteerstellen.setText("Einkaufsliste erstellen");

        raumbedarfberechnung.setText("Raumbedarf berechnen");
        raumbedarfberechnung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raumbedarfberechnungActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(partyname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(partydatum, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(gaesteanzahl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(budget, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(anmerkung, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(partynameeintragen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(partydatumeintragen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(gaesteanzahleintragen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(partybudget, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(anermkungeintragen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(raumbedarf, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(errorLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(partyabbrechen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(partyEinfuegen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(gaestelisteerstellen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(einkaufslisteerstellen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(raumbedarfberechnung, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(partyname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(partynameeintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(partydatum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(partydatumeintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(gaesteanzahl)
                                .addGap(18, 18, 18)
                                .addComponent(gaesteanzahleintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(budget)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(partybudget, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addComponent(raumbedarfberechnung)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(gaestelisteerstellen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(einkaufslisteerstellen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(raumbedarf, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))))
                    .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(anmerkung)
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(anermkungeintragen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(partyabbrechen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(partyEinfuegen)))))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jLayeredPane1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {gaesteanzahleintragen, partybudget, partydatumeintragen, partynameeintragen});

        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(partyname)
                    .addComponent(partynameeintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gaestelisteerstellen))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(partydatum)
                        .addComponent(partydatumeintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(einkaufslisteerstellen))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gaesteanzahl)
                    .addComponent(gaesteanzahleintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raumbedarfberechnung))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(budget)
                    .addComponent(partybudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raumbedarf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(anmerkung)
                    .addComponent(anermkungeintragen, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(partyabbrechen)
                    .addComponent(partyEinfuegen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel)
                .addGap(0, 193, Short.MAX_VALUE))
        );

        partymenue.setText("Party");

        partyanzeigen.setText("Party anzeigen");
        partymenue.add(partyanzeigen);

        partyerstellen.setText("Party erstellen");
        partymenue.add(partyerstellen);

        startmenue.add(partymenue);

        gaestebuchmenue.setText("Gästebuch");
        gaestebuchmenue.setActionCommand("Gaestebuch");
        gaestebuchmenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gaestebuchmenueActionPerformed(evt);
            }
        });

        gbanzeigen.setText("Gästebuch anzeigen");
        gbanzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gbanzeigenActionPerformed(evt);
            }
        });
        gaestebuchmenue.add(gbanzeigen);

        startmenue.add(gaestebuchmenue);

        warenlistemenue.setText("Warenliste");
        warenlistemenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warenlistemenueActionPerformed(evt);
            }
        });

        warenanzeigen.setText("Waren anzeigen");
        warenanzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warenanzeigenActionPerformed(evt);
            }
        });
        warenlistemenue.add(warenanzeigen);

        startmenue.add(warenlistemenue);

        tipps.setText("Tipps");

        kinderparty.setText("Kinderparty");
        kinderparty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kinderpartyActionPerformed(evt);
            }
        });
        tipps.add(kinderparty);

        couchparty.setText("Couchparty");
        couchparty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                couchpartyActionPerformed(evt);
            }
        });
        tipps.add(couchparty);

        tanzparty.setText("Tanzparty");
        tanzparty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanzpartyActionPerformed(evt);
            }
        });
        tipps.add(tanzparty);

        startmenue.add(tipps);

        setJMenuBar(startmenue);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gaestebuchmenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gaestebuchmenueActionPerformed
        Gästebuch gb = new Gästebuch();
        gb.setVisible(true);// Menü in Item ändern 
    }//GEN-LAST:event_gaestebuchmenueActionPerformed

    private void warenlistemenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warenlistemenueActionPerformed
      Warenliste wl = new Warenliste();
      wl.setVisible(true);//Menü in Item ändern
    }//GEN-LAST:event_warenlistemenueActionPerformed

    private void kinderpartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kinderpartyActionPerformed
        Kinderparty kp = new Kinderparty();
        kp.setVisible(true);
    }//GEN-LAST:event_kinderpartyActionPerformed

    private void tanzpartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanzpartyActionPerformed
        Tanzparty tp = new Tanzparty ();
        tp.setVisible(true);
    }//GEN-LAST:event_tanzpartyActionPerformed

    private void couchpartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_couchpartyActionPerformed
        Couchparty cp = new Couchparty ();
        cp.setVisible(true);
    }//GEN-LAST:event_couchpartyActionPerformed

    private void gbanzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gbanzeigenActionPerformed
        Gästebuch gb= new Gästebuch();
        gb.setVisible(true);
    }//GEN-LAST:event_gbanzeigenActionPerformed

    private void warenanzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warenanzeigenActionPerformed
        Warenliste wl= new Warenliste();
        wl.setVisible(true);
        
    }//GEN-LAST:event_warenanzeigenActionPerformed

    private void raumbedarfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raumbedarfActionPerformed
    
         }//GEN-LAST:event_raumbedarfActionPerformed

    private void gaesteanzahlintragenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gaesteanzahlintragenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gaesteanzahlintragenActionPerformed

    private void raumbedarfberechnungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raumbedarfberechnungActionPerformed
        double g, rb;
       g= Double.parseDouble(gaesteanzahleintragen.getText());
       rb= g*1.4;
       rb = Math.round(rb*1000)/1000.0;
       raumbedarf.setText(rb+ " qm");
    }//GEN-LAST:event_raumbedarfberechnungActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anermkungeintragen;
    private javax.swing.JLabel anmerkung;
    private javax.swing.JLabel budget;
    private javax.swing.JMenuItem couchparty;
    private javax.swing.JButton einkaufslisteerstellen;
    public javax.swing.JLabel errorLabel;
    private javax.swing.JLabel gaesteanzahl;
    private javax.swing.JTextField gaesteanzahleintragen;
    private javax.swing.JMenu gaestebuchmenue;
    private javax.swing.JButton gaestelisteerstellen;
    private javax.swing.JMenuItem gbanzeigen;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuItem kinderparty;
    private javax.swing.JButton partyEinfuegen;
    private javax.swing.JButton partyabbrechen;
    private javax.swing.JMenuItem partyanzeigen;
    private javax.swing.JTextField partybudget;
    private javax.swing.JLabel partydatum;
    private javax.swing.JTextField partydatumeintragen;
    private javax.swing.JMenuItem partyerstellen;
    private javax.swing.JMenu partymenue;
    private javax.swing.JLabel partyname;
    private javax.swing.JTextField partynameeintragen;
    private javax.swing.JTextField raumbedarf;
    private javax.swing.JButton raumbedarfberechnung;
    private javax.swing.JMenuBar startmenue;
    private javax.swing.JMenuItem tanzparty;
    private javax.swing.JMenu tipps;
    private javax.swing.JMenuItem warenanzeigen;
    private javax.swing.JMenu warenlistemenue;
    // End of variables declaration//GEN-END:variables

    private void addActionListeners() {
        this.partyerstellen.addActionListener(controller);
        this.partyanzeigen.addActionListener(controller);
        this.partyEinfuegen.addActionListener(controller);
        this.gaestebuchmenue.addActionListener(controller);
        
    }
}
