package Model;

import controller.PPdb;
import java.util.ArrayList;
import java.util.List;

/**
 * Die Verwaltung der Waren.
 *
 * @author Miri
 */
public class Warenverwaltung {

    private List<Ware> warenListe = new ArrayList<Ware>();
    private PPdb datenbank;

    /**
     * Getter für die Liste mit den Waren.
     * @return warenListe Gibt die Liste mit Einträgen von {@link Ware} zurück
     */
    public List<Ware> getWarenListe() {

        return warenListe;
    }

    /**
     * Erstellt eine neue Instanz der Warenverwaltung. Diese holt sich 
     * automatisch alle Waren aus der Datenbank.
     * @param datenbank die Datenbank vom Typ {@link PPdb}
     */
    public Warenverwaltung(PPdb datenbank) {
        this.datenbank = datenbank;
        this.warenListe = datenbank.gibAlleWaren();
    }

    /**
     * Fügt eine Ware der Warenliste hinzu und fügt sie auch in die Datenbank ein.
     *
     * @param warenName Der Name der Ware
     * @param preis Der Preis der Ware
     * @param volumenmenge Das Volumen bzw. die Menge der Ware
     * @param alkoholgehalt Der prozentuale Akloholgehalt
     */
    public void ware_hinzufuegen(String warenName, double preis, String volumenmenge,
            double alkoholgehalt) {
        Ware ware = new Ware(-1, warenName, preis, volumenmenge, alkoholgehalt);
        warenListe.add(ware);
        ware.setStrichcode(datenbank.wareEinfuegen(ware));

    }

    /**
     * Löscht die Ware aus der Warenliste und aus der Datenbank.
     *
     * @param ware Ein {@link Ware} Objekt
     */
    public void ware_loeschen(Ware ware) {
        int i = 0;
        for (Ware ref : warenListe) {
            if (ref.equals(ware)) {
                break;
            }
            i++;
        }
        warenListe.remove(ware);
        datenbank.wareLoeschen(ware.getStrichcode());
    }
}
