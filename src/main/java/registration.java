import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(550, 400);
        frame.setVisible(true);

        setActionListeners();
        Fill_krajcombo();


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
            Baza.insertMuzikant(name, surname,email,doHashing(password),kraj);
            new login();

        });


    }

}


