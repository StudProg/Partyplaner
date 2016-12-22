/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Guidesign.Gaestebuch;
import Guidesign.Gaestelisteparty;
import Guidesign.GastBearbeiten;
import Guidesign.Gasthinzufuegen;
import Guidesign.Partyerstellen;
import Guidesign.Partyliste;
import Guidesign.Startseite;
import Guidesign.Warehinzufuegen;
import Guidesign.Warenliste;
import Model.Gast;
import Model.Model;
import Model.Party;
import Model.Partytyp;
import Model.Partyverwaltung.PartyExestiertBereitsException;
import Model.Ware;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private Gaestebuch gaestebuch;
    private Warenliste warenliste;
    private Warehinzufuegen warehinzufuegen;
    private Gasthinzufuegen gasthinzufuegen;
    private GastBearbeiten gastbearbeiten;
    private int indexBearbeiteterGast;
    private Party aktuelleParty;
    private Gaestelisteparty gaesteListeParty;
    
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
        } else if (e.getActionCommand().equals("Speichern")) {
            if(aktuelleParty == null)
                return;
            partySpeichern();
        } else if (e.getActionCommand().equals("Partyliste.PartyAnzeigen")) {
            int index = partyListe.getpartylist().getSelectedIndex();
            aktuelleParty = model.partyverwaltung.getPartyliste().get(index);
            partyListe.dispose();
            partyListe = null;
            alterPartyName = aktuelleParty.getName();
            gui.getPartynameeintragen().setText(aktuelleParty.getName());
            gui.getPartydatumeintragen().setText(aktuelleParty.getDatumAlsString());
            gui.getPartybudget().setText(Double.toString(aktuelleParty.getBudget()));
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
        } else if (e.getActionCommand().equals("Gästebuch anzeigen")) {
            gaestebuch = new Gaestebuch(this);
            gaestebuch.setVisible(true);
            gaestebuch.setAlwaysOnTop(true);
            gaestebuch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            List<Gast> gaeste = model.gaesteverwaltung.getGaesteListe();
            String[] gaesteArray = new String[gaeste.size()];
            for(int i = 0; i < gaeste.size(); i++) {
                gaesteArray[i] = gaeste.get(i).getName();
            }
            gaestebuch.getgaesteListe().setListData(gaesteArray);
        } else if (e.getActionCommand().equals("Gast hinzufügen")) {
            gasthinzufuegen = new Gasthinzufuegen(this);
            gasthinzufuegen.setVisible(true);
            gasthinzufuegen.setAlwaysOnTop(true);
            gasthinzufuegen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (e.getActionCommand().equals("Gast speichern")) {
            String vname = gasthinzufuegen.getVorname().getText();
            String nname = gasthinzufuegen.getNachname().getText();
            String gbdatum = gasthinzufuegen.getGeburtsdatum().getText();
            String telefon = gasthinzufuegen.getTelefon().getText();
            String mail = gasthinzufuegen.getMail().getText();
            if(vname.equals("") || nname.equals("")) {
                gasthinzufuegen.geterrorLabel().setText("Namen sind nicht richtig ausgefüllt!");
                gasthinzufuegen.geterrorLabel().setForeground(Color.red);
                return;
            }
            String[] datumArray = gbdatum.split("\\.");
            if(datumArray.length != 3) {
                gasthinzufuegen.geterrorLabel().setText("Ungültiges Geburtsdatum.");
                gasthinzufuegen.geterrorLabel().setForeground(Color.red);
                return;
            }
            GregorianCalendar gregorianDatum;
            try {
                int tag = Integer.parseInt(datumArray[0]);
                int monat = Integer.parseInt(datumArray[1]);
                int jahr = Integer.parseInt(datumArray[2]);
                if(tag < 1 || tag > 31 || monat < 1 || monat > 12) { //TODO: Ist das jahr wichtig ? Und wie sieht es mit Feb.aus?
                    gasthinzufuegen.geterrorLabel().setText("Ungültiges Geburtsdatum.");
                    gasthinzufuegen.geterrorLabel().setForeground(Color.red);
                    return;
                }
                gregorianDatum = new GregorianCalendar(jahr, monat, tag);
            } catch (NumberFormatException exeption) {
                gasthinzufuegen.geterrorLabel().setText("Ungültiges Geburtsdatum.");
                gasthinzufuegen.geterrorLabel().setForeground(Color.red);
                return;
            }
            if(model.gaesteverwaltung.gastSuchen(vname, nname) != null) {
                gasthinzufuegen.geterrorLabel().setText("Gast exestiert bereits!");
                gasthinzufuegen.geterrorLabel().setForeground(Color.red);
                return;
            }
            model.gaesteverwaltung.gast_erstellen(vname, nname, gregorianDatum, mail, telefon);
            gasthinzufuegen.dispose();
            List<Gast> gaeste = model.gaesteverwaltung.getGaesteListe();
            String[] gaesteArray = new String[gaeste.size()];
            for(int i = 0; i < gaeste.size(); i++) {
                gaesteArray[i] = gaeste.get(i).getName();
            }
            gaestebuch.getgaesteListe().setListData(gaesteArray);
        } else if(e.getActionCommand().equals("Gast entfernen")) {
            int index = gaestebuch.getgaesteListe().getSelectedIndex();
            Gast gast = model.gaesteverwaltung.getGaesteListe().get(index);
            model.gaesteverwaltung.gast_loeschen(gast);
            List<Gast> gaeste = model.gaesteverwaltung.getGaesteListe();
            String[] gaesteArray = new String[gaeste.size()];
            for(int i = 0; i < gaeste.size(); i++) {
                gaesteArray[i] = gaeste.get(i).getName();
            }
            gaestebuch.getgaesteListe().setListData(gaesteArray);
        } else if(e.getActionCommand().equals("Gast bearbeiten")) {
            indexBearbeiteterGast = gaestebuch.getgaesteListe().getSelectedIndex();
            if(indexBearbeiteterGast < 0)
                return;
            Gast gast = model.gaesteverwaltung.getGaesteListe().get(indexBearbeiteterGast);
            if(gast == null) {
                return;
            }
            gastbearbeiten = new GastBearbeiten(this);
            gastbearbeiten.setVisible(true);
            gastbearbeiten.setAlwaysOnTop(true);
            gastbearbeiten.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            gastbearbeiten.getVnameeintragen().setText(gast.getVorname());
            gastbearbeiten.getNnameeintragen().setText(gast.getNachname());
            gastbearbeiten.getMaileintragen().setText(gast.getEmail());
            gastbearbeiten.getTeleintragen().setText(gast.getTelefon());
            gastbearbeiten.getGbteintragen().setText(gast.getDatumAlsString());
        } else if(e.getActionCommand().equals("bearbeiteter Gast")) {
            String vname = gastbearbeiten.getVnameeintragen().getText();
            String nname = gastbearbeiten.getNnameeintragen().getText();
            String gbdatum = gastbearbeiten.getGbteintragen().getText();
            String telefon = gastbearbeiten.getTeleintragen().getText();
            String mail = gastbearbeiten.getMaileintragen().getText();
            if(vname.equals("") || nname.equals("")) {
                gastbearbeiten.getErrorLabel().setText("Namen sind nicht richtig ausgefüllt!");
                gastbearbeiten.getErrorLabel().setForeground(Color.red);
                return;
            }
            String[] datumArray = gbdatum.split("\\.");
            if(datumArray.length != 3) {
                gastbearbeiten.getErrorLabel().setText("Ungültiges Geburtsdatum.");
                gastbearbeiten.getErrorLabel().setForeground(Color.red);
                return;
            }
            GregorianCalendar gregorianDatum;
            try {
                int tag = Integer.parseInt(datumArray[0]);
                int monat = Integer.parseInt(datumArray[1]);
                int jahr = Integer.parseInt(datumArray[2]);
                if(tag < 1 || tag > 31 || monat < 1 || monat > 12) { //TODO: Ist das jahr wichtig ? Und wie sieht es mit Feb.aus?
                    gastbearbeiten.getErrorLabel().setText("Ungültiges Geburtsdatum.");
                    gastbearbeiten.getErrorLabel().setForeground(Color.red);
                    return;
                }
                gregorianDatum = new GregorianCalendar(jahr, monat, tag);
            } catch (NumberFormatException exeption) {
                gastbearbeiten.getErrorLabel().setText("Ungültiges Geburtsdatum.");
                gastbearbeiten.getErrorLabel().setForeground(Color.red);
                return;
            }          
            model.gaesteverwaltung.gast_bearbeiten(indexBearbeiteterGast, vname, nname, gregorianDatum, mail, telefon);
            indexBearbeiteterGast = -1;
            gastbearbeiten.dispose();
            List<Gast> gaeste = model.gaesteverwaltung.getGaesteListe();
            String[] gaesteArray = new String[gaeste.size()];
            for(int i = 0; i < gaeste.size(); i++) {
                gaesteArray[i] = gaeste.get(i).getName();
            }
            gaestebuch.getgaesteListe().setListData(gaesteArray);
        }
         else if (e.getActionCommand().equals("Waren anzeigen")) {
            warenliste = new Warenliste(this);
            warenliste.setVisible(true);
            warenliste.setAlwaysOnTop(true);
            warenliste.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            List<Ware> ware = model.warenverwaltung.getWarenListe();
            String[] wareArray = new String[ware.size()];
            for(int i = 0; i < ware.size(); i++) {
                wareArray[i] = ware.get(i).getWarenName();
            }
            warenliste.getwarenListe().setListData(wareArray);
            } else if (e.getActionCommand().equals("Ware hinzufügen")) {
            warehinzufuegen = new Warehinzufuegen(this);
            warehinzufuegen.setVisible(true);
            warehinzufuegen.setAlwaysOnTop(true);
            warehinzufuegen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (e.getActionCommand().equals("Ware speichern")) {
            String warenName = warehinzufuegen.getWarenname().getText();
            String volumenmenge = warehinzufuegen.getvolumenmenge().getText();
            String akgh = warehinzufuegen.getalkoholgehalt().getText();
            String preiss = warehinzufuegen.getPreis().getText();
            double alkoholgehalt;
            try {
                
                alkoholgehalt = Double.parseDouble(akgh);
                
            } catch (NumberFormatException exception) {
               
                return;
            }
            double preis;
            try {
                
                preis = Double.parseDouble(preiss);
                
            } catch (NumberFormatException exception) {
                return;
            }
            model.warenverwaltung.ware_hinzufuegen(warenName,preis,volumenmenge, 
            alkoholgehalt);
             warehinzufuegen.dispose();
            List<Ware> waren = model.warenverwaltung.getWarenListe();
            String[] warenArray = new String[waren.size()];
            for(int i = 0; i < waren.size(); i++) {
                warenArray[i] = waren.get(i).getWarenName();
            }
            warenliste.getwarenListe().setListData(warenArray);
            
         } else if(e.getActionCommand().equals("Ware entfernen")) {
            int index = warenliste.getwarenListe().getSelectedIndex();
            Ware ware = model.warenverwaltung.getWarenListe().get(index);
            model.warenverwaltung.ware_loeschen(ware);
            List<Ware>waren = model.warenverwaltung.getWarenListe();
            String[] wareArray = new String[waren.size()];
            for(int i = 0; i < waren.size(); i++) {
                wareArray[i] = waren.get(i).getWarenName();
            }
            warenliste.getwarenListe().setListData(wareArray);
         } else if(e.getActionCommand().equals("Gaesteliste erstellen")) {
             if(aktuelleParty == null)
                 return;
             gaesteListeParty = new Gaestelisteparty(this);
             gaesteListeParty.setVisible(true);
             gaesteListeParty.setAlwaysOnTop(true);
             gaesteListeParty.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             List<Gast> listeGeladen = aktuelleParty.getGaesteListe();
             String[] gaesteArray = new String[listeGeladen.size()];
             for(int i = 0; i < listeGeladen.size(); i++) {
                 gaesteArray[i] = listeGeladen.get(i).getName();
             }
             List<Gast> alleGaesteListe = model.gaesteverwaltung.getGaesteListe();
             String[] alleGaesteArray = new String[alleGaesteListe.size() - listeGeladen.size()];
             int i = 0;
             for(Gast gast : alleGaesteListe) {
                 if(!listeGeladen.contains(gast)) {
                     alleGaesteArray[i] = gast.getName();
                     i++;
                 }
             }
             gaesteListeParty.getGaesteListe().setListData(alleGaesteArray);
             gaesteListeParty.getGaesteListeEingeladen().setListData(gaesteArray);
         } else if(e.getActionCommand().equals("Gaestelisteparty.Gast hinzufuegen")) {
             int index = gaesteListeParty.getGaesteListe().getSelectedIndex();
             if(index < 0)
                 return;
             List<Gast> listeGeladen = aktuelleParty.getGaesteListe();
             List<Gast> alleGaesteListe = model.gaesteverwaltung.getGaesteListe();
             List<Gast> alleGaesteListe2 = new ArrayList<Gast>();
             for(Gast gast : alleGaesteListe)
                 if(!listeGeladen.contains(gast))
                     alleGaesteListe2.add(gast);
             
             listeGeladen.add(alleGaesteListe2.get(index)); 
             alleGaesteListe2.remove(index);
             String[] gaesteArray = new String[listeGeladen.size()];
             for(int i = 0; i < listeGeladen.size(); i++) {
                 gaesteArray[i] = listeGeladen.get(i).getName();
             }
             String[] alleGaesteArray = new String[alleGaesteListe2.size()];
             for(int i = 0; i < alleGaesteListe2.size(); i++) {
                 alleGaesteArray[i] = alleGaesteListe2.get(i).getName();
             }
             gaesteListeParty.getGaesteListe().setListData(alleGaesteArray);
             gaesteListeParty.getGaesteListeEingeladen().setListData(gaesteArray);
         } else if(e.getActionCommand().equals("Gaestelisteparty.Gast entfernen")) {
             int index = gaesteListeParty.getGaesteListeEingeladen().getSelectedIndex();
             if(index < 0)
                 return;
             List<Gast> listeGeladen = aktuelleParty.getGaesteListe();
             List<Gast> alleGaesteListe = model.gaesteverwaltung.getGaesteListe();
             listeGeladen.remove(index);
             String[] gaesteArray = new String[listeGeladen.size()];
             for(int i = 0; i < listeGeladen.size(); i++) {
                 gaesteArray[i] = listeGeladen.get(i).getName();
             }
             
             String[] alleGaesteArray = new String[alleGaesteListe.size() - listeGeladen.size()];
             int i = 0;
             for(Gast gast : alleGaesteListe) {
                 if(!listeGeladen.contains(gast)) {
                     alleGaesteArray[i] = gast.getName();
                     i++;
                 }
             }
             gaesteListeParty.getGaesteListe().setListData(alleGaesteArray);
             gaesteListeParty.getGaesteListeEingeladen().setListData(gaesteArray);
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
            model.partyverwaltung.party_bearbeiten(alterPartyName, name, partyBudget, gregorianDatum );
        } catch (PartyExestiertBereitsException ex) {
            gui.getErrorLabel().setText("Dieser Partyname existiert bereits.");
                gui.getErrorLabel().setForeground(Color.red);
                return;
        }
            
            
            gui.getErrorLabel().setText("Partyänderungen erfolgreich gespeichert");
            gui.getErrorLabel().setForeground(Color.green);
    }
}