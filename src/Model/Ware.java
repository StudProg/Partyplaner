package Model;

import controller.PPdb;

/**
 * Diese Klasse repräsentiert eine Ware.
 * @author Sandra
 */
public class Ware {

    private String warenName;
    private double preis;
    private String menge; //BSP: 1.5 L als Angabe
    private double alkoholgehalt;
    private int Strichcode;

    /**
     * Gibt den Strichcode der Ware zurück. Der Strichcode ist gleichzeitig
     * die eindeutige Identifikation der Ware in der {@link PPdb}.
     *
     * @return int Strichcode
     */
    public int getStrichcode() {
        return Strichcode;
    }

    /**
     * Weist dem Strichcode einen Wert zu.
     *
     * @param Strichcode der Primärschlüssel
     */
    public void setStrichcode(int Strichcode) {
        this.Strichcode = Strichcode;
    }

    /**
     * Gibt den Namen der Ware zurück.
     *
     * @return warenname
     */
    public String getWarenName() {
        return warenName;
    }

    /**
     * Gibt den Preis der Ware zurück.
     *
     * @return preis der Preis der Ware
     */
    public double getPreis() {
        return preis;
    }

    /**
     * Gibt die Menge der Ware zurück.
     *
     * @return menge
     */
    public String getMenge() {
        return menge;
    }

    /**
     * Gibt den Alkoholgehalt der Ware zurück.
     *
     * @return alkoholgehalt
     */
    public double getAlkoholgehalt() {
        return alkoholgehalt;
    }

    /**
     * Die Methode gibt wieder, ob die Ware eine Altersbeschränkung hat.
     *
     * @return 18, wenn über 2.5 % Alkohol. 16, wenn zwischen ]0, 2.5]. Andernfalls 0.
     */
    public int altersbeschraenkung() {
        if (alkoholgehalt > 2.5) {
            return 18;
        }
        if (alkoholgehalt > 0 && alkoholgehalt <= 2.5) {
            return 16;
        }
        return 0;
    }

    /**
     * Der Konstruktor erstellt eine neue Ware mit den angegebenen Parametern.
     * @param strichcode der Primärschlüssel
     * @param warenName der Name
     * @param preis der Preis
     * @param menge die Menge
     * @param alkoholgehalt der Alkoholgehalt
     */
    public Ware(int strichcode, String warenName, double preis, String menge,
            double alkoholgehalt) {
        this.Strichcode = strichcode;
        this.warenName = warenName;
        this.preis = preis;
        this.menge = menge;
        this.alkoholgehalt = alkoholgehalt;
    }
}
