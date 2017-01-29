
package Model;

import controller.Controller;
import controller.PPdb;

/**
 * 
 * @author Miri
 */
public class Model {

    private final Controller controller;
    public final Partyverwaltung partyverwaltung;
    public final Warenverwaltung warenverwaltung;
    public final Gaesteverwaltung gaesteverwaltung;
    
    /**
     * 
     * @param controller ein objekt vom controller
     * @param datenbank ein objekt von PPdb
     */
    public Model(Controller controller, PPdb datenbank) {
        this.controller = controller;
        warenverwaltung = new Warenverwaltung(datenbank);
        gaesteverwaltung = new Gaesteverwaltung(datenbank);
        partyverwaltung = new Partyverwaltung(datenbank, warenverwaltung, gaesteverwaltung);
    }
}
