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

namespace Tema_4_v2_Ejercicio_2
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

        private void ColorComboBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            switch (ColorComboBox.SelectedIndex)
            {
                case 0: ColorTextBox.Background = new SolidColorBrush(Colors.Red); break;
                case 1: ColorTextBox.Background = new SolidColorBrush(Colors.Green); break;
                case 2: ColorTextBox.Background = new SolidColorBrush(Colors.Blue); break;
                case 3: ColorTextBox.Background = new SolidColorBrush(Colors.Yellow); break;
            }
        }
    }
}
