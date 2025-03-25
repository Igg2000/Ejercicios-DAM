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

namespace Tema_4_Ejercicio_7
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

        private void MostrarFecha1_Click(object sender, RoutedEventArgs e) { 
            //esta es la primera forma que he usado, me sacaba la fecha pero despues ponia la hora como 00:00:00
            //MessageBox.Show(calendar.ToString());
            //esta es la segunda forma
            DateTime fechaSeleccionada = calendar.SelectedDate.Value;
            string fechaFormateada = fechaSeleccionada.ToString("d"); // la d es para que solo salga el dia
            MessageBox.Show(fechaFormateada);
        }

        private void MostrarFecha3_Click(object sender, RoutedEventArgs e)
        {
            DateTime fechaSeleccionada = datepicker.SelectedDate.Value;
            string fechaFormateada = fechaSeleccionada.ToString("d"); // la d es para que solo salga el dia
            MessageBox.Show(fechaFormateada);
        }

        private void MostrarFecha2_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("No existe CalendarDatePicker en esta version");
        }
    }
}
