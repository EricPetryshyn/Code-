namespace Name_Loader
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.nameLabel = new System.Windows.Forms.Label();
            this.nameListBox = new System.Windows.Forms.ListBox();
            this.exitButton = new System.Windows.Forms.Button();
            this.openFile = new System.Windows.Forms.OpenFileDialog();
            this.totalButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // nameLabel
            // 
            this.nameLabel.AutoSize = true;
            this.nameLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.nameLabel.Location = new System.Drawing.Point(12, 9);
            this.nameLabel.Name = "nameLabel";
            this.nameLabel.Size = new System.Drawing.Size(272, 20);
            this.nameLabel.TabIndex = 0;
            this.nameLabel.Text = "XYZ Health Club Member Names";
            // 
            // nameListBox
            // 
            this.nameListBox.FormattingEnabled = true;
            this.nameListBox.Location = new System.Drawing.Point(26, 44);
            this.nameListBox.Name = "nameListBox";
            this.nameListBox.Size = new System.Drawing.Size(239, 173);
            this.nameListBox.TabIndex = 1;
            // 
            // exitButton
            // 
            this.exitButton.Location = new System.Drawing.Point(145, 227);
            this.exitButton.Name = "exitButton";
            this.exitButton.Size = new System.Drawing.Size(75, 35);
            this.exitButton.TabIndex = 2;
            this.exitButton.Text = "Exit";
            this.exitButton.UseVisualStyleBackColor = true;
            this.exitButton.Click += new System.EventHandler(this.exitButton_Click);
            // 
            // totalButton
            // 
            this.totalButton.Location = new System.Drawing.Point(64, 227);
            this.totalButton.Name = "totalButton";
            this.totalButton.Size = new System.Drawing.Size(75, 35);
            this.totalButton.TabIndex = 3;
            this.totalButton.Text = "Total Cost";
            this.totalButton.UseVisualStyleBackColor = true;
            this.totalButton.Click += new System.EventHandler(this.totalButton_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(294, 269);
            this.Controls.Add(this.totalButton);
            this.Controls.Add(this.exitButton);
            this.Controls.Add(this.nameListBox);
            this.Controls.Add(this.nameLabel);
            this.Name = "Form1";
            this.Text = "XYZ Health Club";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label nameLabel;
        private System.Windows.Forms.ListBox nameListBox;
        private System.Windows.Forms.Button exitButton;
        private System.Windows.Forms.OpenFileDialog openFile;
        private System.Windows.Forms.Button totalButton;
    }
}

