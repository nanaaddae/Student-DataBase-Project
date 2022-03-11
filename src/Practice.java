import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
public class Practice {
    public static void main(String[] args)
    {
      new main_page();


    }




}
 class main_page extends JFrame {

    JFrame main;

    HashMap<String, String> data;

    HashMap<String,String> data2;

    main_page() {

        setTitle("Brookstone Bookstore");

        this.getContentPane().setBackground(Color.CYAN);


        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton login = new JButton("Login");
        JRadioButton Customer = new JRadioButton("Customer");
        JRadioButton Manager = new JRadioButton("Manager");

        ButtonGroup group = new ButtonGroup();

        Customer.setBackground(Color.CYAN);
        Manager.setBackground(Color.CYAN);


        group.add(Customer);
        group.add(Manager);

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();

        JLabel user = new JLabel("Username");
        JLabel pass = new JLabel("Password");

        JLabel Label = new JLabel("Welcome to Brookstone Bookstore !");
        Label.setFont(new Font("Verdana", Font.BOLD, 24));
        Label.setBounds(150,25,500,45);

        login.setBounds(320,280,70,30);
        Customer.setBounds(220,210,100,30);

        Manager.setBounds(450,210,100,30);

        user.setBounds(150,135,250,22);
        username.setBounds(250,135,250,22);
        password.setBounds(250,170,250,22);
        pass.setBounds(150,170,250,22);
        //Label.setVerticalAlignment(JLabel.TOP);

        JButton Quit = new JButton("Quit Application");

        Quit.setBounds(290,340,150,30);

        JButton create_user = new JButton("Create new Account");

        create_user.setBounds(270,400,200,30);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //JOptionPane.showMessageDialog(null,"Hello user!");

                if(Manager.isSelected())
                {
                    data = information("ADMIN");

                    if(!data.containsKey(username.getText()))
                        JOptionPane.showMessageDialog(null,"No account is registred to this ID!");


                    else if(data.containsKey(username.getText()))
                    {
                        if (Objects.equals(data.get(username.getText()), String.valueOf(password.getPassword()))) {
                            JOptionPane.showMessageDialog(null, "Welcome");
                            new admin_page();
                            dispose();
                        }

                    }

                    System.out.println(data);

                }


                else if( Customer.isSelected())
                {
                    data = information("CUSTOMER");


                    if(!data.containsKey(username.getText()))
                        JOptionPane.showMessageDialog(null,"No account is registred to this ID!");

                    else if(data.containsKey(username.getText()))
                    {
                        if(Objects.equals(data.get(username.getText()), String.valueOf(password.getPassword())))
                        {
                            JOptionPane.showMessageDialog(null,"Welcome");

                            new customer_page();
                            dispose();
                        }
                    }

                    System.out.println(data);

                }
            }
        });

        Quit.addActionListener(new ActionListener() { // leave the application
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        create_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new create_user();
            }
        });

        add(create_user);
        add(Quit);
        add(login);
        add(Customer);
        add(Manager);
        add(username);
        add(password);
        add(Label);
        add(pass);
        add(user);
        setLayout(null);
        setVisible(true);


    }

     HashMap<String,String> information(String type) {

         HashMap<String, String> data = new HashMap<>();

         Statement stmt = null;

         String str = "";

         Connection c = null;

         if(type.equals("CUSTOMER"))
             str = "Customer";

         else if (type.equals("ADMIN"))
             str = "Admin";




         try {
             Class.forName("org.sqlite.JDBC");
             c = DriverManager.getConnection("jdbc:sqlite:Bookstore.db");
             c.setAutoCommit(false);

             String sql = "select ID,password from " + str;
             stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery(sql);


             while (rs.next()) {
                 data.put(rs.getString("ID"), rs.getString("password"));

             }

             c.close();

         } catch (Exception e) {
             System.err.println(e.getClass().getName() + ": " + e.getMessage());
             System.exit(0);


         }


         return data;

     }


}

class customer_page extends JFrame
{

