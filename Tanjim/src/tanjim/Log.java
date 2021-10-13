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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import javax.swing.JTextField;

public class Log extends JFrame {

    private ArrayList<User> users = new ArrayList<>();
    private Container c;
    private JLabel label, title, sup, sin, n1, userName1, userName2;
    private JLabel p1, cp, p2;
    private JTextField name1, username1, username2;
    private JPasswordField pass1, cpass, pass2;
    private ImageIcon img, icon;
    private Font t, s, w, wr;
    private JButton signUp, signIn;
    private Cursor cur;

    Log() throws IOException {

        initComponents();
    }

    public void initComponents() throws FileNotFoundException, IOException {

        this.setTitle("Managing Loanee's Details");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(0, 0, 1213, 884);
        c = this.getContentPane();

        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        img = new ImageIcon(getClass().getResource("picture.JPG"));
        label = new JLabel(img);
        label.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(label);

        t = new Font("Arial", Font.BOLD, 40);
        s = new Font("Arial", Font.BOLD, 30);
        w = new Font("Arial", Font.BOLD, 25);
        wr = new Font("Arial", Font.PLAIN, 20);
        cur = new Cursor(Cursor.HAND_CURSOR);

        title = new JLabel("Registration Form!");
        title.setFont(t);
        title.setForeground(Color.RED);
        title.setBounds(50, 10, 400, 100);
        label.add(title);
        sup = new JLabel("Sign Up");
        sup.setBounds(100, 130, 200, 80);
        sup.setFont(s);
        sup.setForeground(Color.BLUE);
        label.add(sup);
        sin = new JLabel("Sign In");
        sin.setBounds(800, 130, 200, 80);
        sin.setFont(s);
        sin.setForeground(Color.BLUE);
        label.add(sin);
        n1 = new JLabel("Name");
        n1.setFont(w);
        n1.setBounds(70, 220, 80, 50);
        n1.setForeground(Color.BLACK);
        label.add(n1);
        name1 = new JTextField();
        name1.setForeground(Color.BLACK);
        name1.setBounds(320, 220, 230, 40);
        name1.setFont(wr);
        label.add(name1);
        userName1 = new JLabel("User Name");
        userName1.setBounds(70, 280, 180, 50);
        userName1.setFont(w);
        userName1.setForeground(Color.BLACK);
        label.add(userName1);
        username1 = new JTextField();
        username1.setBounds(320, 280, 230, 40);
        username1.setFont(wr);
        username1.setForeground(Color.BLACK);
        label.add(username1);
        p1 = new JLabel("Password");
        p1.setBounds(70, 340, 180, 50);
        p1.setFont(w);
        p1.setForeground(Color.BLACK);
        label.add(p1);
        pass1 = new JPasswordField();
        pass1.setBounds(320, 340, 230, 40);
        pass1.setFont(w);
        pass1.setForeground(Color.BLACK);
        label.add(pass1);
        cp = new JLabel("Confirm Password");
        cp.setBounds(70, 400, 230, 50);
        cp.setFont(w);
        cp.setForeground(Color.BLACK);
        label.add(cp);
        cpass = new JPasswordField();
        cpass.setBounds(320, 400, 230, 40);
        cpass.setForeground(Color.BLACK);
        cpass.setFont(w);
        label.add(cpass);
        signUp = new JButton("Sign up");
        signUp.setBounds(200, 600, 200, 80);
        signUp.setFont(s);
        signUp.setForeground(Color.GREEN);
        signUp.setBackground(Color.BLUE);
        signUp.setCursor(cur);
        label.add(signUp);

        sin = new JLabel("Sign In");
        sin.setBounds(800, 130, 200, 80);
        sin.setFont(s);
        sin.setForeground(Color.BLUE);
        label.add(sin);

        userName2 = new JLabel("User Name");
        userName2.setBounds(750, 200, 230, 50);
        userName2.setFont(w);
        userName2.setForeground(Color.BLACK);
        label.add(userName2);

        username2 = new JTextField();
        username2.setBounds(750, 260, 230, 40);
        username2.setFont(wr);
        username2.setForeground(Color.BLACK);
        username2.setToolTipText("Type Your User Name");
        label.add(username2);

        p2 = new JLabel("Password");
        p2.setBounds(750, 320, 230, 50);
        p2.setFont(w);
        p2.setForeground(Color.BLACK);
        label.add(p2);

        pass2 = new JPasswordField();
        pass2.setBounds(750, 380, 230, 40);
        pass2.setFont(w);
        pass2.setForeground(Color.BLACK);
        label.add(pass2);

        signIn = new JButton("Sign in");
        signIn.setBounds(750, 600, 200, 80);
        signIn.setForeground(Color.GREEN);
        signIn.setBackground(Color.BLUE);
        signIn.setFont(s);
        signIn.setCursor(cur);
        label.add(signIn);

        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String name = name1.getText();
                String userName1 = username1.getText();
                String _pass1 = pass1.getText();
                String _pass2 = cpass.getText();
                if (_pass1.equals(_pass2) && _pass1.length() >= 5) {
                    User user = new User(name, userName1, _pass1);

                    FileInputStream fis = null;
                    try {
                        fis = new FileInputStream("data.dat");
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ObjectInputStream ois;
                    try {
                        ois = new ObjectInputStream(fis);
                        users = (ArrayList<User>) ois.readObject();
                    } catch (IOException ex) {
                        Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        FileOutputStream fos = new FileOutputStream("data.dat");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        boolean exist = false;
                        for (User us : users) {

                            if (us.getUsername().equals(userName1)) {
                                exist = true;
                            }
                        }
                        if (!exist) {
                            users.add(user);
                            oos.writeObject(users);
                            JOptionPane.showMessageDialog(null, "Sign Up Completed");
                            name1.setText("");
                            username1.setText("");
                            pass1.setText("");
                            cpass.setText("");

                        } else if (userName1.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "In Valid User Name");

                        } else {
                            JOptionPane.showMessageDialog(null, "User Name Already Exist");
                        }
                        oos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Password Should be Match And 5 character");

                }
            }

        });
        signIn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String userName2 = username2.getText();
                String lpass = pass2.getText();
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream("data.dat");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
                }
                ObjectInputStream ois;
                try {
                    ois = new ObjectInputStream(fis);
                    users = (ArrayList<User>) ois.readObject();
                } catch (IOException | ClassNotFoundException ex) {

                    ex.printStackTrace();
                }
                for (User us : users) {
                    if (us.getUsername().equals(userName2)) {
                        if (us.getPassword().equals(lpass)) {

                            JOptionPane.showMessageDialog(null, "Hello " + us.getName());
                            Function f = new Function(userName2);
                            f.setVisible(true);
                            dispose();

                            return;
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong Password");

                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "User Name Doesn't Exist");

            }

        });

    }

    public static void main(String[] args) throws IOException {
        Log l = new Log();
        l.setVisible(true);
        l.setResizable(false);

    }

}
