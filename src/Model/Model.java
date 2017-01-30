package Model;

import controller.Controller;
import controller.PPdb;

/**
 * Das Model hält alle wichtigen Daten des Programms. Diese werden nacheinander
 * mithilfe der Datenbank aufgebaut. Der {@link Controller} operiert auf den 
 * Daten.
 * @author Miri
 */
public class Model {

    private final Controller controller;
    public final Partyverwaltung partyverwaltung;
    public final Warenverwaltung warenverwaltung;
    public final Gaesteverwaltung gaesteverwaltung;
    
    /**
     * Konstruiert eine neue Instanz des Models.
     * @param controller ein objekt vom {@link Controller}
     * @param datenbank ein objekt von {@link PPdb}
     */
    public Model(Controller controller, PPdb datenbank) {
        this.controller = controller;
        warenverwaltung = new Warenverwaltung(datenbank);
        gaesteverwaltung = new Gaesteverwaltung(datenbank);
        partyverwaltung = new Partyverwaltung(datenbank, warenverwaltung, gaesteverwaltung);
    }
}
