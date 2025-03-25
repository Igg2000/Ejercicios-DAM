namespace Tema3Ejercicio1
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            miComboBox = new ComboBox();
            SuspendLayout();
            // 
            // miComboBox
            // 
            miComboBox.AccessibleName = "";
            miComboBox.FormattingEnabled = true;
            miComboBox.Items.AddRange(new object[] { "Primera Planta", "Segunda Planta", "Tercera Planta" });
            miComboBox.Location = new Point(316, 152);
            miComboBox.Name = "miComboBox";
            miComboBox.Size = new Size(163, 28);
            miComboBox.TabIndex = 0;
            miComboBox.SelectionChangeCommitted += itemElegido;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(miComboBox);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
        }

        #endregion

        private ComboBox miComboBox;
    }
}
