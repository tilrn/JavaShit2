                                                PROJEKT JAVA
                                            Mentor: Islam Mušič
                                            
                                            
Opis aplikacije:
  Aplikacija omogoča uporabniku, po vsej vrjetnosti glasbeniku iskanje skupine. Kot tudi glasbeniku, kateri želi ustvariti skupino in začeti proizvajati glasbo
  Aplikacija deluje na podlagi baze, katera je objavljena na spletnem strežniku Heroku. Uporabnik (če se nima skupine) lahko kikne na oglas, katerega je objavila
  neka skupina in skupini pošlje prošnjo za pridružitev z opisom, to pomeni zakaj je on tisti ki ga iščejo. Vodja skupine lahko pa tega uporabnika potrdi
  ali pa zavrne. Vodja skupine lahko tudi oglase briše in jih oreja, kot tudi naredi več kot le enega. To pomeni če glasbenik išče trobentaša in pevca lahko tako ustvari 
  2 različna oglasa. Aplikacija ima tudi login in register, z kodiranimi gesli.
  
  
                                            SQL Stavki, katere sva uporabila v aplikaciji:
                                            
                                           
                                           
// povezava z bazo na heroku

 public static Connection connect() {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:postgresql://ec2-176-34-222-188.eu-west-1.compute.amazonaws.com:5432/d6mgn1man4juqu", "epebibyjgvxunf", "93ec9324d483d5ed6ade4fee633490dd665c1d710943c76dbd59a7ece3df6432");
        } catch (SQLException var2) {
            System.out.println("povezava z bazo ni uspela");
        }

        return con;
    }
    
    
    //izpis vseh krajov v bazi
    
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
    
    //funkcija 1 katera izpiše število vseh muzikantov v bazi
    CREATE FUNCTION Prestej()
    RETRUN integer AS
    $$
    DECLARE st integer;
    BEGIN 
    st:= 0;
    FOR counter IN SELECT id FROM muzikanti
    LOOP
    st:= st +1;
    END LOOP;
    RETURN st;
    END;
    $$LANGUAGE 'plpgsql';
    
    
    //funkcija, katera izpiše koliko muzikantov ima id večji od 10;
    CREATE FUNCTION Prestej()
    RETRUN integer AS
    $$
    DECLARE 
    st integer;
    counter integer;
    postna varchar = '3320';
    
    BEGIN 
    st:= 0;
    FOR counter IN SELECT id FROM muzikanti
    LOOP
    IF(counter < 10) THEN
    st:= st +1;
    END IF;    
    RETURN st;
    END;
    $$LANGUAGE 'plpgsql';
    
    
    // trigger 1
    
    CREATE TRIGGER dodaj
    BEFORE INSERT OR UPDATE
    ON oglasi FOR EACH ROW
    EXECUTE PROCEDURE Prestej();
    
    //trigger 2
    
    CREATE TRIGGER dodaj
    BEFORE DELETE
    ON oglasi FOR EACH ROW
    EXECUTE PROCEDURE DeleteOglas();
    
    // izpis opis skupine, ob prijemu imena skupine
    
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
    }
    
    
    
    
