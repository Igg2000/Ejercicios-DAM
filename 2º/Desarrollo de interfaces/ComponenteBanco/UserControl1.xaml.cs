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

namespace ComponenteBanco
{
    public partial class controlarDinero : UserControl
    {
        // Variable privada para almacenar el color original de Foreground
        private Brush originalForegroundColor;

        public controlarDinero()
        {
            InitializeComponent();
            originalForegroundColor = txtCantidad.Foreground;  // Guardamos el color original de Foreground
            cantidadDinero = 0.00;  // Inicializamos con 0
            Actualizar();  // Actualizamos el valor en el control al inicio
        }

        // Propiedad privada para la cantidad de dinero
        private double cantidadDinero;

        // Propiedad pública para acceder a la cantidad de dinero
        public double CantidadDinero
        {
            get { return cantidadDinero; }
            set
            {
                cantidadDinero = value;
                Actualizar();  // Llamamos a actualizar cada vez que se cambia el valor
            }
        }

        // Propiedad para obtener el texto de txtCantidad
        public string TextoCantidad
        {
            get { return txtCantidad.Content.ToString(); }
        }

        // Propiedad para obtener o establecer el color de Foreground de txtCantidad
        public Brush ForegroundColor
        {
            get { return txtCantidad.Foreground; }
            set { txtCantidad.Foreground = value; }  // Permite cambiar el color desde fuera
        }

        // Método para actualizar el label con la cantidad actual y cambiar el color
        public void Actualizar()
        {
            txtCantidad.Content = $"${cantidadDinero:F2}";  // Formateamos la cantidad a dos decimales
            ActualizarColorForeground();  // Actualizamos el color de Foreground
        }

        // Método para actualizar el color de Foreground según la cantidad
        private void ActualizarColorForeground()
        {
            if (cantidadDinero < 0)
            {
                // Si la cantidad es negativa, cambiamos el color a rojo
                ForegroundColor = Brushes.Red;
            }
            else
            {
                // Si la cantidad es mayor o igual a 0, restablecemos el color original
                ForegroundColor = originalForegroundColor;
            }
        }

        // Método para depositar dinero
        public void Depositar(double cantidad)
        {
            CantidadDinero += cantidad;
        }

        // Método para retirar dinero
        public void Retirar(double cantidad)
        {
            CantidadDinero -= cantidad;
        }
    }

}
