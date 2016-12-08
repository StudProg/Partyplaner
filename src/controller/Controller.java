/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Guidesign.Gästebuch;
import Guidesign.Partyerstellen;
import Guidesign.Partyliste;
import Guidesign.Startseite;
import Model.Model;
import Model.Party;
import Model.Partytyp;
import Model.Partyverwaltung.PartyExestiertBereitsException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Sandra
 */
public class Controller implements ActionListener {
    private final Model model;
    private final Startseite gui;
    private Partyliste partyListe;
    private Partyerstellen partyerstellen;
    private String alterPartyName;
    
    public Controller() {
        //initialisierung des Models
        PPdb datenbank = new PPdb();
        //lustig
        model = new Model(this, datenbank);
        gui = new Startseite(this);
        gui.setVisible(true);

       
    }
        
    public static void main(String[] args) {
        Controller controller = new Controller();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Party anzeigen")) {
            partyAnzeigen();
        } else if(e.getActionCommand().equals("Party erstellen")) {
            System.out.println("Party erstellen wurde geklickt!");
            partyerstellen = new Partyerstellen(this);
            partyerstellen.setAlwaysOnTop(true);
            partyerstellen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            partyerstellen.setVisible(true);
        } else if(e.getActionCommand().equals("Gaestebuch")) {
            System.out.println("hallo");
            Gästebuch gaestebuch = new Gästebuch();
            gaestebuch.setVisible(true);
            gaestebuch.setAlwaysOnTop(true);
            gaestebuch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (e.getActionCommand().equals("Speichern")) {
            partySpeichern();
        } else if (e.getActionCommand().equals("Partyliste.PartyAnzeigen")) {
            int index = partyListe.getpartylist().getSelectedIndex();
            Party party = model.partyverwaltung.getPartyliste().get(index);
            partyListe.dispose();
            partyListe = null;
            alterPartyName = party.getName();
            gui.getPartynameeintragen().setText(party.getName());
            gui.getPartydatumeintragen().setText(party.getDatumAlsString());
            gui.getPartybudget().setText(Double.toString(party.getBudget()));
        } else if (e.getActionCommand().equals("Partyliste.PartyLöschen")) {
            int index = partyListe.getpartylist().getSelectedIndex();
            Party party = model.partyverwaltung.getPartyliste().get(index);
            model.partyverwaltung.party_loeschen(party.getName());
            List<Party> partys = model.partyverwaltung.getPartyliste();
            String[] partyArray = new String[partys.size()];
            for(int i = 0; i < partys.size(); i++) {
                partyArray[i] = partys.get(i).getName();
            }
            partyListe.getpartylist().setListData(partyArray);
        }else if (e.getActionCommand().equals("PartyErstellen.Speichern")) {
            String name = partyerstellen.getpartyname().getText();
            String datum = partyerstellen.getpartydatum().getText();
            String budget = partyerstellen.getpartybudget().getText();
            String kategorie = (String)partyerstellen.getpartyKategorien().getSelectedItem();
            if (name.equals("")) {
                partyerstellen.errorLabel.setText("Bitte einen Namen eingeben.");
                partyerstellen.errorLabel.setForeground(Color.red);
                return;
            }
            String[] datumArray = datum.split("\\.");
            if(datumArray.length != 3) {
                partyerstellen.errorLabel.setText("Ungültiges Datum.");
                System.out.println("array nicht 3 lang  " + datumArray.length + "    " + datum);
                partyerstellen.errorLabel.setForeground(Color.red);
                return;
            }
            GregorianCalendar gregorianDatum;
            try {
                int tag = Integer.parseInt(datumArray[0]);
                int monat = Integer.parseInt(datumArray[1]);
                int jahr = Integer.parseInt(datumArray[2]);
                if(tag < 1 || tag > 31 || monat < 1 || monat > 12) { //TODO: Ist das jahr wichtig ? Und wie sieht es mit Feb.aus?
                    partyerstellen.errorLabel.setText("Ungültiges Datum.");
                    System.out.println("Fehler beim überprüfen: " + tag + "   " + monat);
                    partyerstellen.errorLabel.setForeground(Color.red);
                    return;
                }
                gregorianDatum = new GregorianCalendar(jahr, monat, tag);
            } catch (NumberFormatException exeption) {
                partyerstellen.errorLabel.setText("Ungültiges Datum.");
                System.out.println(exeption);
                partyerstellen.errorLabel.setForeground(Color.red);
                return;
            }
            double partyBudget;
            try {
                partyBudget = Double.parseDouble(budget);
                if(partyBudget <= 0) {
                    partyerstellen.errorLabel.setText("Sie sind pleite.");
                    partyerstellen.errorLabel.setForeground(Color.red);
                    return;
                }
            } catch (NumberFormatException exception) {
                partyerstellen.errorLabel.setText("Ungültiges Budget.");
                partyerstellen.errorLabel.setForeground(Color.red);
                return;
            }
            try {
                model.partyverwaltung.party_erstellen(name, partyBudget, 
                    gregorianDatum, Partytyp.valueOf(kategorie)); 
            } catch (PartyExestiertBereitsException exception) {
                partyerstellen.errorLabel.setText("Dieser Partyname existiert bereits.");
                partyerstellen.errorLabel.setForeground(Color.red);
                return;
            } catch (IllegalArgumentException e1) {
                partyerstellen.errorLabel.setText("Bitte eine Kategorie wählen.");
                partyerstellen.errorLabel.setForeground(Color.red);
                return;
            }
            partyerstellen.dispose();
        } else if (e.getActionCommand().equals("PartyErstellen.Abbrechen")) {
            partyerstellen.dispose();
        }
    }

