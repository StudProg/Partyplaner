package Model;


import controller.PPdb;
import java.util.GregorianCalendar;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sandra
 */
public class Gaesteverwaltung {
    //Warum ist dies static? Wir wollen nur eine liste mit allen gästen haben
    //aus der der Benutzer letzendlich eine Liste von gästen zusammenstellt.
    private static List<Gast> gaesteListe;

    /**
     * Gibt eine Liste mit allen Gästen zurück.
     * @return
     */
    public static List<Gast> getGaesteListe() {
        return gaesteListe;
    }
    private final PPdb datenbank;
    
    public Gaesteverwaltung(PPdb datenbank) {
        this.datenbank = datenbank;
    }
     
    /**
     * Erstellt einen neuen Gast und packt ihn/sie in die Gästeliste.
     * @param vorname
     * @param nachname
     * @param geburtstdatum
     * @param email
     * @param telefon
     */
    public void gast_erstellen(String vorname, String nachname, 
            GregorianCalendar geburtstdatum, String email, String telefon) {
        Gast gast = new Gast(vorname, nachname, geburtstdatum, email, telefon);
        gaesteListe.add(gast);
    }
    
    public void gast_aendern(Gast gast) {
        //TODO: was soll geändert werden?
    }
    
    /**
     * Löscht einen Gast aus der Gästeliste.
     * @param gast
     */
    public void gast_loeschen(Gast gast) {
        gaesteListe.remove(gast);
    }
    
    public void gast_anzeigen() {
        //TODO:
    }
}
