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
    public void zakluciLog(){
        new login();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(mainp);
        frame.dispose();
    }
    public void zakluciReg(){
        new registration();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(mainp);
        frame.dispose();
    }

    private void setActionListeners()
    {

        button1.addActionListener(e -> { zakluciReg();});

        button2.addActionListener(e -> { zakluciLog();});
    }
}
