﻿#pragma checksum "..\..\AgendarCita.xaml" "{8829d00f-11b8-4213-878b-770e8597ac16}" "7F8060749FE2726B247AE0ED1C1953C623D4CF9E6C8617AB3F67DEDE4578DD2A"
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
    /// AgendarCita
    /// </summary>
    public partial class AgendarCita : System.Windows.Controls.Page, System.Windows.Markup.IComponentConnector {
        
        
        #line 43 "..\..\AgendarCita.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox TextBoxNombre;
        
        #line default
        #line hidden
        
        
        #line 48 "..\..\AgendarCita.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox TextBoxApellidos;
        
        #line default
        #line hidden
        
        
        #line 62 "..\..\AgendarCita.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.DatePicker DatePickerFecha;
        
        #line default
        #line hidden
        
        
        #line 68 "..\..\AgendarCita.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox TextBoxHora;
        
        #line default
        #line hidden
        
        
        #line 74 "..\..\AgendarCita.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.ListBox ListBoxServicios;
        
        #line default
        #line hidden
        
        
        #line 85 "..\..\AgendarCita.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button BotonGuardarCita;
        
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
            System.Uri resourceLocater = new System.Uri("/IGG Examen 1EVA;component/agendarcita.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\AgendarCita.xaml"
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
            this.DatePickerFecha = ((System.Windows.Controls.DatePicker)(target));
            return;
            case 4:
            this.TextBoxHora = ((System.Windows.Controls.TextBox)(target));
            
            #line 68 "..\..\AgendarCita.xaml"
            this.TextBoxHora.Loaded += new System.Windows.RoutedEventHandler(this.TextBox_Loaded);
            
            #line default
            #line hidden
            
            #line 68 "..\..\AgendarCita.xaml"
            this.TextBoxHora.LostFocus += new System.Windows.RoutedEventHandler(this.TextBox_LostFocus);
            
            #line default
            #line hidden
            
            #line 68 "..\..\AgendarCita.xaml"
            this.TextBoxHora.GotFocus += new System.Windows.RoutedEventHandler(this.TextBox_GotFocus);
            
            #line default
            #line hidden
            return;
            case 5:
            this.ListBoxServicios = ((System.Windows.Controls.ListBox)(target));
            return;
            case 6:
            this.BotonGuardarCita = ((System.Windows.Controls.Button)(target));
            
            #line 85 "..\..\AgendarCita.xaml"
            this.BotonGuardarCita.Click += new System.Windows.RoutedEventHandler(this.BotonGuardarCita_Click);
            
            #line default
            #line hidden
            return;
            }
            this._contentLoaded = true;
        }
    }
}

