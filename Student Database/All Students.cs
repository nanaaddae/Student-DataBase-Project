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
    public partial class All_Students : Form
    {
        public All_Students()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();

            new Form1().Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            SQLiteConnection sqlite_conn;
            sqlite_conn = CreateConnection();
            SQLiteCommand comm = new SQLiteCommand("Select * From Students", sqlite_conn);
            using (SQLiteDataReader read = comm.ExecuteReader())
            {
                while (read.Read())
                {
              dataGridView1.Rows.Add(new object[] {
            read.GetValue(read.GetOrdinal("Name")),  // Or column name like this
            read.GetValue(read.GetOrdinal("ID")),
            read.GetValue(read.GetOrdinal("Address")),
                 read.GetValue(read.GetOrdinal("GPA"))

            });
                }
            }
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
    }


}
