namespace XYZ_Health_Club
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
            this.membershipGroupBox = new System.Windows.Forms.GroupBox();
            this.familyRadioButton = new System.Windows.Forms.RadioButton();
            this.coupleRadioButton = new System.Windows.Forms.RadioButton();
            this.singleRadioButton = new System.Windows.Forms.RadioButton();
            this.extraGroupBox = new System.Windows.Forms.GroupBox();
            this.towelCheckBox = new System.Windows.Forms.CheckBox();
            this.racquetballCheckBox = new System.Windows.Forms.CheckBox();
            this.tennisCheckBox = new System.Windows.Forms.CheckBox();
            this.calculateGroupBox = new System.Windows.Forms.GroupBox();
            this.submitButton = new System.Windows.Forms.Button();
            this.clearButton = new System.Windows.Forms.Button();
            this.totalLabel = new System.Windows.Forms.Label();
            this.displayLabel = new System.Windows.Forms.Label();
            this.calculateButton = new System.Windows.Forms.Button();
            this.exitButton = new System.Windows.Forms.Button();
            this.infoGroupBox = new System.Windows.Forms.GroupBox();
            this.addressTextBox = new System.Windows.Forms.TextBox();
            this.lNameTextBox = new System.Windows.Forms.TextBox();
            this.fNameTextBox = new System.Windows.Forms.TextBox();
            this.addressLabel = new System.Windows.Forms.Label();
            this.lNameLabel = new System.Windows.Forms.Label();
            this.fNameLabel = new System.Windows.Forms.Label();
            this.saveFileDialog = new System.Windows.Forms.SaveFileDialog();
            this.submitToFileButton = new System.Windows.Forms.Button();
            this.membershipGroupBox.SuspendLayout();
            this.extraGroupBox.SuspendLayout();
            this.calculateGroupBox.SuspendLayout();
            this.infoGroupBox.SuspendLayout();
            this.SuspendLayout();
            // 
            // membershipGroupBox
            // 
            this.membershipGroupBox.Controls.Add(this.familyRadioButton);
            this.membershipGroupBox.Controls.Add(this.coupleRadioButton);
            this.membershipGroupBox.Controls.Add(this.singleRadioButton);
            this.membershipGroupBox.Location = new System.Drawing.Point(12, 109);
            this.membershipGroupBox.Name = "membershipGroupBox";
            this.membershipGroupBox.Size = new System.Drawing.Size(226, 156);
            this.membershipGroupBox.TabIndex = 1;
            this.membershipGroupBox.TabStop = false;
            this.membershipGroupBox.Text = "Please select a monthly membership package:";
            // 
            // familyRadioButton
            // 
            this.familyRadioButton.AutoSize = true;
            this.familyRadioButton.Location = new System.Drawing.Point(30, 119);
            this.familyRadioButton.Name = "familyRadioButton";
            this.familyRadioButton.Size = new System.Drawing.Size(169, 17);
            this.familyRadioButton.TabIndex = 2;
            this.familyRadioButton.Text = "Family Pass     ($65 per month)";
            this.familyRadioButton.UseVisualStyleBackColor = true;
            // 
            // coupleRadioButton
            // 
            this.coupleRadioButton.AutoSize = true;
            this.coupleRadioButton.Location = new System.Drawing.Point(30, 81);
            this.coupleRadioButton.Name = "coupleRadioButton";
            this.coupleRadioButton.Size = new System.Drawing.Size(168, 17);
            this.coupleRadioButton.TabIndex = 1;
            this.coupleRadioButton.Text = "Couple\'s Pass ($55 per month)";
            this.coupleRadioButton.UseVisualStyleBackColor = true;
            // 
            // singleRadioButton
            // 
            this.singleRadioButton.AutoSize = true;
            this.singleRadioButton.Checked = true;
            this.singleRadioButton.Location = new System.Drawing.Point(30, 45);
            this.singleRadioButton.Name = "singleRadioButton";
            this.singleRadioButton.Size = new System.Drawing.Size(167, 17);
            this.singleRadioButton.TabIndex = 0;
            this.singleRadioButton.TabStop = true;
            this.singleRadioButton.Text = "Single\'s Pass  ($30 per month)";
            this.singleRadioButton.UseVisualStyleBackColor = true;
            // 
            // extraGroupBox
            // 
            this.extraGroupBox.Controls.Add(this.towelCheckBox);
            this.extraGroupBox.Controls.Add(this.racquetballCheckBox);
            this.extraGroupBox.Controls.Add(this.tennisCheckBox);
            this.extraGroupBox.Location = new System.Drawing.Point(259, 109);
            this.extraGroupBox.Name = "extraGroupBox";
            this.extraGroupBox.Size = new System.Drawing.Size(284, 156);
            this.extraGroupBox.TabIndex = 2;
            this.extraGroupBox.TabStop = false;
            this.extraGroupBox.Text = "Please select any additional services that you would like:";
            // 
            // towelCheckBox
            // 
            this.towelCheckBox.AutoSize = true;
            this.towelCheckBox.Location = new System.Drawing.Point(33, 119);
            this.towelCheckBox.Name = "towelCheckBox";
            this.towelCheckBox.Size = new System.Drawing.Size(225, 17);
            this.towelCheckBox.TabIndex = 2;
            this.towelCheckBox.Text = "Towel Service                   ($10 per month)";
            this.towelCheckBox.UseVisualStyleBackColor = true;
            // 
            // racquetballCheckBox
            // 
            this.racquetballCheckBox.AutoSize = true;
            this.racquetballCheckBox.Location = new System.Drawing.Point(33, 81);
            this.racquetballCheckBox.Name = "racquetballCheckBox";
            this.racquetballCheckBox.Size = new System.Drawing.Size(226, 17);
            this.racquetballCheckBox.TabIndex = 1;
            this.racquetballCheckBox.Text = "Racquetball Court Access ($10 per month)";
            this.racquetballCheckBox.UseVisualStyleBackColor = true;
            // 
            // tennisCheckBox
            // 
            this.tennisCheckBox.AutoSize = true;
            this.tennisCheckBox.Location = new System.Drawing.Point(33, 45);
            this.tennisCheckBox.Name = "tennisCheckBox";
            this.tennisCheckBox.Size = new System.Drawing.Size(225, 17);
            this.tennisCheckBox.TabIndex = 0;
            this.tennisCheckBox.Text = "Tennis Court Access         ($20 per month)";
            this.tennisCheckBox.UseVisualStyleBackColor = true;
            // 
            // calculateGroupBox
            // 
            this.calculateGroupBox.Controls.Add(this.submitToFileButton);
            this.calculateGroupBox.Controls.Add(this.submitButton);
            this.calculateGroupBox.Controls.Add(this.clearButton);
            this.calculateGroupBox.Controls.Add(this.totalLabel);
            this.calculateGroupBox.Controls.Add(this.displayLabel);
            this.calculateGroupBox.Controls.Add(this.calculateButton);
            this.calculateGroupBox.Location = new System.Drawing.Point(14, 271);
            this.calculateGroupBox.Name = "calculateGroupBox";
            this.calculateGroupBox.Size = new System.Drawing.Size(529, 156);
            this.calculateGroupBox.TabIndex = 3;
            this.calculateGroupBox.TabStop = false;
            // 
            // submitButton
            // 
            this.submitButton.Location = new System.Drawing.Point(69, 77);
            this.submitButton.Name = "submitButton";
            this.submitButton.Size = new System.Drawing.Size(75, 23);
            this.submitButton.TabIndex = 2;
            this.submitButton.Text = "&Submit";
            this.submitButton.UseVisualStyleBackColor = true;
            this.submitButton.Click += new System.EventHandler(this.submitButton_Click);
            // 
            // clearButton
            // 
            this.clearButton.Location = new System.Drawing.Point(69, 48);
            this.clearButton.Name = "clearButton";
            this.clearButton.Size = new System.Drawing.Size(75, 23);
            this.clearButton.TabIndex = 1;
            this.clearButton.Text = "Clea&r";
            this.clearButton.UseVisualStyleBackColor = true;
            this.clearButton.Click += new System.EventHandler(this.clearButton_Click);
            // 
            // totalLabel
            // 
            this.totalLabel.AutoSize = true;
            this.totalLabel.Location = new System.Drawing.Point(259, 77);
            this.totalLabel.Name = "totalLabel";
            this.totalLabel.Size = new System.Drawing.Size(58, 13);
            this.totalLabel.TabIndex = 3;
            this.totalLabel.Text = "Total Cost:";
            // 
            // displayLabel
            // 
            this.displayLabel.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.displayLabel.Location = new System.Drawing.Point(323, 72);
            this.displayLabel.Name = "displayLabel";
            this.displayLabel.Size = new System.Drawing.Size(145, 23);
            this.displayLabel.TabIndex = 4;
            this.displayLabel.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // calculateButton
            // 
            this.calculateButton.Location = new System.Drawing.Point(69, 19);
            this.calculateButton.Name = "calculateButton";
            this.calculateButton.Size = new System.Drawing.Size(75, 23);
            this.calculateButton.TabIndex = 0;
            this.calculateButton.Text = "&Calculate";
            this.calculateButton.UseVisualStyleBackColor = true;
            this.calculateButton.Click += new System.EventHandler(this.calculateButton_Click);
            // 
            // exitButton
            // 
            this.exitButton.Location = new System.Drawing.Point(228, 442);
            this.exitButton.Name = "exitButton";
            this.exitButton.Size = new System.Drawing.Size(75, 23);
            this.exitButton.TabIndex = 4;
            this.exitButton.Text = "E&xit";
            this.exitButton.UseVisualStyleBackColor = true;
            this.exitButton.Click += new System.EventHandler(this.exitButton_Click);
            // 
            // infoGroupBox
            // 
            this.infoGroupBox.Controls.Add(this.addressTextBox);
            this.infoGroupBox.Controls.Add(this.lNameTextBox);
            this.infoGroupBox.Controls.Add(this.fNameTextBox);
            this.infoGroupBox.Controls.Add(this.addressLabel);
            this.infoGroupBox.Controls.Add(this.lNameLabel);
            this.infoGroupBox.Controls.Add(this.fNameLabel);
            this.infoGroupBox.Location = new System.Drawing.Point(14, 13);
            this.infoGroupBox.Name = "infoGroupBox";
            this.infoGroupBox.Size = new System.Drawing.Size(529, 90);
            this.infoGroupBox.TabIndex = 0;
            this.infoGroupBox.TabStop = false;
            this.infoGroupBox.Text = "Please fill out the following information";
            // 
            // addressTextBox
            // 
            this.addressTextBox.Location = new System.Drawing.Point(91, 57);
            this.addressTextBox.Name = "addressTextBox";
            this.addressTextBox.Size = new System.Drawing.Size(212, 20);
            this.addressTextBox.TabIndex = 5;
            // 
            // lNameTextBox
            // 
            this.lNameTextBox.Location = new System.Drawing.Point(309, 24);
            this.lNameTextBox.Name = "lNameTextBox";
            this.lNameTextBox.Size = new System.Drawing.Size(179, 20);
            this.lNameTextBox.TabIndex = 3;
            // 
            // fNameTextBox
            // 
            this.fNameTextBox.Location = new System.Drawing.Point(91, 24);
            this.fNameTextBox.Name = "fNameTextBox";
            this.fNameTextBox.Size = new System.Drawing.Size(133, 20);
            this.fNameTextBox.TabIndex = 1;
            // 
            // addressLabel
            // 
            this.addressLabel.AutoSize = true;
            this.addressLabel.Location = new System.Drawing.Point(25, 64);
            this.addressLabel.Name = "addressLabel";
            this.addressLabel.Size = new System.Drawing.Size(42, 13);
            this.addressLabel.TabIndex = 4;
            this.addressLabel.Text = "Adress:";
            // 
            // lNameLabel
            // 
            this.lNameLabel.AutoSize = true;
            this.lNameLabel.Location = new System.Drawing.Point(242, 31);
            this.lNameLabel.Name = "lNameLabel";
            this.lNameLabel.Size = new System.Drawing.Size(61, 13);
            this.lNameLabel.TabIndex = 2;
            this.lNameLabel.Text = "Last Name:";
            // 
            // fNameLabel
            // 
            this.fNameLabel.AutoSize = true;
            this.fNameLabel.Location = new System.Drawing.Point(25, 31);
            this.fNameLabel.Name = "fNameLabel";
            this.fNameLabel.Size = new System.Drawing.Size(60, 13);
            this.fNameLabel.TabIndex = 0;
            this.fNameLabel.Text = "First Name:";
            // 
            // submitToFileButton
            // 
            this.submitToFileButton.Location = new System.Drawing.Point(69, 106);
            this.submitToFileButton.Name = "submitToFileButton";
            this.submitToFileButton.Size = new System.Drawing.Size(75, 35);
            this.submitToFileButton.TabIndex = 5;
            this.submitToFileButton.Text = "Submit to File";
            this.submitToFileButton.UseVisualStyleBackColor = true;
            this.submitToFileButton.Click += new System.EventHandler(this.submitToFileButton_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(555, 477);
            this.Controls.Add(this.infoGroupBox);
            this.Controls.Add(this.exitButton);
            this.Controls.Add(this.calculateGroupBox);
            this.Controls.Add(this.extraGroupBox);
            this.Controls.Add(this.membershipGroupBox);
            this.Name = "Form1";
            this.Text = "XYZ Health Club";
            this.membershipGroupBox.ResumeLayout(false);
            this.membershipGroupBox.PerformLayout();
            this.extraGroupBox.ResumeLayout(false);
            this.extraGroupBox.PerformLayout();
            this.calculateGroupBox.ResumeLayout(false);
            this.calculateGroupBox.PerformLayout();
            this.infoGroupBox.ResumeLayout(false);
            this.infoGroupBox.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox membershipGroupBox;
        private System.Windows.Forms.RadioButton familyRadioButton;
        private System.Windows.Forms.RadioButton coupleRadioButton;
        private System.Windows.Forms.RadioButton singleRadioButton;
        private System.Windows.Forms.GroupBox extraGroupBox;
        private System.Windows.Forms.CheckBox towelCheckBox;
        private System.Windows.Forms.CheckBox racquetballCheckBox;
        private System.Windows.Forms.CheckBox tennisCheckBox;
        private System.Windows.Forms.GroupBox calculateGroupBox;
        private System.Windows.Forms.Button clearButton;
        private System.Windows.Forms.Label totalLabel;
        private System.Windows.Forms.Label displayLabel;
        private System.Windows.Forms.Button calculateButton;
        private System.Windows.Forms.Button exitButton;
        private System.Windows.Forms.GroupBox infoGroupBox;
        private System.Windows.Forms.TextBox addressTextBox;
        private System.Windows.Forms.TextBox lNameTextBox;
        private System.Windows.Forms.TextBox fNameTextBox;
        private System.Windows.Forms.Label addressLabel;
        private System.Windows.Forms.Label lNameLabel;
        private System.Windows.Forms.Label fNameLabel;
        private System.Windows.Forms.Button submitButton;
        private System.Windows.Forms.SaveFileDialog saveFileDialog;
        private System.Windows.Forms.Button submitToFileButton;
    }
}

