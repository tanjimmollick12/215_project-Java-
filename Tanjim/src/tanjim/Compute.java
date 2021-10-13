
package tanjim;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Compute extends JFrame{
    private Container c;
    private JLabel title,amount,time,rate,si,ci;
    private JTextField tamount,ttime,trate;
    private Font t,w;
    private JTextArea output;
    private JButton com_s,com_c,clear;
    private ImageIcon icon;
    private Cursor cur;
    Compute(){
        initComponents();
    }
    public void initComponents(){
        this.setResizable(false);
        this.setBounds(0, 0, 1213, 884);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Managing Loanee's Details");
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(java.awt.Color.BLACK);
        
        t = new Font("Arial",Font.BOLD,50);
        w = new Font("Arial",Font.BOLD,30);
        
        title = new JLabel("Compute Simple Interest/Compound Interest/EMI");
        title.setBounds(10, 15, 1200, 100);
        title.setFont(t);
        title.setForeground(java.awt.Color.MAGENTA);
        c.add(title);
        
        amount = new JLabel("Amount");
        amount.setBounds(80, 150, 250, 50);
        amount.setForeground(java.awt.Color.WHITE);
        amount.setFont(w);
        c.add(amount);
        
        
        tamount = new JTextField();
        tamount.setBounds(340, 150, 150, 50);
        tamount.setForeground(java.awt.Color.BLACK);
        tamount.setFont(w);
        c.add(tamount);
        
        
        time = new JLabel("Time(Year)");
        time.setBounds(80, 210, 250, 50);
        time.setForeground(java.awt.Color.WHITE);
        time.setFont(w);
        c.add(time);
        
        
        ttime = new JTextField();
        ttime.setBounds(340, 210, 150, 50);
        ttime.setForeground(java.awt.Color.BLACK);
        ttime.setFont(w);
        c.add(ttime);
        
        
        rate = new JLabel("Rate");
        rate.setBounds(80, 270, 250, 50);
        rate.setForeground(java.awt.Color.WHITE);
        rate.setFont(w);
        c.add(rate);
        
        
        trate = new JTextField();
        trate.setBounds(340, 270, 150, 50);
        trate.setForeground(java.awt.Color.BLACK);
        trate.setFont(w);
        c.add(trate);
        
        
        output = new JTextArea();
        output.setBounds(520, 150, 550, 550);
        output.setFont(w);
        output.setForeground(java.awt.Color.BLACK);
        c.add(output);
        
        si = new JLabel("Simple Interest");
        si.setBounds(0, 400, 300, 50);
        si.setFont(w);
        si.setForeground(java.awt.Color.WHITE);
        c.add(si);
        
        cur = new Cursor(Cursor.HAND_CURSOR);
        
        com_s = new JButton("Compute");
        com_s.setBounds(310, 400, 180, 60);
        com_s.setFont(w);
        com_s.setBackground(java.awt.Color.BLACK);
        com_s.setForeground(java.awt.Color.GREEN);
        com_s.setCursor(cur);
        c.add(com_s);
        
        ci = new JLabel("Compound Interest");
        ci.setBounds(0, 500, 300, 50);
        ci.setFont(w);
        ci.setForeground(java.awt.Color.WHITE);
        c.add(ci);
        
        com_c = new JButton("Compute");
        com_c.setBounds(310, 500, 180, 60);
        com_c.setFont(w);
        com_c.setForeground(java.awt.Color.GREEN);
        com_c.setBackground(java.awt.Color.BLACK);
        com_c.setCursor(cur);
        c.add(com_c);
        
        clear = new JButton("Clear");
        clear.setBounds(710, 750, 180, 60);
        clear.setFont(w);
        clear.setForeground(java.awt.Color.GREEN);
        clear.setBackground(java.awt.Color.BLACK);
        clear.setCursor(cur);
        c.add(clear);
        
        
        com_s.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                double amount = Double.parseDouble(tamount.getText());
                int time = Integer.parseInt(ttime.getText());
                double rate = Double.parseDouble(trate.getText());
                
               double SI = (amount * time * rate) / 100;
               
               String am = String.format("%.2f", amount);
               String ti = String.valueOf(time);
               String ra = String.format("%.2f", rate);
               String simple_in = String.format("%.2f", SI);
               output.append("Amount :"+am+"\nTime: "+ti+"\nRate: "+ra+"\nSimple Interest:"+simple_in);
                
                
                
            }
            
            
        });
        
        com_c.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                double amount = Double.parseDouble(tamount.getText());
                int time = Integer.parseInt(ttime.getText());
                double rate = Double.parseDouble(trate.getText());
                
               double CI = amount * Math.pow((1 + rate / 100), time);
               int month = time*12;
               double EMI = CI/month;
               
               String am = String.format("%.2f", amount);
               String ti = String.valueOf(time);
               String ra = String.format("%.2f", rate);
               String Compound_in = String.format("%.2f", CI);
               String emi = String.format("%.2f", EMI);
               
               output.append("Amount: "+am+"\nTime: "+ti+"\nRate: "+ra+"\nCompound Interest:"+Compound_in+"\nEMI: "+emi);
                
                
            }
            
            
        });
        clear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                output.setText("");
            }
            
            
        });
        
    }

}
