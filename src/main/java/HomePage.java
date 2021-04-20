import javax.swing.*;

public class HomePage {
    private JButton createGroupButton;
    private JList list1;
    private JPanel HomePage;

    public HomePage()
    {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(HomePage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 750);
        frame.setVisible(true);

        //setActionListeners();


    }
}