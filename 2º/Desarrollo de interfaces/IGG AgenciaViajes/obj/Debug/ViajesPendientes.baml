   M S B A M L   `   `   `  ����L  HIGG AgenciaViajes, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null5clr-namespace:IGG_AgenciaViajesIGG_AgenciaViajes  5      (    "IGG_AgenciaViajes.ViajesPendientes   5      R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      1localclr-namespace:IGG_AgenciaViajes     5        N� Title$  ViajesPendientes��5	      .��5      � ��5   
   �� 5       �� ImageSource$ /fondoAvion.jpg��6    � RowDefinitions 5   
   �� 5      $
��Auto �6   �� 5      $��* �6   .+�5   
   �� $��0��6   $��Listado de Viajes��5      $��36(�5      $��10q�5      $	��Top=�5      $��Center=�5      ���	#FFEEF5FF$
��Bold"�5      &   System.Windows.Controls.DataGrid  5   
   -   5          Name$ DataGridViajes��5       $��1��5         AutoGenerateColumns .  $��Stretch=�5"      $��Stretch=�5#      $��20q�5$      $��16(�5%      ���	#FF176B87���	#FFEEF5FF   HeadersVisibility$ Column=�5(         GridLinesVisibility$ 
Horizontal=�5)         
IsReadOnly .    CanUserAddRows .  	   Columns	 5.      0  *System.Windows.Controls.DataGridTextColumn  5/      ,  &System.Windows.Controls.DataGridColumn
   Header$
 Nombre��6%      Width5  /System.Windows.Controls.DataGridLengthConverter$ * 6P   1  +System.Windows.Controls.DataGridBoundColumn   Binding 65   �� *Nombre+6P     50      $	
 DNI��6%   $ * 6J    62   �� *Dni+6J     51      $
 Datos del Viaje��6%   $ 2* 6]    6>   �� *
DatosViaje+6]   53      54      56      