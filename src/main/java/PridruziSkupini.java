import javax.swing.*;

public class PridruziSkupini {
    private JComboBox comboBox1;
    private JButton button1;
    private JPanel pridruzi;
    private JTextPane textPane1;


    public PridruziSkupini()
    {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(pridruzi);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 150);
        frame.setVisible(true);

        setActionListeners();



    }


    private void setActionListeners()
    {

            button1.addActionListener(e -> {
            String ime = comboBox1.getSelectedItem().toString();





        });
    }




}
