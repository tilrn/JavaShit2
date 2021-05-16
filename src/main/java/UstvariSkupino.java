import javax.swing.*;

public class UstvariSkupino {
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox KrajCombo;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton dodajButton;
    private JPanel ustvariSkupino;

    public UstvariSkupino()
    {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(ustvariSkupino);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 150);
        frame.setVisible(true);

        setActionListeners();


        DefaultComboBoxModel mod = new DefaultComboBoxModel();
        mod.addAll(Baza.SelectKraji());
        KrajCombo.setModel(mod);

        DefaultComboBoxModel mod2 = new DefaultComboBoxModel();
        mod.addAll(Baza.ZvrstiIzpis());
        KrajCombo.setModel(mod2);



    }


    private void setActionListeners()
    {


    }





}
