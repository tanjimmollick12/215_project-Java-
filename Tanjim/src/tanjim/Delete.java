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

public class Delete extends JFrame {

    private ArrayList<Loanee> loanees = new ArrayList<>();
    private Container c;
    private ImageIcon icon;
    private JLabel title, name;
    private JTextField tname;
    private Font t, w;
    private JButton delete;
    private Cursor cur;
    private String username;

   
    private Loanee target;

    Delete(String username) {

        this.username = username;

        initComponetes();
    }

    public void initComponetes() {
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

        title = new JLabel("Delete Individual Loanee's Information");
        title.setBounds(200, 30, 950, 100);
        title.setFont(t);
        title.setForeground(Color.RED);
        c.add(title);

        name = new JLabel("Enter Loanee's Name to Delete");
        name.setBounds(70, 200, 450, 70);
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

        delete = new JButton("Delete");
        delete.setBounds(135, 390, 150, 50);
        delete.setFont(w);
        delete.setForeground(Color.RED);
        delete.setBackground(Color.BLACK);
        delete.setCursor(cur);
        c.add(delete);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = 0;
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
                    
                    for (;i<loanees.size();i++) {
                        Loanee lll = loanees.get(i);
                        System.out.println(lll.getName());
                        if (name.equals(lll.getName())) {
                            exist = true;
                            target = lll;
                            JOptionPane.showMessageDialog(null, "Name Found");
                            break;
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
                if (target != null) {
                    System.out.println(target.getAdmin());
                    System.out.println(username);
                    if (target.getAdmin().equals(username)) {
                        String lastpaid = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime());
                        target.setEMIPaidDate(lastpaid);
                        loanees.remove(i);
                        try {
                            FileOutputStream fos = new FileOutputStream("Information.dat");
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(loanees);

                            oos.close();
                            JOptionPane.showMessageDialog(null, "Loanee deleted");

                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "You can't delete this loanee.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not found!");

                }

            }

        });

    }


}
