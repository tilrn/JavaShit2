import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Baza {


    public static Connection connect() {
        Connection con = null;
        try
        {
            con = DriverManager.getConnection("jdbc:postgresql://ec2-176-34-222-188.eu-west-1.compute.amazonaws.com:5432/d6mgn1man4juqu", "epebibyjgvxunf", "93ec9324d483d5ed6ade4fee633490dd665c1d710943c76dbd59a7ece3df6432");
        }
        catch (SQLException e)
        {
            System.out.println("povezava z bazo ni uspela");
        }
        return con;
    }
    public static ArrayList<String> SelectKraji()
    {
        String com = "SELECT ime FROM kraji";
        ArrayList<String> locations = new ArrayList<String>();

        try (Connection con = connect();
             Statement stat = con.createStatement();
             ResultSet rez = stat.executeQuery(com))
        {

            while (rez.next()) {
                String k = rez.getString(1);
                locations.add(k);
            }

        }
        catch (SQLException e) {

            System.out.println("SelectKraji() napaka " + e );
        }
        return locations;

    }
    public static boolean SelectLogin(String email_, String pass_)
    {
        String com = "SELECT mail, geslo FROM muzikanti WHERE (mail='" + email_ + "') AND (geslo='" + pass_ + "');";
        boolean potrditev = false;

        try (Connection con = connect();
             Statement stat = con.createStatement();
             ResultSet rez = stat.executeQuery(com))
        {

            while (rez.next()) {
                String l = rez.getString(1);
                if(l != null)
                {
                    potrditev = true;
                }
            }

        }
        catch (SQLException e) {

            System.out.println("Login napaka " + e );
        }
        return potrditev;
    }
    public static boolean registracija(String ime,String priimek, String email, String pass) {
        String com = "SELECT ('" + ime + "','" + email + "','" + pass + "','" + priimek + "')";
        boolean ok = true;
        try (Connection con = connect();
             Statement stat = con.createStatement();
             ResultSet rez = stat.executeQuery(com)){

            while (rez.next()) {
                ok = rez.getBoolean(1);
            }

        } catch (SQLException e) {

            System.out.println("registracija() napaka " + e);
        }
        return ok;

    }
    public static void InsertOglas(String imee, String opiss)
    {
        try (Connection con = connect();
             Statement stat = con.createStatement())
        {
            stat.executeUpdate("INSERT INTO oglasi(ime, opis) VALUES('" + imee + "','" +  opiss + "');");
        }
        catch (SQLException e) {

            System.out.println("InsertOglas " + e );
        }
    }

}