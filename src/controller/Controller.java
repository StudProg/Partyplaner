/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Guidesign.Gästebuch;
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
import javax.swing.JFrame;

/**
 *
 * @author Sandra
 */
public class Controller implements ActionListener {
    private final Model model;
    private final Startseite gui;
    private Partyliste partyListe;
    
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
        } else if(e.getActionCommand().equals("Gaestebuch")) {
            System.out.println("hallo");
            Gästebuch gaestebuch = new Gästebuch();
            gaestebuch.setVisible(true);
            gaestebuch.setAlwaysOnTop(true);
            gaestebuch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (e.getActionCommand().equals("speichern")) {
            partySpeichern();
        } else if (e.getActionCommand().equals("Partyliste.PartyAnzeigen")) {
            int index = partyListe.getpartylist().getSelectedIndex();
            Party party = model.partyverwaltung.getPartyliste().get(index);
            partyListe.dispose();
            partyListe = null;
            gui.getPartynameeintragen().setText(party.getName());
            gui.getPartydatumeintragen().setText(party.getDatum().toString());
            
            gui.getPartybudget().setText(Double.toString(party.getBudget()));
            
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
        System.out.println("Speichern triggered");
            String name = gui.getPartynameeintragen().getText();
            String datum = gui.getPartydatumeintragen().getText();
            String budget = gui.getPartybudget().getText();
            if (name.equals("")) {
                gui.errorLabel.setText("Bitte einen Namen eingeben.");
                gui.errorLabel.setForeground(Color.red);
                return;
            }
            String[] datumArray = datum.split("\\.");
            if(datumArray.length != 3) {
                gui.errorLabel.setText("Ungültiges Datum.");
                System.out.println("array nicht 3 lang  " + datumArray.length + "    " + datum);
                gui.errorLabel.setForeground(Color.red);
                return;
            }
            GregorianCalendar gregorianDatum;
            try {
                int tag = Integer.parseInt(datumArray[0]);
                int monat = Integer.parseInt(datumArray[1]);
                int jahr = Integer.parseInt(datumArray[2]);
                if(tag < 1 || tag > 31 || monat < 1 || monat > 12) { //TODO: Ist das jahr wichtig ? Und wie sieht es mit Feb.aus?
                    gui.errorLabel.setText("Ungültiges Datum.");
                    System.out.println("Fehler beim überprüfen: " + tag + "   " + monat);
                    gui.errorLabel.setForeground(Color.red);
                    return;
                }
                gregorianDatum = new GregorianCalendar(jahr, monat, tag);
            } catch (NumberFormatException exeption) {
                gui.errorLabel.setText("Ungültiges Datum.");
                System.out.println(exeption);
                gui.errorLabel.setForeground(Color.red);
                return;
            }
            double partyBudget;
            try {
                partyBudget = Double.parseDouble(budget);
                if(partyBudget <= 0) {
                    gui.errorLabel.setText("Sie sind pleite.");
                    gui.errorLabel.setForeground(Color.red);
                    return;
                }
            } catch (NumberFormatException exception) {
                gui.errorLabel.setText("Ungültiges Budget.");
                gui.setForeground(Color.red);
                return;
            }
            try {
                model.partyverwaltung.party_erstellen(name, partyBudget, 
                    gregorianDatum, Partytyp.TANZPARTY); //TODO: Partytype auswählbar machen
            } catch (PartyExestiertBereitsException exception) {
                gui.errorLabel.setText("Dieser Partyname existiert bereits.");
                gui.errorLabel.setForeground(Color.red);
                return;
            }
            gui.errorLabel.setText("");
    }
}
