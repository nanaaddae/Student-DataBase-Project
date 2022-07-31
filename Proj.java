import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;

// Bank Program that uses SQL to store and retrieve data
public class Proj {		// Program uses MySQL to insert and get information from a database.....


	public static HashMap<String,String> get_data()
	{
		String url = "jdbc:mysql://localhost:3306/Bank"; //change these parameters to match your SQL database...
		String username = "root";
		String password = "**********";
		
		
		HashMap<String,String> data = new HashMap<String,String>();
		 
		 Connection connection = null;
		
		try
		{
			 connection = DriverManager.getConnection(url,username,password);
			
		}
		
		catch(SQLException e1)
		{
			System.out.println("Error connecting to Database");
		}
		
		try
		{
			String query = "select Card_No,PIN from customer";

			Statement statement = connection.prepareStatement(query);
			 
			 ResultSet result = statement.executeQuery(query);
			 
			 
			 while(result.next()) {
				 
				 data.put(result.getString("Card_No"),result.getString("PIN"));
			 }
			 
			 
		}
		
		catch(SQLException e1)
		{
			System.out.println("ERROR");
		}
		
		
		
		return data;
		
		
	}
	
	public static void main(String[] args)
	
	{
		MainPage();
	
		
	}
	
	
	
	
	static JFrame logged_in(String Card)
	{
		
		
		String url = "jdbc:mysql://localhost:3306/Bank";
		String username = "root";
		String password = "nanarocks"; 
		
		 
		 Connection connection = null;
		
		try
		{
			 connection = DriverManager.getConnection(url,username,password);
			
			
		}
		
		catch(SQLException e1)
		{
			System.out.println("Error connecting to Database");
		}
		
		
		
		JFrame logged = new JFrame();
		
		logged.setTitle("USER INFORMATION");
		
		JButton Transfer = new JButton ("Transfer to Another account");
		
		JButton Deposit = new JButton ("Deposit to your account");
		
		JButton WithDrawl = new JButton ("Withdraw from your account");
		
		JButton LOGOUT = new JButton ("Log Out");
		
		
		logged.getContentPane().setBackground(new Color(0x0688CB));

		
		
		
		logged.setLayout(null);
		
		logged.setSize(1080,720);
		
		logged.setVisible(true);
		
		
		try
		{
			String query ="Select CustName,Card_No,balance from customer where Card_No=" + Card; 
			
			Statement statement = connection.prepareStatement(query);
			 
			 ResultSet result = statement.executeQuery(query);
			
			
			 while(result.next())
			 {
				 
					JLabel NAME = new JLabel("Welcome " + result.getString("CustName") );
					
					JLabel CARD = new JLabel("Card Number: " + result.getString("Card_No"));
					
					JLabel BALANCE = new JLabel("Balance: " +result.getDouble("Balance"));
					
				 
					NAME.setFont(new Font("Verdana",Font.PLAIN,30));
					CARD.setFont(new Font("Verdana",Font.PLAIN,30));
					BALANCE.setFont(new Font("Verdana",Font.PLAIN,30));


					
					NAME.setBounds(50, 60, 700, 50);
					CARD.setBounds(50, 150, 700, 50);
					BALANCE.setBounds(50, 240, 700, 50);

					
					
					logged.add(NAME);
					logged.add(CARD);
					logged.add(BALANCE);
					
					
			 }
			
		}
		
		catch(SQLException e1)
		{
				System.out.println("Error");
		}
		
		
		LOGOUT.setBounds(50, 400, 100, 40);
		
		Transfer.setBounds(175, 400, 200, 40);
		Deposit.setBounds(400, 400, 200, 40);
		WithDrawl.setBounds(625, 400, 200, 40);
		logged.add(LOGOUT);
		logged.add(Transfer);
		logged.add(Deposit);
		logged.add(WithDrawl);
		
		JTextField Dep = new JTextField("");
		
		Dep.setBounds(50, 490, 100, 40);
		
		
		Transfer.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			
			{
			
				
				
				
				
				
			}
			
			
		});
		
		
		
		Deposit.addActionListener(new ActionListener()
		{




			public void actionPerformed(ActionEvent e)
			
			{
				
				//logged.add(Dep);
				
				SwingUtilities.updateComponentTreeUI(logged);


				String url = "jdbc:mysql://localhost:3306/Bank";
				String username = "root";
				String password = "nanarocks"; 
				
				 
				 Connection connection = null;

				JPanel panel = new JPanel();

				 JTextField CARD_NO = new JTextField();
				 JTextField amount = new JTextField();


				 CARD_NO.setBounds(0,0,80,30);
				 amount.setBounds(0,50,80,30);

				 panel.add(CARD_NO);
				 panel.add(amount);

				// String value1;
				// double value2;

				int value = JOptionPane.showConfirmDialog(null, panel, "Enter in the correct information please", JOptionPane.OK_CANCEL_OPTION);

				if (value == JOptionPane.OK_OPTION)
				{
					String value1  = CARD_NO.getText();
					 double value2 = Double.parseDouble(amount.getText());

					try
					{
						connection = DriverManager.getConnection(url,username,password);


					}

					catch(SQLException e1)
					{
						System.out.println("Error connecting to Database");
					}


					try
					{
						String query = "UPDATE customer"+"SET balance = ? "+"WHERE Card_No = ?";
						PreparedStatement statement = connection.prepareStatement(query);

						statement.setDouble(1,value2);
						statement.setString(2, value1);
						statement.execute();

					}


					catch(SQLException e1)
					{

					}
				}




				
			
			
			}
			
			
		});
		
		
		WithDrawl.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			
			{
			
				
				
			}
			
			
		});
		
		
		LOGOUT.addActionListener(new ActionListener()
		{
		
		public void actionPerformed(ActionEvent e)
		
		{
			
			MainPage().setVisible(true);
			logged.setVisible(false);

		}

		});

		return logged;
	}
	
	
	static JFrame MainPage()
	{
		HashMap<String,String> data = get_data();
		
		
		
		JFrame frame = new JFrame();
		JFrame SIGNUP = new JFrame();
		JLabel label = new JLabel("Omega Holding Company");
	
		
		
		
		
		
		
		
		JTextField Card_No = new JTextField("Card No");
		
		JPasswordField Pin_No = new JPasswordField("Pin No");
		
		label.setBounds(150, -30, 400, 200);
		
		
		
		Card_No.setBounds(145,100, 200,30);  
		
		Pin_No.setBounds(145,155, 200,30); 
		
		label.setFont(new Font("Dialog",Font.PLAIN,20));
		
		frame.setTitle("Omega Holding Company");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,420);
		frame.setVisible(true);
		
		frame.getContentPane().setBackground(new Color(0x0688CB));
		
		JButton Sign_In = new JButton("Sign In");
		JButton Sign_Up = new JButton("Sign Up");
		
		
		
		Sign_In.setBounds(200, 250, 80, 30);
		Sign_Up.setBounds(200, 300, 80, 30);
		frame.setLayout(null);
		frame.add(Sign_In);
		frame.add(Sign_Up);
		frame.add(Card_No);
		frame.add(label);
		frame.add(Pin_No);
		
		
		JFrame Signed_IN = new JFrame();

		Signed_IN.setTitle("User Information"); 
		
		Sign_Up.addActionListener(new ActionListener()
				{
				
				public void actionPerformed(ActionEvent e)
				
				{
						frame.setVisible(false);
						SIGNUP.setTitle("Sign Up");
						SIGNUP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						SIGNUP.setVisible(true);
						SIGNUP.getContentPane().setBackground(new Color(0x0688CB));
						SIGNUP.setSize(1000,800);

						JLabel name = new JLabel("Name");
						
						JLabel cardno = new JLabel("Card Number");
					
						JLabel pinno = new JLabel("Pin Number");
						
						JLabel email = new JLabel("Email");
						
						JTextField Name = new JTextField("");
						
						JTextField Card_No = new JTextField("");
						
						JPasswordField Pin_No = new JPasswordField("");
						
						JLabel bal = new JLabel("Balance");
						
						JTextField Balance = new JTextField ("");
						
						JTextField Email = new JTextField("");
						
						JButton submit = new JButton("Submit");
						
						
						SIGNUP.setLayout(null);
						
						
						Name.setBounds(145,100, 200, 30);
						name.setBounds(145,75,200,30);
						
						Card_No.setBounds(145,170, 200,30);  
						cardno.setBounds(145, 145, 200, 30);
						
						Pin_No.setBounds(145,240, 200,30); 
						pinno.setBounds(145, 215, 200, 30);
						
						Balance.setBounds(145, 310, 200, 30);
						bal.setBounds(145, 285, 200, 30);
						
						Email.setBounds(145, 380, 200, 30);
						email.setBounds(145, 355, 200, 30);
						
						submit.setBounds(145, 450, 200, 30);
						
						SIGNUP.add(Name);
						SIGNUP.add(Card_No);
						SIGNUP.add(Pin_No);
						SIGNUP.add(Email);
						SIGNUP.add(name);
						SIGNUP.add(cardno);
						SIGNUP.add(pinno);
						SIGNUP.add(email);
						SIGNUP.add(Balance);
						SIGNUP.add(bal);
						SIGNUP.add(submit);
						
						
						
						submit.addActionListener(new ActionListener()
						{
						
						public void actionPerformed(ActionEvent e) 
						{
							
							
							String url = "jdbc:mysql://localhost:3306/Bank";
							String username = "root";
							String password = "nanarocks"; 
							
							 
							 Connection connection = null;
							
							try
							{
								 connection = DriverManager.getConnection(url,username,password);
								
								
							}
							
							catch(SQLException e1)
							{
								System.out.println("Error connecting to Database");
							}
							
						try
						{
							String NAME = Name.getText();
							String CARD = Card_No.getText();
							String PIN =String.valueOf(Pin_No.getPassword());
							double BALANCE = Double.parseDouble(Balance.getText());
							String EMAIL = Email.getText();
							
							JLabel newLabel = new JLabel("Welcome to Adrion Banking Service "  + NAME );

							
							
							String query = "insert into Customer (CustName,Card_No,PIN,balance,email)" + "values(?,?,?,?,?)";
							
							 PreparedStatement statement = connection.prepareStatement(query);
							
							statement.setString(1, NAME);
							statement.setString(2, CARD);
							statement.setString(3, PIN);
							statement.setDouble(4,BALANCE);

							statement.setString(5, EMAIL);
							
							SIGNUP.add(newLabel);

							
							statement.execute();
							
							
							connection.close();
							
							Thread.sleep(2000);
							
							
							//newLabel.setBounds(145,550, 300, 100);
							
							SIGNUP.remove(newLabel);
							
							
							SIGNUP.setVisible(false);
							
							// Name, Card_No,Pin_No,Balance,Email;

							Name.setText(null);  // Empties the text fields after the data is submitted
							Card_No.setText(null);
							Pin_No.setText(null);
							Balance.setText(null);
							Email.setText(null);
							
							frame.setVisible(true);
							
							data.put(CARD,PIN);
							
							
						}
						
							catch (Exception e1)
						{
								System.out.println("Error Occured!!!");
						}
							
						
						
						}

						});
							
						
						
						
						
				}
		
				});
		
		
		Sign_In.addActionListener(new ActionListener()
		{
		
		public void actionPerformed(ActionEvent e) 
		{
				
			
			String CARD = Card_No.getText();
			String PIN =String.valueOf(Pin_No.getPassword());
			
			
			boolean present = data.containsKey(CARD);
			
			if(present == true)
			{
				
				if (PIN.equals(data.get(CARD)))
				{
					frame.setVisible(false);
					logged_in(CARD);
				}
				
				else  
					JOptionPane.showMessageDialog(frame,
						    "You entered in the wrong password. Please try again.");
			}
			
			else
				JOptionPane.showMessageDialog(frame,
					    "The Card Number you entered was not found in our Database. Please make sure you entered the right Card Number");			
			
			
			
			
		}

		});
		get_data();
		return frame;
	}
	
}

