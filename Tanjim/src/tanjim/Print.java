package tanjim;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Print extends JFrame {

    private ArrayList<Loanee> loanees = new ArrayList<>();
    private Container c;
    private ImageIcon icon;
    private JLabel title, name;
    private JTextField tname;
    private Font t, w;
    private JButton print;
    private Cursor cur;
    private String username;



    Print(String username)  {

        this.username = username;
        initComponentes();
  
    }

    public void initComponentes()  {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(0, 0, 1100, 700);
        this.setResizable(false);
        this.setTitle("Managing Loanee's Details");
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        t = new Font("Arial", Font.BOLD, 40);
        w = new Font("Arial", Font.BOLD, 30);

        title = new JLabel("Print EMI History As a PDF");
        title.setBounds(200, 30, 950, 100);
        title.setFont(t);
        title.setForeground(Color.GREEN);
        c.add(title);

        name = new JLabel("Enter Loanee's Name to Print His/Her EMI History");
        name.setBounds(70, 200, 950, 70);
        name.setFont(w);
        name.setForeground(Color.WHITE);
        c.add(name);

        tname = new JTextField();
        tname.setBounds(70, 285, 300, 55);
        tname.setFont(w);
        tname.setToolTipText("Type Name as Saved Before");
        tname.setForeground(Color.BLACK);
        c.add(tname);

        cur = new Cursor(Cursor.HAND_CURSOR);

        print = new JButton("Print");
        print.setBounds(135, 390, 150, 50);
        print.setFont(w);
        print.setForeground(Color.BLUE);
        print.setBackground(Color.BLACK);
        print.setCursor(cur);
        c.add(print);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Loanee target = null;
                String name = tname.getText();
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
                    JTextArea toBeprinted = new JTextArea();
                    String printLoanee = "";
                    String printEmi = "\n\n**********EMI History**********\n";

                    boolean exist = false;
                    for (Loanee lll : loanees) {

                        if (name.equals(lll.getName())) {

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

                            for (int i = 0; i < target.getI(); i++) {


                                printEmi += (i + 1) + "'s EMI " + target.getEMIPaid()[i] + "    Due: " + target.getDueList(i) + "\n" + target.getEMIPaidDate(i) + "\n";
                            }

                            toBeprinted.setText(printLoanee + "----------------------" + printEmi + "\n");

                            toBeprinted.print();
                        }


                    }
                                            if (!exist) {

                            JOptionPane.showMessageDialog(null, "Name Not Found");
                        }
                } catch (IOException ex) {
                    ex.printStackTrace();

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PrinterException ex) {
                    Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

    }


}
