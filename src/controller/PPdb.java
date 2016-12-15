package controller;

import Model.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kadir Aktas
 */
public class PPdb {

    Connection con = null;

    public PPdb() {
        try {
            // Laden des JDBC-Treibers aus dem CLASSPATH:
            // Hierfür ist unter Eclipse die Einbindung des jar-Files als
            // Library erforderlich.
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Fehler!!!");
            return;
        }

        con = null;

        try {
            con = DriverManager.getConnection("jdbc:hsqldb:file:data\\partys", "SA", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {

        PPdb p = new PPdb();
        // p.wareEinfügen(6, "Coca Cola", 0.99, "1 Lter", 0.0);
        // p.gastEinfügen("Max", "Mustermann", 1990.01.01, "m.m@mail.com", "01234567891");
        p.selectAll();
        List<Gast> gaeste = p.gibAlleGaeste();
        List<Ware> waren = p.gibAlleWaren();
        List<Party> partys = p.gibAllePartys();
        System.out.println(gaeste.size());
        System.out.println(waren.size());
        System.out.println(partys.size());

    }

    public ResultSet executeSQL(String sql) {
        try {
            Statement stmt = con.createStatement();

            ResultSet res = stmt.executeQuery(sql);
            return res;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Party> gibAllePartys() {
        List<Party> partys = new ArrayList<Party>();

        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Party";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                int id = res.getInt(1);
                String partyname = res.getString(2);
                double budget = res.getDouble(3);
                int raumbedarf = res.getInt(4);
                String anmerkung = res.getString(5);
                String datum = res.getString(6);
                String[] datumsteile = datum.split("-");
                int jahr = Integer.parseInt(datumsteile[0]);
                int monat = Integer.parseInt(datumsteile[1]) - 1;
                int tag = Integer.parseInt(datumsteile[2]);
                GregorianCalendar greg = new GregorianCalendar(jahr, monat, tag);
                Party party = new Party(partyname, budget, greg, null); //TODO: Partytyp darf nicht null sein!
                //party.setPartynummer(id);
                partys.add(party);
            }

            res.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partys;
    }

    public void partyEinfuegen(Party party) {

        try {
            Statement stmt = con.createStatement();
            ResultSet r = stmt.executeQuery("SELECT * FROM Party");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "INSERT INTO Party (partyname, budget, raumbedarf, tipps, datum) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, party.getName());
            prep.setDouble(2, party.getBudget());
            prep.setInt(3, party.getRaumbedarf());
            prep.setString(4, party.getAnmerkung());
            GregorianCalendar datum = party.getDatum();
            int jahr = datum.get(Calendar.YEAR);
            int monat = datum.get(Calendar.MONTH) + 1;
            int tag = datum.get(Calendar.DAY_OF_MONTH);
            prep.setString(5, jahr + "-" + monat + "-" + tag);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void partyLoeschen(int partynummer) {

        try {
            String sql = "Delete from Party where ID = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, partynummer);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void partyBearbeiten(int partynummer, Party party) {

        try {
            String sql = "UPDATE Party SET Partyname = ?, Budget = ?, Raumbedarf = ?,"
                    + "Tipps = ?, Datum = ? WHERE id = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, party.getName());
            prep.setDouble(2, party.getBudget());
            prep.setInt(3, party.getRaumbedarf());
            prep.setString(4, party.getAnmerkung());
            GregorianCalendar datum = party.getDatum();
            int jahr = datum.get(Calendar.YEAR);
            int monat = datum.get(Calendar.MONTH) + 1;
            int tag = datum.get(Calendar.DAY_OF_MONTH);
            prep.setString(5, jahr + "-" + monat + "-" + tag);
            prep.setInt(6, partynummer);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Gast> gibAlleGaeste() {
        List<Gast> gaeste = new ArrayList<Gast>();

        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Gast";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                int id = res.getInt(1);
                String vorname = res.getString(2);
                String nachname = res.getString(3);
                String email = res.getString(5);
                String geburtsdatum = res.getString("geburtsdatum");
                String[] datumsteile = geburtsdatum.split("-");
                int jahr = Integer.parseInt(datumsteile[0]);
                int monat = Integer.parseInt(datumsteile[1]) - 1;
                int tag = Integer.parseInt(datumsteile[2]);
                GregorianCalendar greg = new GregorianCalendar(jahr, monat, tag);
                String telefon = res.getString("telefonnr");
                Gast gast = new Gast(vorname, nachname, greg, email, telefon);
                gast.setGastnummer(id);
                gaeste.add(gast);
            }

            res.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gaeste;
    }

    public void gastEinfuegen(Gast gast) {

        try {
            Statement stmt = con.createStatement();
            ResultSet r = stmt.executeQuery("SELECT * FROM Gast");

        } catch (SQLException e) {
            e.printStackTrace();
            
        }

        try {
            String sql = "INSERT INTO Gast (vorname, nachname, geburtsdatum, email, telefonnr) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, gast.getVorname());
            prep.setString(2, gast.getNachname());
           
            /**
             * String[] datumsteile = geburtsdatum.split("-"); int jahr =
             * Integer.parseInt(datumsteile[0]); int monat =
             * Integer.parseInt(datumsteile[1]) - 1; int tag =
             * Integer.parseInt(datumsteile[2]); GregorianCalendar greg = new
             * GregorianCalendar(jahr, monat, tag);
             */GregorianCalendar datum = gast.getGeburtstdatum();
            int jahr = datum.get(Calendar.YEAR);
            int monat = datum.get(Calendar.MONTH) + 1;
            int tag = datum.get(Calendar.DAY_OF_MONTH);
            prep.setString(3, jahr + "-" + monat + "-" + tag);
            prep.setString(4, gast.getEmail());
            prep.setString(5, gast.getTelefon());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void gastLoeschen(int gastnummer) {

        try {
            String sql = "Delete from Gast where GastID = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, gastnummer);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void gastBearbeiten(Gast gast) {

        try {
            String sql = "UPDATE Gast SET Vorname = ?, Nachname = ?, Geburtsdatum = ?,"
                    + "Email = ?, Telefonnr = ? WHERE GastId = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, gast.getVorname());
            prep.setString(2, gast.getNachname());
            GregorianCalendar datum = gast.getGeburtstdatum();
            int jahr = datum.get(Calendar.YEAR);
            int monat = datum.get(Calendar.MONTH) + 1;
            int tag = datum.get(Calendar.DAY_OF_MONTH);
            prep.setString(3, jahr + "-" + monat + "-" + tag);
            prep.setString(4, gast.getEmail());
            prep.setString(5, gast.getTelefon());
            prep.setInt(6, gast.getGastnummer());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ware> gibAlleWaren() {
        List<Ware> waren = new ArrayList<Ware>();

        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Ware";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                int id = res.getInt(1);
                String warenName = res.getString(2);
                Double preis = res.getDouble(3);
                String menge = res.getString(4);
                Double alkoholgehalt = res.getDouble(5);
                Ware ware = new Ware(warenName, preis, menge, alkoholgehalt);
                //mware.setWarennummer(id);
                waren.add(ware);
            }

            res.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return waren;
    }

    public void wareEinfuegen(Ware ware) {

        try {
            Statement stmt = con.createStatement();
            ResultSet r = stmt.executeQuery("SELECT * FROM Ware");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "INSERT INTO Ware (warenname, preis, menge, alkoholgehalt) VALUES (?, ?, ?, ?)";

            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, ware.getWarenName());
            prep.setDouble(2, ware.getPreis());
            prep.setString(3, ware.getMenge());
            prep.setDouble(4, ware.getAlkoholgehalt());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void wareLoeschen(int warennummer) {

        try {
            String sql = "Delete from Ware where strichcode = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, warennummer);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void wareBearbeiten(int warennummer, Ware ware) {

        try {
            String sql = "UPDATE Ware SET Warenname = ?, Preis = ?, Menge = ?,"
                    + "Alkoholgehalt = ? WHERE Strichcode = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, ware.getWarenName());
            prep.setDouble(2, ware.getPreis());
            prep.setString(3, ware.getMenge());
            prep.setDouble(4, ware.getAlkoholgehalt());
            prep.setInt(5, warennummer);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAll() {

        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Gast";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                String id = res.getString(1);
                String vorname = res.getString(2);
                String nachname = res.getString(3);
                String email = res.getString(5);
                System.out.println(id + ", " + vorname + ", " + nachname + ", " + email);
            }

            res.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean gastErstellen(Gast gast) throws SQLException {

        boolean erfolgreich = false;

        Statement stmt = con.createStatement();
        GregorianCalendar datum = gast.getGeburtstdatum();
        String sqlDatum = datum.get(GregorianCalendar.YEAR) + "-" + (datum.get(GregorianCalendar.MONTH) + 1) + "-" + datum.get(GregorianCalendar.DAY_OF_MONTH);
        stmt.executeUpdate("INSERT INTO gast (vorname, nachname, geburtsdatum, email, telefon) values ('"
                + gast.getVorname() + "', '" + gast.getNachname() + "', '" + sqlDatum + "', '" + gast.getEmail() + "', '" + gast.getTelefon() + "')", Statement.RETURN_GENERATED_KEYS);
        // Auslesen des erzeugten Primärschlüssels (id)
        ResultSet rst = stmt.getGeneratedKeys();
        if (rst.next()) {
            gast.setGastnummer(rst.getInt(1));
            erfolgreich = true;
        }

        stmt.close();
        return erfolgreich;
    }

}
