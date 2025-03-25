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

namespace Tema_4_Ejercicio_3
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

        private void clickTitulo1(object sender, MouseButtonEventArgs e)
        {
            
            titulo1.Text = "";
            titulo1.Foreground = new SolidColorBrush(Colors.Black);
        }

        private void clickTitulo2(object sender, MouseButtonEventArgs e)
        {
            titulo2.Text = "";
            titulo2.Foreground = new SolidColorBrush(Colors.Black);
        }

        private void clickTitulo3(object sender, MouseButtonEventArgs e)
        {
            titulo3.Text = "";
            titulo3.Foreground = new SolidColorBrush(Colors.Black);
        }
    }
}
