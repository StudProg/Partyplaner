package Model;


import controller.PPdb;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Sandra
 */
public class Gaesteverwaltung {
    //Warum ist dies static? Wir wollen nur eine liste mit allen gästen haben
    //aus der der Benutzer letzendlich eine Liste von gästen zusammenstellt.
    private List<Gast> gaesteListe = new ArrayList<Gast>();
    private PPdb datenbank;

    /**
     * Gibt eine Liste mit allen Gästen zurück.
     * @return
     */
    public List<Gast> getGaesteListe() {
        return gaesteListe;
    }
   
    public Gaesteverwaltung(PPdb datenbank) {
        this.datenbank = datenbank;
        this.gaesteListe = datenbank.gibAlleGaeste();
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
        datenbank.gastEinfuegen(gast);
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
