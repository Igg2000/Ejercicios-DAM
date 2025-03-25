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
    /// Lógica de interacción para AltaCliente.xaml
    /// </summary>
    public partial class AltaCliente : Page
    {
        public AltaCliente()
        {
            InitializeComponent();
        }

        private void BotonGuardarCliente_Click(object sender, RoutedEventArgs e)
        {
            // Capturar datos ingresados
            string nombre = TextBoxNombre.Text.Trim();
            string apellidos = TextBoxApellidos.Text.Trim();
            DateTime? fechaUltimaVisita = DatePickerUltimaVisita.SelectedDate;
            string colorUnas = ComboBoxColorUnas.SelectedItem is ComboBoxItem selectedColor
                ? selectedColor.Content.ToString()
                : null;
            string alergenos = TextBoxAlergenos.Text.Trim();
            string masajeFavorito = ComboBoxMasajeFavorito.SelectedItem is ComboBoxItem selectedMasaje
                ? selectedMasaje.Content.ToString()
                : null;

            // Validar campos
            string errores = "";
            if (string.IsNullOrEmpty(nombre))
                errores += "- El campo 'Nombre' está vacío.\n";
            if (string.IsNullOrEmpty(apellidos))
                errores += "- El campo 'Apellidos' está vacío.\n";
            if (!fechaUltimaVisita.HasValue)
                errores += "- El campo 'Última visita' no está seleccionado.\n";
            else if (fechaUltimaVisita > DateTime.Now) // Validación adicional para la fecha
                errores += "- La 'Última visita' no puede ser una fecha futura.\n";
            if (string.IsNullOrEmpty(colorUnas))
                errores += "- El campo 'Color de uñas' no está seleccionado.\n";
            if (string.IsNullOrEmpty(alergenos))
                errores += "- El campo 'Alérgenos' está vacío.\n";
            if (string.IsNullOrEmpty(masajeFavorito))
                errores += "- El campo 'Tipo de masaje favorito' no está seleccionado.\n";

            // Mostrar errores o guardar datos
            if (!string.IsNullOrEmpty(errores))
            {
                MessageBox.Show($"Por favor, complete los siguientes campos:\n\n{errores}",
                                "Campos incompletos o inválidos",
                                MessageBoxButton.OK,
                                MessageBoxImage.Warning);
            }
            else
            {
                // Crear mensaje de confirmación
                string mensaje = $"Datos del cliente:\n\n" +
                                 $"Nombre: {nombre}\n" +
                                 $"Apellidos: {apellidos}\n" +
                                 $"Última visita: {fechaUltimaVisita?.ToString("dd/MM/yyyy")}\n" +
                                 $"Color de uñas: {colorUnas}\n" +
                                 $"Alérgenos: {alergenos}\n" +
                                 $"Tipo de masaje favorito: {masajeFavorito}";

                // Mostrar datos en un MessageBox
                MessageBox.Show(mensaje, "Cliente Registrado", MessageBoxButton.OK, MessageBoxImage.Information);
            }
        }

    }
}
