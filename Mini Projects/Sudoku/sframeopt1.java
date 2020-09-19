package sudoku;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class sframeopt1 {
	static int Arr[][]=new int[6][6];
	static int Ans2[]=new int[12];
	static int num[]=new int[12];
	private JTextField t00;
	private JTextField t03;
	private JTextField t15;
	private JTextField t21;
	private JTextField t24;
	private JTextField t30;
	private JTextField t33;
	private JTextField t42;
	private JTextField t45;
	private JTextField t51;
	private JTextField t54;
	private JTextField t12;
	private JFrame frame;
	private JTextField t01;
	private JTextField t02;
	private JTextField t10;
	private JTextField t20;
	private JTextField t22;
	private JTextField t41;
	private JTextField t40;
	private JTextField t50;
	private JTextField t31;
	private JTextField t52;
	private JTextField t13;
	private JTextField t43;
	private JTextField t53;
	private JTextField t14;
	private JTextField t04;
	private JTextField t34;
	private JTextField t44;
	private JTextField t25;
	private JTextField t05;
	private JTextField t35;
	private JTextField t55;
	private JTextField t11;
	private JTextField t32;
	private JTextField t23;
	private JLabel lblRules;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sframeopt1 window = new sframeopt1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static boolean check(int r,int c,int val)
	{  int i1;
		for(i1=r-1;i1>=0;i1--)
			{if(val==Arr[i1][c])
				return false;
			}
		int j1;
		for(j1=c-1;j1>=0;j1--)
			{if(val==Arr[r][j1])
				return false;
			}
		return true;
	}
	
	public static boolean checkbysub(int r,int c,int val)
	{  int add;
		if(c<=2)
			add=0;
		else
			add=3;
		int i;
		for(i=add;i<=add+2;i++)
			{if(val==Arr[r-1][i])
				return false;
			}
			return true;
				
	}
	

	

	public  void make()
	{  
		int s[]=new int[6];
		
		 int Arr2[][]=new int[6][6];
		Random randomGenerator = new Random();
		 boolean a,b,c;
		int i=0,co,j=0,randomno,k;
	    for(i=0;i<6;)
	    {   co=0;
	    	randomno=randomGenerator.nextInt(6)+1;
	    	for(j=i-1;j>=0;j--)
	    		if(randomno==s[j])
	    		{
	    			co=1;
	    			break;
	    		}
	    	if(co==0)
	    		{s[i]=randomno;
	    	     i++;
	    		}
	    }
	    randomno=0;
		for(i=0;i<6;i++) 
		{  
			for(j=0,k=0;j<6;)
			{
				randomno=s[k];
				a=check(i,j,randomno);
       		if(i%2!=0)
       		 c=checkbysub(i,j,randomno);
       		else
       			c=true;
       		if((a==true)&&(c==true))
       			{
       			Arr[i][j]=randomno;
       			j++;
       			
       			}
       		else
       			if(k!=5)
       			k++;
       			else
       			k=0;
			}
		}
		
		
			int k1=0;
		for( i=0;i<6;i++)
		 {
			 for(j=0;j<6;j++)
				 if((i+j)%3!=0)
					  Arr2[i][j]=Arr[i][j];
				 else
					 {Ans2[k1]=Arr[i][j];
					  k1++;
					 }
				 
		 }
		
        grid();
	}	
	
	public void grid()
	{   
		
				cleartext();
				t01.setText(Integer.toString(Arr[0][1]));
				t02.setText(Integer.toString(Arr[0][2]));
				t04.setText(Integer.toString(Arr[0][4]));
				t05.setText(Integer.toString(Arr[0][5]));
				t10.setText(Integer.toString(Arr[1][0]));
				t11.setText(Integer.toString(Arr[1][1]));
				t13.setText(Integer.toString(Arr[1][3]));
				t14.setText(Integer.toString(Arr[1][4]));
				t20.setText(Integer.toString(Arr[2][0]));
				t22.setText(Integer.toString(Arr[2][2]));
				t23.setText(Integer.toString(Arr[2][3]));
				t25.setText(Integer.toString(Arr[2][5]));
				t31.setText(Integer.toString(Arr[3][1]));
				t32.setText(Integer.toString(Arr[3][2]));
				t34.setText(Integer.toString(Arr[3][4]));
				t35.setText(Integer.toString(Arr[3][5]));
				t40.setText(Integer.toString(Arr[4][0]));
				t41.setText(Integer.toString(Arr[4][1]));
				t43.setText(Integer.toString(Arr[4][3]));
				t44.setText(Integer.toString(Arr[4][4]));
				t50.setText(Integer.toString(Arr[5][0]));
				t52.setText(Integer.toString(Arr[5][2]));
				t53.setText(Integer.toString(Arr[5][3]));
				t55.setText(Integer.toString(Arr[5][5]));
                t01.setEditable(false);
                t02.setEditable(false);
				t04.setEditable(false);
				t05.setEditable(false);
				t10.setEditable(false);
				t11.setEditable(false);
				t13.setEditable(false);
				t14.setEditable(false);
				t20.setEditable(false);
				t22.setEditable(false);
				t23.setEditable(false);
				t25.setEditable(false);
				t31.setEditable(false);
				t32.setEditable(false);
				t34.setEditable(false);
				t35.setEditable(false);
				t40.setEditable(false);
				t41.setEditable(false);
				t43.setEditable(false);
				t44.setEditable(false);
				t50.setEditable(false);
				t52.setEditable(false);
				t53.setEditable(false);
				t55.setEditable(false);
				
	}
	public void cleartext()
	{ 
		t01.setEditable(true);
        t02.setEditable(true);
		t04.setEditable(true);
		t05.setEditable(true);
		t10.setEditable(true);
		t11.setEditable(true);
		t13.setEditable(true);
		t14.setEditable(true);
		t20.setEditable(true);
		t22.setEditable(true);
		t23.setEditable(true);
		t25.setEditable(true);
		t31.setEditable(true);
		t32.setEditable(true);
		t34.setEditable(true);
		t35.setEditable(true);
		t40.setEditable(true);
		t41.setEditable(true);
		t43.setEditable(true);
		t44.setEditable(true);
		t50.setEditable(true);
		t52.setEditable(true);
		t53.setEditable(true);
		t55.setEditable(true);
	t00.setText("");
	t03.setText("");
	t12.setText("");
	t15.setText("");
	t21.setText("");
	t24.setText("");
	t30.setText("");
	t33.setText("");
	t42.setText("");
	t45.setText("");
	t51.setText("");
	t54.setText("");
	t01.setText("");
	t02.setText("");
	t04.setText("");
	t05.setText("");
	t10.setText("");
	t11.setText("");
	t13.setText("");
	t14.setText("");
	t20.setText("");
	t22.setText("");
	t23.setText("");
	t25.setText("");
	t31.setText("");
	t32.setText("");
	t34.setText("");
	t35.setText("");
	t40.setText("");
	t41.setText("");
	t43.setText("");
	t44.setText("");
	t50.setText("");
	t52.setText("");
	t53.setText("");
	t55.setText("");	
	}
	
	
	public  void perf()
	{   
		
		make();
		
	}    		
		

	public sframeopt1() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 255, 250));
		frame.setBounds(100, 100, 800, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		t00 = new JTextField("");
		t00.setBackground(new Color(255, 192, 203));
		t00.setBounds(70, 137, 86, 20);
		frame.getContentPane().add(t00);
		t00.setColumns(10);
		
		t03 = new JTextField("");
		t03.setBackground(new Color(0, 255, 255));
		t03.setBounds(328, 137, 86, 20);
		frame.getContentPane().add(t03);
		t03.setColumns(10);
		
		 		t15 = new JTextField("");
		 		t15.setBackground(new Color(0, 255, 255));
		t15.setBounds(500, 157, 86, 20);
		frame.getContentPane().add(t15);
		t15.setColumns(10);
		
		 
		t21 = new JTextField("");
		t21.setBackground(new Color(255, 255, 0));
		t21.setBounds(156, 177, 86, 20);
		frame.getContentPane().add(t21);
		t21.setColumns(10);
		
		
		
		t24 = new JTextField("");
		t24.setBackground(new Color(0, 0, 255));
		t24.setBounds(414, 177, 86, 20);
		frame.getContentPane().add(t24);
		t24.setColumns(10);
		
		
		t30 = new JTextField("");
		t30.setBackground(new Color(255, 255, 0));
		t30.setBounds(70, 197, 86, 20);
		frame.getContentPane().add(t30);
		t30.setColumns(10);
			
		t33 = new JTextField("");
		t33.setBackground(new Color(0, 0, 255));
		t33.setBounds(328, 197, 86, 20);
		frame.getContentPane().add(t33);
		t33.setColumns(10);
		
		t42 = new JTextField("");
		t42.setBackground(new Color(255, 0, 0));
		t42.setBounds(242, 217, 86, 20);
		frame.getContentPane().add(t42);
		t42.setColumns(10);
	
		t45 = new JTextField("");
		t45.setBackground(new Color(255, 215, 0));
		t45.setBounds(500, 217, 86, 20);
		frame.getContentPane().add(t45);
		t45.setColumns(10);
		
			
		t51 = new JTextField("");
		t51.setBackground(new Color(255, 0, 0));
		t51.setBounds(156, 237, 86, 20);
		frame.getContentPane().add(t51);
		t51.setColumns(10);
		
		t54 = new JTextField("");
		t54.setBackground(new Color(255, 215, 0));
		t54.setBounds(414, 237, 86, 20);
		frame.getContentPane().add(t54);
		t54.setColumns(10);
		
		t12 = new JTextField("");
		t12.setBackground(new Color(255, 192, 203));
		t12.setBounds(242, 157, 86, 20);
		frame.getContentPane().add(t12);
		t12.setColumns(10);
		
		t01 = new JTextField();
		t01.setBackground(new Color(255, 192, 203));
		t01.setBounds(156, 137, 86, 20);
		frame.getContentPane().add(t01);
		t01.setColumns(10);
		
		t02 = new JTextField();
		t02.setBackground(new Color(255, 192, 203));
		t02.setBounds(242, 137, 86, 20);
		frame.getContentPane().add(t02);
		t02.setColumns(10);
		
		t10 = new JTextField();
		t10.setBackground(new Color(255, 192, 203));
		t10.setBounds(70, 157, 86, 20);
		frame.getContentPane().add(t10);
		t10.setColumns(10);
		
		t20 = new JTextField();
		t20.setBackground(new Color(255, 255, 0));
		t20.setBounds(70, 177, 86, 20);
		frame.getContentPane().add(t20);
		t20.setColumns(10);
		
		t22 = new JTextField();
		t22.setBackground(new Color(255, 255, 0));
		t22.setBounds(242, 177, 86, 20);
		frame.getContentPane().add(t22);
		t22.setColumns(10);
		
		t41 = new JTextField();
		t41.setBackground(new Color(255, 0, 0));
		t41.setBounds(156, 217, 86, 20);
		frame.getContentPane().add(t41);
		t41.setColumns(10);
		
		t40 = new JTextField();
		t40.setBackground(new Color(255, 0, 0));
		t40.setBounds(70, 217, 86, 20);
		frame.getContentPane().add(t40);
		t40.setColumns(10);
		
		t50 = new JTextField();
		t50.setBackground(new Color(255, 0, 0));
		t50.setBounds(70, 237, 86, 20);
		frame.getContentPane().add(t50);
		t50.setColumns(10);
		
		t31 = new JTextField();
		t31.setBackground(new Color(255, 255, 0));
		t31.setBounds(156, 197, 86, 20);
		frame.getContentPane().add(t31);
		t31.setColumns(10);
		
		t52 = new JTextField();
		t52.setBackground(new Color(255, 0, 0));
		t52.setBounds(242, 237, 86, 20);
		frame.getContentPane().add(t52);
		t52.setColumns(10);
		
		t13 = new JTextField();
		t13.setBackground(new Color(0, 255, 255));
		t13.setBounds(328, 157, 86, 20);
		frame.getContentPane().add(t13);
		t13.setColumns(10);
		
		t43 = new JTextField();
		t43.setBackground(new Color(255, 215, 0));
		t43.setBounds(328, 217, 86, 20);
		frame.getContentPane().add(t43);
		t43.setColumns(10);
		
		t53 = new JTextField();
		t53.setBackground(new Color(255, 215, 0));
		t53.setBounds(328, 237, 86, 20);
		frame.getContentPane().add(t53);
		t53.setColumns(10);
		
		t14 = new JTextField();
		t14.setBackground(new Color(0, 255, 255));
		t14.setBounds(414, 157, 86, 20);
		frame.getContentPane().add(t14);
		t14.setColumns(10);
		
		t04 = new JTextField();
		t04.setBackground(new Color(0, 255, 255));
		t04.setBounds(414, 137, 86, 20);
		frame.getContentPane().add(t04);
		t04.setColumns(10);
		
		t34 = new JTextField();
		t34.setBackground(new Color(0, 0, 255));
		t34.setBounds(414, 197, 86, 20);
		frame.getContentPane().add(t34);
		t34.setColumns(10);
		
		t44 = new JTextField();
		t44.setBackground(new Color(255, 215, 0));
		t44.setBounds(414, 217, 86, 20);
		frame.getContentPane().add(t44);
		t44.setColumns(10);
		
		t25 = new JTextField();
		t25.setBackground(new Color(0, 0, 255));
		t25.setBounds(500, 177, 86, 20);
		frame.getContentPane().add(t25);
		t25.setColumns(10);
		
		t05 = new JTextField();
		t05.setBackground(new Color(0, 255, 255));
		t05.setBounds(500, 137, 86, 20);
		frame.getContentPane().add(t05);
		t05.setColumns(10);
		
		t35 = new JTextField();
		t35.setBackground(new Color(0, 0, 255));
		t35.setBounds(500, 197, 86, 20);
		frame.getContentPane().add(t35);
		t35.setColumns(10);
		
		t55 = new JTextField();
		t55.setBackground(new Color(255, 215, 0));
		t55.setBounds(500, 237, 86, 20);
		frame.getContentPane().add(t55);
		t55.setColumns(10);
		
		t11 = new JTextField();
		t11.setBackground(new Color(255, 192, 203));
		t11.setBounds(156, 157, 86, 20);
		frame.getContentPane().add(t11);
		t11.setColumns(10);
		
		t32 = new JTextField();
		t32.setBackground(new Color(255, 255, 0));
		t32.setBounds(242, 197, 86, 20);
		frame.getContentPane().add(t32);
		t32.setColumns(10);
		
		t23 = new JTextField();
		t23.setBackground(new Color(0, 0, 255));
		t23.setBounds(328, 177, 86, 20);
		frame.getContentPane().add(t23);
		t23.setColumns(10);


		t00.setFont(new Font("Sitka Display", Font.BOLD, 16));
		t03.setFont(new Font("Sitka Display", Font.BOLD, 16));
		t12.setFont(new Font("Sitka Display", Font.BOLD, 16));
		t15.setFont(new Font("Sitka Display", Font.BOLD, 16));	
		t21.setFont(new Font("Sitka Display", Font.BOLD, 16));
		t24.setFont(new Font("Sitka Display", Font.BOLD, 16));
		t30.setFont(new Font("Sitka Display", Font.BOLD, 16));
		t33.setFont(new Font("Sitka Display", Font.BOLD, 16));
		t42.setFont(new Font("Sitka Display", Font.BOLD, 16));
		t45.setFont(new Font("Sitka Display", Font.BOLD, 16));
		t51.setFont(new Font("Sitka Display", Font.BOLD, 16));
		t54.setFont(new Font("Sitka Display", Font.BOLD, 16));
		JLabel lblSudokuEasy = new JLabel("SUDOKU EASY");
		lblSudokuEasy.setFont(new Font("Sitka Display", Font.BOLD, 32));
		lblSudokuEasy.setBounds(239, 21, 247, 53);
		frame.getContentPane().add(lblSudokuEasy);
		
		JOptionPane.showMessageDialog(null, "Rules \n1)This is a simple 6X6 sudoku\n2)You have to fill all the incomplete grids in time\n3)Please press submit when done\n4)You can Quit anytime\n5)Press New-Game to Start ");
		JButton btnNewGame = new JButton("NEW GAME");
		btnNewGame.setBackground(new Color(30, 144, 255));
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make();
			}
		});
		btnNewGame.setBounds(99, 89, 127, 23);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBackground(new Color(30, 144, 255));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					num[0]=Integer.parseInt(t00.getText());
					num[1]=Integer.parseInt(t03.getText());
					num[2]=Integer.parseInt(t12.getText());
					num[3]=Integer.parseInt(t15.getText());
					num[4]=Integer.parseInt(t21.getText());
					num[5]=Integer.parseInt(t24.getText());
					num[6]=Integer.parseInt(t30.getText());
					num[7]=Integer.parseInt(t33.getText());
					num[8]=Integer.parseInt(t42.getText());
					num[9]=Integer.parseInt(t45.getText());
					num[10]=Integer.parseInt(t51.getText());
					num[11]=Integer.parseInt(t54.getText());
						

				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Enter a valid number");
				}
				
			
				int c=0;
				for(int i=0;i<12;i++)
				{	
					if(Ans2[i]!=num[i])
					c=1;
				}
				if(c==0)
				{  
					JOptionPane.showMessageDialog(null,"You win\nLet's Play again!!!");
					
				  perf();
				}
				else
					JOptionPane.showMessageDialog(null,"Try-More");
			}
		});
		btnSubmit.setBounds(293, 85, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.setBackground(new Color(30, 144, 255));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Bye");
				System.exit(0);
			}
		});
		btnQuit.setBounds(474, 85, 89, 23);
		frame.getContentPane().add(btnQuit);
		
		lblRules = new JLabel("RULES");
		lblRules.setFont(new Font("Sitka Display", Font.BOLD, 24));
		lblRules.setBounds(285, 283, 89, 20);
		frame.getContentPane().add(lblRules);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(21, 314, 735, 53);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText("* Each puzzle consists of a 6X6 grid containing given clues in various places.");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(21, 378, 735, 50);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText("* The objective is to fill all empty squares so that the numbers 1 to 6 appear exactly once in each row, column and 2x3 box.");
		
		
	}
}
