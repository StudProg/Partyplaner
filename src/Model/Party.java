package Model;


import java.util.ArrayList;
import java.util.Calendar;
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
public class Party {
    private String name;
    private double budget;
    private GregorianCalendar datum;
    private String anmerkung;
    private int raumbedarf;
    private Partytyp partytyp;
    
    private List<Einkaufsposten> warenListe;
    private List<Gast> gaesteListe;
    private List<Kommentar> kommentarListe;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /**
     * Getter für den Namen der Party.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Ändert den Namen der Party.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter für das Budget der Party.
     * @return
     */
    public double getBudget() {
        return budget;
    }

    /**
     * Setzt das Budget der Party neu.
     * @param budget
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getDatumAlsString () {
        int datumTag = datum.get(Calendar.DAY_OF_MONTH);
        int datumMonat = datum.get(Calendar.MONTH);
        int datumJahr = datum.get(Calendar.YEAR);
        return datumTag + "." + datumMonat + "." + datumJahr;
    }
    /**
     * Getter für das Datum der Party.
     * @return
     */
    public GregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Setzt das Datum der Party neu.
     * @param datum
     */
    public void setDatum(GregorianCalendar datum) {
        this.datum = datum;
    }

    /**
     * Getter für die Tipps, die es zu dieser Party gibt.
     * @return
     */
    public String getAnmerkung() {
        return anmerkung;
    }

    /**
     * Getter für den berechneten Raumbedarf.
     * @return
     */
    public int getRaumbedarf() {
        return raumbedarf;
    }

    /**
     * Gibt den Typ dieser Party zurück.
     * @return
     */
    public Partytyp getPartytyp() {
        return partytyp;
    }

    /**
     * Setzt die Art dieser Party neu.
     * @param partytyp
     */
    public void setPartytyp(Partytyp partytyp) {
        this.partytyp = partytyp;
    }
    
    /**
     * Erstelle eine neue Party mit den angegebenen Parametern.
     * @param name Name der Party 
     * @param budget Budget der Party
     * @param datum Datum der Veranstaltung
     * @param partytyp Der Partytyp
     */
    public Party(int id, String name, double budget, GregorianCalendar datum,
            Partytyp partytyp) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.datum = datum;
        this.partytyp = partytyp;
        anmerkung = "";
        warenListe = new ArrayList<Einkaufsposten>();
        gaesteListe = new ArrayList<Gast>();
        kommentarListe = new ArrayList<Kommentar>();
        raumbedarf = gaesteListe.size()*2;
    }
    
    public void kommentar_hinzufuegen(String kommentar) {
        Kommentar k = new Kommentar(kommentar);
        kommentarListe.add(k);
    }
    
    public void kommentar_loeschen(String kommentar) {
        Kommentar k = new Kommentar(kommentar);
        while(kommentarListe.contains(k))
            kommentarListe.remove(k);
    }

    public List<Gast> getGaesteListe() {
        return gaesteListe;
    }
    
    public String getGaesteListeAlsDatenbank() {
        String ret = "";
        for(Gast gast : gaesteListe) 
            ret += gast.getGastnummer() + ";";
        if(ret.length() > 0)
            ret = ret.substring(0, ret.length()-1); //löschen des letzten semikollons
        return ret;
    }

    public List<Einkaufsposten> getWarenListe() {
        return warenListe;
    }
}
