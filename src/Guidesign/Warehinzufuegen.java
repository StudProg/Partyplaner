package Guidesign;

import controller.Controller;
import javax.swing.JTextField;

/**
 * Hier kann man ein neues Produkt der Warenliste hinzufügen.
 * @author Miri
 */
public class Warehinzufuegen extends javax.swing.JFrame {

    /**
     * Getter für das JTextField des Warennamens.
     * @return warennameeintragen gibt das JtextFields des Warennamen zurück, 
     * den der Nutzer eingegeben hat
     */
    public JTextField getWarenname() {
        return warennameeintragen;
    }

    /**
     * Getter für das JTextField des Volumen.
     * @return volumenmenge gibt das JTextField des Volumen zurück, das der 
     * Nutzer eingegeben hat
     */
    public JTextField getvolumenmenge() {
        return volumenmengeeintragen;
    }

    /**
     * Getter für das JTextField des Alkoholgehalts.
     * @return alkoholgehalteintragen gibt das JTextField des Alkoholgehalt 
     * zurück, den der Nutzer eingegeben hat
     */
    public JTextField getalkoholgehalt() {
        return alkoholgehalteintragen;
    }

    /**
     * Getter für das JTextField des Preises.
     * @return preiseintragen gibt das JTextField des Preises zurück, den der 
     * Nutzer eingegeben hat
     */
    public JTextField getPreis() {
        return preiseintragen;
    }

    /**
     * Konstruktor für ein neues Fenster, in dem Waren zur Verwaltung 
     * hinzugefügt werden können.
     *
     * @param controller Ein Objekt vom Typ {@link Controller} und ActionListener
     * für den Button "Ware speichern"
     */
    public Warehinzufuegen(Controller controller) {
        initComponents();
        warespeichern.addActionListener(controller);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        warennameeintragen = new javax.swing.JTextField();
        volumenmengeeintragen = new javax.swing.JTextField();
        preiseintragen = new javax.swing.JTextField();
        warenname = new javax.swing.JLabel();
        preis = new javax.swing.JLabel();
        volumenmenge = new javax.swing.JLabel();
        warespeichern = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        alkoholgehalteintragen = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        warenname.setText("Warenname");

        preis.setText("Preis");

        volumenmenge.setText("Volumen/Menge");

        warespeichern.setText("Ware speichern");

        jLabel1.setText("Alkoholgehalt in %");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(269, Short.MAX_VALUE)
                .addComponent(warespeichern)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(warenname)
                    .addComponent(volumenmenge)
                    .addComponent(preis)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(preiseintragen, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(volumenmengeeintragen, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(warennameeintragen)
                    .addComponent(alkoholgehalteintragen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(warennameeintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warenname))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volumenmenge)
                    .addComponent(volumenmengeeintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(alkoholgehalteintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(preis)
                    .addComponent(preiseintragen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(warespeichern)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alkoholgehalteintragen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel preis;
    private javax.swing.JTextField preiseintragen;
    private javax.swing.JLabel volumenmenge;
    private javax.swing.JTextField volumenmengeeintragen;
    private javax.swing.JLabel warenname;
    private javax.swing.JTextField warennameeintragen;
    private javax.swing.JToggleButton warespeichern;
    // End of variables declaration//GEN-END:variables
}
