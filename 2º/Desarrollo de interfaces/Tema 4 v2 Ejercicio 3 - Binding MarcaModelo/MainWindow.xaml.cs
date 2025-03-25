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

namespace Tema_4_v2_Ejercicio_3
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private List<Marca> marcas;
        public MainWindow()
        {
            InitializeComponent();

            // Creo las marcas
            Marca ford = new Marca("Ford");
            Marca hyundai = new Marca("Hyundai");
            Marca seat = new Marca("Seat");
            Marca alfaRomeo = new Marca("Alfa Romeo");

            // agrego modelos
            ford.AgregarModelo(new Modelo("Fiesta"));
            ford.AgregarModelo(new Modelo("Mustang"));
            ford.AgregarModelo(new Modelo("Focus"));
            ford.AgregarModelo(new Modelo("Explorer"));

            hyundai.AgregarModelo(new Modelo("Elantra"));
            hyundai.AgregarModelo(new Modelo("Tucson"));
            hyundai.AgregarModelo(new Modelo("Santa Fe"));
            hyundai.AgregarModelo(new Modelo("Kona"));

            seat.AgregarModelo(new Modelo("Ibiza"));
            seat.AgregarModelo(new Modelo("Leon"));
            seat.AgregarModelo(new Modelo("Ateca"));
            seat.AgregarModelo(new Modelo("Arona"));

            alfaRomeo.AgregarModelo(new Modelo("Giulia"));
            alfaRomeo.AgregarModelo(new Modelo("Stelvio"));
            alfaRomeo.AgregarModelo(new Modelo("GTV"));
            alfaRomeo.AgregarModelo(new Modelo("Giulietta"));


            marcas= new List<Marca>();
            marcas.Add(ford);
            marcas.Add(hyundai);
            marcas.Add(seat);
            marcas.Add(alfaRomeo);
            
            /*
                // Esto es de prueba
                MostrarMarcaModelos(ford);
                MostrarMarcaModelos(hyundai);
                MostrarMarcaModelos(seat);
                MostrarMarcaModelos(alfaRomeo);
            */

            //ahora añado las marcas al combo 
            foreach (var marca in marcas)
            {
                cbMarca.Items.Add(marca.Nombre);
            }
        }

        public static void MostrarMarcaModelos(Marca marca)
        {
            string mensaje = $"Marca: {marca.Nombre}\nModelos:\n";
            foreach (var modelo in marca.Modelos)
            {
                mensaje += $"- {modelo.Nombre}\n";
            }

            // Mostrar el mensaje en una MessageBox
            MessageBox.Show(mensaje, "Modelos de " + marca.Nombre);
        }

        private void cbMarca_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            // Limpio el ComboBox de modelos
            cbModelo.Items.Clear();

            // convierto la marca seleccionada a String
            string marcaSeleccionada = cbMarca.SelectedItem as string;

            if (!string.IsNullOrEmpty(marcaSeleccionada))
            {
                // busco la marca en la lista
                Marca marca = marcas.Find(m => m.Nombre == marcaSeleccionada);

                if (marca != null)
                {
                    // y por ultimo lleno la lista de modelos con los modelos de la marca
                    foreach (var modelo in marca.Modelos)
                    {
                        cbModelo.Items.Add(modelo.Nombre);
                    }
                }
            }
        }
    }


    public class Modelo
    {
        public string Nombre { get; set; }

        public Modelo(string nombre)
        {
            Nombre = nombre;
        }
    }

    public class Marca
    {
        public string Nombre { get; set; }
        public List<Modelo> Modelos { get; set; }

        public Marca(string nombre)
        {
            Nombre = nombre;
            Modelos = new List<Modelo>();
        }

 
        public void AgregarModelo(Modelo modelo)
        {
            Modelos.Add(modelo);
        }
    }


}
