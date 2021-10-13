package tanjim;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Update extends JFrame {

    private ArrayList<Loanee> loanees = new ArrayList<>();
    private Container c;
    private ImageIcon icon;
    private JLabel title, amount, name;
    private JTextField tamount, tname;
    private Font t, w, b;
    private JButton add, search;
    private Cursor cur;

    Loanee target = null;
    

    private String username;

    Update(String username) {
        this.username = username;

        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Managing Loanee's Details");
        this.setBounds(0, 0, 1200, 900);
        this.setResizable(false);
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        t = new Font("Arial", Font.BOLD, 50);
        w = new Font("Arial", Font.BOLD, 25);
        b = new Font("Arial", Font.BOLD, 35);

        title = new JLabel("EMI");
        title.setFont(t);
        title.setBounds(100, 50, 900, 60);
        title.setForeground(Color.RED);
        c.add(title);

        name = new JLabel("Name:");
        name.setFont(w);
        name.setBounds(150, 150, 150, 50);
        name.setForeground(Color.BLUE);
        c.add(name);

        tname = new JTextField();
        tname.setFont(w);
        tname.setBounds(320, 150, 300, 50);
        tname.setForeground(Color.BLACK);
        c.add(tname);

        cur = new Cursor(Cursor.HAND_CURSOR);

        search = new JButton("Search");
        search.setFont(b);
        search.setBounds(670, 150, 180, 50);
        search.setBackground(Color.LIGHT_GRAY);
        search.setForeground(Color.GREEN);
        search.setBackground(Color.BLACK);
        search.setCursor(cur);
        c.add(search);

        amount = new JLabel("Enter Amount:");
        amount.setBounds(150, 350, 250, 60);
        amount.setFont(w);
        amount.setForeground(Color.WHITE);
        c.add(amount);

        tamount = new JTextField();
        tamount.setBounds(150, 420, 250, 50);
        tamount.setForeground(Color.BLACK);
        tamount.setFont(w);
        c.add(tamount);

        add = new JButton("Add");
        add.setBounds(430, 420, 120, 50);
        add.setFont(w);
        add.setBackground(Color.BLACK);
        add.setCursor(cur);
        add.setForeground(Color.GREEN);
        c.add(add);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
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

                    boolean exist = false;
                    for (Loanee lll : loanees) {
                        
                        if (name.equals(lll.getName())) {
                            exist = true;

                            target = lll;
                            JOptionPane.showMessageDialog(null, "Name Found");
                        }
                    }
                    if (!exist) {
                        JOptionPane.showMessageDialog(null, "Name Not Found");
                        return;
                    }
                    ois.close();
                } catch (IOException ex) {

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                double emi = Double.parseDouble(tamount.getText());

                if (target != null) {

                    if (target.getAdmin().equals(username)) {
                        target.setEMIPaid(emi);
                        target.setCompoundInterest(target.getCompoundInterest() - emi);
                        target.setDueList(target.getCompoundInterest());

                        double CI = target.getCompoundInterest() * Math.pow((1 + target.getRate() / 100), target.getTime() * 12);
                        int month = target.getTime() * 12;
                        double EMI = CI / month;
                        target.setEMI(EMI);

                        String lastpaid = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime());
                        target.setEMIPaidDate(lastpaid);
                        for (int i = 0; i < loanees.size(); ++i) {
                            if (loanees.get(i).getName().equals(target.getName())) {
                                loanees.set(i, target);
                                break;
                            }
                        }
                        try {
                            FileOutputStream fos = new FileOutputStream("Information.dat");
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(loanees);

                            oos.close();
                            JOptionPane.showMessageDialog(null, "EMI Added");

                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "This loanee was not registered by you!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not found!");

                }
            }

        }
        );

    }


}
