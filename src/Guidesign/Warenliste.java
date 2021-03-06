package Guidesign;

import controller.Controller;
import javax.swing.JList;

/**
 * Hier wird Liste aller gespeicherten Waren angezeigt.
 * @author Miri 
 */
public class Warenliste extends javax.swing.JFrame {

    private Controller controller;

    /**
     * Gibt das JList Component für die Liste aller Waren zurück.
     * @return warenliste gibt das JList aller Waren zurück
     */
    public JList<String> getwarenListe() {
        return warenliste;
    }

    /**
     * Konstuktor für das Fenster der Warenliste.
     *
     * @param controller ein {@link Controller} als ActionListener.
     */
    public Warenliste(Controller controller) {
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

        jToggleButton3 = new javax.swing.JToggleButton();
        warehinzufuegen = new javax.swing.JToggleButton();
        wareentfernen = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        warenliste = new javax.swing.JList<>();
        wl = new javax.swing.JLabel();

        jToggleButton3.setText("jToggleButton3");

        warehinzufuegen.setText("Ware hinzufügen");

        wareentfernen.setText("Ware entfernen");

        jScrollPane1.setViewportView(warenliste);

        wl.setText("Warenliste");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(warehinzufuegen)
                                .addGap(129, 129, 129)
                                .addComponent(wareentfernen))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(wl)))
                .addGap(258, 258, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(wl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(warehinzufuegen)
                    .addComponent(wareentfernen))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Die Action Listener für "Ware hinzufügen" und "Ware entfernen" werden
     * im Controller registriert.
     */
    private void addActionListener() {
        warehinzufuegen.addActionListener(controller);
        wareentfernen.addActionListener(controller);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton wareentfernen;
    private javax.swing.JToggleButton warehinzufuegen;
    private javax.swing.JList<String> warenliste;
    private javax.swing.JLabel wl;
    // End of variables declaration//GEN-END:variables
}
