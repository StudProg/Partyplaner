package Model;


import controller.PPdb;
import java.util.ArrayList;
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
public class Partyverwaltung {
    private List<Party> partyListe = new ArrayList<Party>();
    private PPdb datenbank;
    
    public Partyverwaltung(PPdb datenbank) {
        this.datenbank = datenbank;
    }

    public List<Party> getPartyliste(){
        
        return partyListe;
    }
   
   
    
    /**
     * Erstellt eine neue Party mit den angegebenen Parametern.
     * @param name Der Name der Party
     * @param budget Das Budget für die Party
     * @param datum Das Datum der Party
     * @param partyTyp Der Partytyp
     */
    public void party_erstellen(String name, double budget, 
            GregorianCalendar datum, Partytyp partyTyp) 
    throws PartyExestiertBereitsException {
        if(partySuchenMitName(name))
            throw new PartyExestiertBereitsException(name);
        Party party = new Party(name, budget, datum, partyTyp);
        partyListe.add(party);
        datenbank.partyEinfügen(party);
    }
    
    /**
     * Geht durch alle Partys in der Liste und guckt, ob es schon eine Party
     * mit dem Namen gibt.
     * @param name
     * @return true, wenn es eine Party mit dem Namen gibt, false andernfalls
     */
    public boolean partySuchenMitName(String name) {
        for(Party party : partyListe) {
            if(party.getName().equals(name))
                return true;
        }
        return false;
    }
    /**
     * Löscht eine Party aus dem Verzeichniss für Partys.
     * @param name Der Name der Party die gelöscht werden soll
     */
    public void party_loeschen(String name) { //name darf nur einmal exestieren
        for(Party party : partyListe) {
            if(party.getName().equals(name)) {
                partyListe.remove(party);
                break;
            }
        }
    }
    
    public void party_aendern() {
        //TODO: was soll geändert werden?
    }
    
    /**
     * Holt die Tipps aus der Party ab.
     * @param name Der name der Party
     * @return die Tipps für diese Party als String.
     * @throws PartyExestiertNichtException
     */
    public String tipps_aufrufen(String name) 
            throws PartyExestiertNichtException {
        for(Party party : partyListe) {
            if(party.getName().equals(name))
                return party.getTipps();
        }
        throw new PartyExestiertNichtException("Party mit Namen " + name + 
                " exestiert nicht!");
    }

    /**
     * Diese Exception behandelt oder meldet den Fehler, dass die Party die
     * angegeben wurde (identifiziert über den partynamen) nicht gefunden
     * wurde oder nicht in der statischen Partyliste exestiert. Wenn es 
     * also keine Party mit dem namen gibt, dann wird diese Exception 
     * geschmissen, die genau auf diesen Fehler hinweist und später
     * auch der GUI mitteilen kann, das ein Fehler vorliegt.
     */
    public static class PartyExestiertNichtException extends Exception {
        
        public PartyExestiertNichtException(String string) {
        }
        
    }
    
    /**
     * Diese Exception behandelt den Fehler, der passiert, wenn eine neue
     * Party angelegt werden soll, der Name aber schon exestiert.
     */
    public static class PartyExestiertBereitsException extends Exception {

        public PartyExestiertBereitsException(String name) {
        }
    }
}
