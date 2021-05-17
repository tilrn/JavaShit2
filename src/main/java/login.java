import javax.swing.*;

public class login {

    private JPanel login;
    private JFormattedTextField emailField;
    private JPasswordField passwordField;
    private JButton prijavaButton;
    public String mail;
    public String geslo;
    public int ID_muzikanta;
    public static int id_;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;

    public login()
    {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(login);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);

        setActionListeners();


    }
    public void zakluci(){
        new HomePage(ID_muzikanta);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(login);
        frame.dispose();
    }

    private void setActionListeners()
    {
        button1.addActionListener(e -> {
            if(Baza.SelectLogin(textField1.getText(),textField2.getText()) == false)
            {
                textField1.setText("ni pravilno geslo");
            }
            else {
                mail =textField1.getText() ;
                geslo= textField2.getText();
                ID_muzikanta = Baza.IDmuzikanta(mail,geslo);
                System.out.println(ID_muzikanta);
                zakluci();
            };
        });
    }


}