    customer_page()
    {
        this.getContentPane().setBackground(Color.CYAN);

        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        JButton search = new JButton("Search for books");
        JButton quit = new JButton("Quit");

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {


            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new main_page();
                dispose();
            }
        });

        search.setBounds(325,200,155,40);
        quit.setBounds(325,275,60,40);

        add(search);
        add(quit);
        setLayout(null);
        setVisible(true);
    }
}


class create_user extends JFrame
{
    create_user()
    {
        setTitle("Create New USER");

        this.getContentPane().setBackground(Color.CYAN);

        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JLabel name = new JLabel("Name");
        JTextField NAME = new JTextField();

        name.setBounds(32,10,70,30);
        NAME.setBounds(32,35,250,20);

        JLabel username = new JLabel("Username");
        JTextField user = new JTextField();

        username.setBounds(32,65,70,30);
        user.setBounds(32,110,250,20);


        JLabel password = new JLabel("Password");
        JPasswordField pass = new JPasswordField();

        password.setBounds(32,145,70,30);
        pass.setBounds(32,175,250,20);

        JLabel DOB = new JLabel("DOB");
        JTextField dob = new JTextField();

        DOB.setBounds(32,215,70,30);
        dob.setBounds(32,245,250,20);


        JLabel Address = new JLabel("Address");
        JTextField address = new JTextField();

        ButtonGroup buttons = new ButtonGroup();


        Address.setBounds(32,275,70,30);
        address.setBounds(32,305,250,20);

        JRadioButton customer = new JRadioButton("Normal User");

        JRadioButton admin = new JRadioButton("Admin");


        JLabel types = new JLabel("Please select the type of user account you want to create");

        types.setBounds(400,30,350,40);
        customer.setBounds(450,70,120,40);
        admin.setBounds(450,110,120,40);





        admin.setBackground(Color.CYAN);
        customer.setBackground(Color.CYAN);


        buttons.add(customer);
        buttons.add(admin);

        JButton submit = new JButton("Submit");

        submit.setBounds(32,350,100,20);

        JButton Back = new JButton("Go Back");

        Back.setBounds(190,350,100,20);


        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new main_page();
            }
        });


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String u = user.getText();
                String p = String.valueOf(pass.getPassword());;
                String d = dob.getText();
                String a = address.getText();
                String n = NAME.getText();

                if(admin.isSelected()) // put all the information into the database...
                {

                    Database data = new Database();

                    Database.connect();

                    Database.createNewTable("ADMIN");

                    data.insert(n,u,p,d,a,"ADMIN");



                    JOptionPane.showMessageDialog(null,"Welcome to Brookstone "+n);


                    new main_page();

                    dispose();
                }

                else if (customer.isSelected()) // put customer information into database
                {
                    Database data = new Database();

                    Database.connect();

                    Database.createNewTable("CUSTOMER");

                    data.insert(n,u,p,d,a,"CUSTOMER");

                    JOptionPane.showMessageDialog(null,"Welcome to Brookstone "+n);


                    new main_page();

                    dispose();
                }

                else
                    JOptionPane.showMessageDialog(null,"Please make a selection !");


            }
        });


        add(types);
        add(username);
        add(user);


        add(customer);
        add(admin);

        add(pass);
        add(password);

        add(dob);
        add(DOB);

        add(Address);
        add(address);

        add(submit);
        add(Back);

        add(NAME);
        add(name);

        setLayout(null);
        setVisible(true);

    }
}

class admin_page extends JFrame
{

