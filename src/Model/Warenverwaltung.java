package Model;
import controller.PPdb;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
/**
 *
 * @author Sandra
 */
public class Warenverwaltung {
   private List<Ware> warenListe = new ArrayList<Ware>();
    private PPdb datenbank;
    
    public List<Ware> getWarenliste(){
        
        return warenListe;
    }
    public Warenverwaltung(PPdb datenbank) {
        this.datenbank = datenbank;
        this.warenListe = datenbank.gibAlleWaren();
    }
    
    /**
     * Gibt einfach eine neue leere Einkaufsposten zurück.
     * @param name
     * @return leeren Einkaufsposten.
     */
    public Einkaufsposten einkaufsliste_erstellen(String name) {
        return new Einkaufsposten(name);
    }
    
    public void ware_hinzufuegen(String warenName, double preis, String menge, 
            double alkoholgehalt) {
        Ware ware = new Ware(warenName, preis, "0.0", alkoholgehalt);
        warenListe.add(ware);
        datenbank.wareEinfuegen(ware);
    }
    
    public void einkaufslist_loeschen() {
        //TODO:
    }
    
    public void einkaufsliste_bearbeiten() {
        //TODO:
    }
    
    public void gesamtausgaben_berechnen() {
        //TODO:
    }
}
