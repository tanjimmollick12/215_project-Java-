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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Add extends JFrame {

    ArrayList<Loanee> loanees = new ArrayList<>();

    private Container c;
    private ImageIcon icon;
    private JLabel title, types, name, age, gender, occupation, contact, amount, interest, time;
    private JTextField tname, tage, toccupation, tcontact, tamount, tinterest, ttime;
    private JRadioButton male, female, ve, pro, per, bus;
    private ButtonGroup grp, loan;
    private Font t, w, wr;
    private JButton add, clear;
    private Cursor cur;
    private String username;

    Add(String username) {
        this.username = username;

        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        this.setBounds(0, 0, 1213, 950);
        this.setResizable(false);
        this.setTitle("Managing Loanee's Details");
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        t = new Font("Arial", Font.BOLD, 50);
        w = new Font("Arial", Font.BOLD, 30);
        wr = new Font("Arial", Font.PLAIN, 25);

        title = new JLabel("Add New Loanee's Details");
        title.setBounds(260, 50, 700, 60);
        title.setFont(t);
        title.setForeground(Color.RED);
        c.add(title);

        types = new JLabel("Type Of Loan");
        types.setBounds(50, 150, 200, 60);
        types.setForeground(Color.WHITE);
        types.setFont(w);
        c.add(types);

        ve = new JRadioButton("Vehicle");
        ve.setBounds(50, 220, 150, 50);
        ve.setForeground(Color.WHITE);
        ve.setBackground(Color.BLACK);
        ve.setFont(w);
        c.add(ve);

        pro = new JRadioButton("Property");
        pro.setBounds(220, 220, 150, 50);
        pro.setForeground(Color.WHITE);
        pro.setBackground(Color.BLACK);
        pro.setFont(w);
        c.add(pro);

        per = new JRadioButton("Personal");
        per.setBounds(390, 220, 180, 50);
        per.setForeground(Color.WHITE);
        per.setBackground(Color.BLACK);
        per.setFont(w);
        c.add(per);

        bus = new JRadioButton("Business");
        bus.setBounds(580, 220, 180, 50);
        bus.setForeground(Color.WHITE);
        bus.setBackground(Color.BLACK);
        bus.setFont(w);
        c.add(bus);
        loan = new ButtonGroup();
        loan.add(ve);
        loan.add(pro);
        loan.add(per);
        loan.add(bus);

        name = new JLabel("Name");
        name.setBounds(50, 290, 200, 60);
        name.setFont(w);
        name.setForeground(Color.WHITE);
        c.add(name);

        tname = new JTextField();
        tname.setBounds(260, 290, 300, 50);
        tname.setForeground(Color.BLACK);
        tname.setFont(wr);
        c.add(tname);

        age = new JLabel("Age");
        age.setBounds(50, 360, 200, 60);
        age.setFont(w);
        age.setForeground(Color.WHITE);
        c.add(age);

        tage = new JTextField();
        tage.setBounds(260, 360, 300, 50);
        tage.setForeground(Color.BLACK);
        tage.setFont(wr);
        c.add(tage);

        gender = new JLabel("Gender");
        gender.setBounds(50, 430, 200, 60);
        gender.setFont(w);
        gender.setForeground(Color.WHITE);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(270, 430, 200, 60);
        male.setFont(w);
        male.setBackground(Color.BLACK);
        male.setForeground(Color.WHITE);
        c.add(male);
        female = new JRadioButton("Female");
        female.setBounds(480, 430, 200, 60);
        female.setFont(w);
        female.setBackground(Color.BLACK);
        female.setForeground(Color.WHITE);
        c.add(female);
        grp = new ButtonGroup();
        grp.add(male);
        grp.add(female);

        occupation = new JLabel("Occupation");
        occupation.setBounds(50, 500, 200, 60);
        occupation.setFont(w);
        occupation.setForeground(Color.WHITE);
        c.add(occupation);

        toccupation = new JTextField();
        toccupation.setBounds(260, 500, 300, 50);
        toccupation.setForeground(Color.BLACK);
        toccupation.setFont(wr);
        c.add(toccupation);

        contact = new JLabel("Phone");
        contact.setBounds(50, 570, 200, 60);
        contact.setFont(w);
        contact.setForeground(Color.WHITE);
        c.add(contact);

        tcontact = new JTextField();
        tcontact.setBounds(260, 570, 300, 50);
        tcontact.setForeground(Color.BLACK);
        tcontact.setFont(wr);
        c.add(tcontact);

        amount = new JLabel("Amount");
        amount.setBounds(50, 640, 200, 60);
        amount.setFont(w);
        amount.setForeground(Color.WHITE);
        c.add(amount);

        tamount = new JTextField();
        tamount.setBounds(260, 640, 300, 50);
        tamount.setForeground(Color.BLACK);
        tamount.setFont(wr);
        c.add(tamount);

        interest = new JLabel("Rate");
        interest.setBounds(50, 710, 200, 60);
        interest.setFont(w);
        interest.setForeground(Color.WHITE);
        c.add(interest);

        tinterest = new JTextField();
        tinterest.setBounds(260, 710, 300, 50);
        tinterest.setForeground(Color.BLACK);
        tinterest.setFont(wr);
        c.add(tinterest);

        time = new JLabel("Time");
        time.setBounds(50, 780, 200, 60);
        time.setFont(w);
        time.setForeground(Color.WHITE);
        c.add(time);

        ttime = new JTextField();
        ttime.setBounds(260, 780, 300, 50);
        ttime.setForeground(Color.BLACK);
        ttime.setFont(wr);
        c.add(ttime);

        cur = new Cursor(Cursor.HAND_CURSOR);

        add = new JButton("Add");
        add.setBounds(800, 330, 150, 70);
        add.setFont(w);
        add.setForeground(Color.GREEN);
        add.setBackground(Color.BLACK);
        add.setCursor(cur);
        c.add(add);

        clear = new JButton("Clear");
        clear.setBounds(800, 420, 150, 70);
        clear.setFont(w);
        clear.setForeground(Color.RED);
        clear.setBackground(Color.BLACK);
        clear.setCursor(cur);
        c.add(clear);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                JRadioButton selectedLoanType = null;
                if (ve.isSelected()) {
                    selectedLoanType = ve;
                } else if (pro.isSelected()) {
                    selectedLoanType = pro;
                } else if (per.isSelected()) {
                    selectedLoanType = per;
                } else if (bus.isSelected()) {

                    selectedLoanType = bus;
                }

                String tOfloan = selectedLoanType.getText();
                String name = tname.getText();
                int age = Integer.parseInt(tage.getText());

                JRadioButton selectedGender = null;
                if (male.isSelected()) {
                    selectedGender = male;
                } else if (female.isSelected()) {
                    selectedGender = female;
                }

                String gender = selectedGender.getText();
                String occupation = toccupation.getText();
                String phone = tcontact.getText();
                double amount = Double.parseDouble(tamount.getText());
                double rate = Double.parseDouble(tinterest.getText());
                int time = Integer.parseInt(ttime.getText());
                
                Loanee loanee = new Loanee(tOfloan, name,  username, age, gender, occupation, phone, amount, rate, time);
                String registeredOn = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime());
                loanee.setRegisteredOn(registeredOn);
                double CI = amount * Math.pow((1 + rate / 100), time);
                int month = time * 12;
                double EMI = CI / month;
                loanee.setEMI(EMI);
                loanee.setCompoundInterest(CI);
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

                } catch (IOException ex) {

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    FileOutputStream fos = new FileOutputStream("Information.dat");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    boolean exist = false;
                    for (Loanee l : loanees) {
                        
                        if (l.getName().equals(name)) {
                            exist = true;
                        }
                    }
                    if (!exist) {

                        loanees.add(loanee);
                        oos.writeObject(loanees);
                        oos.flush();
                        oos.close();

                        JOptionPane.showMessageDialog(null, "Added New Loanee's Details");

                    } else {
                        JOptionPane.showMessageDialog(null, "Already exists!");

                    }

                    oos.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                tname.setText("");
                tage.setText("");
                toccupation.setText("");
                tcontact.setText("");
                tamount.setText("");
                tinterest.setText("");
                ttime.setText("");
            }

        });

    }


}
