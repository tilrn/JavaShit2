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
    private JList list1;
    private JPanel HomePage;
    private JButton pridruziSkupiniButton;
    private JButton ustvariSkupinoButton;
    public int idu=0;

    public HomePage(int idmuzikanta)
    {
        idu=idmuzikanta;
        System.out.println(idu);
        JFrame frame = new JFrame("Login");
        frame.setContentPane(HomePage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 750);
        frame.setVisible(true);
        ustvariSkupinoButton.setVisible(false);
        narediOglasButton.setVisible(false);
        //pridruziSkupiniButton.setVisible(false);
        setActionListeners();
        int i=Baza.IDmuzikantanull(idu);
        if(i>0){
            ustvariSkupinoButton.setVisible(true);



        }
        else{
            int id=Baza.IDmuzikantanulladmin(idu);
            System.out.println(id);
            if(id>0){
                narediOglasButton.setVisible(true);
            }
            else {

            }

        }


    }
    private void setActionListeners()
    {
        ustvariSkupinoButton.addActionListener(e -> {
            new UstvariSkupino(idu);
        });
    }
}