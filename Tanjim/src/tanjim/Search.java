package tanjim;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Search extends JFrame {

    private ArrayList<Loanee> loanees = new ArrayList<>();
    private Container c;
    private JLabel title, name;
    private JTextField tname;
    private JTextArea output;
    private Font t, w;
    private ImageIcon icon;
    private JButton sea;
    private Cursor cur;
    private JScrollPane scroll;
    private String username;

    
   

    Search(String username) {
                
        this.username = username;
 

        initComponents();
    }

    public void initComponents() {

        this.setResizable(false);
        this.setBounds(0, 0, 1213, 884);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Managing Loanee's Details");
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        t = new Font("Arial", Font.BOLD, 40);
        w = new Font("Arial", Font.BOLD, 30);

        title = new JLabel("Search For Individual Loanee's Information");
        title.setBounds(10, 15, 1000, 100);
        title.setForeground(Color.GREEN);
        title.setFont(t);
        c.add(title);

        name = new JLabel("Enter Loanee's Name");
        name.setBounds(50, 140, 400, 50);
        name.setForeground(Color.WHITE);
        name.setFont(w);
        c.add(name);

        tname = new JTextField();
        tname.setBounds(50, 210, 300, 50);
        tname.setFont(w);
        tname.setForeground(Color.BLACK);
        tname.setToolTipText("Type Name As Saved Before");
        c.add(tname);

        output = new JTextArea();

        output.setFont(w);
        output.setForeground(Color.BLACK);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);

        c.add(output);

        scroll = new JScrollPane(output);
        scroll.setBounds(520, 180, 500, 500);
        c.add(scroll);

        cur = new Cursor(Cursor.HAND_CURSOR);

        sea = new JButton("Search");
        sea.setBounds(122, 322, 150, 70);
        sea.setForeground(Color.GREEN);
        sea.setBackground(Color.BLACK);
        sea.setFont(w);
        sea.setCursor(cur);
        c.add(sea);
        sea.addActionListener((ActionEvent ae) -> {
            Loanee target = null;
            String name1 = tname.getText();
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("Information.dat");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            }
            ObjectInputStream ois;
            try {
                ois = new ObjectInputStream(fis);
                loanees = (ArrayList<Loanee>) ois.readObject();
                String printLoanee = "";
                boolean exist = false;
                for (Loanee lll : loanees) {
                    if (name1.equals(lll.getName())) {
                        exist = true;
                        target = lll;
                        JOptionPane.showMessageDialog(null, "Name Found");
                        printLoanee = ("Type Of Loan: " + lll.gettOloan() + "\n"
                                + "Name: " + lll.getName() + "\n"
                                + "Age: " + lll.getAge() + "\n"
                                + "Gender: " + lll.getGender() + "\n"
                                + "Occupation: " + lll.getOccupation() + "\n"
                                + "Contact: " + lll.getPhone() + "\n"
                                + "Loan Amount:" + lll.getAmount() + "\n"
                                + "Interest: " + lll.getRate() + "%\n"
                                + "Time: " + lll.getTime() + " year" + "\n"
                                + "Registered Time:" + lll.getRegisteredOn() + "\n");
                        output.setText(printLoanee);
                    }
                }
                if (!exist) {

                    JOptionPane.showMessageDialog(null, "Name Not Found");
                }
            } catch (IOException ex) {
                ex.printStackTrace();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }


}
