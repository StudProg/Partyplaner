package Model;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Klasse für ein Kommentar, dass nur den text speichert.
 * @author Sandra
 */
public class Kommentar {
    private String text;
    
    public Kommentar(String kommentar) {
        text = kommentar;
    }
    
    /**
     * Getter für das Kommentar.
     * @return
     */
    public String getKommentar() {
        return text;
    }

    /**
     * Um zwei Kommentare zu vergleichen müssen diese den exakt gleichen 
     * Text haben.
     * @param obj ein anderes Kommentar
     * @return true, wenn und nur wenn das Object eine Instanz der Klasse
     * Kommentar ist und der Text im Kommentar genau dem dieser Klasse gleicht.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Kommentar) {
            Kommentar k = (Kommentar) obj;
            if(k.getKommentar().equals(text))
                return true;
        }
        return false;
    }
}
