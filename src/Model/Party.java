package Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Diese Klasse repräsentiert eine Party.
 * @author Sandra
 */
public class Party {

    private String name;
    private double budget;
    private GregorianCalendar datum;
    private String anmerkung;
    private int raumbedarf;
    private Partytyp partytyp;
    private List<Gast> gaesteListe;
    private List<Kommentar> kommentarListe;
    private int id;

    /**
     * Der Konstruktor für ein Partyobjekt.
     *
     * @param id die ID der Party
     * @param name Der Name der Party
     * @param budget das Budget für die Party
     * @param datum das datum für die Party
     * @param partytyp Die Kategorie der Party
     */
    public Party(int id, String name, double budget, GregorianCalendar datum,
            Partytyp partytyp) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.datum = datum;
        this.partytyp = partytyp;
        gaesteListe = new ArrayList<Gast>();
    }

    /**
     * Getter für die ID der Party.
     * @return id gibt die ID der Party zurück
     */
    public int getId() {
        return id;
    }

    /**
     * Weist der id einen Wert zu.
     *
     * @param id die neue PartyId
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter für den Namen der Party.
     *
     * @return Name der Party
     */
    public String getName() {
        return name;
    }

    /**
     * Ändert den Namen der Party.
     *
     * @param name der Name der Party
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter für das Budget der Party.
     *
     * @return budget Das Budget
     */
    public double getBudget() {
        return budget;
    }

    /**
     * Setzt das Budget der Party neu.
     *
     * @param budget neue Budget
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }

    /**
     * Wandelt das Datum der Party vom Gregorian Calender in einen String um.
     *
     * @return das Datum als String in dem Format Tag.Monat.Jahr
     */
    public String getDatumAlsString() {
        int datumTag = datum.get(Calendar.DAY_OF_MONTH);
        int datumMonat = datum.get(Calendar.MONTH);
        int datumJahr = datum.get(Calendar.YEAR);
        return datumTag + "." + datumMonat + "." + datumJahr;
    }

    /**
     * Getter für das Datum der Party.
     *
     * @return datum als {@link GregorianCalendar}
     */
    public GregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Setzt das Datum der Party neu.
     *
     * @param datum als {@link GregorianCalendar}
     */
    public void setDatum(GregorianCalendar datum) {
        this.datum = datum;
    }

    /**
     * Getter für die Tipps, die es zu dieser Party gibt.
     *
     * @return anmerkung
     */
    public String getAnmerkung() {
        return anmerkung;
    }

    /**
     * Getter für den berechneten Raumbedarf.
     *
     * @return raumbedarf
     */
    public int getRaumbedarf() {
        return raumbedarf;
    }

    /**
     * Gibt den Typ dieser Party zurück.
     *
     * @return partytyp als {@link Partytyp}
     */
    public Partytyp getPartytyp() {
        return partytyp;
    }

    /**
     * Setzt die Art dieser Party neu.
     *
     * @param partytyp als {@link Partytyp}
     */
    public void setPartytyp(Partytyp partytyp) {
        this.partytyp = partytyp;
    }

    /**
     * Gibt die Liste der geladenen Gäste zurück.
     * @return gaesteListe die Liste mit {@link Gast} eintragungen.
     */
    public List<Gast> getGaesteListe() {
        return gaesteListe;
    }

    /**
     * Gibt die Gästelist nicht als Gast zurück sondern jeweils als 
     * in der Datenbank speicherbarer String von Gästenummern zurück.
     * @return Gibt die Gästeliste zurück anhand der Gastnummern
     */
    public String getGaesteListeAlsDatenbank() {
        String ret = "";
        for (Gast gast : gaesteListe) {
            ret += gast.getGastnummer() + ";";
        }
        if (ret.length() > 0) {
            ret = ret.substring(0, ret.length() - 1); //löschen des letzten semikollons
        }
        return ret;
    }

}
