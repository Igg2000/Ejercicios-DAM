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
    /// Lógica de interacción para ViajesPendientes.xaml
    /// </summary>
    public partial class ViajesPendientes : Page
    {
        public ViajesPendientes()
        {
            InitializeComponent();
            CargarDatosDePrueba();
        }

        private void CargarDatosDePrueba()
        {
            // Lista de datos de prueba
            var datosViajes = new List<Viaje>
            {

                new Viaje { Nombre = "Juan Pérez", Dni = "12345678A", DatosViaje = "Origen: Madrid, Destino: Barcelona, Fecha: 15/12/2024, Transporte: Tren" },
                new Viaje { Nombre = "Ana López", Dni = "23456789B", DatosViaje = "Origen: Valencia, Destino: Sevilla, Fecha: 20/12/2024, Transporte: Autobús" },
                new Viaje { Nombre = "Carlos Martínez", Dni = "34567890C", DatosViaje = "Origen: Bilbao, Destino: Málaga, Fecha: 25/12/2024, Transporte: Avión" },
                new Viaje { Nombre = "Lucía García", Dni = "45678901D", DatosViaje = "Origen: Zaragoza, Destino: Granada, Fecha: 30/12/2024, Transporte: Auto" },
                new Viaje { Nombre = "Pedro Gómez", Dni = "56789012E", DatosViaje = "Origen: A Coruña, Destino: Vigo, Fecha: 01/01/2025, Transporte: Tren" },
                new Viaje { Nombre = "Elena Ruiz", Dni = "67890123F", DatosViaje = "Origen: Toledo, Destino: Salamanca, Fecha: 10/01/2025, Transporte: Autobús" },
                new Viaje { Nombre = "Mario Sánchez", Dni = "78901234G", DatosViaje = "Origen: León, Destino: Burgos, Fecha: 15/01/2025, Transporte: Tren" },
                new Viaje { Nombre = "Carmen Torres", Dni = "89012345H", DatosViaje = "Origen: Alicante, Destino: Murcia, Fecha: 20/01/2025, Transporte: Avión" },
                new Viaje { Nombre = "Luis Fernández", Dni = "90123456I", DatosViaje = "Origen: Valladolid, Destino: Pamplona, Fecha: 25/01/2025, Transporte: Auto" },
                new Viaje { Nombre = "Isabel Díaz", Dni = "01234567J", DatosViaje = "Origen: Logroño, Destino: Santander, Fecha: 30/01/2025, Transporte: Autobús" },
                new Viaje { Nombre = "Sergio López", Dni = "12345678K", DatosViaje = "Origen: Gijón, Destino: Oviedo, Fecha: 05/02/2025, Transporte: Tren" },
                new Viaje { Nombre = "Paula Romero", Dni = "23456789L", DatosViaje = "Origen: Cáceres, Destino: Badajoz, Fecha: 10/02/2025, Transporte: Autobús" },
                new Viaje { Nombre = "Alberto Moreno", Dni = "34567890M", DatosViaje = "Origen: Huelva, Destino: Cádiz, Fecha: 15/02/2025, Transporte: Auto" },
                new Viaje { Nombre = "Marta Gutiérrez", Dni = "45678901N", DatosViaje = "Origen: Tarragona, Destino: Girona, Fecha: 20/02/2025, Transporte: Avión" },
                new Viaje { Nombre = "Raúl Blanco", Dni = "56789012O", DatosViaje = "Origen: Ibiza, Destino: Palma de Mallorca, Fecha: 25/02/2025, Transporte: Barco" },
                new Viaje { Nombre = "Nuria Ortega", Dni = "67890123P", DatosViaje = "Origen: Ceuta, Destino: Melilla, Fecha: 05/03/2025, Transporte: Avión" },
                new Viaje { Nombre = "Diego Álvarez", Dni = "78901234Q", DatosViaje = "Origen: Segovia, Destino: Ávila, Fecha: 10/03/2025, Transporte: Auto" },
                new Viaje { Nombre = "Clara Martín", Dni = "89012345R", DatosViaje = "Origen: La Rioja, Destino: Zaragoza, Fecha: 15/03/2025, Transporte: Tren" },
                new Viaje { Nombre = "Javier Vega", Dni = "90123456S", DatosViaje = "Origen: Madrid, Destino: Toledo, Fecha: 20/03/2025, Transporte: Autobús" },
                new Viaje { Nombre = "Silvia Castro", Dni = "01234567T", DatosViaje = "Origen: Alicante, Destino: Valencia, Fecha: 25/03/2025, Transporte: Auto" },
                new Viaje { Nombre = "Fernando Jiménez", Dni = "12345678U", DatosViaje = "Origen: Salamanca, Destino: León, Fecha: 30/03/2025, Transporte: Tren" },
                new Viaje { Nombre = "Laura Peña", Dni = "23456789V", DatosViaje = "Origen: Málaga, Destino: Granada, Fecha: 05/04/2025, Transporte: Avión" },
                new Viaje { Nombre = "Daniel Pardo", Dni = "34567890W", DatosViaje = "Origen: Sevilla, Destino: Córdoba, Fecha: 10/04/2025, Transporte: Autobús" },
                new Viaje { Nombre = "Adriana Mena", Dni = "45678901X", DatosViaje = "Origen: Bilbao, Destino: Vitoria, Fecha: 15/04/2025, Transporte: Tren" },
                new Viaje { Nombre = "Rubén Herrera", Dni = "56789012Y", DatosViaje = "Origen: Vigo, Destino: Santiago de Compostela, Fecha: 20/04/2025, Transporte: Auto" },
                new Viaje { Nombre = "Patricia Vidal", Dni = "67890123Z", DatosViaje = "Origen: Cádiz, Destino: Huelva, Fecha: 25/04/2025, Transporte: Autobús" },
                new Viaje { Nombre = "Álvaro Navarro", Dni = "78901234A", DatosViaje = "Origen: San Sebastián, Destino: Pamplona, Fecha: 30/04/2025, Transporte: Avión" },
                new Viaje { Nombre = "Rocío Soler", Dni = "89012345B", DatosViaje = "Origen: Zaragoza, Destino: Logroño, Fecha: 05/05/2025, Transporte: Auto" },
                new Viaje { Nombre = "Iván Rivas", Dni = "90123456C", DatosViaje = "Origen: Santander, Destino: Gijón, Fecha: 10/05/2025, Transporte: Tren" },
                new Viaje { Nombre = "Verónica Cabrera", Dni = "01234567D", DatosViaje = "Origen: Ávila, Destino: Segovia, Fecha: 15/05/2025, Transporte: Autobús" },

            };

            // Asignar los datos a la DataGrid
            DataGridViajes.ItemsSource = datosViajes;
        }
    }

    // Clase para representar un viaje
    public class Viaje
    {
        public string Nombre { get; set; }
        public string Dni { get; set; }
        public string DatosViaje { get; set; }
    }
}

