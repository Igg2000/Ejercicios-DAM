using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading;
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

namespace Tema_4_v2_Ejercicio_6
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            // Inicializar el ComboBox de Países
            PaisPostal.ItemsSource = ProvinciasPorPais.Keys;
            PaisFacturacion.ItemsSource = ProvinciasPorPais.Keys;
        }

        private void ClonarCheckBox_Checked(object sender, RoutedEventArgs e)
        {
            // Copiar los valores de Dirección Postal a Dirección Facturación
            NombreFacturacion.Text = NombrePostal.Text;
            ApellidoFacturacion.Text = ApellidoPostal.Text;
            DireccionFacturacion.Text = DireccionPostal.Text;
            Direccion2Facturacion.Text = Direccion2Postal.Text;
            CPFacturacion.Text = CPPostal.Text;
            CiudadFacturacion.Text = CiudadPostal.Text;
            ProvinciaFacturacion.Text = ProvinciaPostal.Text;
            PaisFacturacion.Text = PaisPostal.Text;
            MovilFacturacion.Text = MovilPostal.Text;

            // Deshabilitar los campos de facturación para evitar edición
            NombreFacturacion.IsEnabled = false;
            ApellidoFacturacion.IsEnabled = false;
            DireccionFacturacion.IsEnabled = false;
            Direccion2Facturacion.IsEnabled = false;
            CPFacturacion.IsEnabled = false;
            CiudadFacturacion.IsEnabled = false;
            ProvinciaFacturacion.IsEnabled = false;
            PaisFacturacion.IsEnabled = false;
            MovilFacturacion.IsEnabled = false;
        }

        private void ClonarCheckBox_Unchecked(object sender, RoutedEventArgs e)
        {
            // Vaciar los valores en Dirección Facturación
            NombreFacturacion.Text = string.Empty;
            ApellidoFacturacion.Text = string.Empty;
            DireccionFacturacion.Text = string.Empty;
            Direccion2Facturacion.Text = string.Empty;
            CPFacturacion.Text = string.Empty;
            CiudadFacturacion.Text = string.Empty;
            ProvinciaFacturacion.Text = string.Empty;
            PaisFacturacion.Text = string.Empty;
            MovilFacturacion.Text = string.Empty;

            // Habilitar los campos de facturación para que el usuario pueda editarlos
            NombreFacturacion.IsEnabled = true;
            ApellidoFacturacion.IsEnabled = true;
            DireccionFacturacion.IsEnabled = true;
            Direccion2Facturacion.IsEnabled = true;
            CPFacturacion.IsEnabled = true;
            CiudadFacturacion.IsEnabled = true;
            ProvinciaFacturacion.IsEnabled = true;
            PaisFacturacion.IsEnabled = true;
            MovilFacturacion.IsEnabled = true;
        }

        // Diccionario que relaciona cada país con sus provincias/estados
        private Dictionary<string, List<string>> ProvinciasPorPais = new Dictionary<string, List<string>>()
        {
            { "España", new List<string> { "Madrid", "Barcelona", "Sevilla", "Valencia" } },
            { "Alemania", new List<string> { "Baviera", "Berlín", "Brandeburgo", "Hamburgo" } },
            { "Francia", new List<string> { "París", "Marsella", "Lyon", "Niza" } },
            { "Italia", new List<string> { "Roma", "Milán", "Venecia", "Florencia" } },
            { "Estados Unidos", new List<string> { "California", "Texas", "Nueva York", "Florida" } },
            { "México", new List<string> { "Ciudad de México", "Jalisco", "Nuevo León", "Chiapas" } },
            { "Argentina", new List<string> { "Buenos Aires", "Córdoba", "Mendoza", "Santa Fe" } },
            { "Brasil", new List<string> { "São Paulo", "Río de Janeiro", "Brasilia", "Bahía" } }
        };

        private void PaisPostal_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            // Obtener el país seleccionado
            string paisSeleccionado = PaisPostal.SelectedItem as string;

            // Limpiar el ComboBox de Provincias
            ProvinciaPostal.ItemsSource = null;

            // Verificar si el país seleccionado tiene provincias
            if (paisSeleccionado != null && ProvinciasPorPais.ContainsKey(paisSeleccionado))
            {
                // Asignar las provincias correspondientes al ComboBox de Provincias
                ProvinciaPostal.ItemsSource = ProvinciasPorPais[paisSeleccionado];
            }


        }


        //este metodo cambia las textbox mientras la casilla este marcada
        private void datoCambiado(object sender, TextChangedEventArgs e)
        {
            if (ClonarCheckBox.IsChecked == true)
            {
                TextBox sourceTextBox = sender as TextBox;
                string sourceName = sourceTextBox.Name;

                switch (sourceName)
                {
                    case "NombrePostal":
                        NombreFacturacion.Text = NombrePostal.Text;
                        break;
                    case "ApellidoPostal":
                        ApellidoFacturacion.Text = ApellidoPostal.Text;
                        break;
                    case "DireccionPostal":
                        DireccionFacturacion.Text = DireccionPostal.Text;
                        break;
                    case "Direccion2Postal":
                        Direccion2Facturacion.Text = Direccion2Postal.Text;
                        break;
                    case "CPPostal":
                        CPFacturacion.Text = CPPostal.Text;
                        break;
                    case "CiudadPostal":
                        CiudadFacturacion.Text = CiudadPostal.Text;
                        break;
                    case "MovilPostal":
                        MovilFacturacion.Text = MovilPostal.Text;
                        break;
                }
            }
        }


        private void PaisPostal_DropDownClosed(object sender, EventArgs e)
        {
            if (ClonarCheckBox.IsChecked == true)
            {
                    PaisFacturacion.Text = PaisPostal.Text;
            }
        }

        private void ProvinciaPostal_DropDownClosed(object sender, EventArgs e)
        {
            if (ClonarCheckBox.IsChecked == true)
                ProvinciaFacturacion.Text = ProvinciaPostal.Text;


        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            // Construir la cadena con la información de dirección postal y de facturación
            string cad = "Dirección Postal: \n";
            cad += $"Nombre: {NombrePostal.Text}\n";
            cad += $"Apellido: {ApellidoPostal.Text}\n";
            cad += $"Dirección: {DireccionPostal.Text}\n";
            cad += $"Dirección 2: {Direccion2Postal.Text}\n";
            cad += $"Código Postal: {CPPostal.Text}\n";
            cad += $"Ciudad: {CiudadPostal.Text}\n";
            cad += $"Provincia: {ProvinciaPostal.Text}\n";
            cad += $"País: {PaisPostal.Text}\n";
            cad += $"Móvil: {MovilPostal.Text}\n\n";

            cad += "Datos de Facturación: \n";
            cad += $"Nombre: {NombreFacturacion.Text}\n";
            cad += $"Apellido: {ApellidoFacturacion.Text}\n";
            cad += $"Dirección: {DireccionFacturacion.Text}\n";
            cad += $"Dirección 2: {Direccion2Facturacion.Text}\n";
            cad += $"Código Postal: {CPFacturacion.Text}\n";
            cad += $"Ciudad: {CiudadFacturacion.Text}\n";
            cad += $"Provincia: {ProvinciaFacturacion.Text}\n";
            cad += $"País: {PaisFacturacion.Text}\n";
            cad += $"Móvil: {MovilFacturacion.Text}\n";

            // Mostrar el mensaje con toda la información
            MessageBox.Show(cad);
        }

        private void PaisFacturacion_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            // Obtener el país seleccionado
            string paisSeleccionado = PaisFacturacion.SelectedItem as string;

            // Limpiar el ComboBox de Provincias
            ProvinciaFacturacion.ItemsSource = null;

            // Verificar si el país seleccionado tiene provincias
            if (paisSeleccionado != null && ProvinciasPorPais.ContainsKey(paisSeleccionado))
            {
                // Asignar las provincias correspondientes al ComboBox de Provincias
                ProvinciaFacturacion.ItemsSource = ProvinciasPorPais[paisSeleccionado];
            }

        }
    }
}
