using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TestGame
{
    public partial class Form1 : Form
    {
        private bool right;
        private bool left;
        private int x_value;
        private int y_value;
        private bool jump;
        private int force;

        public Form1()
        {
            InitializeComponent();

            x_value = 50;
            y_value = 500;
            jump = true;
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            e.Graphics.DrawImage(new Bitmap("apple.png"), x_value, y_value, 32, 32);
        }

        private void Timer1_Tick(Object sender, EventArgs e)
        {
            if(right == true)
            {
                x_value += 10;
            }
            if(left == true)
            {
                x_value -= 10;
            }

            if (jump == true)
            {
                //falling for if the player has jumped before
                y_value -= force;
                force -= 5;
            }
            if (y_value > 530)
            {
                y_value = 530;
                force = 0;
                jump = false;
            }
            

            Invalidate();
        }

        private void Form1_KeyDown(Object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Right)
            {
                right = true;
            }
            if (e.KeyCode == Keys.Left)
            {
                left = true;
            }
            if (e.KeyCode == Keys.Escape)
            {
                this.Close();
            }
            if (jump != true)
            {
                if (e.KeyCode == Keys.Up)
                {
                    jump = true;
                    force = 40;
                }
            }
        }

        private void Form1_KeyUp(Object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Right)
            {
                right = false;
            }
            if (e.KeyCode == Keys.Left)
            {
                left = false;
            }
        }
    }
}
