import javax.swing.*;

public class UstvariSkupino {
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox KrajCombo;
    private JComboBox zvrstCombo;
    private JComboBox claniCombo;
    private JButton dodajButton;
    private JPanel ustvariSkupino;

    public UstvariSkupino()
    {
        JFrame frame = new JFrame("Ustvari skupino");
        frame.setContentPane(ustvariSkupino);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 300);
        frame.setVisible(true);

        setActionListeners();


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


    private void setActionListeners()
    {
        dodajButton.addActionListener(e -> {

            String ime = KrajCombo.getSelectedItem().toString();





        });

    }





}
