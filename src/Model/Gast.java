package Model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Die Klasse für einen Gast.
 *
 * @author Miri
 */
public class Gast {

    private String vorname;
    private String nachname;
    private GregorianCalendar geburtstdatum;
    private String email;
    private String telefon;
    private int gastnummer;

    /**
     * Kreirt einen neuen Gast mit den Parametern.
     *
     * @param vorname Der Vorname des Gastes
     * @param nachname der Nachname des Gastes
     * @param geburtstdatum das Geburtsdatum des Gastes
     * @param email Die Email des Gastes
     * @param telefon die Telefonummer des Gastes
     */
    public Gast(String vorname, String nachname,
            GregorianCalendar geburtstdatum, String email, String telefon) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtstdatum = geburtstdatum;
        this.email = email;
        this.telefon = telefon;
    }

    /**
     * Gibt den vollen Namen (Vor- und Zuname) als String zurück.
     *
     * @return vorname + nachname
     */
    public String getName() {
        return vorname + " " + nachname;
    }

    /**
     * Gibt nur den Vornamen zurück.
     *
     * @return vorname
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * Weist dem Vornamen einen Wert zu
     *
     * @param vorname der Vorname des Gastes
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**
     * Gibt nur den Nachnamen des Gastes zurück.
     *
     * @return nachname
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * Weist dem Nachnamen eine Wert zu
     *
     * @param nachname der nachname des Gastes
     */
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    /**
     * Gibt das Geburtstag des Gastes zurück.
     *
     * @return geburtsdatum
     */
    public GregorianCalendar getGeburtstdatum() {
        return geburtstdatum;
    }

    /**
     * Weist dem Gebutsdatum einen Wert zu
     *
     * @param geburtstdatum das geburtsdatum des Gastes als {@link GregorianCalendar}
     */
    public void setGeburtstdatum(GregorianCalendar geburtstdatum) {
        this.geburtstdatum = geburtstdatum;
    }

    /**
     * Gibt das Geburtsdatum lesbar zurück.
     *
     * @return das Geburtsdatum als String mit Tag+Monat+Jahr
     */
    public String getDatumAlsString() {
        int datumTag = geburtstdatum.get(Calendar.DAY_OF_MONTH);
        int datumMonat = geburtstdatum.get(Calendar.MONTH);
        int datumJahr = geburtstdatum.get(Calendar.YEAR);
        return datumTag + "." + datumMonat + "." + datumJahr;
    }

    /**
     * Gibt die Gastnummer zurück.
     *
     * @return gastnummer Die Nummer des Gastes
     */
    public int getGastnummer() {
        return gastnummer;
    }

    /**
     * Setzt die Gastnummer auf einen bestimmten Wert.
     *
     * @param gastnummer die Nummer des Gastes
     */
    public void setGastnummer(int gastnummer) {
        this.gastnummer = gastnummer;
    }

    /**
     * Gibt die Email dieses Gastes zurück.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setzt die Email auf einen Wert
     *
     * @param email die EMail adresse des Gastes
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gibt die Telefonnummer des Gastes zurück.
     *
     * @return telefon Die Telefonnummer des Gastes
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Weist der Telefonnummer einen Wert zu
     *
     * @param telefon die Telefonnummer des Gastes
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

}
