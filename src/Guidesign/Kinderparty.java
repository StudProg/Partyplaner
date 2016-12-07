/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guidesign;

/**
 *
 * @author Miri
 */
public class Kinderparty extends javax.swing.JFrame {

    /**
     * Creates new form Kinderparty
     */
    public Kinderparty() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Starten Sie frühzeitig (ca. 2-3 Monate vorher) mit der Planung!\nSammeln Sie Ideen und lassen Sie sich inspirieren.\n\nLegen Sie das Motto oder das Thema des Kindergeburtstags zusammen mit Ihrem Kind fest.\n\nÜberlegen Sie, wo und wie Sie mit Ihrem Kind feiern möchten. Soll die Party zu \nHause stattfinden, holen Sie sich Unterstützung oder nutzen Sie einen Veranstalter,\nbei dem Sie auswärts die Feier begehen.\n\nEinigen Sie sich auf die Anzahl der Kinder. Als Faustregel gilt – das Geburtstagskind\ndarf so viele Gäste einladen, wie es alt ist (plus/minus ein Kind).\nBei Kindern ab ca. 10 Jahren kommt es auf die Art der Veranstaltung an -\nweniger ist oft mehr!\n\nNehmen Sie Kontakt mit einem Veranstalter oder Animateur für Infos,\nTerminabstimmung und letztlich Buchung auf.\n\nBesorgen Sie Einladungen oder Zubehör und basteln bzw. beschriften diese.\nAm besten ca. 3 Wochen vorher schon verteilen, damit Kinder und Eltern besser \nplanen können.\n\nWerden Dekoartikel oder Spielmaterial benötigt?\nUtensilien dazu rechtzeitig besorgen.\n\nWas soll es zu essen und zu trinken geben? Rezepte aussuchen und Einkaufszettel\nvorbereiten.\n\nKleine Geschenke für Gastkinder besorgen (Mitgebsel-Tüten).\nGeschenkideen für das Geburtstagskind überlegen. In einigen Spielwaren-\nund Buchgeschäften gibt es die Möglichkeit, Geschenkekisten oder –körbe\naufzustellen.\nDort werden vorher die Geschenkwünsche ausgesucht und anschließend können\nFreunde und Verwandte gezielt einen Wunsch erfüllen. \n\nBenötigen Sie noch Helfer oder Autofahrer? Ältere Geschwister freuen sich,\neine Aufgabe übernehmen zu dürfen. Eltern von eingeladenen Kindern finden sich\nbestimmt, die eine Hin- oder Rückfahrt zum Veranstaltungsort übernehmen.\nLegen Sie zusätzlich noch bereit: Fotoapparat, eventuell Filmkamera, Notfallkiste (für kleinere Blessuren z. B. Pflaster, Sonnencreme bei einer Feier im Freien, ggf. Wechselkleidung etc.)");
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Kinderparty");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Kinderparty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kinderparty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kinderparty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kinderparty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kinderparty().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
