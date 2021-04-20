import javax.swing.*;

public class registration {


    private JPanel login;
    private JFormattedTextField emailField;
    private JPasswordField passwordField;
    //private JButton prijavaButton;

    public static int id_;
    private JTextField textField1;
    private JPanel registration;
    private JTextField textField3;
    private JTextField textField4;
    private JButton OKButton;
    private JPasswordField passwordField1;

    public registration()
    {
        JFrame frame = new JFrame("Reg");
        frame.setContentPane(registration);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 250);
        frame.setVisible(true);

        setActionListeners();


    }

   private void setActionListeners()
    {
        OKButton.addActionListener(e -> { new HomePage();
        });

    }

}


