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

namespace Ignacio_Garcia_Garcia_Proyecto_DI_1Eva
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



            //MessageBox.Show("DNI: " + dni);
            //cambiar de ventana
            MenuPrincipal subWindow = new MenuPrincipal();
            subWindow.Show();
            this.Close();
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
    }

}
