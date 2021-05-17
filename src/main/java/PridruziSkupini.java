import javax.swing.*;

public class PridruziSkupini {
    private JComboBox comboBox1;
    private JButton pridruzi_se;
    private JPanel pridruzi;
    private JTextPane textPane1;

    int Oglas_id = 0;
    int MuzikantID = 0;
    public PridruziSkupini(int muzikantID,int oglas_id)
    {
        MuzikantID = muzikantID;
        Oglas_id = oglas_id;
        JFrame frame = new JFrame("Login");
        frame.setContentPane(pridruzi);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 150);
        frame.setVisible(true);

        setActionListeners();



    }


    private void setActionListeners()
    {

            pridruzi_se.addActionListener(e -> {

            String opis = textPane1.getText();
            Baza.InsertRequest(MuzikantID,Oglas_id,opis);
            zakluci();






        });

    }
    public void zakluci(){
        new HomePage(MuzikantID);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(pridruzi);
        frame.dispose();
    }




}
