import javax.swing.*;
import java.util.ArrayList;

public class PridruziSkupini {
    private JComboBox comboBox1;
    private JButton button1;
    private JPanel pridruzi;


    public PridruziSkupini()
    {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(pridruzi);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 150);
        frame.setVisible(true);

        setActionListeners();

       //ArrayList<String> lol = new ArrayList<String>();
        DefaultComboBoxModel mod = new DefaultComboBoxModel();
        //lol = Baza.SkupineIzpis();
       // lol.forEach((s) -> comboBox1.addItem(s));
        mod.addAll(Baza.SkupineIzpis());
        comboBox1.setModel(mod);

    }


    private void setActionListeners()
    {

            button1.addActionListener(e -> {
            String ime = comboBox1.getSelectedItem().toString();





        });
    }




}
