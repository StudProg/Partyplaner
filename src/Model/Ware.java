package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sandra
 */
public class Ware {
    private String warenName;
    private double preis;
    private String menge; //BSP: 1.5 L als Angabe
    private double alkoholgehalt;
    private int Strichcode;

    public int getStrichcode() {
        return Strichcode;
    }

    public void setStrichcode(int Strichcode) {
        this.Strichcode = Strichcode;
    }

    /**
     * Gibt den Namen der Ware zurück.
     * @return
     */
    public String getWarenName() {
        return warenName;
    }

    /**
     * Gibt den Preis der Ware zurück.
     * @return
     */
    public double getPreis() {
        return preis;
    }

    /**
     * Gibt die Menge der Ware zurück.
     * @return
     */
    public String getMenge() {
        return menge;
    }

    /**
     * Gibt den Alkoholgehalt der Ware zurück.
     * @return
     */
    public double getAlkoholgehalt() {
        return alkoholgehalt;
    }
    
    /**
    * Die Methode gibt wieder, ob die Ware eine Altersbeschränkung hat.
    * @return 18, wenn über 2.5. 16, wenn zwischen ]0, 2.5]. Andernfalls 0. 
    */
    public int altersbeschraenkung() {
        if (alkoholgehalt>2.5)
            return 18;
        if (alkoholgehalt > 0 && alkoholgehalt <= 2.5)
            return 16;
        return 0;
    }

    /**
    * Der Konstruktor erstellt eine neue Ware mit den angegebenen Parametern.
    * @param warenName
    * @param preis
    * @param menge
    * @param alkoholgehalt
    */
    public Ware (int strichcode, String warenName, double preis, String menge, 
            double alkoholgehalt){
        this.Strichcode = strichcode;
        this.warenName = warenName;
        this.preis = preis;
        this.menge = menge;
        this.alkoholgehalt = alkoholgehalt;
    }
}
