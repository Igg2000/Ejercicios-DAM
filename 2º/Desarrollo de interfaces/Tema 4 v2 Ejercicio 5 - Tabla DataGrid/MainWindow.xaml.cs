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

namespace Tema_4_v2_Ejercicio_5
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public List<Persona> personas { get; set; }
        public MainWindow()
        {
            InitializeComponent();
            personas = new List<Persona>
            {
            new Persona { Nombre = "Lola",      Edad = 34,  Hijos = 1 },
            new Persona { Nombre = "Alfredo",   Edad = 25,  Hijos = 2 },
            new Persona { Nombre = "Marina",    Edad = 46,  Hijos = 0 },
            new Persona { Nombre = "Sebastian", Edad = 50,  Hijos = 4 }
            };

            // Ordena por Hijos de mayor a menor
            personas = personas.OrderByDescending(p => p.Hijos).ToList();

            //dg.ItemsSource = personas;
            DataContext = this;
        }
    }

    public class Persona
    {
        public string Nombre { get; set; }
        public int Edad { get; set; } 
        public  int Hijos { get; set; }
    }
}

