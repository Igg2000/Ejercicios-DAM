using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using static System.Net.Mime.MediaTypeNames;

namespace MiPrimerProyecto
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            //Button Next = (Button)sender
            Next.BorderBrush = Brushes.Green;
            Next.Background = Brushes.Red;
        }

        private void Exit_Click(object sender, RoutedEventArgs e)
        {
            Exit.BorderBrush = Brushes.Red;
            Exit.Background = Brushes.Green;
            MessageBox.Show("You are a machine");
        }
    }
}