    admin_page()
    {
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.getContentPane().setBackground(Color.CYAN);

        JLabel label = new JLabel("Please make a selection please");

        JButton remove_user = new JButton("Remove User from database");
        JButton add_books = new JButton("Add Books to Database");
        JButton remove_book = new JButton("Remove Book from Database");
        JButton see_books = new JButton("See all books in database");
        JButton quit = new JButton("Sign Out");



        label.setBounds(220,50,500,50);
        remove_user.setBounds(270,150,200,40);
        add_books.setBounds(270,200,200,40);
        remove_book.setBounds(270,250,200,40);
        see_books.setBounds(270,300,200,40);
        quit.setBounds(270,350,200,40);

        label.setFont(new Font("Verdana", Font.BOLD, 24));

        add(label);
        add(remove_user);
        add(add_books);
        add(remove_book);
        add(see_books);
        add(quit);



        remove_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField user = new JTextField();

                Object[] message = {
                        "USER ID:", user
                };

                int option = JOptionPane.showConfirmDialog(getParent(), message, "Enter in the ID of the user you want to remove please", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION)
                {
                    Database data = new Database();

                    String value1 = user.getText();
                    data.delete_user(value1);
                }


            }

        });


        add_books.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {


                JTextField ISBN = new JTextField();
                JTextField Name = new JTextField();
                JTextField Genre = new JTextField();
                JTextField Author = new JTextField();
                JTextField Price = new JTextField();
                Object[] message = {
                        "ISBN:", ISBN,
                        "Name:", Name,
                        "Genre:", Genre,
                        "Author:", Author,
                        "Price", Price,
                };
                int option = JOptionPane.showConfirmDialog(getParent(), message, "Enter in the new Book Information please", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION)
                {
                    Database data = new Database();

                    Database.createNewTable("Book");

                    String value1 = ISBN.getText();
                    String value2 = Name.getText();
                    String value3 = Genre.getText();
                    String value4 = Author.getText();
                    double value5 = Double.parseDouble(Price.getText());

                    data.insert(value1,value2,value3,value4,value5);

                }
            }
        });

        remove_book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField ISBN = new JTextField();
                JTextField name = new JTextField();

                Database data = new Database();

                Object[] message =
                        {
                                "ISBN:", ISBN,
                               "Name:", name
                        };

                String value1 = ISBN.getText();
                String value2 = name.getText();

                int option = JOptionPane.showConfirmDialog(getParent(), message, "Enter in the information for the book you are removing", JOptionPane.OK_CANCEL_OPTION);

                if(option == JOptionPane.OK_OPTION)
                {
                    data.delete_book(value1,value2);
                }
            }
        });

        see_books.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                Statement stmt = null;
                Connection conn = null;
                try {
                    conn = DriverManager.getConnection("jdbc:sqlite:C:\\\\Users\\\\nana_\\\\IdeaProjects\\\\Java Practice\\\\Bookstore.db");
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from Books");
                    JTable table = new JTable(Database.buildTableModel(rs));
                    JOptionPane.showMessageDialog(null, new JScrollPane(table));

                } catch (SQLException ex)
                {
                    ex.printStackTrace();
                }


            }
        });
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new main_page();

            }
        });

        setLayout(null);
        setVisible(true);

    }

}




 class Database {
    /**
     * Connect to a sample database
     */
    public static void connect() {
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Bookstore.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            if (c != null) {
                try {
                    c.close(); // <-- This is important
                } catch (SQLException e) {
                    /* handle exception */
                }
            }

        }

    }

     public static void createNewTable(String type) {
         // SQLite connection string
       //  String url = "jdbc:sqlite:C://sqlite/db/Bookstore.db";

         String url = "jdbc:sqlite:C:\\Users\\nana_\\IdeaProjects\\Java Practice\\Bookstore.db";

         // SQL statement for creating a new table
         String sql ="";

    if(type.equals("CUSTOMER"))
    {
         sql = "CREATE TABLE IF NOT EXISTS Customer(\n"
                 + "	name text,\n"
                 + "	ID text PRIMARY KEY,\n"
                 + "	 password text,\n"
                 + "  DOB text,\n"
                 +"   Address text\n"
                + ");";
    }

    else if( type.equals("ADMIN"))
    {
        sql = "CREATE TABLE IF NOT EXISTS Admin (\n"
                + "	name text,\n"
                + "	ID text PRIMARY KEY,\n"
                + "	 password text,\n"
                + "  DOB text,\n"
                +"   Address text\n"
                + ");";
    }

    else if(type.equals("Book"))
    {
        sql = "CREATE TABLE IF NOT EXISTS Books (\n"
                + "	ISBN text PRIMARY KEY,\n"
                + "	name text,\n"
                + "  genre text,\n"
                + "  Author text,\n"
                + "  price real\n"
                + ");";
    }


         try (Connection conn = DriverManager.getConnection(url);
              Statement stmt = conn.createStatement()) {
             // create a new table
             stmt.execute(sql);

             conn.close();

         }
         catch (SQLException e)
         {
             System.out.println(e.getMessage());
         }



     }


     public void insert(String name,String ID,String password,String DOB,String address,String type) {


        String sql = "";

        if(type.equals("ADMIN"))
            sql = "INSERT INTO Admin(name,ID,password,DOB,Address) VALUES(?,?,?,?,?)";


        else if(type.equals("CUSTOMER"))
            sql = "INSERT INTO Customer(name,ID,password,DOB,Address) VALUES(?,?,?,?,?)";



         //String url = "jdbc:sqlite:C://sqlite/db/Bookstore.db";

         String url = "jdbc:sqlite:C:\\Users\\nana_\\IdeaProjects\\Java Practice\\Bookstore.db";


         try (Connection conn = DriverManager.getConnection(url);
              PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setString(1, name);
             pstmt.setString(2, ID);
             pstmt.setString(3, password);
             pstmt.setString(4, DOB);
             pstmt.setString(5,address);

             pstmt.executeUpdate();
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
     }

     public void insert(String ISBN,String Name,String Genre,String Author,double price) // overloaded function to insert for books
     {
         String url = "jdbc:sqlite:C:\\Users\\nana_\\IdeaProjects\\Java Practice\\Bookstore.db";

         String sql = "INSERT INTO Books(ISBN,Name,Genre,Author,Price) VALUES(?,?,?,?,?)";


         try (Connection conn = DriverManager.getConnection(url);
              PreparedStatement pstmt = conn.prepareStatement(sql))
           {
             pstmt.setString(1, ISBN);
             pstmt.setString(2, Name);
             pstmt.setString(3, Genre);
             pstmt.setString(4, Author);
             pstmt.setDouble(5,price);

             pstmt.executeUpdate();
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }

     }

     public void delete_book(String ISBN,String name)
     {
         String url = "jdbc:sqlite:C:\\Users\\nana_\\IdeaProjects\\Java Practice\\Bookstore.db";


         String sql = "DELETE FROM Books WHERE ISBN = ? AND Name = ?";


         try (Connection conn = DriverManager.getConnection(url);
              PreparedStatement pstmt = conn.prepareStatement(sql)) {

             // set the corresponding param
             pstmt.setString(1,ISBN );
             pstmt.setString(2,name);
             // execute the delete statement
           //  pstmt.executeUpdate();

             pstmt.execute();


         }
         catch (SQLException e)
         {
             System.out.println(e.getMessage());
         }


     }

     public void delete_user (String ID)
     {
         String sql = "DELETE FROM Customer WHERE ID = ?";


         try (Connection conn = DriverManager.getConnection(sql);
              PreparedStatement pstmt = conn.prepareStatement(sql))
         {
             // set the corresponding param
             pstmt.setString(1,ID );
             // execute the delete statement
             pstmt.executeUpdate();

         } catch (SQLException e)
         {
             System.out.println(e.getMessage());
         }

     }

     public static DefaultTableModel buildTableModel(ResultSet rs)
             throws SQLException {

         ResultSetMetaData metaData = rs.getMetaData();

         // names of columns
         Vector<String> columnNames = new Vector<String>();
         int columnCount = metaData.getColumnCount();
         for (int column = 1; column <= columnCount; column++) {
             columnNames.add(metaData.getColumnName(column));
         }

         // data of the table
         Vector<Vector<Object>> data = new Vector<Vector<Object>>();
         while (rs.next()) {
             Vector<Object> vector = new Vector<Object>();
             for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                 vector.add(rs.getObject(columnIndex));
             }
             data.add(vector);
         }

         return new DefaultTableModel(data, columnNames);

     }
}

class user_page extends JFrame
{
    user_page()
    {
        this.getContentPane().setBackground(Color.CYAN);

        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(null);
        setVisible(true);

    }

}



