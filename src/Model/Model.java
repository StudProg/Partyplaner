/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import controller.Controller;
import controller.PPdb;

/**
 *
 * @author Sandra
 */
public class Model {

    private final Controller controller;
    public final Partyverwaltung partyverwaltung;
    public final Einkaufslistenverwaltung einkaufslistenverwaltung;
    public final Gaesteverwaltung gaesteverwaltung;
    
    public Model(Controller controller, PPdb datenbank) {
        this.controller = controller;
        partyverwaltung = new Partyverwaltung(datenbank);
        einkaufslistenverwaltung = new Einkaufslistenverwaltung();
        gaesteverwaltung = new Gaesteverwaltung(datenbank);
    }
}
