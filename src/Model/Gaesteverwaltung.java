package Model;


import controller.PPdb;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Sandra
 */
public class Gaesteverwaltung {
   
    private List<Gast> gaesteListe = new ArrayList<Gast>();
    private final PPdb datenbank;

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
        try {
            datenbank.gastErstellen(gast);
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
            ex.printStackTrace();
        }
    }
    
    /**
     * Löscht einen Gast aus der Gästeliste.
     * @param gast
     */
    public void gast_loeschen(Gast gast) {
        gaesteListe.remove(gast);
        datenbank.gastLoeschen(gast.getGastnummer());
    }
    
    public void gast_anzeigen() {
        //TODO:
    }
    
    public Gast gastSuchen(String vName, String nName) {
        for(Gast gast : gaesteListe) {
            if(gast.getVorname().equals(vName) && gast.getNachname().equals(nName))
                return gast;
        }
        return null;
    }
    
    public Gast gastSuchen(int gastnummer) {
        for (Gast gast : gaesteListe) {
            if (gast.getGastnummer()== gastnummer)
                return gast;
        }
        return null;
    }

    public void gast_bearbeiten(int gastindex, String vname, String nname, GregorianCalendar gregorianDatum, String mail, String telefon) {
        gaesteListe.get(gastindex).setVorname(vname);
        gaesteListe.get(gastindex).setEmail(mail);
        gaesteListe.get(gastindex).setGeburtstdatum(gregorianDatum);
        gaesteListe.get(gastindex).setNachname(nname);
        gaesteListe.get(gastindex).setTelefon(telefon);
        datenbank.gastBearbeiten(gaesteListe.get(gastindex));
    }
}
