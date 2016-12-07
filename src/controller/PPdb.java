

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
            e.printStackTrace();
            return;
        }

        con = null;

        try {
            con = DriverManager.getConnection("jdbc:hsqldb:file:data/partys;ifexists=true", "SA", "");
            Statement statement = con.createStatement();
            statement.executeQuery("CREATE TABLE IF NOT EXISTS "
                    + "Ware(index int, warename varChar(15), preis double, menge varchar(10), alkoholgehalt double)");
            statement.executeQuery("CREATE TABLE IF NOT EXISTS "
                    + "Gast(index int, vorname varChar(20), nachname varChar(20), geburtstdatum date, email varChar(100), telefon varChar(20))");
            statement.executeQuery("CREATE TABLE IF NOT EXISTS "
                    + "Party(index int, name varChar(50), budget double, raumbedarf int, tipps varChar(1000), datum varChar(15))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void wareEinfügen(String warenName, double preis, String menge, double alkoholgehalt) throws SQLException {
        int index = 0;
        try {
            Statement stmt = con.createStatement();

            ResultSet r = stmt.executeQuery("SELECT * FROM Ware");

            while (r.next()) {
                if (r.getInt(1) < index) {
                    continue;
                }
                index = r.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "INSERT INTO Ware (index, warenname, preis, menge, alkoholgehalt) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, index+1);
            prep.setString(2, warenName);
            prep.setDouble(3, preis);
            prep.setString(4, menge);
            prep.setDouble(5, alkoholgehalt);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void gastEinfügen(String vorname, String nachname,
            Date geburtsdatum, String email, String telefon) {

        int index = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet r = stmt.executeQuery("SELECT * FROM Gast");

            while (r.next()) {
                if (r.getInt(1) < index) {
                    continue;
                }
                index = r.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "INSERT INTO Gast VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, index+1);
            prep.setString(2, vorname);
            prep.setString(3, nachname);
            /**
             * String[] datumsteile = geburtsdatum.split("-"); int jahr =
             * Integer.parseInt(datumsteile[0]); int monat =
             * Integer.parseInt(datumsteile[1]) - 1; int tag =
             * Integer.parseInt(datumsteile[2]); GregorianCalendar greg = new
             * GregorianCalendar(jahr, monat, tag);
             */
            prep.setDate(4, geburtsdatum);
            prep.setString(5, email);
            prep.setString(6, telefon);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void partyEinfuegen(Party party) {

        int index = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet r = stmt.executeQuery("SELECT * FROM Party");

            while (r.next()) {
                if (r.getInt(1) < index) {
                    continue;
                }
                index = r.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "INSERT INTO Party VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, index+1);
            prep.setString(2, party.getName());
            prep.setDouble(3, party.getBudget());
            prep.setInt(4, party.getRaumbedarf());
            prep.setString(5, party.getTipps());
            GregorianCalendar datum = party.getDatum();
            int jahr = datum.get(Calendar.YEAR);
            int monat = datum.get(Calendar.MONTH)+1;
            int tag = datum.get(Calendar.DAY_OF_MONTH);
            prep.setString(6, jahr+"-"+monat+"-"+tag);
            prep.executeUpdate();
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

    public static void main(String[] args) throws SQLException {

        PPdb p = new PPdb();
        // p.wareEinfügen(6, "Coca Cola", 0.99, "1 Lter", 0.0);

        //p.selectAll();
        List<Gast> gaeste = p.gibAlleGaeste();
        System.out.println(gaeste.size());
        for(Gast gast : gaeste) {
            System.out.println(gast.getName());
        }
        List<Ware> waren = p.gibAlleWaren();
        for(Ware ware : waren)
            System.out.println(ware.getWarenName() + "  " + ware.getPreis());
        List<Party> partys = p.gibAllePartys();
        for(Party party : partys) {
            System.out.println(party.getName());
        }
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
                String tipps = res.getString(5);
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

}
