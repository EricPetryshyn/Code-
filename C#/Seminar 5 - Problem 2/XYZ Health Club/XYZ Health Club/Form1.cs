/****    
*
* Name: Eric Petryshyn
* Student Number: T00229613
* Seminar Number: 5
* Problem Number: 2
* Due Date: October 30, 2015
*
* Program Purpose:  To register for XYZ Health Club memberships.
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

namespace XYZ_Health_Club
{
    public partial class Form1 : Form
    {
        const int MAX_SIZE = 20;
        int cost = 0;
        int count = 0;

        struct info
        {
            public string name;
            public string address;
            public string membership;
            public string cost;
        }
        List <info> members = new List <info>();
       
        public Form1()
        {
            InitializeComponent();
        }

        private void calculateButton_Click(object sender, EventArgs e)
        {
            cost = 0;

            // Adding up cost by checking what has been selected
            if (singleRadioButton.Checked == true)
            {
                cost += 30;
            }
            else if (coupleRadioButton.Checked == true)
            {
                cost += 55;
            }
            else
            {
                cost += 65;
            }

            if (tennisCheckBox.Checked == true)
            {
                cost += 20;
            }
            if (racquetballCheckBox.Checked == true)
            {
                cost += 10;
            }
            if (towelCheckBox.Checked == true)
            {
                cost += 10;
            }


            if (fNameTextBox.Text != "" && lNameTextBox.Text != "" && addressTextBox.Text != "")
            {
                // Displays cost
                displayLabel.Text = cost.ToString("C");
            }
            else
            {
                MessageBox.Show("Please fill out all required information.");
            }  
        }

        private void clearButton_Click(object sender, EventArgs e)
        {
            // Clears input and output, and resets focus
            singleRadioButton.Checked = true;
            coupleRadioButton.Checked = false;
            familyRadioButton.Checked = false;
            tennisCheckBox.Checked = false;
            racquetballCheckBox.Checked = false;
            towelCheckBox.Checked = false;
            displayLabel.Text = "";
            singleRadioButton.Focus();
            fNameTextBox.Text = "";
            lNameTextBox.Text = "";
            addressTextBox.Text = "";
        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            // Closes application
            this.Close();
        }

        private void submitButton_Click(object sender, EventArgs e)
        {
            // Submits information into a list of structs
            if (fNameTextBox.Text != "" && lNameTextBox.Text != "" && addressTextBox.Text != "" && displayLabel.Text != "")
            {
                info information;
                information.name = "Name: " + fNameTextBox.Text + " " + lNameTextBox.Text + ",";
                information.address = "Address: " + addressTextBox.Text + ",";
                if (singleRadioButton.Checked)
                {
                    information.membership = "Membership: Single's Membership,";
                }
                else if (coupleRadioButton.Checked)
                {
                    information.membership = "Membership: Couple's Membership,";
                }
                else
                {
                    information.membership = "Membership: Family Membership,";
                }
                information.cost = "Monthly Fee: " + cost.ToString("C") + ",";
                members.Add(information);
                clearButton.PerformClick();
            }
            // Displays message if more information is required
            else
            {
                MessageBox.Show("Please fill in all required information and press calculate first");
            }
                    
        }

        private void submitToFileButton_Click(object sender, EventArgs e)
        {
            // Submits information contained in list to a text file
            StreamWriter outputFile;

            if (saveFileDialog.ShowDialog() == DialogResult.OK)
            {
                outputFile = File.AppendText(saveFileDialog.FileName);
                for (int i = 0; i < members.Count; i++)
                {
                    outputFile.Write(members[i].name + members[i].address + members[i].membership + members[i].cost);
                    outputFile.WriteLine();
                }
                outputFile.Close();
            }
        }
    }
}
