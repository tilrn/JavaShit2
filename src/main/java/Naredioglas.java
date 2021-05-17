import javax.swing.*;

public class Naredioglas {
    private JTextField textField1;
    private JPanel naredioglas;
    private JTextPane textPane1;
    private JButton dodajButton;
    public int Ids;

    public Naredioglas(int ids)
    {
        Ids=ids;
        JFrame frame = new JFrame("Login");
        frame.setContentPane(naredioglas);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 400);
        frame.setVisible(true);

        setActionListeners();



    }
    private void setActionListeners(){


        dodajButton.addActionListener(e -> {
            String ime=textField1.getText();
            String opis=textPane1.getText();
            System.out.println(ime+opis+Ids);
            Baza.insertoglasi(ime,opis,Ids);
        });


    };
}
