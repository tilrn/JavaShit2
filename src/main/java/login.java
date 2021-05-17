import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);

        setActionListeners();


    }
    public static String doHashing (String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(password.getBytes());

            byte[] resultByteArray = messageDigest.digest();

            StringBuilder sb = new StringBuilder();

            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }
    public void zakluci(){
        new HomePage(ID_muzikanta);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(login);
        frame.dispose();
    }

    private void setActionListeners()
    {
        button1.addActionListener(e -> {
            if(Baza.SelectLogin(textField1.getText(),doHashing(textField2.getText()) ) == false)
            {
                textField1.setText("ni pravilno geslo");
            }
            else {
                mail =textField1.getText() ;
                geslo= textField2.getText();
                ID_muzikanta = Baza.IDmuzikanta(mail,doHashing(geslo));
                System.out.println(ID_muzikanta);
                zakluci();
            };
        });
    }


}

