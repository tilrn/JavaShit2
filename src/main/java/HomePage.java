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
    private JButton ustvariSkupinoButton;






    public HomePage()
    {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(HomePage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 750);
        frame.setVisible(true);

        setActionListeners();




        ArrayList<String> i = Baza.IzpisOglasov();
        DefaultListModel model = new DefaultListModel();


        for (int st = 0;st<i.size();st++){
            String temp = i.get(st);
            String[] temp2 = temp.split(" ", 2);
            String konec = temp2[0];
            System.out.println(konec);
            model.addElement(temp2[0]);


        }
        lista.setModel(model);


    }
    private void setActionListeners()
    {
        ustvariSkupinoButton.addActionListener(e -> {
            new UstvariSkupino();
        });
        lista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String selected = lista.getSelectedValue().toString();
                System.out.println(selected);
                new SelectedOglas(selected);

            }
        });
    }

}