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

namespace Tema_5_Ejercicio_4
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

        private void bGetCash_Click(object sender, RoutedEventArgs e)
        {
            
            double cantidad = ConvertirCantidadAModificar(cantidadAModificar.Text);
            dineroCuenta.Retirar(cantidad);


        }

        private void bDeposit_Click(object sender, RoutedEventArgs e)
        {
            double cantidad = ConvertirCantidadAModificar(cantidadAModificar.Text);
            dineroCuenta.Depositar(cantidad);
        }


        public static double ConvertirCantidadAModificar(string cantidadARetirar)
        {
            // Verificar si el string comienza con un "$" y quitarlo si es el caso
            if (cantidadARetirar.StartsWith("$"))
            {
                cantidadARetirar = cantidadARetirar.Substring(1);  // Elimina el primer carácter (el "$")
            }

            try
            {
                // Intentamos convertir el string a double
                double numero = Double.Parse(cantidadARetirar);
                return numero;
            }
            catch (FormatException)
            {
                // Si ocurre una excepción (formato incorrecto), retornamos 0
                Console.WriteLine("El formato del número no es válido.");
                return 0.0;
            }
        }

        private void ClickSinFuncionalidad(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Este boton aun no tiene funcionalidad");
        }
    }
}
