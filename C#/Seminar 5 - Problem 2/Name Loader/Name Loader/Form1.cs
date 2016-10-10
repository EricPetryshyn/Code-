/****    
*
* Name: Eric Petryshyn
* Student Number: T00229613
* Seminar Number: 5
* Problem Number: 2
* Due Date: October 30, 2015
*
* Program Purpose: To display information in a text file and calculate total of member costs
*
****/

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace Name_Loader
{
    public partial class Form1 : Form
    {
        const int MAX_SIZE = 20;

        struct info
        {
            public string name;
            public string address;
            public string membership;
            public string cost;
        }
        List <info> list = new List <info>();

        public Form1()
        {
            InitializeComponent();
        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            // Closes application
            this.Close();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            string entireFile;
            info information;

            // Saves text file to a string function
            StreamReader inputFile;

            inputFile = File.OpenText("List.txt");
            entireFile = inputFile.ReadToEnd();

            // Splits the string and saves to a list of structures
            string[] splitter = entireFile.Split(',');
  
            for (int i = 0; i < splitter.Length-1; i = i+4)
            {
                information.name = splitter[i];
                information.address = splitter[i+1];
                information.membership = splitter[i+2];
                information.cost = splitter[i+3];
                list.Add(information);
            }

            // Displays information in nameListBox
            for (int i = 0; i < list.Count; i++)
            {
                nameListBox.Items.Add(list[i].name);
                nameListBox.Items.Add(list[i].address);
                nameListBox.Items.Add(list[i].membership);
                nameListBox.Items.Add(list[i].cost);
                nameListBox.Items.Add("\n");
            }

            inputFile.Close();
        }

        private void totalButton_Click(object sender, EventArgs e)
        {
            // Calculates total of all member's cost and displays it
            string money = "";
            double total = 0;

            for(int i = 0; i <list.Count; i++)
            { 
                money = list[i].cost;
                money = money.Substring(14);
                total += double.Parse(money);
              
            }

            MessageBox.Show("The accumulated cost of all members is " + total.ToString("C"));
        }
    }
}
