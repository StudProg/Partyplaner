package Model;


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
public class Einkaufslistenverwaltung {
    //Warum ist dies static? Weil wir nur eine Liste mit allen möglichen Waren 
    //haben wollen! Der Benutzer soll letzendlich nur Waren aus dieser Liste
    //zu seiner Party hinzufügen.
    private static List<Ware> warenListe;

    /**
     * Gibt die Liste mit allen möglichen Waren zurück.
     * @return
     */
    public static List<Ware> getWarenListe() {
        return warenListe;
    }
    
    /**
     * Gibt einfach eine neue leere Einkaufsposten zurück.
     * @param name
     * @return leeren Einkaufsposten.
     */
    public Einkaufsposten einkaufsliste_erstellen(String name) {
        return new Einkaufsposten(name);
    }
    
    public void ware_hinzufuegen(String warenName, double preis, 
            double alkoholgehalt) {
        Ware ware = new Ware(warenName, preis, 0.0, alkoholgehalt);
        warenListe.add(ware);
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
