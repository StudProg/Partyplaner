package controller;

import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Diese Klasse baut die Verbindung zur Datenbank auf und führt bestimmte 
 * Operationen darauf auf.
 * @author Kadir Aktas
 */
public class PPdb {

    Connection con = null;

    /**
     * Der Konstruktor baut die Verbindung zur Datenbank auf.
     */
    public PPdb() {
        try {
            // Laden des JDBC-Treibers aus dem CLASSPATH:
            // Hierfür ist unter Eclipse die Einbindung des jar-Files als
            // Library erforderlich.
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Fehler!!!");
            e.printStackTrace();
            return;
        }

        try {
            con = DriverManager.getConnection("jdbc:hsqldb:file:../data/partys", "SA", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Diese Main Methode wird eine Verbindung zur Datenbank aufbauen und 
     * bestimmte Informationen zu Testzwecken abfragen.
     * @param args Startargumente
     * @throws java.sql.SQLException bei einem Zugriffsfehler
     */
    public static void main(String[] args) throws SQLException {

        PPdb p = new PPdb();
        // p.wareEinfügen(6, "Coca Cola", 0.99, "1 Lter", 0.0);
        // p.gastEinfügen("Max", "Mustermann", 1990.01.01, "m.m@mail.com", "01234567891");
        p.selectAll();
        List<Gast> gaeste = p.gibAlleGaeste();
        List<Ware> waren = p.gibAlleWaren();
        Map<Party, List<String[]>> partys = p.gibAllePartys();
        System.out.println(gaeste.size());
        System.out.println(waren.size());
        System.out.println(partys.size());

    }

    /**
     * Diese Methode führt einen String (SQL Kommando) auf der Datenbank aus.
     * @param sql der SQL Kommando
     * @return das {@link ResultSet}
     */
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
    
    /**
     * Die Methode gibAlleGaeste holt aus der Daten alle gespeicherten Gäste
     * @return gaeste gib eine Liste aller {@link Gast} zurück
     */
    public List<Gast> gibAlleGaeste() {
        List<Gast> gaeste = new ArrayList<>();

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
    
    /**
     * Ein neuer {@link Gast} wird in die DB Relation Gast eingefügt.
     * @param gast gast ist ein Objekt vom Typ {@link Gast}
     * @return true, wenn das einfügen erfolgreich war, false andernfalls.
     * @throws java.sql.SQLException bei einem Zugriffsfehler
     */
    public boolean gastErstellen(Gast gast) throws SQLException {

        boolean erfolgreich = false;

        Statement stmt = con.createStatement();
        GregorianCalendar datum = gast.getGeburtstdatum();
        String sqlDatum = datum.get(GregorianCalendar.YEAR) + "-" + (datum.get(GregorianCalendar.MONTH) + 1) + "-" + datum.get(GregorianCalendar.DAY_OF_MONTH);
        String sql = "INSERT INTO gast (vorname, nachname, geburtsdatum, email, telefonnr) values ('"
                + gast.getVorname() + "', '" + gast.getNachname() + "', '" + sqlDatum + "', '" + gast.getEmail() + "', '" + gast.getTelefon() + "')";
        System.out.println(sql);
        //Geburtsdatum ist ein Datetime objekt, kein String!
        stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        
        // Auslesen des erzeugten Primärschlüssels (id)
        ResultSet rst = stmt.getGeneratedKeys();
        if (rst.next()) {
            gast.setGastnummer(rst.getInt(1));
            erfolgreich = true;
        }

        stmt.close();
        return erfolgreich;
    }
    
    /**
     * Der ausgewählte Gast wird aus DB gelöscht
     * @param gastnummer ist {@link Gast#gastnummer} (Primärschlüssel)
     */
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
    
    /**
     * Der ausgewählte Gast wird durch die neuen Eingaben bearbeitet.
     * @param gast gast ist ein Objekt vom Typ {@link Gast}
     */
    public void gastBearbeiten(Gast gast) {

        try {
            String sql = "UPDATE Gast SET vorname = ?, nachname = ?, geburtsdatum = ?,"
                    + "email = ?, telefonnr = ? WHERE GastId = ?";
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

    /**
     * Die Methode gibAllePartys holt aus der Daten alle gespeicherten Partys.
     * @return gibt eine Liste mit {@link Party} zurück
     */
    public Map<Party, List<String[]>> gibAllePartys() {
        Map<Party, List<String[]>> partys = new LinkedHashMap<Party, List<String[]>>();

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
                String gaeste = res.getString(7);
                String[] datumsteile = datum.split("-");
                int jahr = Integer.parseInt(datumsteile[0]);
                int monat = Integer.parseInt(datumsteile[1]) - 1;
                int tag = Integer.parseInt(datumsteile[2]);
                GregorianCalendar greg = new GregorianCalendar(jahr, monat, tag);
                Party party = new Party(id, partyname, budget, greg, null); //TODO: Partytyp darf nicht null sein!
                //party.setPartynummer(id);
                List<String[]> extra = new ArrayList<String[]>();
                if (gaeste==null) {
                    extra.add(new String[0]);
                } else {
                    extra.add(gaeste.split(";"));
                }
                partys.put(party, extra);
            }

            res.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partys;
    }

    /**
     * Eine neue {@link Party} wird in die DB Relation Party eingefügt.
     * @param party party ist ein Objekt vom Typ {@link Party}
     * @return der Primärschlüssel der eingefügten Party
     */
    public int partyEinfuegen(Party party) {

        try {
            Statement stmt = con.createStatement();
            ResultSet r = stmt.executeQuery("SELECT * FROM Party");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            GregorianCalendar datum = party.getDatum();
            int jahr = datum.get(Calendar.YEAR);
            int monat = datum.get(Calendar.MONTH) + 1;
            int tag = datum.get(Calendar.DAY_OF_MONTH);
            String sql = "INSERT INTO Party (partyname, budget, raumbedarf, tipps, datum, gaeste) values ('"
                + party.getName() + "', '" + party.getBudget() + "', '" + party.getRaumbedarf() + "', '" 
                    + party.getAnmerkung() + "', '" + jahr + "-" + monat + "-" + tag + "', '" + "" + "')";
            Statement prep = con.createStatement();     
            prep.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            // Auslesen des erzeugten Primärschlüssels (id)
            ResultSet rst = prep.getGeneratedKeys();
            if (rst.next()) {
                return rst.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Die ausgewählte Party wird aus der DB gelöscht.
     * @param partynummer {@link Party#id} (Primärschlüssel)
     */
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

    /**
     * Die ausgewählte Party wird durch die neuen Eingaben bearbeitet.
     * @param partynummer ist das Primärschlüssel der gewählten Party ({@link Party#id})
     * @param party party ist ein Objekt vom Typ {@link Party}
     * @param gaesteListe Angaben der Gästeanzahl laut {@link Party#getGaesteListeAlsDatenbank()}
     */
    public void partyBearbeiten(int partynummer, Party party, String gaesteListe) {

        try {
            String sql = "UPDATE Party SET Partyname = ?, Budget = ?, Raumbedarf = ?,"
                    + "Tipps = ?, Datum = ?, Gaeste = ? WHERE id = ?";
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
            prep.setString(6, gaesteListe);
            prep.setInt(7, partynummer);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Holt aus der Datenbank alle gespeicherten Waren.
     * @return waren gibt eine Liste mit {@link Ware} zurück
     */
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
                Ware ware = new Ware(id, warenName, preis, menge, alkoholgehalt);
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

    /**
     * Eine neue Ware wird in die DB Relation Ware eingefügt.
     * @param ware ware ist ein Objekt vom Typ {@link Ware}
     * @return der Primärschlüssel der eingefügten Ware in der Datenbank
     */
    public int wareEinfuegen(Ware ware) {

        try {
            Statement stmt = con.createStatement();
            ResultSet r = stmt.executeQuery("SELECT * FROM Ware");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            
            String sql = "INSERT INTO Ware (warenname, preis, menge, alkoholgehalt) VALUES ('"
                    + ware.getWarenName() +  "', '" + ware.getPreis() + "', '" + ware.getMenge() + "', '"+ ware.getAlkoholgehalt()+"')";
            Statement prep = con.createStatement();     
            prep.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            // Auslesen des erzeugten Primärschlüssels (id)
            ResultSet rst = prep.getGeneratedKeys();
            if (rst.next()) {
                return rst.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    /**
     * Die ausgewählte Ware wird aus DB gelöscht.
     * @param warennummer {@link Ware#Strichcode} (Primärschlüssel)
     */
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

    /**
     * Die ausgewählte Ware wird durch die neuen Eingaben bearbeitet.
     * @param warennummer ist das Primärschlüssel {@link Ware#Strichcode}
     * @param ware ware ist ein Objekt vom Typ {@link Ware}
     */
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

    /**
     * Fragt in der Datenbank nach den Gästen und gibt diese auf der Konsole 
     * aus.
     */
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
