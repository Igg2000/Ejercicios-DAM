   M S B A M L   `   `   `  ����a  ]Ignacio Garcia Garcia Proyecto DI 1Eva, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null_4clr-namespace:Ignacio_Garcia_Garcia_Proyecto_DI_1Eva&Ignacio_Garcia_Garcia_Proyecto_DI_1Eva  5   	   7    1Ignacio_Garcia_Garcia_Proyecto_DI_1Eva.MainWindow   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   Flocal4clr-namespace:Ignacio_Garcia_Garcia_Proyecto_DI_1Eva     5   	     � Title$  
MainWindow��5      $	��400��6   $	��500��6!    � 	Resources 5	         TextBox.Static.Border �� Color  TextBox.MouseOver.Border  TextBox.Focus.Border  TextBoxStyle1 �� 
TargetType �� Property �� Value-  'System.Windows.Input.KeyboardNavigation �� 
TargetType ��Name J� SnapsToDevicePixels	 ��Name
 �� Triggers P� Property P� Value �� 
TargetName �� Triggers ]� 
Conditions �� Property �� Value��%�  &	        &	 #     &	 F     &	 i     7   7  7  �� 5
   
   $ 	#FFABAdB3��68   �� 5   
   $ 	#FF7EB4EA��6;   �� 5   
   $ 	#FF569DE5��67   �� 5   
   " ��6&   .�5      ��  � ��# � ��6+   �� 5       � ��8   6,   �� 5       � ��# � ��6+   �� 5       � ��$ 1q�60   �� 5       �@ TabNavigation$
 None=�6A   �� 5       � ��$
 Left=�6;   �� 5       �@�FocusVisualStyle 61   Z� �� 5       �@J�	AllowDrop . 6*   �� 5       �@��PanningMode$ VerticalFirst=�69   �� 5       �@��IsFlicksEnabled .  67   �� 5       � �� 5      �� 5      " ��6&   .R�5      �� $ border��6!   #��z��61   #��z��6[   #��z��6�    . ._�5      �� $	 PART_ContentHost��6+   |�.  $��Hidden=�6W   $��Hidden=�6~   5      
 5      P� 5       � {� .  . �5    "   �� $ border��6<    �@J�Opacity$
 0.56Q�6P   5!      P� 5"       �@J�IsMouseOver . . �5#   "   �� $ border��6@   8   � ��6T   5$      P� 5%       �@J�IsKeyboardFocused . . �5&   "   �� $ border��6@   8   � ��6T   5'      5)      5+       5,      ]� 5-       5.      �� 5/      + �@��#IsInactiveSelectionHighlightEnabled . 6S   �� 50       �@��IsSelectionActive .  6A   ./�52      ��  �@��SelectionBrush# � /�67   53      55      56      .��59      � ��5:   
   
� 5;      .��5<      �  � Color$ 	#FF1F68FF��6   � 5=      $ 	#FF0C3286��6    � Offset$ 1Q�61   5>      .+�5@   
   � $��Center=�6   $	��Top=�6,   $��0,10,0,0q�6D   .+�5A      �� $��Viajes Nacho��6   $��Center=�6+   $	��Top=�6H   $��36(�6`   $
��Bold"�6n   ���	#33FFFFFF$��Center=�6�   �� 5B      -   5         ��Name$ InicioSesionDNI��5B      #���  6/   $��Center=�6W    �� TextWrapping$
 Wrap=�6t   $	��DNI��6�   $��Center=�6�   $��36(�6�   $��Center=�6�   $��20,0,0,0q�6�   ���	#33FFFFFF���	#4CFFFFFF���	#00ABADB3$��86��6Y  $	��394��6e  �� 5C      -   5         ��Name$ botonInicioSesion��5C      $��Iniciar Sesion��60   $��Center=�6I   $��	0,260,0,0q�6f   $��36(�6y   
�������$	��Top=�6�   $��73��6�   $	��347��6�   ��5D      �� 5E       �� EndPoint$ 0.5,1&�6*    �� 
StartPoint$ 0.5,0&�6;   .��5F      � $ 	#FFFFB327��6'   � 5G      $ 	#FF7B4700��6'   $ 1Q�69   5H      5J      5K      5L      5M      