import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UstvariSkupino {
    String fileName = "";
    boolean fileIfDelete;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox KrajCombo;
    private JComboBox zvrstCombo;
    private JComboBox claniCombo;
    private JButton dodajButton;
    private JPanel ustvariSkupino;
    private JLabel clan1;
    private JLabel clan2;
    private JLabel clan3;
    private JLabel clan4;
    private JLabel clan5;
    private JButton ustvariSkupinoButton;
    private JLabel clan_label;
    private JButton Delete1;
    private JButton Delete2;
    private JButton Delete3;
    private JButton Delete4;
    private JButton Delete5;
    private JButton Delete6;
    private JButton koncaj;
    private JButton DeleteClani;
    private JLabel adminlabel;
    private JButton vstaviSlikoButton;

    public int idu;


    public UstvariSkupino(int iduporabnika)
    {
        idu=iduporabnika;
        System.out.println(idu);
        JFrame frame = new JFrame("Ustvari skupino");
        frame.setContentPane(ustvariSkupino);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);

        setActionListeners();
        claniCombo.setVisible(false);
        clan_label.setVisible(false);
        dodajButton.setVisible(false);
        clan1.setVisible(false);
        clan2.setVisible(false);
        clan3.setVisible(false);
        clan4.setVisible(false);
        clan5.setVisible(false);
        DeleteClani.setVisible(false);
        koncaj.setVisible(false);
        adminlabel.setVisible(false);

        

        DefaultComboBoxModel mod = new DefaultComboBoxModel();
        mod.addAll(Baza.SelectKraji());
        KrajCombo.setModel(mod);

        DefaultComboBoxModel mod2 = new DefaultComboBoxModel();
        mod2.addAll(Baza.ZvrstiIzpis());
        zvrstCombo.setModel(mod2);

        DefaultComboBoxModel mod3 = new DefaultComboBoxModel();
        mod3.addAll(Baza.ClaniIzpis());
        claniCombo.setModel(mod3);




    }
    public void zakluci(){
        new HomePage(idu);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ustvariSkupino);
        frame.dispose();
    }
    public int i = 0;
    public String ime;
    private void setActionListeners() {


        vstaviSlikoButton.addActionListener(e -> {
            //Shranjevanje slike
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "JPG, jpeg, and PNG Images", "jpg", "png", "jpeg");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(ustvariSkupino);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                System.out.println("You chose to open this file: "
                        + file.getName());
                BufferedImage image;
                try {
                    image = ImageIO.read(file);
                    ImageIO.write(image, "jpg",new File("src\\img\\" + file.getName()));
                    ImageIO.write(image, "jpeg",new File("src\\img\\" + file.getName()));
                    ImageIO.write(image, "png",new File("src\\img\\" + file.getName()));
                    fileName = file.getName();
                    fileIfDelete = true;
                } catch (IOException ex) {
                    Logger.getLogger(UstvariSkupino.class.getName()).log(Level.SEVERE, null, ex);

                    //izpis errorja ce ne zberes slike
                    JOptionPane.showMessageDialog(ustvariSkupino,
                            "Niste izbrali slike!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        ustvariSkupinoButton.addActionListener(e -> {

            ime = textField1.getText();
            String ops = textField2.getText();
            String ime_kraja = KrajCombo.getSelectedItem().toString();
            String zvrst = zvrstCombo.getSelectedItem().toString();
            int id_kraja = Baza.IDkraja(ime_kraja);
            int id_zvrsti = Baza.IDzvrsti(zvrst);
            Baza.InsertSkupina(ime, ops, id_kraja, id_zvrsti);
            claniCombo.setVisible(true);
            clan_label.setVisible(true);
            dodajButton.setVisible(true);
            clan1.setVisible(true);
            clan2.setVisible(true);
            clan3.setVisible(true);
            clan4.setVisible(true);
            clan5.setVisible(true);
            DeleteClani.setVisible(true);
            koncaj.setVisible(true);
            adminlabel.setVisible(true);

            textField1.disable();
            textField2.disable();
            KrajCombo.disable();
            zvrstCombo.disable();
            ustvariSkupinoButton.setVisible(false);

        });
        koncaj.addActionListener(e -> {
            int st_clanov = 0;
            int ID_skupine = Baza.IDskupine(ime);
            System.out.println(ID_skupine);
            if (clan1.getText() != "-----") {

                String str = clan1.getText();
                String[] random = str.split(" ", 5);
                String ime = random[0];
                String priimek = random[1];
                System.out.println(ime);
                System.out.println(priimek);
                Baza.InsertUporabnikSkupinaadmin(ime, priimek, ID_skupine, idu);
                st_clanov++;
            }
            if (clan2.getText() != "-----") {
                String str = clan2.getText();
                String[] random = str.split(" ", 5);
                String ime = random[0];
                String priimek = random[1];
                Baza.InsertUporabnikSkupina(ime, priimek, ID_skupine);
                st_clanov++;

            }
            if (clan3.getText() != "-----") {
                String str = clan3.getText();
                String[] random = str.split(" ", 5);
                String ime = random[0];
                String priimek = random[1];
                Baza.InsertUporabnikSkupina(ime, priimek, ID_skupine);
                st_clanov++;

            }
            if (clan4.getText() != "-----") {
                String str = clan4.getText();
                String[] random = str.split(" ", 5);
                String ime = random[0];
                String priimek = random[1];
                Baza.InsertUporabnikSkupina(ime, priimek, ID_skupine);
                st_clanov++;

            }
            if (clan5.getText() != "-----") {
                String str = clan5.getText();
                String[] random = str.split(" ", 5);
                String ime = random[0];
                String priimek = random[1];
                Baza.InsertUporabnikSkupina(ime, priimek, ID_skupine);
                st_clanov++;
            }
            //System.out.println(st_clanov);
            int lol = Baza.IDskupine(ime);
            Baza.stclanov(st_clanov, lol);
            zakluci();

        });
        dodajButton.addActionListener(e -> {

            if (i == 0) {
                String clan = claniCombo.getSelectedItem().toString();
                clan1.setText(clan);
                claniCombo.setSelectedIndex(-1);
                claniCombo.removeItem(clan);


            }
            if (i == 1) {
                String clan1 = claniCombo.getSelectedItem().toString();
                clan2.setText(clan1);

                claniCombo.setSelectedIndex(-1);
                claniCombo.removeItem(clan1);
            }
            if (i == 2) {
                String clan1 = claniCombo.getSelectedItem().toString();
                clan3.setText(clan1);

                claniCombo.setSelectedIndex(-1);
                claniCombo.removeItem(clan1);
            }
            if (i == 3) {
                String clan1 = claniCombo.getSelectedItem().toString();
                clan4.setText(clan1);

                claniCombo.setSelectedIndex(-1);
                claniCombo.removeItem(clan1);
            }
            if (i == 4) {
                String clan1 = claniCombo.getSelectedItem().toString();
                clan5.setText(clan1);

                claniCombo.setSelectedIndex(-1);
                claniCombo.removeItem(clan1);
            }
            i++;
        });

        DeleteClani.addActionListener(e -> {
            clan1.setText("-----");
            clan2.setText("-----");
            clan3.setText("-----");
            clan4.setText("-----");
            clan5.setText("-----");
            DefaultComboBoxModel mod3 = new DefaultComboBoxModel();
            mod3.addAll(Baza.ClaniIzpis());
            claniCombo.setModel(mod3);
            i = 0;

        });

    }
}













