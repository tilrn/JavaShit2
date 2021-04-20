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


public class groups {
    private JTextField textField1;
    private JTextField textField2;
    private JButton dodajOglas;
    private JPanel content;
    private JLabel naslov;
    private JLabel opis;
    private JLabel adsa;


    public groups()
    {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 150);
        frame.setVisible(true);

        setActionListeners();


    }


    private void setActionListeners()
    {

        dodajOglas.addActionListener(e -> {
            String ime = textField1.getText();
            String opis = textField2.getText();

            Baza.InsertOglas(ime, opis);


        });
    }
}
