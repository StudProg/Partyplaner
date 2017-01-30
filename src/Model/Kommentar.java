package Model;

/**
 * Klasse für ein Kommentar, dass nur den text speichert.
 *
 * @author Sandra
 */
public class Kommentar {

    private String text;

    /**
     *
     * @param kommentar ein Kommentar zur Party
     */
    public Kommentar(String kommentar) {
        text = kommentar;
    }

    /**
     * Getter für das Kommentar.
     *
     * @return text Das Kommentar als String
     */
    public String getKommentar() {
        return text;
    }

    /**
     * Um zwei Kommentare zu vergleichen müssen diese den exakt gleichen Text
     * haben.
     *
     * @param obj ein anderes Kommentar
     * @return true, wenn und nur wenn das Object eine Instanz der Klasse
     * Kommentar ist und der Text im Kommentar genau dem dieser Klasse gleicht.
     */
    @Override

    public boolean equals(Object obj) {
        if (obj instanceof Kommentar) {
            Kommentar k = (Kommentar) obj;
            if (k.getKommentar().equals(text)) {
                return true;
            }
        }
        return false;
    }
}
