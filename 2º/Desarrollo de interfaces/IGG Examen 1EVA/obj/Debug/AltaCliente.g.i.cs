﻿#pragma checksum "..\..\AltaCliente.xaml" "{8829d00f-11b8-4213-878b-770e8597ac16}" "06813DED8BAB1C1C520E47C47C17FE0D72E97656F850AFA2877FD79A39D22A78"
//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

using IGG_Examen_1EVA;
using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Shell;


namespace IGG_Examen_1EVA {
    
    
    /// <summary>
    /// AltaCliente
    /// </summary>
    public partial class AltaCliente : System.Windows.Controls.Page, System.Windows.Markup.IComponentConnector {
        
        
        #line 43 "..\..\AltaCliente.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox TextBoxNombre;
        
        #line default
        #line hidden
        
        
        #line 48 "..\..\AltaCliente.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox TextBoxApellidos;
        
        #line default
        #line hidden
        
        
        #line 54 "..\..\AltaCliente.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.DatePicker DatePickerUltimaVisita;
        
        #line default
        #line hidden
        
        
        #line 58 "..\..\AltaCliente.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.ComboBox ComboBoxColorUnas;
        
        #line default
        #line hidden
        
        
        #line 68 "..\..\AltaCliente.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox TextBoxAlergenos;
        
        #line default
        #line hidden
        
        
        #line 72 "..\..\AltaCliente.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.ComboBox ComboBoxMasajeFavorito;
        
        #line default
        #line hidden
        
        
        #line 82 "..\..\AltaCliente.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button BotonGuardarCliente;
        
        #line default
        #line hidden
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Uri resourceLocater = new System.Uri("/IGG Examen 1EVA;component/altacliente.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\AltaCliente.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            this.TextBoxNombre = ((System.Windows.Controls.TextBox)(target));
            return;
            case 2:
            this.TextBoxApellidos = ((System.Windows.Controls.TextBox)(target));
            return;
            case 3:
            this.DatePickerUltimaVisita = ((System.Windows.Controls.DatePicker)(target));
            return;
            case 4:
            this.ComboBoxColorUnas = ((System.Windows.Controls.ComboBox)(target));
            return;
            case 5:
            this.TextBoxAlergenos = ((System.Windows.Controls.TextBox)(target));
            return;
            case 6:
            this.ComboBoxMasajeFavorito = ((System.Windows.Controls.ComboBox)(target));
            return;
            case 7:
            this.BotonGuardarCliente = ((System.Windows.Controls.Button)(target));
            
            #line 82 "..\..\AltaCliente.xaml"
            this.BotonGuardarCliente.Click += new System.Windows.RoutedEventHandler(this.BotonGuardarCliente_Click);
            
            #line default
            #line hidden
            return;
            }
            this._contentLoaded = true;
        }
    }
}

