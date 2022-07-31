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
    public partial class Form1 : Form
    {
        public Form1()
        {
          

            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
            
        {
            All_Students all = new All_Students();

            all.ShowDialog();

              this.Hide();


        



        }

        private void button3_Click(object sender, EventArgs e)
        {
            Delete_Student delete = new Delete_Student();

            delete.ShowDialog();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Add_Student_Page student_page = new Add_Student_Page();

            student_page.ShowDialog();


        }

        private void button4_Click(object sender, EventArgs e)
        {
            Environment.Exit(0);

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
            string Createsql = "CREATE TABLE IF NOT EXISTS Students (Name VARCHAR(50), ID INT PRIMARY KEY,Address VARCHAR(50), GPA DECIMAL(1,2)";
         sqlite_cmd = conn.CreateCommand();
            sqlite_cmd.CommandText = Createsql;
            sqlite_cmd.ExecuteNonQuery();
          
        }

        static void ReadData(SQLiteConnection conn)
        {
            SQLiteDataReader sqlite_datareader;
            SQLiteCommand sqlite_cmd;
            sqlite_cmd = conn.CreateCommand();
            sqlite_cmd.CommandText = "SELECT * FROM Students";

            sqlite_datareader = sqlite_cmd.ExecuteReader();
            while (sqlite_datareader.Read())
            {
                string myreader = sqlite_datareader.GetString(0);
                Console.WriteLine(myreader);
            }
            conn.Close();



        }
    }

}

   