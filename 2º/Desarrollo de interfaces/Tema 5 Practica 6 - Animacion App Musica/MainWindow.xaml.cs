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
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Tema_5_Practica_6
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

        public class Artista
        {
            public string Nombre { get; set; }
            public string Genero { get; set; }
            public string Imagen { get; set; } // Ruta de la imagen, null si no hay imagen
            public Brush Fondo { get; set; } // Fondo por defecto
        }

        private void WindowLoaded(object sender, RoutedEventArgs e)
        {
            Storyboard Pantalla_de_carga = (Storyboard)FindResource("Pantalla_de_carga");
            Pantalla_de_carga.Begin();
        }

        private void caja1_MouseEnter(object sender, MouseEventArgs e)
        {
            Storyboard anim = (Storyboard)FindResource("zoomCaja1");
            anim.Begin();
        }

        private void caja2_MouseEnter(object sender, MouseEventArgs e)
        {
            Storyboard anim = (Storyboard)FindResource("zoomCaja2");
            anim.Begin();
        }

        private void caja3_MouseEnter(object sender, MouseEventArgs e)
        {
            Storyboard anim = (Storyboard)FindResource("zoomCaja3");
            anim.Begin();
        }

        private void caja4_MouseEnter(object sender, MouseEventArgs e)
        {
            Storyboard anim = (Storyboard)FindResource("zoomCaja4");
            anim.Begin();
        }

        private void caja5_MouseEnter(object sender, MouseEventArgs e)
        {
            Storyboard anim = (Storyboard)FindResource("zoomCaja5");
            anim.Begin();
        }

        private void caja1_MouseLeave(object sender, MouseEventArgs e)
        {
            Storyboard anim = (Storyboard)FindResource("zoomCaja1");
            anim.Stop();
        }

        private void caja2_MouseLeave(object sender, MouseEventArgs e)
        {
            Storyboard anim = (Storyboard)FindResource("zoomCaja2");
            anim.Stop();
        }

        private void caja3_MouseLeave(object sender, MouseEventArgs e)
        {
            Storyboard anim = (Storyboard)FindResource("zoomCaja3");
            anim.Stop();
        }

        private void caja4_MouseLeave(object sender, MouseEventArgs e)
        {
            Storyboard anim = (Storyboard)FindResource("zoomCaja4");
            anim.Stop();
        }

        private void caja5_MouseLeave(object sender, MouseEventArgs e)
        {
            Storyboard anim = (Storyboard)FindResource("zoomCaja5");
            anim.Stop();
        }
    }
}
