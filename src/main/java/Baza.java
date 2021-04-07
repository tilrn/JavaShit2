import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Baza {


    private static Connection connect() {
        Connection con = null;
        try
        {
            con = DriverManager.getConnection("postgres://epebibyjgvxunf:93ec9324d483d5ed6ade4fee633490dd665c1d710943c76dbd59a7ece3df6432@ec2-176-34-222-188.eu-west-1.compute.amazonaws.com:5432/d6mgn1man4juqu", "epebibyjgvxunf", "93ec9324d483d5ed6ade4fee633490dd665c1d710943c76dbd59a7ece3df6432");
        }
        catch (SQLException e)
        {
            System.out.println("povezava z bazo ni uspela");
        }
        return con;
    }
    public static ArrayList<String> SelectKraji()
    {
        String com = "SELECT name FROM locations";
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
}
