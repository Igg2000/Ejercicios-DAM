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

namespace Tema_4_Ejercicio_5
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

        private void pass_PasswordChanged(object sender, RoutedEventArgs e)
        {
            //tengo un label por detras de la caja de la contraseña a modo de placeholder (no se me ocurria como hacerlo de otra forma)
            labelContraseña.Visibility = Visibility.Hidden;
        }

        private void clickBotonRegistrarse(object sender, RoutedEventArgs e)
        {

            String nom = "";
            String correo = "";
            String pass = "";

            //compruebo si los cambios han cambiado o siguen vacios
            if (nombreRegistro.Text!="Nombre" && nombreRegistro.Text != "")
            {
                nom = nombreRegistro.Text;
            } else
            {
                MessageBox.Show("Tienes que escribir un nombre");
                return;
            }

            if (correoRegistro.Text != "Correo" && correoRegistro.Text != "")
            {
                correo = correoRegistro.Text;
            }
            else
            {
                MessageBox.Show("Tienes que escribir un correo");
                return;
            }

            if (passRegistro.Password != "")
            {
                pass = passRegistro.Password;
            }
            else
            {
                MessageBox.Show("Tienes que escribir una contraseña");
                return;
            }
            

            MessageBox.Show("Nombre: "+nom+"\nCorreo: "+correo + "\nContraseña: "+pass);
        }

        private void nombreRegistro_KeyDown(object sender, KeyEventArgs e)
        {
            if (nombreRegistro.Text=="Nombre")
                nombreRegistro.Text = "";
            
        }

        private void correoRegistro_KeyDown(object sender, KeyEventArgs e)
        {

            if (correoRegistro.Text == "Email")
                correoRegistro.Text = "";
        }
    }
}
