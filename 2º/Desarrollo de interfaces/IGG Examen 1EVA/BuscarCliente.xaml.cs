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
    /// Lógica de interacción para BuscarCliente.xaml
    /// </summary>
    public partial class BuscarCliente : Page
    {
        // Lista simulada de clientes (en un entorno real, esto provendría de una base de datos)
        private List<Cliente> clientes = new List<Cliente>
        {
            new Cliente("Ana", "López", new DateTime(2023, 12, 1), "Rojo", "Ninguno", "Masaje relajante"),
            new Cliente("Carlos", "Pérez", new DateTime(2023, 11, 20), "Azul", "Polen", "Masaje deportivo"),
            new Cliente("Laura", "Gómez", new DateTime(2023, 10, 15), "Verde", "Gluten", "Masaje relajante"),
            new Cliente("Pedro", "Martínez", new DateTime(2023, 9, 30), "Negro", "Lactosa", "Masaje descontracturante"),
            new Cliente("Marta", "Hernández", new DateTime(2023, 8, 5), "Rosa", "Frutos secos", "Masaje terapéutico"),
            new Cliente("José", "Sánchez", new DateTime(2023, 7, 22), "Blanco", "Ninguno", "Masaje relajante"),
            new Cliente("Lucía", "Fernández", new DateTime(2023, 6, 18), "Naranja", "Polvo", "Masaje deportivo"),
            new Cliente("Raúl", "González", new DateTime(2023, 5, 10), "Amarillo", "Gluten", "Masaje facial"),
            new Cliente("Isabel", "Álvarez", new DateTime(2023, 4, 25), "Morado", "Polen", "Masaje relajante"),
            new Cliente("Antonio", "Jiménez", new DateTime(2023, 3, 14), "Azul", "Frutos secos", "Masaje shiatsu")
        };


        public BuscarCliente()
        {
            InitializeComponent();
        }


        private void BotonBuscar_Click(object sender, RoutedEventArgs e)
        {
            string textoBusqueda = TextBoxBusqueda.Text.Trim().ToLower();

            // Limpiamos la lista de resultados antes de buscar
            ListBoxResultados.Items.Clear();

            // Comprobamos si el campo de búsqueda está vacío
            if (string.IsNullOrEmpty(textoBusqueda))
            {
                // Mostrar todos los clientes si el campo está vacío
                foreach (var cliente in clientes)
                {
                    ListBoxResultados.Items.Add(cliente);  // Aquí agregamos el objeto Cliente directamente
                }
            }
            else
            {
                // Buscar clientes cuyo nombre o apellido contenga el texto ingresado
                var resultados = clientes.Where(c =>
                    c.Nombre.ToLower().Contains(textoBusqueda) ||
                    c.Apellidos.ToLower().Contains(textoBusqueda)).ToList();

                if (resultados.Any())
                {
                    foreach (var cliente in resultados)
                    {
                        ListBoxResultados.Items.Add(cliente);  // Agregar el objeto Cliente directamente
                    }
                }
                else
                {
                    // Si no hay resultados
                    ListBoxResultados.Items.Add("No se encontraron clientes.");
                }
            }
        }


        // Método para generar el texto formateado de un cliente
        private string GenerarTextoCliente(Cliente cliente)
        {
            return $"Nombre: {cliente.Nombre} {cliente.Apellidos}\n" +
                   $"Última visita: {cliente.UltimaVisita.ToString("dd/MM/yyyy")}\n" +
                   $"Color de uñas: {cliente.ColorUnas}\n" +
                   $"Alérgenos: {cliente.Alergenos}\n" +
                   $"Masaje favorito: {cliente.MasajeFavorito}";
        }

        private void BotonCobrarCliente_Click(object sender, RoutedEventArgs e)
        {
            // Verificamos si hay un cliente seleccionado
            var clienteSeleccionado = ListBoxResultados.SelectedItem as Cliente;

            if (clienteSeleccionado != null)
            {
                // Mostrar el nombre y apellidos del cliente en un MessageBox
                String clienteACobrar = clienteSeleccionado.Nombre + " " + clienteSeleccionado.Apellidos;
                MessageBox.Show($"Cliente a cobrar: {clienteACobrar}",
                                "Cliente Seleccionado", MessageBoxButton.OK, MessageBoxImage.Information);

                var mainWindow = Application.Current.MainWindow as MainWindow;
                mainWindow.MainFrame.Navigate(new CobrarCliente(clienteACobrar)); // Navega a la nueva página
            }
            else
            {
                // Si no se seleccionó un cliente, mostramos un mensaje
                MessageBox.Show("Por favor, seleccione un cliente para cobrar.",
                                "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
            }
        }


    }

    // Clase Cliente
    public class Cliente
    {
        public string Nombre { get; set; }
        public string Apellidos { get; set; }
        public DateTime UltimaVisita { get; set; }
        public string ColorUnas { get; set; }
        public string Alergenos { get; set; }
        public string MasajeFavorito { get; set; }

        public Cliente(string nombre, string apellidos, DateTime ultimaVisita, string colorUnas, string alergenos, string masajeFavorito)
        {
            Nombre = nombre;
            Apellidos = apellidos;
            UltimaVisita = ultimaVisita;
            ColorUnas = colorUnas;
            Alergenos = alergenos;
            MasajeFavorito = masajeFavorito;
        }
    }
}
