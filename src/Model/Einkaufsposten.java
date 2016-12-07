package Model;


import java.util.ArrayList;
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
public class Einkaufsposten {
    private String name;
    private int menge;
    private List<Ware> warenListe;
    
    /**
     * Konstruiert und eine neue Einkaufsliste mit positionen für Waren.
     * @param name
     */
    public Einkaufsposten(String name) {
        this.name = name;
        menge = 0;
        warenListe = new ArrayList<Ware>();
    }
    
    /**
     * Gibt die Menge der Waren zurück.
     * @return Menge an Waren.
     */
    public int getMenge() {
        return menge;
    }
    
    /**
     * Fügt eine Ware zur Einkaufsliste hinzu.
     * @param ware
     */
    public void ware_hinzufuegen(Ware ware) {
        warenListe.add(ware);
        menge++;
    }
    
    /**
     * Entfernt ein Ware aus der List.
     * @param warenName
     */
    public void ware_entfernen(String warenName) {
        for(Ware w : warenListe) {
            if(w.getWarenName().equals(warenName)) {
                menge--;
                warenListe.remove(w);
                return;
            }
        }
    }
    
    /**
     * Gibt an, wieviel Geld insgesamt ausgegeben wird.
     * @return
     */
    public double gesamtausgaben_berechnen() {
        double gesamtSumme = 0.0;
        for(Ware ware : warenListe) {
            gesamtSumme += ware.getPreis();
        }
        return gesamtSumme;
    }
}
