package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse für die "Einkaufsposten" enthält die Waren, die auf die
 * Einkaufsliste landen sollen.
 * @author Miri 
 */
public class Einkaufsposten {

    private String name;
    private int menge;
    private List<Ware> warenListe;

    /**
     * Konstruiert eine neue Instanz für Einkausposten.
     * @param name der Name der Ware
     */
    public Einkaufsposten(String name) {
        this.name = name;
        menge = 0;
        warenListe = new ArrayList<Ware>();
    }

    /**
     * Gibt die Menge der Waren zurück.
     *
     * @return menge an Waren als Integer.
     */
    public int getMenge() {
        return menge;
    }

    /**
     * Fügt eine Ware zur Einkaufsliste hinzu.
     *
     * @param ware das Produkt als {@link Ware}
     */
    public void ware_hinzufuegen(Ware ware) {
        warenListe.add(ware);
        menge++;
    }

    /**
     * Entfernt ein Ware aus der Liste.
     *
     * @param warenName der Name des Produktes
     */
    public void ware_entfernen(String warenName) {
        for (Ware w : warenListe) {
            if (w.getWarenName().equals(warenName)) {
                menge--;
                warenListe.remove(w);
                return;
            }
        }
    }

    /**
     * Berechnet, wieviel Geld insgesamt ausgegeben wird.
     *
     * @return gesamtSumme die Summe, die sich aus der Warenliste errechnet
     */
    public double gesamtausgaben_berechnen() {
        double gesamtSumme = 0.0;
        for (Ware ware : warenListe) {
            gesamtSumme += ware.getPreis();
        }
        return gesamtSumme;
    }
}
