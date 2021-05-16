import javax.swing.*;

public class UstvariSkupino {
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
    private JLabel clan6;

    public UstvariSkupino()
    {
        JFrame frame = new JFrame("Ustvari skupino");
        frame.setContentPane(ustvariSkupino);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 300);
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
        ustvariSkupinoButton.addActionListener(e -> {

            String ime = textField1.getText();
            String ops = textField2.getText();
            String ime_kraja = KrajCombo.getSelectedItem().toString();
            String zvrst = zvrstCombo.getSelectedItem().toString();
            int id_kraja = Baza.IDkraja(ime_kraja);
            int id_zvrsti = Baza.IDzvrsti(zvrst);
            Baza.InsertSkupina(ime,ops,id_kraja,id_zvrsti);
            claniCombo.setVisible(true);
            clan_label.setVisible(true);
            dodajButton.setVisible(true);
            clan1.setVisible(true);
            clan2.setVisible(true);
            clan3.setVisible(true);
            clan4.setVisible(true);
            clan5.setVisible(true);
            textField1.disable();
            textField2.disable();
            KrajCombo.disable();
            zvrstCombo.disable();
            ustvariSkupinoButton.setVisible(false);






        });
        Delete1.addActionListener(e -> {


            clan1.setText("-----");





        });
        Delete2.addActionListener(e -> {



            clan2.setText("-----");




        });
        Delete3.addActionListener(e -> {



            clan3.setText("-----");




        });
        Delete4.addActionListener(e -> {



            clan4.setText("-----");




        });
        Delete5.addActionListener(e -> {


            clan5.setText("-----");





        });
        Delete6.addActionListener(e -> {


            clan6.setText("-----");





        });

        koncaj.addActionListener(e -> {


            if(clan1.getText() != "-----"){


            }





        });

    }





}
