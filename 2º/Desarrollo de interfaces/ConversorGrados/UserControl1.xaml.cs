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

namespace ConversorGrados
{
    /// <summary>
    /// Lógica de interacción para UserControl1.xaml
    /// </summary>
    public partial class UserControl1 : UserControl
    {
        public UserControl1()
        {
            InitializeComponent();
        }

        private void ConvertirButton_Click(object sender, RoutedEventArgs e)
        {
            // Obtener el valor ingresado en el TextBox
            string input = txtTemperatura.Text;

            // Verificar que el valor ingresado es un número válido
            if (double.TryParse(input, out double temperatura))
            {
                // Verificar la unidad seleccionada (Celsius o Fahrenheit)
                if (cmbUnidad.SelectedItem is ComboBoxItem selectedItem)
                {
                    if (selectedItem.Content.ToString() == "Celsius")
                    {
                        // Convertir de Celsius a Fahrenheit
                        double fahrenheit = (temperatura * 9 / 5) + 32;
                        txtResultado.Text = $"Resultado: {fahrenheit} °F";
                    }
                    else
                    {
                        // Convertir de Fahrenheit a Celsius
                        double celsius = (temperatura - 32) * 5 / 9;
                        txtResultado.Text = $"Resultado: {celsius} °C";
                    }
                }
            }
            else
            {
                // Si el valor ingresado no es un número válido
                MessageBox.Show("Por favor ingresa un valor numérico válido.");
            }
        }

        // Propiedad para obtener o establecer el valor de la temperatura ingresada
        public double Temperatura
        {
            get
            {
                // Si el valor es un número válido, devolverlo como doble
                return double.TryParse(txtTemperatura.Text, out double temperatura) ? temperatura : 0;
            }
            set
            {
                // Establecer el valor en el TextBox (como cadena)
                txtTemperatura.Text = value.ToString();
            }
        }

        // Propiedad para obtener o establecer la unidad seleccionada (Celsius o Fahrenheit)
        public string Unidad
        {
            get
            {
                // Comprobar si el ComboBox está en "Celsius" o "Fahrenheit"
                return (cmbUnidad.SelectedItem as ComboBoxItem)?.Content.ToString();
            }
            set
            {
                // Establecer la unidad seleccionada en el ComboBox
                foreach (ComboBoxItem item in cmbUnidad.Items)
                {
                    if (item.Content.ToString() == value)
                    {
                        cmbUnidad.SelectedItem = item;
                        break;
                    }
                }
            }
        }

        // Propiedad para obtener o establecer el texto del resultado
        public string Resultado
        {
            get => txtResultado.Text;
            set => txtResultado.Text = value;
        }
    }
}
