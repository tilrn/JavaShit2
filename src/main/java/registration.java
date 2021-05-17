import javax.swing.*;

public class registration {


    private JPanel login;
    private JFormattedTextField emailField;
    private JPasswordField passwordField;
    //private JButton prijavaButton;

    public static int id_;
    private JPanel registration;
    private JButton OKButton;
    private JComboBox krajbox;
    private JLabel placeLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public registration()
    {
        JFrame frame = new JFrame("Reg");
        frame.setContentPane(registration);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(550, 400);
        frame.setVisible(true);

        setActionListeners();
        Fill_krajcombo();


    }
    public void zakluci(){
        new login();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(registration);
        frame.dispose();
    }
    private void Fill_krajcombo()
    {
        DefaultComboBoxModel mod = new DefaultComboBoxModel();

        mod.addAll(Baza.SelectKraji());
        krajbox.setModel(mod);
    }
   private void setActionListeners()
    {
        OKButton.addActionListener(e -> {
            String name = textField1.getText();
            String surname = textField2.getText();
            String email = textField3.getText();
            String password = textField4.getText();

            String kraj= krajbox.getSelectedItem().toString();
            //System.out.println("SelectKraji() napaka "+kraj);
            Baza.insertMuzikant(name, surname,email,password,kraj);
            zakluci();

        });


    }

}


