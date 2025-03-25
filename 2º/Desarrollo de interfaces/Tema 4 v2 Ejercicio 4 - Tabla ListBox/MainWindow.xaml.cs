using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
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

namespace Tema_4_vs_Ejercicio_4
{
    public partial class MainWindow : Window
    {
        public ObservableCollection<Persona> Personas { get; set; }
        public ICollectionView PersonasOrdenadas { get; set; }

        public MainWindow()
        {
            InitializeComponent();

            // Inicializar la colección de personas
            Personas = new ObservableCollection<Persona>
            {
                new Persona { Nombre = "Lola", Edad = 34, Hijos = 1 },
                new Persona { Nombre = "Alfredo", Edad = 25, Hijos = 2 },
                new Persona { Nombre = "Marina", Edad = 46, Hijos = 0 },
                new Persona { Nombre = "Sebastián", Edad = 50, Hijos = 4 }
            };

            // Crear la vista que va a ordenar las personas por edad
            PersonasOrdenadas = CollectionViewSource.GetDefaultView(Personas);
            PersonasOrdenadas.SortDescriptions.Add(new SortDescription("Edad", ListSortDirection.Ascending));

            // Establecer el DataContext de la ventana para la vinculación
            DataContext = this;
        }
    }

    // Definir la clase Persona
    public class Persona : INotifyPropertyChanged
    {
        private string _nombre;
        private int _edad;
        private int _hijos;

        public string Nombre
        {
            get => _nombre;
            set { _nombre = value; OnPropertyChanged("Nombre"); }
        }

        public int Edad
        {
            get => _edad;
            set { _edad = value; OnPropertyChanged("Edad"); }
        }

        public int Hijos
        {
            get => _hijos;
            set { _hijos = value; OnPropertyChanged("Hijos"); }
        }

        public event PropertyChangedEventHandler PropertyChanged;
        protected void OnPropertyChanged(string name)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
    }
}
