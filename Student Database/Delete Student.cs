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
    public partial class Delete_Student : Form
    {
        public Delete_Student()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            SQLiteTransaction trans;

            SQLiteConnection sqlite_conn;
            sqlite_conn = CreateConnection();


            int id = Convert.ToInt32(textBox1.Text);

            SQLiteCommand cmd = new SQLiteCommand();
            trans = sqlite_conn.BeginTransaction();
            cmd.Connection = sqlite_conn;
            cmd.CommandText = "delete from Students where ID = @ID";
            cmd.Parameters.AddWithValue("@ID", id);
            cmd.ExecuteNonQuery();
            trans.Commit();


            MessageBox.Show("Record Deleted");

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
    }
}
