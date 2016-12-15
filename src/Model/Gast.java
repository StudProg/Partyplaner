package Model;


import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Die Klasse für einen Gast.
 * @author Sandra
 */
public class Gast {
    private String vorname;
    private String nachname;
    private GregorianCalendar geburtstdatum;
    private int gastnummer;
    private String email;
    private String telefon;
    
    /**
     * Gibt den vollen Namen (Vor- und Zuname) als String zurück.
     * @return
     */
    public String getName() {
        return vorname + " " + nachname;
    }

    /**
     * Gibt nur den Vornamen zurück.
     * @return
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * Gibt nur den Nachnamen zurück.
     * @return
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * Gibt das Geburtstag des Gastes zurück.
     * @return
     */
    public GregorianCalendar getGeburtstdatum() {
        return geburtstdatum;
    }
    
    public String getDatumAlsString () {
        int datumTag = geburtstdatum.get(Calendar.DAY_OF_MONTH);
        int datumMonat = geburtstdatum.get(Calendar.MONTH);
        int datumJahr = geburtstdatum.get(Calendar.YEAR);
        return datumTag + "." + datumMonat + "." + datumJahr;
    }

    /**
     * Gibt die nummer dieses Gastes zurück.
     * @return
     */
    public int getGastnummer() {
        return gastnummer;
    }

    /**
     * Setzt die Gastnummer auf einen bestimmten Wert.
     * @param gastnummer
     */
    public void setGastnummer(int gastnummer) {
        this.gastnummer = gastnummer;
    }

    /**
     * Gibt die Email dieses Gastes zurück.
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gibt die Telefonnummer des Gastes zurück.
     * @return
     */
    public String getTelefon() {
        return telefon;
    }
    
    /**
     * Kreirt einen neuen Gast mit den Parametern.
     * @param vorname
     * @param nachname
     * @param geburtstdatum
     * @param email
     * @param telefon
     */
    public Gast(String vorname, String nachname, 
            GregorianCalendar geburtstdatum, String email, String telefon) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtstdatum = geburtstdatum;
        this.email = email;
        this.telefon = telefon;
    }
}
