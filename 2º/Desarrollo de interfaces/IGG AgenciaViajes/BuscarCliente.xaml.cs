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
    /// Lógica de interacción para BuscarCliente.xaml
    /// </summary>
    public partial class BuscarCliente : Page
    {
        public BuscarCliente()
        {
            InitializeComponent();
        }

        // Simulación de datos de clientes
        private readonly Dictionary<string, string> clientes = new Dictionary<string, string>
        {
            { "12345678A", "Juan Pérez" },
            { "87654321B", "María Gómez" }
        };

        // Manejador del botón "Buscar"
        private void BotonBuscarCliente_Click(object sender, RoutedEventArgs e)
        {
            string dni = TextBoxDni.Text.Trim();

            if (string.IsNullOrWhiteSpace(dni))
            {
                MessageBox.Show("Por favor, ingrese un DNI válido.", "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }

            if (clientes.TryGetValue(dni, out string nombre))
            {
                MessageBox.Show($"Cliente encontrado:\nDNI: {dni}\nNombre: {nombre}", "Resultado de Búsqueda", MessageBoxButton.OK, MessageBoxImage.Information);
                StackPanelRegistro.Visibility = Visibility.Collapsed;
            }
            else
            {
                MessageBox.Show("Cliente no encontrado. Puede registrarlo si lo desea.", "Resultado de Búsqueda", MessageBoxButton.OK, MessageBoxImage.Information);
                StackPanelRegistro.Visibility = Visibility.Visible;
            }
        }

        // Manejador del botón "Registrar"
        private void BotonRegistrarCliente_Click(object sender, RoutedEventArgs e)
        {
            string dni = TextBoxDni.Text.Trim();
            string nombre = TextBoxNombre.Text.Trim();

            if (string.IsNullOrWhiteSpace(nombre))
            {
                MessageBox.Show("Por favor, ingrese un nombre válido para registrar al cliente.", "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }

            if (clientes.ContainsKey(dni))
            {
                MessageBox.Show("Este cliente ya está registrado.", "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }

            clientes[dni] = nombre;
            MessageBox.Show($"Cliente registrado exitosamente:\nDNI: {dni}\nNombre: {nombre}", "Registro Exitoso", MessageBoxButton.OK, MessageBoxImage.Information);
            StackPanelRegistro.Visibility = Visibility.Collapsed;
            TextBoxDni.Clear();
            TextBoxNombre.Clear();
        }

        // Manejador del botón "Cancelar"
        private void BotonCancelarRegistro_Click(object sender, RoutedEventArgs e)
        {
            StackPanelRegistro.Visibility = Visibility.Collapsed;
            TextBoxNombre.Clear();
        }
    }
}

