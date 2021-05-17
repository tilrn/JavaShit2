//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Baza {
    public Baza() {
    }

    public static Connection connect() {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:postgresql://ec2-176-34-222-188.eu-west-1.compute.amazonaws.com:5432/d6mgn1man4juqu", "epebibyjgvxunf", "93ec9324d483d5ed6ade4fee633490dd665c1d710943c76dbd59a7ece3df6432");
        } catch (SQLException var2) {
            System.out.println("povezava z bazo ni uspela");
        }

        return con;
    }

    public static ArrayList<String> SelectKraji() {
        String com = "SELECT ime FROM kraji";
        ArrayList locations = new ArrayList();

        try {
            Connection con = connect();

            try {
                Statement stat = con.createStatement();

                try {
                    ResultSet rez = stat.executeQuery(com);

                    try {
                        while(rez.next()) {
                            String k = rez.getString(1);
                            locations.add(k);
                        }
                    } catch (Throwable var10) {
                        if (rez != null) {
                            try {
                                rez.close();
                            } catch (Throwable var9) {
                                var10.addSuppressed(var9);
                            }
                        }

                        throw var10;
                    }

                    if (rez != null) {
                        rez.close();
                    }
                } catch (Throwable var11) {
                    if (stat != null) {
                        try {
                            stat.close();
                        } catch (Throwable var8) {
                            var11.addSuppressed(var8);
                        }
                    }

                    throw var11;
                }

                if (stat != null) {
                    stat.close();
                }
            } catch (Throwable var12) {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Throwable var7) {
                        var12.addSuppressed(var7);
                    }
                }

                throw var12;
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException var13) {
            System.out.println("SelectKraji() napaka " + var13);
        }

        return locations;
    }

    public static boolean SelectLogin(String email_, String pass_) {
        String com = "SELECT mail, geslo FROM muzikanti WHERE (mail='" + email_ + "') AND (geslo='" + pass_ + "');";
        boolean potrditev = false;

        try {
            Connection con = connect();

            try {
                Statement stat = con.createStatement();

                try {
                    ResultSet rez = stat.executeQuery(com);

                    try {
                        while(rez.next()) {
                            String l = rez.getString(1);
                            if (l != null) {
                                potrditev = true;
                            }
                        }
                    } catch (Throwable var12) {
                        if (rez != null) {
                            try {
                                rez.close();
                            } catch (Throwable var11) {
                                var12.addSuppressed(var11);
                            }
                        }

                        throw var12;
                    }

                    if (rez != null) {
                        rez.close();
                    }
                } catch (Throwable var13) {
                    if (stat != null) {
                        try {
                            stat.close();
                        } catch (Throwable var10) {
                            var13.addSuppressed(var10);
                        }
                    }

                    throw var13;
                }

                if (stat != null) {
                    stat.close();
                }
            } catch (Throwable var14) {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Throwable var9) {
                        var14.addSuppressed(var9);
                    }
                }

                throw var14;
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException var15) {
            System.out.println("Login napaka " + var15);
        }

        return potrditev;
    }

    public static boolean registracija(String ime, String priimek, String email, String pass) {
        String com = "SELECT ('" + ime + "','" + email + "','" + pass + "','" + priimek + "')";
        boolean ok = true;

        try {
            Connection con = connect();

            try {
                Statement stat = con.createStatement();

                try {
                    ResultSet rez = stat.executeQuery(com);

                    try {
                        while(rez.next()) {
                            ok = rez.getBoolean(1);
                        }
                    } catch (Throwable var14) {
                        if (rez != null) {
                            try {
                                rez.close();
                            } catch (Throwable var13) {
                                var14.addSuppressed(var13);
                            }
                        }

                        throw var14;
                    }

                    if (rez != null) {
                        rez.close();
                    }
                } catch (Throwable var15) {
                    if (stat != null) {
                        try {
                            stat.close();
                        } catch (Throwable var12) {
                            var15.addSuppressed(var12);
                        }
                    }

                    throw var15;
                }

                if (stat != null) {
                    stat.close();
                }
            } catch (Throwable var16) {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Throwable var11) {
                        var16.addSuppressed(var11);
                    }
                }

                throw var16;
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException var17) {
            System.out.println("registracija() napaka " + var17);
        }

        return ok;
    }

    public static void InsertOglas(String imee, String opiss) {
        try {
            Connection con = connect();

            try {
                Statement stat = con.createStatement();

                try {
                    stat.executeUpdate("INSERT INTO oglasi(ime, opis) VALUES('" + imee + "','" + opiss + "');");
                } catch (Throwable var8) {
                    if (stat != null) {
                        try {
                            stat.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (stat != null) {
                    stat.close();
                }
            } catch (Throwable var9) {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException var10) {
            System.out.println("InsertOglas " + var10);
        }

    }

    public static ArrayList<String> SkupineIzpis() {
        ArrayList<String> casi = new ArrayList();
        String comm = "SELECT id, ime FROM skupine;";

        try {
            Connection con = connect();

            try {
                Statement stat = con.createStatement();

                try {
                    ResultSet rez = stat.executeQuery(comm);

                    try {
                        while(rez.next()) {
                            String m = rez.getString(2);
                            casi.add(m);
                        }
                    } catch (Throwable var11) {
                        if (rez != null) {
                            try {
                                rez.close();
                            } catch (Throwable var10) {
                                var11.addSuppressed(var10);
                            }
                        }

                        throw var11;
                    }

                    if (rez != null) {
                        rez.close();
                    }
                } catch (Throwable var12) {
                    if (stat != null) {
                        try {
                            stat.close();
                        } catch (Throwable var9) {
                            var12.addSuppressed(var9);
                        }
                    }

                    throw var12;
                }

                if (stat != null) {
                    stat.close();
                }
            } catch (Throwable var13) {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Throwable var8) {
                        var13.addSuppressed(var8);
                    }
                }

                throw var13;
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException var14) {
            System.out.println("Selectskupine() napaka " + var14);
        }

        return casi;
    }

    public static ArrayList<String> ZvrstiIzpis() {
        ArrayList<String> zvrsti = new ArrayList();
        String comm = "SELECT id, ime FROM zvrsti;";

        try {
            Connection con = connect();

            try {
                Statement stat = con.createStatement();

                try {
                    ResultSet rez = stat.executeQuery(comm);

                    try {
                        while(rez.next()) {
                            String zvr = rez.getString(2);
                            zvrsti.add(zvr);
                        }
                    } catch (Throwable var11) {
                        if (rez != null) {
                            try {
                                rez.close();
                            } catch (Throwable var10) {
                                var11.addSuppressed(var10);
                            }
                        }

                        throw var11;
                    }

                    if (rez != null) {
                        rez.close();
                    }
                } catch (Throwable var12) {
                    if (stat != null) {
                        try {
                            stat.close();
                        } catch (Throwable var9) {
                            var12.addSuppressed(var9);
                        }
                    }

                    throw var12;
                }

                if (stat != null) {
                    stat.close();
                }
            } catch (Throwable var13) {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Throwable var8) {
                        var13.addSuppressed(var8);
                    }
                }

                throw var13;
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException var14) {
            System.out.println("SelectZvrsti() napaka " + var14);
        }

        return zvrsti;
    }

    public static ArrayList<String> ClaniIzpis() {
        ArrayList<String> casi = new ArrayList();
        String comm = "SELECT id, ime, priimek FROM muzikanti WHERE skupina_id IS null;";

        try {
            Connection con = connect();

            try {
                Statement stat = con.createStatement();

                try {
                    ResultSet rez = stat.executeQuery(comm);

                    try {
                        while(rez.next()) {
                            String m = rez.getString(2);
                            m = m + " ";
                            m = m + rez.getString(3);
                            casi.add(m);
                        }
                    } catch (Throwable var11) {
                        if (rez != null) {
                            try {
                                rez.close();
                            } catch (Throwable var10) {
                                var11.addSuppressed(var10);
                            }
                        }

                        throw var11;
                    }

                    if (rez != null) {
                        rez.close();
                    }
                } catch (Throwable var12) {
                    if (stat != null) {
                        try {
                            stat.close();
                        } catch (Throwable var9) {
                            var12.addSuppressed(var9);
                        }
                    }

                    throw var12;
                }

                if (stat != null) {
                    stat.close();
                }
            } catch (Throwable var13) {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Throwable var8) {
                        var13.addSuppressed(var8);
                    }
                }

                throw var13;
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException var14) {
            System.out.println("SelectZvrsti() napaka " + var14);
        }

        return casi;
    }

    public static void InsertSkupina(String imee, String opiss, int krajj_id, int zvrstt_id) {
        try {
            Connection con = connect();

            try {
                Statement stat = con.createStatement();

                try {
                    stat.executeUpdate("INSERT INTO skupine(ime, opis,kraj_id,zvrst_id) VALUES('" + imee + "','" + opiss + "'," + krajj_id + ", " + zvrstt_id + ");");
                } catch (Throwable var10) {
                    if (stat != null) {
                        try {
                            stat.close();
                        } catch (Throwable var9) {
                            var10.addSuppressed(var9);
                        }
                    }

                    throw var10;
                }

                if (stat != null) {
                    stat.close();
                }
            } catch (Throwable var11) {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Throwable var8) {
                        var11.addSuppressed(var8);
                    }
                }

                throw var11;
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException var12) {
            System.out.println("InsertOglas " + var12);
        }

    }

    public static int IDkraja(String imee) {
        String comm = "SELECT id FROM kraji WHERE ime = '" + imee + "';";
        int idd = 0;

        try {
            Connection con = connect();

            try {
                Statement stat = con.createStatement();

                try {
                    ResultSet rez = stat.executeQuery(comm);

                    try {
                        while(rez.next()) {
                            idd = rez.getInt(1);
                        }
                    } catch (Throwable var11) {
                        if (rez != null) {
                            try {
                                rez.close();
                            } catch (Throwable var10) {
                                var11.addSuppressed(var10);
                            }
                        }

                        throw var11;
                    }

                    if (rez != null) {
                        rez.close();
                    }
                } catch (Throwable var12) {
                    if (stat != null) {
                        try {
                            stat.close();
                        } catch (Throwable var9) {
                            var12.addSuppressed(var9);
                        }
                    }

                    throw var12;
                }

                if (stat != null) {
                    stat.close();
                }
            } catch (Throwable var13) {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Throwable var8) {
                        var13.addSuppressed(var8);
                    }
                }

                throw var13;
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException var14) {
            System.out.println("selectIDkraja() napaka " + var14);
        }

        return idd;
    }

    public static int IDzvrsti(String imee) {
        String comm = "SELECT id FROM zvrsti WHERE ime = '" + imee + "';";
        int idd = 0;

        try {
            Connection con = connect();

            try {
                Statement stat = con.createStatement();

                try {
                    ResultSet rez = stat.executeQuery(comm);

                    try {
                        while(rez.next()) {
                            idd = rez.getInt(1);
                        }
                    } catch (Throwable var11) {
                        if (rez != null) {
                            try {
                                rez.close();
                            } catch (Throwable var10) {
                                var11.addSuppressed(var10);
                            }
                        }

                        throw var11;
                    }

                    if (rez != null) {
                        rez.close();
                    }
                } catch (Throwable var12) {
                    if (stat != null) {
                        try {
                            stat.close();
                        } catch (Throwable var9) {
                            var12.addSuppressed(var9);
                        }
                    }

                    throw var12;
                }

                if (stat != null) {
                    stat.close();
                }
            } catch (Throwable var13) {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Throwable var8) {
                        var13.addSuppressed(var8);
                    }
                }

                throw var13;
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException var14) {
            System.out.println("selectIDzvrsti() napaka " + var14);
        }

        return idd;
    }

    public static void insertMuzikant(String imee, String priimek, String maill, String gesloo, String krajj) {
        System.out.println("SelectKraji() napaka " + krajj);

        try {
            Connection con = connect();

            try {
                Statement stat = con.createStatement();

                try {
                    stat.executeUpdate("INSERT INTO muzikanti(ime, priimek,mail,geslo,kraj_id) VALUES('" + imee + "','" + priimek + "','" + maill + "','" + gesloo + "',(SELECT id FROM kraji WHERE LOWER(ime) = LOWER('" + krajj + "')))");
                } catch (Throwable var11) {
                    if (stat != null) {
                        try {
                            stat.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }
                    }

                    throw var11;
                }

                if (stat != null) {
                    stat.close();
                }
            } catch (Throwable var12) {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }
                }

                throw var12;
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException var13) {
            System.out.println("InsertOglas " + var13);
        }

    }
    public static void InsertUporabnikSkupina(String imee,String priimekk,  int id_skup)
    {
        try (Connection con = connect();
             Statement stat = con.createStatement())
        {
            stat.executeUpdate("UPDATE muzikanti SET skupina_id = '"+id_skup+"',adminu = 0 WHERE ime = '"+imee+"' AND priimek = '"+priimekk+"' ");
        }
        catch (SQLException e) {

            System.out.println("InsertZnamka napaka " + e );
        }
    }
    public static void InsertUporabnikSkupinaadmin(String imee,String priimekk,  int id_skup,int idu)
    {
        try (Connection con = connect();
             Statement stat = con.createStatement())
        {
            stat.executeUpdate("UPDATE muzikanti SET skupina_id = "+id_skup+",adminu = 1 WHERE id="+idu+"");
            System.out.println();
        }
        catch (SQLException e) {

            System.out.println("InsertZnamka napaka " + e );
        }
    }

    public static int IDskupine(String imee)
    {
        int id_skup = 0;
        String comm = "SELECT id FROM skupine WHERE ime = '"+ imee +"';";


        try (Connection con = connect();
             Statement stat = con.createStatement();
             ResultSet rez = stat.executeQuery(comm)) {

            while (rez.next()) {
                id_skup = rez.getInt(1);

            }

        } catch (SQLException e) {

            System.out.println("Selectskupine() napaka " + e);
        }
        return id_skup;
    }
    public static int IDmuzikanta(String mail,String geslo)
    {
        int id_muzikanta = 0;
        String comm = "SELECT id FROM muzikanti WHERE mail = '"+ mail +"'AND geslo = '"+ geslo +"' ;";


        try (Connection con = connect();
             Statement stat = con.createStatement();
             ResultSet rez = stat.executeQuery(comm)) {

            while (rez.next()) {
                id_muzikanta = rez.getInt(1);

            }

        } catch (SQLException e) {

            System.out.println("Selectskupine() napaka " + e);
        }
        return id_muzikanta;
    }
    public static ArrayList<String> clanibrezskupine()
    {
        ArrayList<String> casi = new ArrayList<>();
        String comm = "SELECT id, ime FROM skupine;";
        String cas;

        try (Connection con = connect();
             Statement stat = con.createStatement();
             ResultSet rez = stat.executeQuery(comm)) {

            while (rez.next()) {
                String m = rez.getString(1);
                casi.add(m);
            }

        } catch (SQLException e) {

            System.out.println("Selectskupine() napaka " + e);
        }
        return casi;
    }
    public static int IDmuzikantanull(int idu)
    {
        int id_muzikanta = 0;
        String comm = "SELECT id FROM muzikanti WHERE id = '"+ idu +"'AND skupina_id IS null ;";


        try (Connection con = connect();
             Statement stat = con.createStatement();
             ResultSet rez = stat.executeQuery(comm)) {

            while (rez.next()) {
                id_muzikanta = rez.getInt(1);

            }

        } catch (SQLException e) {

            System.out.println("Selectskupine() napaka " + e);
        }
        return id_muzikanta;
    }
    public static int IDmuzikantanulladmin(int idu)
    {
        int id_muzikanta = 0;
        String comm = "SELECT id FROM muzikanti WHERE id = '"+ idu +"'AND skupina_id IS not null AND adminu=1 ;";


        try (Connection con = connect();
             Statement stat = con.createStatement();
             ResultSet rez = stat.executeQuery(comm)) {

            while (rez.next()) {
                id_muzikanta = rez.getInt(1);

            }

        } catch (SQLException e) {

            System.out.println("Selectskupine() napaka " + e);
        }
        return id_muzikanta;
    }
    public static ArrayList<String> IzpisOglasov()
    {
        ArrayList<String> casi = new ArrayList<>();
        String comm = "SELECT id, ime FROM oglasi;";
        String cas;

        try (Connection con = connect();
             Statement stat = con.createStatement();
             ResultSet rez = stat.executeQuery(comm)) {

            while (rez.next()) {
                String m = rez.getString(2);
                m += " ";
                m += rez.getInt(1);
                casi.add(m);
            }

        } catch (SQLException e) {

            System.out.println("Selectskupine() napaka " + e);
        }
        return casi;
    }
    public static String opisSkupine(String imee)
    {
        String skupine = "";
        String comm = "SELECT opis FROM oglasi WHERE ime = '"+ imee +"';";


        try (Connection con = connect();
             Statement stat = con.createStatement();
             ResultSet rez = stat.executeQuery(comm)) {

            while (rez.next()) {
                skupine = rez.getString(1);

            }

        } catch (SQLException e) {

            System.out.println("Selectskupine() napaka " + e);
        }
        return skupine;
    }public static int IDmuzikantanullskupine(int idu)
    {
        int id_muzikanta = 0;
        String comm = "SELECT id FROM muzikanti WHERE id = '"+ idu +"'AND skupina_id IS not null ;";


        try (Connection con = connect();
             Statement stat = con.createStatement();
             ResultSet rez = stat.executeQuery(comm)) {

            while (rez.next()) {
                id_muzikanta = rez.getInt(1);

            }

        } catch (SQLException e) {

            System.out.println("Selectskupine() napaka " + e);
        }
        return id_muzikanta;
    }
    public static void stclanov( int stclanov,int ids)
    {
        try (Connection con = connect();
             Statement stat = con.createStatement())
        {
            stat.executeUpdate("UPDATE skupine SET st_clanov = "+stclanov+" WHERE id="+ids+"");
            System.out.println();
        }
        catch (SQLException e) {

            System.out.println("updatestclanovnapaka napaka " + e );
        }
    }


}
