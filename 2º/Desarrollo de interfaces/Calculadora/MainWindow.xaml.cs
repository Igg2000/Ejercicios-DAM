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

namespace Calculadora
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

        private void b1(object sender, RoutedEventArgs e)
        {
            pantalla.Text= pantalla.Text+"1";
            //MessageBox.Show(pantalla.Text);
        }

        private void b2(object sender, RoutedEventArgs e)
        {
            pantalla.Text = pantalla.Text + "2";
        }

        private void b3(object sender, RoutedEventArgs e)
        {
            pantalla.Text = pantalla.Text + "3";
        }

        private void b4(object sender, RoutedEventArgs e)
        {
            pantalla.Text = pantalla.Text + "4";
        }

        private void b5(object sender, RoutedEventArgs e)
        {
            pantalla.Text = pantalla.Text + "5";
        }

        private void b6(object sender, RoutedEventArgs e)
        {
            pantalla.Text = pantalla.Text + "6";
        }

        private void b7(object sender, RoutedEventArgs e)
        {
            pantalla.Text = pantalla.Text + "7";
        }

        private void b8(object sender, RoutedEventArgs e)
        {
            pantalla.Text = pantalla.Text + "8";
        }

        private void b9(object sender, RoutedEventArgs e)
        {
            pantalla.Text = pantalla.Text + "9";
        }

        private void bresultado(object sender, RoutedEventArgs e)
        {
            // 1.Suma       2.Resta       3.Multiplicacion      4.Division
            int op=0;

            if (pantalla.Text.Contains('+'))
                op = 1;
            else if (pantalla.Text.Contains('-'))
                op = 2;
            else if (pantalla.Text.Contains('x'))
                op = 3;
            else if (pantalla.Text.Contains('/'))
                op = 4;



            String[] cads= pantalla.Text.Split('+','-','x','/');


            if (cads.Length == 2) // Asegúrate de que hay exactamente dos operandos
            {
                int num1;
                int num2;

                // Intenta convertir las cadenas a enteros
                if (int.TryParse(cads[0], out num1) && int.TryParse(cads[1], out num2))
                {
                    switch (op)
                    {
                        case 1: // Suma
                            pantalla.Text=(num1 + num2).ToString();
                            break;
                        case 2: // Resta
                            pantalla.Text = (num1 - num2).ToString();
                            break;
                        case 3: // Multiplicación
                            pantalla.Text = (num1 * num2).ToString();
                            break;
                        case 4: // División
                            if (num2 != 0) // Verifica división por cero
                            {
                                pantalla.Text = (num1 / num2).ToString();
                            }
                            else
                            {
                                pantalla.Text = ("Error: División por cero");
                            }
                            break;
                        default:
                            pantalla.Text = ("Operación no válida.");
                            break;
                    }
                }
                else
                {
                    pantalla.Text = ("Error: Ingrese números válidos.");
                }
            }
            else
            {
                pantalla.Text = ("Error: Formato de entrada no válido.");
            }
        }

        private void bsumar(object sender, RoutedEventArgs e)
        {
            pantalla.Text = pantalla.Text + "+";
        }

        private void bMultiplicar(object sender, RoutedEventArgs e)
        {
            pantalla.Text = pantalla.Text + "x";
        }

        private void bRestar(object sender, RoutedEventArgs e)
        {
            pantalla.Text = pantalla.Text + "-";
        }

        private void bDividir(object sender, RoutedEventArgs e)
        {
            pantalla.Text = pantalla.Text + "/";
        }

        private void bComa(object sender, RoutedEventArgs e)
        {
            pantalla.Text = pantalla.Text + ",";
        }

        private void bBorrar(object sender, RoutedEventArgs e)
        {
            pantalla.Text = "";
        }

        private void b0(object sender, RoutedEventArgs e)
        {
            pantalla.Text = pantalla.Text + "0";
        }
    }
}
