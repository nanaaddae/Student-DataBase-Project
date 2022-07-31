using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SQLite;

namespace Student_Database
{
    public partial class Add_Student_Page : Form
    {
        public Add_Student_Page()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string name = textBox2.Text;
            int ID = Convert.ToInt32(textBox3.Text);
            string address = textBox1.Text;
            double GPA = Convert.ToDouble(textBox4.Text);
            SQLiteConnection sqlite_conn;
            sqlite_conn = CreateConnection();
            CreateTable(sqlite_conn);
            InsertData(sqlite_conn,name,ID,address,GPA);

            MessageBox.Show(name + " has been added to the Database");


            this.Hide();
        }


        static SQLiteConnection CreateConnection()
        {

            SQLiteConnection sqlite_conn;
            // Create a new database connection:
            sqlite_conn = new SQLiteConnection("Data Source=database.db; Version = 3; New = True; Compress = True; ");
            // Open the connection:
            try
            {
                sqlite_conn.Open();
            }
            catch (Exception ex)
            {

            }
            return sqlite_conn;
        }


        static void CreateTable(SQLiteConnection conn)
        {
            SQLiteCommand sqlite_cmd;
            string Createsql = "CREATE TABLE IF NOT EXISTS Students (Name VARCHAR(50), ID INT PRIMARY KEY,Address VARCHAR(50), GPA DECIMAL(1,2))";
            sqlite_cmd = conn.CreateCommand();
            sqlite_cmd.CommandText = Createsql;
            sqlite_cmd.ExecuteNonQuery();

        }

        static void InsertData(SQLiteConnection conn,string name,int ID,string address,double gpa)
        {

            SQLiteCommand sqlite_cmd;
            sqlite_cmd = conn.CreateCommand();
            sqlite_cmd.CommandText = "INSERT INTO Students(Name, ID,Address,GPA) VALUES(?,?,?,?)";

            sqlite_cmd.Parameters.AddWithValue("Name", name);
            sqlite_cmd.Parameters.AddWithValue("ID", ID);
            sqlite_cmd.Parameters.AddWithValue("address", address);
            sqlite_cmd.Parameters.AddWithValue("GPA", gpa);

            sqlite_cmd.ExecuteNonQuery();

        }

    }

}
