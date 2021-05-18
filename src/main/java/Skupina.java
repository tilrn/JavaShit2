import javax.swing.*;

public class Skupina {
    private JLabel oskupini;

    private JLabel lol;
    private JComboBox comboBox1;
    public int Ids=0;


    public Skupina(int ids)
    {
        Ids=ids;
        JFrame frame = new JFrame("Login");
        frame.setContentPane(oskupini);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);

        lol();



    }
    public void lol(){
        DefaultComboBoxModel mod3 = new DefaultComboBoxModel();
        mod3.addAll(Baza.izpisclanovvskupini(Ids));
        comboBox1.setModel(mod3);
    }
}

