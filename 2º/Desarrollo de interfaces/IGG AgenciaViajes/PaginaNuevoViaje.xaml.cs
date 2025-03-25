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
    /// Lógica de interacción para PaginaNuevoViaje.xaml
    /// </summary>
    public partial class PaginaNuevoViaje : Page
    {
        public PaginaNuevoViaje()
        {
            InitializeComponent();
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

        // Manejador del evento Click del botón "Guardar"
        private void BotonGuardarViaje_Click(object sender, RoutedEventArgs e)
        {
            // Obtener los valores de los controles
            string origen = TextBoxOrigen.Text;
            string destino = TextBoxDestino.Text;
            string fechaIda = DatePickerFechaIda.SelectedDate?.ToString("dd/MM/yyyy");
            string fechaVuelta = DatePickerFechaVuelta.SelectedDate?.ToString("dd/MM/yyyy");
            string horaSalida = TextBoxHoraSalida.Text;
            string horaLlegada = TextBoxHoraLlegada.Text;
            string transporte = (ComboBoxTransporte.SelectedItem as ComboBoxItem)?.Content.ToString();
            string hotel = (ComboBoxHotel.SelectedItem as ComboBoxItem)?.Content.ToString();

            // Validaciones
            if (string.IsNullOrWhiteSpace(origen))
            {
                MessageBox.Show("El campo 'Origen' no puede estar vacío.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            if (string.IsNullOrWhiteSpace(destino))
            {
                MessageBox.Show("El campo 'Destino' no puede estar vacío.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            if (!DatePickerFechaIda.SelectedDate.HasValue)
            {
                MessageBox.Show("Por favor, seleccione una 'Fecha de ida'.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            if (!DatePickerFechaVuelta.SelectedDate.HasValue)
            {
                MessageBox.Show("Por favor, seleccione una 'Fecha de vuelta'.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            // Validar que la fecha de ida sea menor o igual que la de vuelta
            if (DatePickerFechaIda.SelectedDate > DatePickerFechaVuelta.SelectedDate)
            {
                MessageBox.Show("La 'Fecha de ida' no puede ser mayor que la 'Fecha de vuelta'.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            // Si las fechas son iguales, validar que la hora de ida no sea posterior a la de vuelta
            if (DatePickerFechaIda.SelectedDate == DatePickerFechaVuelta.SelectedDate)
            {
                if (!EsHoraValida(horaSalida) || !EsHoraValida(horaLlegada))
                {
                    MessageBox.Show("Las horas deben estar en formato válido (HH:mm).", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                    return;
                }

                DateTime horaIda = DateTime.ParseExact(horaSalida, "HH:mm", null);
                DateTime horaVuelta = DateTime.ParseExact(horaLlegada, "HH:mm", null);

                if (horaVuelta < horaIda)
                {
                    MessageBox.Show("La 'Hora de llegada' no puede ser anterior a la 'Hora de salida' cuando las fechas son iguales.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                    return;
                }
            }

            // Validar que las horas no superen las 24:00
            if (!EsHoraValida(horaSalida) || !EsHoraValida(horaLlegada))
            {
                MessageBox.Show("La hora debe estar en formato válido (HH:mm) y no puede superar las 24:00.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            // Comprobamos que la hora no sea superior a las 24:00
            if (IsHoraMayorQue24(horaSalida) || IsHoraMayorQue24(horaLlegada))
            {
                MessageBox.Show("La hora no puede ser mayor a las 24:00.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            if (string.IsNullOrWhiteSpace(transporte))
            {
                MessageBox.Show("Por favor, seleccione un 'Tipo de transporte'.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            if (string.IsNullOrWhiteSpace(hotel))
            {
                MessageBox.Show("Por favor, seleccione un 'Tipo de hotel'.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            // Mostrar los datos si todo es válido
            string mensaje = $"Origen: {origen}\n" +
                             $"Destino: {destino}\n" +
                             $"Fecha de ida: {fechaIda}\n" +
                             $"Fecha de vuelta: {fechaVuelta}\n" +
                             $"Hora de salida: {horaSalida}\n" +
                             $"Hora de llegada: {horaLlegada}\n" +
                             $"Transporte: {transporte}\n" +
                             $"Hotel: {hotel}";

            MessageBox.Show(mensaje, "Datos del Viaje", MessageBoxButton.OK, MessageBoxImage.Information);
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
