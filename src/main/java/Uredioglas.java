import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Uredioglas {
    private JComboBox comboBox1;
    private JTextField textField1;
    private JPanel uredioglas;
    private JTextArea textArea1;
    private JLabel imelabel;
    private JLabel opislabel;
    private JButton uredibutton;
    private JButton deleteButton;
    private JButton updateButton;
    public int Ids;
    public Uredioglas(int ids)
    {

        Ids=ids;
        DefaultComboBoxModel mod = new DefaultComboBoxModel();
        mod.addAll(Baza.IzpisOglasovskupine(Ids));
        comboBox1.setModel(mod);
        JFrame frame = new JFrame("Oglas :");
        frame.setContentPane(uredioglas);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
        System.out.println(ids);
        textField1.setVisible(false);
        textArea1.setVisible(false);
        imelabel.setVisible(false);
        opislabel.setVisible(false);
        updateButton.setVisible(false);
        deleteButton.setVisible(false);
        setActionListeners();
    }
    private void setActionListeners(){
        uredibutton.addActionListener(e -> {
            comboBox1.disable();
            uredibutton.disable();
            textField1.setVisible(true);
            textArea1.setVisible(true);
            imelabel.setVisible(true);
            opislabel.setVisible(true);
            updateButton.setVisible(true);
            deleteButton.setVisible(true);
            int ido=Baza.idoglasa(comboBox1.getSelectedItem().toString());
            System.out.println(comboBox1.getSelectedItem().toString());
            System.out.println(ido);
            String ime = Baza.imeoglasa(ido);
            textField1.setText(ime);
        });
    };
}
