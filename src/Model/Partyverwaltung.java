package Model;

import controller.PPdb;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

/**
 * Die Verwaltung für die Partys
 *
 * @author Sandra
 */
public class Partyverwaltung {

    private List<Party> partyListe = new ArrayList<Party>();
    private PPdb datenbank;

    /**
     *
     * @return partyListe die Liste der Partys wird zurückgegeben
     */
    public List<Party> getPartyliste() {
        return partyListe;
    }

    /**
     * Ordnet die Partys aus der Datenbank in eine Map und weisr ihnen ggf.
     * Gästen zu
     *
     * @param datenbank die Datenbank
     * @param warenverwaltung die Warenverwaltung
     * @param gaesteverwaltung die Gästeverwaltung
     */
    public Partyverwaltung(PPdb datenbank, Warenverwaltung warenverwaltung, Gaesteverwaltung gaesteverwaltung) {
        this.datenbank = datenbank;
        Map<Party, List<String[]>> map = datenbank.gibAllePartys();
        for (Party party : map.keySet()) { //Map ist eine Tabelle mit 2 Spalten und die erste Spalte sind die partys und die zweite Spalte teilt sich in mehrere Zeilen. Die nullte Zeile ist die Gästeliste
            List<String[]> extras = map.get(party);
            for (String gastnummer : extras.get(0)) {
                try {
                    Gast gast = gaesteverwaltung.gastSuchen(Integer.parseInt(gastnummer));
                    if (gast != null) {
                        party.getGaesteListe().add(gast);
                    }
                } catch (NumberFormatException e) {
                    continue;
                }

            }
            this.partyListe.add(party);
        }
    }

    /**
     * Erstellt eine neue Party mit den angegebenen Parametern.
     *
     * @param name Der Name der Party
     * @param budget Das Budget für die Party
     * @param datum Das Datum der Party
     * @param partyTyp Der Partytyp
     */
    public void party_erstellen(String name, double budget,
            GregorianCalendar datum, Partytyp partyTyp)
            throws PartyExestiertBereitsException {
        if (partySuchenMitName(name)) {
            throw new PartyExestiertBereitsException(name);
        }
        Party party = new Party(-1, name, budget, datum, partyTyp);
        partyListe.add(party);
        party.setId(datenbank.partyEinfuegen(party));

    }

    /**
     * Geht durch alle Partys in der Liste und guckt, ob es schon eine Party mit
     * dem Namen gibt.
     *
     * @param name
     * @return true, wenn es eine Party mit dem Namen gibt, false andernfalls
     */
    public boolean partySuchenMitName(String name) {
        for (Party party : partyListe) {
            if (party.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Löscht eine Party aus dem Verzeichniss für Partys.
     *
     * @param name Der Name der Party die gelöscht werden soll
     */
    public void party_loeschen(String name) {
        int i = 0;
        for (Party party : partyListe) {
            if (party.getName().equals(name)) {
                partyListe.remove(party);
                datenbank.partyLoeschen(party.getId());
                break;
            }
            i++;
        }
    }

    /**
     * Eine bereits erstelle Party wird bearbeitet
     *
     * @param alterPartyName Der ursprüngliche Name der Party
     * @param partyname der Name der Party
     * @param partyBudget das Budget der party
     * @param datum da sDatum der Party
     * @throws Model.Partyverwaltung.PartyExestiertBereitsException
     */
    public void party_bearbeiten(String alterPartyName, String partyname, double partyBudget,
            GregorianCalendar datum) throws PartyExestiertBereitsException {
        if (partySuchenMitName(partyname) && !alterPartyName.equals(partyname))//frage ob dieser partyname schon existiert und wenn ja, frage ob der partyname sich geändert hat
        {
            throw new PartyExestiertBereitsException(partyname);
        }
        int i = 0;
        for (Party party : partyListe) {
            if (party.getName().equals(alterPartyName)) {
                party.setBudget(partyBudget);
                party.setDatum(datum);
                party.setName(partyname);
                datenbank.partyBearbeiten(party.getId(), party, party.getGaesteListeAlsDatenbank());
                break;
            }
            i++;

        }

    }

    /**
     * Holt die Tipps aus der Party ab.
     *
     * @param name Der name der Party
     * @return die Tipps für diese Party als String.
     * @throws PartyExestiertNichtException
     */
    public String tipps_aufrufen(String name)
            throws PartyExestiertNichtException {
        for (Party party : partyListe) {
            if (party.getName().equals(name)) {
                return party.getAnmerkung();
            }
        }
        throw new PartyExestiertNichtException("Party mit Namen " + name
                + " exestiert nicht!");
    }

    /**
     * Diese Exception behandelt oder meldet den Fehler, dass die Party die
     * angegeben wurde (identifiziert über den partynamen) nicht gefunden wurde
     * oder nicht in der statischen Partyliste exestiert. Wenn es also keine
     * Party mit dem namen gibt, dann wird diese Exception geschmissen, die
     * genau auf diesen Fehler hinweist und später auch der GUI mitteilen kann,
     * das ein Fehler vorliegt.
     */
    public static class PartyExestiertNichtException extends Exception {

        public PartyExestiertNichtException(String string) {
        }

    }

    /**
     * Diese Exception behandelt den Fehler, der passiert, wenn eine neue Party
     * angelegt werden soll, der Name aber schon exestiert.
     */
    public static class PartyExestiertBereitsException extends Exception {

        public PartyExestiertBereitsException(String name) {
        }
    }
}