    private void partyAnzeigen() {
        System.out.println("Party Anzeigen wurde gedrückt!");
        partyListe = new Partyliste(this);
        partyListe.setVisible(true);
        partyListe.setAlwaysOnTop(true);
        List<Party> partys = model.partyverwaltung.getPartyliste();
        String[] partyArray = new String[partys.size()];
        for(int i = 0; i < partys.size(); i++) {
            partyArray[i] = partys.get(i).getName();
        }
        partyListe.getpartylist().setListData(partyArray);
    }
    
    private void partySpeichern() {
        if (alterPartyName == null)
            return;
        System.out.println("Speichern triggered");
            String name = gui.getPartynameeintragen().getText();
            String datum = gui.getPartydatumeintragen().getText();
            String budget = gui.getPartybudget().getText();
            if (name.equals("")) {
                gui.getErrorLabel().setText("Bitte einen Namen eingeben.");
                gui.getErrorLabel().setForeground(Color.red);
                return;
            }
            String[] datumArray = datum.split("\\.");
            if(datumArray.length != 3) {
                gui.getErrorLabel().setText("Ungültiges Datum.");
                System.out.println("array nicht 3 lang  " + datumArray.length + "    " + datum);
                gui.getErrorLabel().setForeground(Color.red);
                return;
            }
            GregorianCalendar gregorianDatum;
            try {
                int tag = Integer.parseInt(datumArray[0]);
                int monat = Integer.parseInt(datumArray[1]);
                int jahr = Integer.parseInt(datumArray[2]);
                if(tag < 1 || tag > 31 || monat < 1 || monat > 12) { //TODO: Ist das jahr wichtig ? Und wie sieht es mit Feb.aus?
                    gui.getErrorLabel().setText("Ungültiges Datum.");
                    System.out.println("Fehler beim überprüfen: " + tag + "   " + monat);
                    gui.getErrorLabel().setForeground(Color.red);
                    return;
                }
                gregorianDatum = new GregorianCalendar(jahr, monat, tag);
            } catch (NumberFormatException exeption) {
                gui.getErrorLabel().setText("Ungültiges Datum.");
                System.out.println(exeption);
                gui.getErrorLabel().setForeground(Color.red);
                return;
            }
            double partyBudget;
            try {
                partyBudget = Double.parseDouble(budget);
                if(partyBudget <= 0) {
                    gui.getErrorLabel().setText("Sie sind pleite.");
                    gui.getErrorLabel().setForeground(Color.red);
                    return;
                }
            } catch (NumberFormatException exception) {
                gui.getErrorLabel().setText("Ungültiges Budget.");
                gui.getErrorLabel().setForeground(Color.red);
                return;
            }
            
        try { 
            model.partyverwaltung.party_bearbeiten(alterPartyName,name, partyBudget, gregorianDatum );
        } catch (PartyExestiertBereitsException ex) {
            gui.getErrorLabel().setText("Dieser Partyname existiert bereits.");
                gui.getErrorLabel().setForeground(Color.red);
                return;
        }
            
            
            gui.getErrorLabel().setText("Partyänderungen erfolgreich gespeichert");
            gui.getErrorLabel().setForeground(Color.green);
    }
}