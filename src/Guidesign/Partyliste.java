package Guidesign;

import controller.Controller;
import javax.swing.JList;

/**
 * Zeigt einem alle bereits geplanten Partys an. Diese kann man
 * sich detaillierter anzeigen lassen oder löschen.
 * @author Miri
 */
public class Partyliste extends javax.swing.JDialog {

    private Controller controller;

    /**
     * Getter für das JList Component 
     * @return JList Component, dass die Informationen über die Partys hält.
     */
    public JList<String> getpartylist() {
        return partylist;
    }

    /**
     * Konstruktor für das Partyliste Fenster.
     *
     * @param controller der {@link Controller} als ActionListener
     */
    public Partyliste(Controller controller) {
        this.controller = controller;
        initComponents();
        addActionListener();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        partyliste = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        partylist = new javax.swing.JList<>();
        partyanzeigen = new javax.swing.JToggleButton();
        partyloeschen = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        partyliste.setText("Partyliste");

        jScrollPane1.setViewportView(partylist);

        partyanzeigen.setText("Party anzeigen");
        partyanzeigen.setActionCommand("Partyliste.PartyAnzeigen");

        partyloeschen.setText("Party löschen");
        partyloeschen.setActionCommand("Partyliste.PartyLöschen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(partyliste))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(partyanzeigen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(partyloeschen)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(partyliste)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(partyanzeigen)
                    .addComponent(partyloeschen))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  /**
     * Den Buttons für anzeigen und löschen werden ActionListener hinzugefügt,
     * die im Controller registriert werden.
     */
    private void addActionListener() {
        partyanzeigen.addActionListener(controller);
        partyloeschen.addActionListener(controller);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton partyanzeigen;
    private javax.swing.JList<String> partylist;
    private javax.swing.JLabel partyliste;
    private javax.swing.JToggleButton partyloeschen;
    // End of variables declaration//GEN-END:variables
}
