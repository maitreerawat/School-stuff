import java.awt.EventQueue;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class pswdgen {

    private JFrame frame;
    private JTextField textField;
    String f,cp;
    public static long s1;
    public static void main(String[] args) {
    	
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	pswdgen window = new pswdgen();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public pswdgen() {
        initialize();
    }
    public static long change(int e)
    {  
        long n;
        n=s1%e;
        s1/=2;
        return n;
    }
    public static String set(String f,long s)
    {      char p;
            p=(char)s;
            f=f.concat(Character.toString((char)p));
            return f;
    }
    public void initialize() {
        frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 48));
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 32));
        btnGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	long s, digits,s3;
            	char p;
            	int count=2;
            	s1=System.currentTimeMillis()%10000;
                s1=(s1%100)*100+(s1/100);
                if(s1<1000)
                    s1+=1000;
                s1=s1*s1*s1*s1*s1*s1*s1*s1*s1;
                if(s1<0)
                    s1*=-1;
                 digits=change(21)+12;   
                s=change(26)+97; 
                p=(char)s;
                f=Character.toString((char)p);
                while(count<digits-4)
                {   
                        	s=change(95)+34;
                        	  count++;
                        	  f=set(f,s);
                }
 
                s=change(128);
                if(s<=33)
               	 s+=33; 
                 s3=s;
                  s3=s%26+97;
                 f=set(f,s3);       
                  s3=s%10+48;
                  f=set(f,s3);       
                   s3=s%26+65;
                   f=set(f,s3);
                   s3=s%15+34;
                   f=set(f,s3);
                s=change(26)+65;
                f=set(f,s);
                cp = f;
            textField.setText(cp);
            }
        });
        btnGenerate.setBounds(0, 0, 211, 56);
        frame.getContentPane().add(btnGenerate);
        
        JButton btnCopy = new JButton("Copy");
        btnCopy.setFont(new Font("Tahoma", Font.PLAIN, 32));
        btnCopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String myString = cp;
                StringSelection stringSelection = new StringSelection(myString);
                Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                clpbrd.setContents(stringSelection, null);
            }
        });
        btnCopy.setBounds(462, 0, 206, 56);
        frame.getContentPane().add(btnCopy);
        
        JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblPassword.setBounds(263, 28, 156, 33);
		frame.getContentPane().add(lblPassword);
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 36));
		frame.getContentPane().add(textField);
		JScrollPane scroll=new JScrollPane(textField);
		scroll.setBounds(34, 145, 617, 122);
		frame.add(scroll);
        
    }
}
