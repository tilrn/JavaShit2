import javax.swing.*;

public class Odzivi {
    private JTextArea textArea1;
    private JButton Potrdi;
    private JButton Zavrni;
    private JPanel odzivi;
    int MuzikantID = 0;
    public Odzivi(int muzikantID)
    {
        MuzikantID = muzikantID;
        JFrame frame = new JFrame("Odzivi");
        frame.setContentPane(odzivi);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);

        setActionListeners();



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
