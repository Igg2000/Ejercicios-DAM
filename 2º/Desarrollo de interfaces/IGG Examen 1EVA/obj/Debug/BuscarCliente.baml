   M S B A M L   `   `   `  ����J  FIGG Examen 1EVA, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null1clr-namespace:IGG_Examen_1EVAIGG_Examen_1EVA  5      #    IGG_Examen_1EVA.BuscarCliente   5      R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      /localclr-namespace:IGG_Examen_1EVA     5        N� Title$  BuscarCliente��5	      .��5      � ��5   
   �� 5       �� ImageSource$ 
/fondo.jpg��6    j� Stretch$ UniformToFill=�62    � RowDefinitions 5   
   �� 5      $
��Auto �6   �� 5      $��* �6    � ColumnDefinitions 5   
   �� 5      $��* �6   �� 5      $
��Auto �6   .+�5   
   �� $��0��6   $��0��6!   $��Buscar Clientes��5      $��36(�5      $��10q�5      $	��Top=�5      $��Center=�5      $
��Bold"�5       ���	#FFEEF5FF5!      �� 5$   
   $��1��6   $��2��6"   $��40,10,40,10q�66   $	��Top=�6K   .+�5&      �� $G��ABusque por nombre o apellido (Dejar en blanco para mostrar todo):��6   $��18(�5'      $��5q�5(      ���	#FFEEF5FF5)      � 5,      $
��0,10q�6    5-      �� 5.      $��* �6'   �� 5/      $
��Auto �6'   .+�53      �� -   5         ��Name$ TextBoxBusqueda��53      $��0��54      $��5q�55      $��35��56      $��16(�57      $��Center=�58      �� 5;      -   5         ��Name$ BotonBuscar��5;      $��Buscar��5<      $��1��5=      $��5q�5>      $��35��5?      $	��100��5@      ���	#FF176B87���	#FFEEF5FF$��16(�5C      $��Center=�5D      5E      5F      �� 5I      $��Resultados:��6   $��18(�6+   $��5q�69   ���	#FFEEF5FF6D   �� 5J      -   5         ��Name$ ListBoxResultados��5J      $��5q�61   $	��300��6<   $��16(�6I   ��5K      �� 5L      .R�5M      �� .+�5O      �� $��Nombre:��6(   $
��Bold"�67   �� 5P       �� Orientation$ 
Horizontal=�6)   .+�5Q   "   �� $��0,0,5,0q�6D   ��6,   �� *Nombre+6D   �� 5R   "   ��6,   �� *	Apellidos+5S      �� 5U      $��Última visita:��6(   $
��Bold"�6>   $��0,5,0,0q�6P   �� 5V      ��6(   �� *UltimaVisita+	 �� StringFormat$	 
dd/MM/yyyy���� 5Y      $��Color de uñas:��6(   $
��Bold"�6>   $��0,5,0,0q�6P   �� 5Z      ��6(   �� *	ColorUnas+�� 5]      $��
Alergenos:��6(   $
��Bold"�6:   $��0,5,0,0q�6L   �� 5^      ��6(   �� *	Alergenos+�� 5a      $��Masaje favorito:��6(   $
��Bold"�6@   $��0,5,0,0q�6R   �� 5b      ��6(   �� *MasajeFavorito+5c      5d      5f      �� 5k      $ 
Horizontal=�6   $��Center=�62   $��10q�6O   .+�5l      �� -   5        $ BotonCobrarCliente��5l      $��Cobrar Cliente��5m      $��5q�5n      $��50��5o      $	��150��5p      ���	#FF176B87���	#FFEEF5FF$��18(�5s      5t      5u      5w      5x      5y      