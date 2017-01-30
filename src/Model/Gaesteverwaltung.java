package Model;

import controller.PPdb;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

/**
 * Die Verwaltungsklasse der Gäste.
 * @author Miri 
 */
public class Gaesteverwaltung {

    private List<Gast> gaesteListe = new ArrayList<Gast>();
    private final PPdb datenbank;

    /**
     * Gibt eine Liste mit allen Gästen zurück.
     *
     * @return gaesteliste Liste mit {@link Gast}
     */
    public List<Gast> getGaesteListe() {
        return gaesteListe;
    }

    /**
     * Konstruiert eine Instanz der Gästeverwaltung, welche sie die 
     * gespeicherten Gäste aus der Datenbank holt.
     * @param datenbank die datenbank vom Typ {@link PPdb}
     */
    public Gaesteverwaltung(PPdb datenbank) {
        this.datenbank = datenbank;
        this.gaesteListe = datenbank.gibAlleGaeste();
    }

    /**
     * Erstellt einen neuen Gast und packt ihn/sie in die Gästeliste und 
     * erstellt einen neuen Datenbankeintrag für diesen.
     *
     * @param vorname der Vorname des Gastes
     * @param nachname der Nachname des Gastes
     * @param geburtstdatum das Geburtsdatum vom Gast
     * @param email Die Email vom Gast
     * @param telefon Die Telefonnummer vom Gast
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
     * Löscht einen Gast aus der Gästeliste und der Datenbank.
     *
     * @param gast Ein {@link Gast}
     */
    public void gast_loeschen(Gast gast) {
        gaesteListe.remove(gast);
        datenbank.gastLoeschen(gast.getGastnummer());
    }

    /**
     * Sucht einen Gast innerhalb der Gästeliste anhand des Namens.
     *
     * @param vName der Vorname des Gastes
     * @param nName der Nachname des Gastes
     * @return gast gibt den {@link Gast} zurück, wenn Vor-und Nachname übereinstimmen,
     * sonst null
     */
    public Gast gastSuchen(String vName, String nName) {
        for (Gast gast : gaesteListe) {
            if (gast.getVorname().equals(vName) && gast.getNachname().equals(nName)) {
                return gast;
            }
        }
        return null;
    }

    /**
     * Sucht einen Gast in der Gästeliste anhand seiner Gastnummer.
     *
     * @param gastnummer die Nummer des Gastes
     * @return gast, gibt den {@link Gast} zurück, wenn die gastnummern übereinstimmen,
     * sonst nichts
     */
    public Gast gastSuchen(int gastnummer) {
        for (Gast gast : gaesteListe) {
            if (gast.getGastnummer() == gastnummer) {
                return gast;
            }
        }
        return null;
    }

    /**
     * Gästeattribute werden überschrieben und an die Datenbank übertragen.
     *
     * @param gastnummer die Nummer des Gastes
     * @param vname der Vorname des Gastes
     * @param nname der Nachname des Gastes
     * @param gregorianDatum das Geburtstdatum des Gastes
     * @param mail die Email Adresse des Gasges
     * @param telefon Die Telefonnummer des Gastes
     */
    public void gast_bearbeiten(int gastnummer, String vname, String nname, 
            GregorianCalendar gregorianDatum, String mail, String telefon) {
        gaesteListe.get(gastnummer).setVorname(vname);
        gaesteListe.get(gastnummer).setEmail(mail);
        gaesteListe.get(gastnummer).setGeburtstdatum(gregorianDatum);
        gaesteListe.get(gastnummer).setNachname(nname);
        gaesteListe.get(gastnummer).setTelefon(telefon);
        datenbank.gastBearbeiten(gaesteListe.get(gastnummer));
    }
}
