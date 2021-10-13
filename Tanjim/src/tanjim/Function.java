package tanjim;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Function extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel title;
    private Font f, w, t;
    private JButton b1, b2, b3, b4, b5, b6;
    private JLabel l1, l2, l3, l4, l5, l6;
    private Cursor cur;
    
    
    private String username;
    
    

    Function(String username) {
        
        this.username = username;

        
        initComponents();
    }

    public void initComponents() {
        this.setBounds(0, 0, 1213, 884);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setTitle("Managing Loanee's Details");
        this.setResizable(false);
        this.setIconImage(icon.getImage());
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);
       
        
        f = new Font("Arial", Font.BOLD, 35);
        t = new Font("Arial", Font.BOLD, 50);
        w = new Font("Arial", Font.PLAIN, 30);
        title = new JLabel("Select an Option");
        title.setBounds(50, 50, 400, 200);
        title.setFont(t);
        title.setForeground(Color.red);
        c.add(title);
        
        cur = new Cursor(Cursor.HAND_CURSOR);
        
        b1 = new JButton("Add");
        b1.setBounds(50, 300, 200, 50);
        b1.setFont(f);
        b1.setForeground(Color.GREEN);
        b1.setBackground(Color.WHITE);
        b1.setCursor(cur);
        c.add(b1);

        l1 = new JLabel("(To add New Loanee's Details)");
        l1.setBounds(260, 300, 500, 40);
        l1.setFont(w);
        l1.setForeground(Color.WHITE);
        c.add(l1);

        b2 = new JButton("Update");
        b2.setBounds(50, 370, 200, 50);
        b2.setFont(f);
        b2.setForeground(Color.GREEN);
        b2.setBackground(Color.WHITE);
        b2.setCursor(cur);
        c.add(b2);

        l2 = new JLabel("(Add EMI)");
        l2.setBounds(260, 370, 500, 40);
        l2.setFont(w);
        l2.setForeground(Color.WHITE);
        c.add(l2);

        b3 = new JButton("Compute");
        b3.setBounds(50, 440, 200, 50);
        b3.setFont(f);
        b3.setForeground(Color.GREEN);
        b3.setBackground(Color.WHITE);
        b3.setCursor(cur);
        c.add(b3);

        l3 = new JLabel("(Compute Interest)");
        l3.setBounds(260, 440, 500, 40);
        l3.setFont(w);
        l3.setForeground(Color.WHITE);
        c.add(l3);

        b4 = new JButton("Search");
        b4.setBounds(50, 510, 200, 50);
        b4.setFont(f);
        b4.setForeground(Color.GREEN);
        b4.setBackground(Color.WHITE);
        b4.setCursor(cur);
        c.add(b4);

        l4 = new JLabel("(Search for individual loanee’s information)");
        l4.setBounds(260, 510, 700, 40);
        l4.setFont(w);
        l4.setForeground(Color.WHITE);
        c.add(l4);

        b5 = new JButton("Delete");
        b5.setBounds(50, 580, 200, 50);
        b5.setFont(f);
        b5.setForeground(Color.GREEN);
        b5.setBackground(Color.WHITE);
        b5.setCursor(cur);
        c.add(b5);

        l5 = new JLabel("(Delete individual loanee's information)");
        l5.setBounds(260, 580, 700, 40);
        l5.setFont(w);
        l5.setForeground(Color.WHITE);
        c.add(l5);

        b6 = new JButton("Print");
        b6.setBounds(50, 650, 200, 50);
        b6.setFont(f);
        b6.setForeground(Color.GREEN);
        b6.setBackground(Color.WHITE);
        b6.setCursor(cur);
        c.add(b6);

        l6 = new JLabel("(Print EMI history as a pdf)");
        l6.setBounds(260, 650, 700, 40);
        l6.setFont(w);
        l6.setForeground(Color.WHITE);
        c.add(l6);
        
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Add a = new Add(username);
                a.setVisible(true);
               
            }
            
            
            
        });
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Update u = new Update(username);
                u.setVisible(true);
                
            }
            
            
        });
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Compute co = new Compute();
                co.setVisible(true);
                
            }
            
            
        });
        b4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Search s = new Search(username);
                s.setVisible(true);
                
            }
            
            
            
        });
        b5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Delete d = new Delete(username);
                d.setVisible(true);
                
            }
            
        });
        b6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Print pr = new Print(username);
                
                pr.setVisible(true);
               
               
            }
            
            
        });

    }
    



}
