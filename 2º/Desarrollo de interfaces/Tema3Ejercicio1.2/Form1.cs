namespace Tema3Ejercicio1._2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(textBox1.Text != "" & textBox2.Text != "" & textBox3.Text != "" )
                if(progressBar1.Value == 0 )
                    progressBar1.Increment(95);
        }
    }
}
