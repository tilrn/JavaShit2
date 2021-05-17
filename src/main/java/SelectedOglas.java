import javax.swing.*;

public class SelectedOglas {
    private JButton SendInvite;
    private JPanel selectoglas;
    private JLabel ime_oglasa;
    private JLabel opis_oglasa;

    String imee  = "";
    int MuzikantID = 0;
    public SelectedOglas(int muzikantID,String ime)
    {
        MuzikantID = muzikantID;
        imee = ime;
        JFrame frame = new JFrame("Oglas : "+ime+"");
        frame.setContentPane(selectoglas);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);

        setActionListeners();

    String opis = Baza.opisSkupine(ime);
    ime_oglasa.setText(ime);
    opis_oglasa.setText(opis);

    }


    int id_oglasa = 0;

    private void setActionListeners(){

        id_oglasa = Baza.IDOglasa(imee);
        SendInvite.addActionListener(e -> {

        zakluci();
        });


    };
    public void zakluci(){
        new PridruziSkupini(MuzikantID,id_oglasa);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(selectoglas);
        frame.dispose();
    }



}
