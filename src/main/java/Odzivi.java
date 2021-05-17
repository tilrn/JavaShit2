import javax.swing.*;

public class Odzivi {
    private JTextArea textArea1;
    private JPanel odzivi;
    private JButton Potrdi;
    private JButton Zavrni;
    int MuzikantID = 0;

    public Odzivi(int muzikantID) {
        MuzikantID = muzikantID;
        JFrame frame = new JFrame("Odzivi");
        frame.setContentPane(odzivi);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);

        setActionListeners();
        int id_skupine = Baza.IDskupineZIdMuzikant(MuzikantID);
        int id_oglasa = Baza.IdOglasaZSkupino(id_skupine);
        int id_potrjen = Baza.IdPotrjen(id_oglasa);
    }
    private void setActionListeners(){

        Potrdi.addActionListener(e ->{



        });
        Zavrni.addActionListener(e ->{



        });



    };
    public void zakluci(){
        new HomePage(MuzikantID);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(odzivi);
        frame.dispose();
    }
}
