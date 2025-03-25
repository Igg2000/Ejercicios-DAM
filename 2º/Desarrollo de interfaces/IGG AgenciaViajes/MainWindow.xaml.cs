using System.ComponentModel; // Para INotifyPropertyChanged
using System.Runtime.CompilerServices; // Para [CallerMemberName]
using System.Windows;

namespace IGG_AgenciaViajes
{
    public partial class MainWindow : Window, INotifyPropertyChanged
    {
        private string _bienvenidaTexto;

        public MainWindow()
        {
            InitializeComponent();

            // Centrar la ventana en la pantalla al abrir
            this.WindowStartupLocation = WindowStartupLocation.CenterScreen;

            // Establece el contexto de datos para el binding
            DataContext = this;

            // Texto inicial
            BienvenidaTexto = "Bienvenido";

            // Navega a la primera página (Login)
            MainFrame.Navigate(new Login());
        }

        // Propiedad enlazada al TextBlock
        public string BienvenidaTexto
        {
            get => _bienvenidaTexto;
            set
            {
                if (_bienvenidaTexto != value)
                {
                    _bienvenidaTexto = value;
                    OnPropertyChanged(); // Notifica cambios
                }
            }
        }

        // Implementación de INotifyPropertyChanged
        public event PropertyChangedEventHandler PropertyChanged;

        protected void OnPropertyChanged([CallerMemberName] string propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        // Evento del botón Menú (puedes usarlo para navegar)
        private void irAMenu(object sender, RoutedEventArgs e)
        {
            MainFrame.Navigate(new MenuPrincipal());
        }
    }
}
