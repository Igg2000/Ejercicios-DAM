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

namespace IGG_Examen_1EVA
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            // Centrar la ventana en la pantalla al abrir
            this.WindowStartupLocation = WindowStartupLocation.CenterScreen;

            // Navega a la primera página (Login)
            MainFrame.Navigate(new MenuPrincipal());
        }

        // Evento del botón Menú (puedes usarlo para navegar)
        private void irAMenu(object sender, RoutedEventArgs e)
        {
            MainFrame.Navigate(new MenuPrincipal());
        }
    }
}
