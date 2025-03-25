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
    /// Lógica de interacción para CobrarCliente.xaml
    /// </summary>
    public partial class CobrarCliente : Page
    {

        public string ClienteACobrar { get; }

        public CobrarCliente(string clienteACobrar)
        {
            InitializeComponent();
            ClienteACobrar = clienteACobrar;
            CargarServiciosCliente(clienteACobrar);
            ServiciosContratados.Text = "Servicios contratados por "+clienteACobrar+":";
            calcularTotal();
        }


        // Método para cargar los servicios contratados por el cliente
        private void CargarServiciosCliente(string cliente)
        {
            // Suponemos que tienes una lista de servicios contratados
            var servicios = ObtenerServiciosPorCliente(cliente);

            // Limpiar la lista actual
            ListBoxHistorial.Items.Clear();

            // Agregar los servicios a la lista
            foreach (var servicio in servicios)
            {
                string servicioDescripcion = $"{servicio.Nombre} - {servicio.Fecha} - {servicio.Precio:C}";
                ListBoxHistorial.Items.Add(servicioDescripcion);
            }
        }

        // Simulamos la obtención de los servicios de un cliente
        private List<Servicio> ObtenerServiciosPorCliente(string cliente)
        {
            // Aquí iría la lógica para obtener los servicios de un cliente
            return new List<Servicio>
        {
            new Servicio { Nombre = "Corte de cabello", Fecha = "01/12/2024", Precio = 20 },
            new Servicio { Nombre = "Manicura", Fecha = "03/12/2024", Precio = 15 },
            new Servicio { Nombre = "Pedicura", Fecha = "05/12/2024", Precio = 18 }
        };

        }

        // Manejar el evento del botón "Calcular Total"
        private void BotonTotal_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Se ha cobrado "+TextBlockTotal.Text+" al cliente "+ClienteACobrar);
        }

        private void calcularTotal()
        {
            // Calcular el total de los servicios
            var total = 0.0;
            var servicios = ObtenerServiciosPorCliente(ClienteACobrar);
            foreach (var servicio in servicios)
            {
                total += servicio.Precio;
            }

            // Mostrar el total
            TextBlockTotal.Text = $"Total: {total:C}";
        }
    }



    // Clase para representar un servicio
    public class Servicio
    {
        public string Nombre { get; set; }
        public string Fecha { get; set; }
        public double Precio { get; set; }
    }
}

