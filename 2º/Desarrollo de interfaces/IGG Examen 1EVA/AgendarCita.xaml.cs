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
    /// Lógica de interacción para AgendarCita.xaml
    /// </summary>
    public partial class AgendarCita : Page
    {
        public AgendarCita()
        {
            InitializeComponent();
        }

        private void BotonGuardarCita_Click(object sender, RoutedEventArgs e)
        {
            // Validar campos
            string nombre = TextBoxNombre.Text.Trim();
            string apellidos = TextBoxApellidos.Text.Trim();
            string hora = TextBoxHora.Text.Trim();
            string fecha = DatePickerFecha.SelectedDate.HasValue ? DatePickerFecha.SelectedDate.Value.ToString("dd/MM/yyyy") : null;
            var serviciosSeleccionados = ListBoxServicios.SelectedItems.Cast<ListBoxItem>()
                                        .Select(item => item.Content.ToString())
                                        .ToList();

            // Lista de errores
            string errores = "";

            if (string.IsNullOrEmpty(nombre))
                errores += "- El campo 'Nombre' está vacío.\n";

            if (string.IsNullOrEmpty(apellidos))
                errores += "- El campo 'Apellidos' está vacío.\n";

            if (string.IsNullOrEmpty(hora) || hora.Equals("Ej. 16:00"))
            {
                errores += "- El campo 'Hora' está vacío.\n";
            } else
            {
                if (!EsHoraValida(hora) || IsHoraMayorQue24(hora))
                    errores += "- La hora introducida es incorrecta.\n";
            }




            if (string.IsNullOrEmpty(fecha))
                errores += "- El campo 'Fecha' no está seleccionado.\n";

            if (!serviciosSeleccionados.Any())
                errores += "- No se seleccionaron servicios.\n";

            // Mostrar errores o guardar datos
            if (!string.IsNullOrEmpty(errores))
            {
                MessageBox.Show($"Por favor, complete los siguientes campos:\n\n{errores}",
                                "Campos incompletos",
                                MessageBoxButton.OK,
                                MessageBoxImage.Warning);
            }
            else
            {
                // Crear el mensaje de confirmación
                string mensaje = $"Datos de la cita:\n\n" +
                                 $"Nombre: {nombre}\n" +
                                 $"Apellidos: {apellidos}\n" +
                                 $"Fecha: {fecha}\n" +
                                 $"Hora: {hora}\n" +
                                 $"Servicios: {string.Join(", ", serviciosSeleccionados)}";

                // Mostrar mensaje de confirmación
                MessageBox.Show(mensaje, "Cita Registrada", MessageBoxButton.OK, MessageBoxImage.Information);
            }
        }

            private void TextBox_GotFocus(object sender, RoutedEventArgs e)
        {
            var textBox = sender as TextBox;
            if (textBox != null && textBox.Text == "Ej. 16:00")
            {
                textBox.Text = "";
                textBox.Foreground = new SolidColorBrush(Colors.Black); // Cambiar color de texto a negro
            }
        }

        private void TextBox_LostFocus(object sender, RoutedEventArgs e)
        {
            var textBox = sender as TextBox;
            if (textBox != null && string.IsNullOrEmpty(textBox.Text))
            {
                textBox.Text = "Ej. 16:00"; // El valor por defecto
                textBox.Foreground = new SolidColorBrush(Colors.Gray); // Cambiar color de texto a gris
            }
        }

        // Método para inicializar los valores con el watermark cuando la página se carga
        private void TextBox_Loaded(object sender, RoutedEventArgs e)
        {
            var textBox = sender as TextBox;
            if (textBox != null)
            {
                // Asignamos el watermark predeterminado
                textBox.Text = "Ej. 16:00";
                textBox.Foreground = new SolidColorBrush(Colors.Gray); // Cambiar color de texto a gris
            }
        }


        // Función para validar el formato de la hora (HH:mm)
        private bool EsHoraValida(string hora)
        {
            DateTime horaParseada;
            return DateTime.TryParseExact(hora, "HH:mm", null, System.Globalization.DateTimeStyles.None, out horaParseada);
        }

        // Función para comprobar si la hora supera las 24:00
        private bool IsHoraMayorQue24(string hora)
        {
            if (DateTime.TryParseExact(hora, "HH:mm", null, System.Globalization.DateTimeStyles.None, out DateTime parsedTime))
            {
                // Verificamos si la hora es igual o superior a las 24:00
                return parsedTime.Hour >= 24;
            }
            return false;
        }
    }
}
