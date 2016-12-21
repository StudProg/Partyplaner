package Model;
import controller.PPdb;
import java.sql.SQLException;
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
    
    public List<Ware> getWarenListe(){
        
        return warenListe;
    }
    public Warenverwaltung(PPdb datenbank) {
        this.datenbank = datenbank;
        this.warenListe = datenbank.gibAlleWaren();
    }
    
    
    public void ware_hinzufuegen(String warenName, double preis, String volumenmenge, 
            double alkoholgehalt) {
        Ware ware = new Ware(warenName, preis, "0.0", alkoholgehalt);
        warenListe.add(ware);
        
            datenbank.wareEinfuegen(ware);
        
        }
     public void ware_loeschen(Ware ware) {
        int i = 0;
        for(Ware ref : warenListe) {
            if(ref.equals(ware))
                break;
            i++;
        }
        warenListe.remove(ware);
        datenbank.wareLoeschen(i);
    }
    }
    