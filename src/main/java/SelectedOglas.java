import javax.swing.*;

public class SelectedOglas {
    private JButton SendInvite;
    private JPanel selectoglas;
    private JLabel ime_oglasa;
    private JLabel opis_oglasa;
    private JLabel skupinaime;
    public int Idso=0;

    public SelectedOglas(String ime,int idso)
    {
        Idso=idso;
        System.out.println(Idso);
        JFrame frame = new JFrame("Oglas : "+ime+"");
        frame.setContentPane(selectoglas);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
        String imes=Baza.imeskupine(idso);
        setActionListeners();
        skupinaime.setText("Oglas skupine: "+ imes);

    String opis = Baza.opisSkupine(ime);
    ime_oglasa.setText(ime);
    opis_oglasa.setText(opis);

    }




    private void setActionListeners(){


        SendInvite.addActionListener(e -> {
        new PridruziSkupini();

        });


    };



}
