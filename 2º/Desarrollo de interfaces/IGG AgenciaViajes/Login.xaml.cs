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

namespace IGG_AgenciaViajes
{
    /// <summary>
    /// Lógica de interacción para Login.xaml
    /// </summary>
    public partial class Login : Page
    {

        
        public Login()
        {
            InitializeComponent();
        }


        private void clickBotonRegistrarse(object sender, RoutedEventArgs e)
        {

            String dni = "";


            //compruebo si los cambios han cambiado o siguen vacios


            if (InicioSesionDNI.Text != "DNI" && InicioSesionDNI.Text != "" && elDniEsValido(InicioSesionDNI.Text))
            {
                dni = InicioSesionDNI.Text;
            }
            else
            {
                MessageBox.Show("Tienes que escribir un DNI valido");
                return;
            }


            var mainWindow = Application.Current.MainWindow as MainWindow;
            
            mainWindow.BienvenidaTexto = $"Bienvenido {dni}"; // Actualiza la propiedad

            mainWindow.menuBarraSuperior.Visibility = Visibility.Visible;
            mainWindow.MainFrame.Margin = new Thickness(0, 50, 0, 0);

            mainWindow.MainFrame.Navigate(new MenuPrincipal()); // Navega a la nueva página

        }

        private void InicioSesionDNI_KeyDown(object sender, KeyEventArgs e)
        {

            if (InicioSesionDNI.Text == "DNI")
                InicioSesionDNI.Text = "";
        }

        public static bool elDniEsValido(string dni)
        {
            if (string.IsNullOrWhiteSpace(dni) || dni.Length != 9)
                return false;

            // Extraer números y letra
            string numbers = dni.Substring(0, 8);
            char letter = dni[8];

            // Comprobar que los números son válidos
            if (!int.TryParse(numbers, out int dniNumber))
                return false;

            // Calcular la letra
            string validLetters = "TRWAGMYFPDXBNJZSQVHLCKE";
            int index = dniNumber % 23;
            char calculatedLetter = validLetters[index];

            // Comparar la letra calculada con la letra proporcionada
            return char.ToUpper(letter) == calculatedLetter;
        }

        private void InicioSesionDNI_GotFocus(object sender, RoutedEventArgs e)
        {
            if (InicioSesionDNI != null && InicioSesionDNI.Text == "DNI")
                InicioSesionDNI.Text = "";
        }
            
    }
}
