import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.Renderer;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class HomePage{
    private JButton narediOglasButton;
    private JList lista;
    private JPanel HomePage;
    private JButton pridruziSkupiniButton;
    private JButton ustvariSkupinoButton;
    private JLabel oglaslabel;
    private JButton uredioglas;
    private JButton odziviButton;
    private JButton osveziButton;
    public int idu=0;

    public HomePage(int idmuzikanta)
    {
        idu=idmuzikanta;
        System.out.println(idu);
        oglaslabel.setSize(500, 400);
        JFrame frame = new JFrame("Login");
        frame.setContentPane(HomePage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 750);
        frame.setVisible(true);
        ustvariSkupinoButton.setVisible(false);
        narediOglasButton.setVisible(false);
        pridruziSkupiniButton.setVisible(false);
        uredioglas.setVisible(false);
        setActionListeners();
        int in=Baza.IDmuzikantanull(idu);
        System.out.println(in);
        if(in>0){
            ustvariSkupinoButton.setVisible(true);
            pridruziSkupiniButton.setVisible(false);
        }
        else{
            int id=Baza.IDmuzikantanulladmin(idu);
            System.out.println(id);
            if(id>0){
                narediOglasButton.setVisible(true);
                uredioglas.setVisible(true);
            }
            else {

            }

        }
        nigger();






    }
    private void setActionListeners()
    {
        ustvariSkupinoButton.addActionListener(e -> {
            new UstvariSkupino(idu);
        });
        lista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);

                String selected = lista.getSelectedValue().toString();
                int idso=Baza.idskupineoglasa(selected);
                System.out.println(selected);

                new SelectedOglas(idu,selected,idso);

            }
        });
        narediOglasButton.addActionListener(e -> {
            int ids=Baza.idskupine(idu);
            System.out.println(ids);
            new Naredioglas(ids);

        });
        uredioglas.addActionListener(e -> {



            int ids=Baza.idskupine(idu);
            new Uredioglas(ids);
        });
        odziviButton.addActionListener(e -> {
            zakluciOdzivi();
        });
        osveziButton.addActionListener(e -> {
            nigger();
        });


    }
    public void zakluciOdzivi(){
        new Odzivi(idu);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(HomePage);
        //frame.dispose();
    }
    public void nigger(){
        ArrayList<String> i = Baza.IzpisOglasov();
        DefaultListModel model = new DefaultListModel();
        for (int st = 0;st<i.size();st++){
            String temp = i.get(st);
            String[] temp2 = temp.split("/", 2);
            String konec = temp2[0];
            System.out.println(konec);
            model.addElement(temp2[0]);


        }
        lista.setModel(model);
    }

}