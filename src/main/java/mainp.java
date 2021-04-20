import javax.swing.*;

public class mainp {
    private JButton button2;
    private JButton button1;
    private JPanel mainp;


    public mainp() {
        JFrame frame = new JFrame("main");
        frame.setContentPane(mainp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 150);
        frame.setVisible(true);

        setActionListeners();


    }

    private void setActionListeners()
    {

        button1.addActionListener(e -> { new registration();});

        button2.addActionListener(e -> { new login();});
    }
}
