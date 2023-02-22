import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;
public class Task2 {
    static int balance=0;
    public static void main(String args[]){
        JFrame f1,f2,f3;
        f1=new JFrame();
        JLabel l1,l2,l3;
        l1=new JLabel("Login to ATM");
        l2=new JLabel("Username : ");
        l3=new JLabel("ATM Pin : ");
        JTextField t=new JTextField();
        JPasswordField p=new JPasswordField(4);
        JButton b=new JButton("LOGIN");
        l1.setBounds(150,50,200,100);
        l1.setFont(new Font("Courier",Font.BOLD,30));
        l1.setForeground(Color.red);
        l2.setBounds(150,150,100,30);
        l3.setBounds(150,200,100,30);
        t.setBounds(250,150,100,30);
        p.setBounds(250,200,100,30);
        b.setBounds(200,250,75,30);
        f1.add(l1);f1.add(l2);f1.add(l3);f1.add(t);f1.add(p);f1.add(b);
        f2=new JFrame();
        JLabel l=new JLabel();
        l.setBounds(150,30,300,50);
        l.setFont(new Font("Courier",Font.BOLD,20));
        f2.add(l);
        JButton b1,b2,b3,b4,b5,b6;
        b1=new JButton("DEPOSITE");
        b2=new JButton("WITHDRAW");
        b3=new JButton("TRANSFER");
        b4=new JButton("BALANCE");
        b5=new JButton("HISTORY");
        b6=new JButton("QUIT");
        JPanel pn=new JPanel();
        pn.setBounds(50,100,400,300);
        pn.setLayout(new GridLayout(3,2,50,50));
        pn.add(b1);pn.add(b2);pn.add(b3);pn.add(b4);pn.add(b5);pn.add(b6);
        f2.add(pn);
        f3=new JFrame();
        JButton q=new JButton("BACK");
        q.setBounds(200,410,100,50);
        f3.add(q);
        JTextArea ta=new JTextArea();
        ta.setBounds(0,50,500,350);
        ta.setEditable(false);
        f3.add(ta);
        JLabel la=new JLabel("TRANSACTION HISTORY");
        la.setBounds(200,0,200,50);
        f3.add(la);
        b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
                if(t.getText().isEmpty() && p.getText().isEmpty())
                    JOptionPane.showMessageDialog(f1,"ENTER USERNAME AND ATM PIN");
                else if(p.getText().isEmpty())
                    JOptionPane.showMessageDialog(f1,"ENTER ATM PIN");
                else if(t.getText().isEmpty())
                    JOptionPane.showMessageDialog(f1,"ENTER USERNAME");
                else{
                    f1.setVisible(false);
				    f2.setVisible(true);
                    l.setText("Hello "+t.getText());
                }
			}
		});
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String s=JOptionPane.showInputDialog(f2,"ENTER THE AMOUNT : ");
                balance+=Float.parseFloat(s);
                JOptionPane.showMessageDialog(f2,"AMOUNT DEPOSITED SUCCESSFULLY");
                ta.append(Float.parseFloat(s)+" IS DEPOSITED SUCCESSFULLY.\n");
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String s=JOptionPane.showInputDialog(f2,"ENTER THE AMOUNT : ");
                balance-=Float.parseFloat(s);
                if(balance>=0){
                    JOptionPane.showMessageDialog(f2,"AMOUNT WITHDRAWN SUCCESSFULLY");
                    ta.append(Float.parseFloat(s)+" IS WITHDRAWN SUCCESSFULLY.\n");
                }
                else{
                    JOptionPane.showMessageDialog(f2,"INSUFFICIENT BALANCE");
                    balance+=Float.parseFloat(s);
                }
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String str=JOptionPane.showInputDialog(f2,"ENTER THE NAME : ");
                String s=JOptionPane.showInputDialog(f2,"ENTER THE AMOUNT : ");
                balance-=Float.parseFloat(s);
                if(balance>=0){
                    JOptionPane.showMessageDialog(f2,"AMOUNT TRANSFERED TO "+str+" SUCCESSFULLY");
                    ta.append(Float.parseFloat(s)+" IS TRANSFERED SUCCESSFULLY.\n");
                }
                else{
                    JOptionPane.showMessageDialog(f2,"INSUFFICIENT BALANCE");
                    balance+=Float.parseFloat(s);
                }
            }
        });
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                JOptionPane.showMessageDialog(f2,"TOTAL BALANCE = "+balance);
            }
        });
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                f2.setVisible(false);
                f3.setVisible(true);
            }
        });
        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                f2.setVisible(false);
                f1.setVisible(true);
                t.setText("");
                p.setText("");
                balance=0;
                ta.setText("");
            }
        });
        q.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                f3.setVisible(false);
                f2.setVisible(true);
            }
        });
        f3.setSize(500,500);
        f3.setLayout(null);
        f2.setSize(500,500);
        f2.setLayout(null);
        f1.setSize(500,500);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
