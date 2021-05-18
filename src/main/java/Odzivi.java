import javax.swing.*;

public class Odzivi {
    private JPanel odzivi;
    private JButton Potrdi;
    private JButton Zavrni;
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JButton selectbutton;
    int MuzikantID = 0;

    public Odzivi(int muzikantID) {
        MuzikantID = muzikantID;
        JFrame frame = new JFrame("Odzivi");
        frame.setContentPane(odzivi);
        Potrdi.setVisible(false);
        Zavrni.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);


        setActionListeners();
        int id_skupine = Baza.IDskupineZIdMuzikant(MuzikantID);
        int id_oglasa = Baza.IdOglasaZSkupino(id_skupine);
        int id_potrjen = Baza.IdPotrjen(id_oglasa);

        DefaultComboBoxModel mod3 = new DefaultComboBoxModel();
        mod3.addAll(Baza.izpispodrditev(MuzikantID));
        comboBox1.setModel(mod3);

    }
    public void nigger(){
        DefaultComboBoxModel mod3 = new DefaultComboBoxModel();
        mod3.addAll(Baza.izpispodrditev(MuzikantID));
        comboBox1.setModel(mod3);
    }
    private void setActionListeners(){

        Potrdi.addActionListener(e ->{
            String ime=comboBox1.getSelectedItem().toString();
            Baza.Potrdi(ime);
            int id_skupine = Baza.IDskupineZIdMuzikant(MuzikantID);
            Baza.dodajvskupino(id_skupine,ime);
            nigger();


        });
        Zavrni.addActionListener(e ->{
            String ime=comboBox1.getSelectedItem().toString();
            Baza.Zavrni(ime);
            nigger();
        });
        selectbutton.addActionListener(e -> {
            String ime=comboBox1.getSelectedItem().toString();

            textArea1.setText(Baza.opisclana(ime));
            Potrdi.setVisible(true);
            Zavrni.setVisible(true);
        }
    );



    };
    public void zakluci(){
        new HomePage(MuzikantID);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(odzivi);
        frame.dispose();
    }
}
