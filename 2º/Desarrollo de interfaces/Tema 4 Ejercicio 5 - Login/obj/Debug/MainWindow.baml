   M S B A M L   `   `   `  ����M  ITema 4 Ejercicio 5, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null7 clr-namespace:Tema_4_Ejercicio_5Tema_4_Ejercicio_5  5   	   #    Tema_4_Ejercicio_5.MainWindow   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   2local clr-namespace:Tema_4_Ejercicio_5     5   	     � Title$  
MainWindow��5   	   $	��700��6   $	��500��6)    � 	Resources 5	         TextBox.Static.Border �� Color  TextBox.MouseOver.Border  TextBox.Focus.Border  TextBoxStyle1 �� 
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
 0.56Q�6P   5!      P� 5"       �@J�IsMouseOver . . �5#   "   �� $ border��6@   8   � ��6T   5$      P� 5%       �@J�IsKeyboardFocused . . �5&   "   �� $ border��6@   8   � ��6T   5'      5)      5+       5,      ]� 5-       5.      �� 5/      + �@��#IsInactiveSelectionHighlightEnabled . 6S   �� 50       �@��IsSelectionActive .  6A   ./�52      ��  �@��SelectionBrush# � /�67   53      55      56      .��57      � ��58   
   
� 59      .��5:      �  � Color$ 	#FF1F68FF��6   � 5;      $ 	#FF0C3286��6    � Offset$ 1Q�61   5<      .+�5>   
   � $��Center=�6   $	��664��6,   $	��Top=�69   $	��480��6Q   $��0,10,0,0q�6]   .+�5?      �� $��Registrarse��6   $
��Left=�6*   $��41��6E   $��	71,10,0,0q�6Q   $	��Top=�6d   $	��153��6|   $��24(�6�   $
��Bold"�6�   
�������$��Center=�6�   �� 5@      $��Iniciar sesion��6   $
��Left=�6-   $��41��6H   $��
229,10,0,0q�6T   $	��Top=�6h   $	��175��6�   $��24(�6�   $
��Bold"�6�   ���	#33FFFFFF$��Center=�6�   �� 5A      -   5         ��Name$ nombreRegistro��5A      $
��Left=�6.   $��89��6I   $��
10,128,0,0q�6U    �� TextWrapping$
 Wrap=�6i   $��Nombre��6}   $	��Top=�6�   $	��456��6�   $��36(�6�   $��Center=�6�   $��20,0,0,0q�6�   ���	#33FFFFFF���	#4CFFFFFF���	#00ABADB368  �� 5B      -   5        $ correoRegistro��5B      #���  6.   $
��Left=�6V   $��89��6q   $��
10,243,0,0q�6}   $
 Wrap=�6�   $��Email��6�   $	��Top=�6�   $	��456��6�   $��36(�6�   $��Center=�6�   $��20,0,0,0q�6  ���	#33FFFFFF���	#4CFFFFFF���	#00ABADB36_  G� 5D      -   5         G�Name$ passRegistro��5D      $��Center=�60   $��	0,362,0,0q�6M   $	��Top=�6`   $	��456��6x   $��89��6�   $��36(�6�   $��Center=�6�   $��23,0,0,0q�6�   4  .System.Windows.Automation.AutomationProperties   HelpText$ Contraseña��6�    K� ZIndex$ 2��6�   ��5E      �� 5F      $ 	#33FFFFFF��6&   5H      �� 5I      -   5         ��Name$ botonRegistro��5I      $��Registrarte��6,   $��Center=�6B   $��82��6_   $��	0,530,0,0q�6k   $	��Top=�6~   $	��460��6�   $��36(�6�   
���������5J      �� 5K       �� EndPoint$ 0.5,1&�6*    �� 
StartPoint$ 0.5,0&�6;   .��5L      � $ 	#FFFFB327��6'   � 5M      $ 	#FF7B4700��6'   $ 1Q�69   5N      5P      �� 5Q      -   5         ��Name$ labelContraseña��5Q      $��Contraseña��6-   $
��Left=�6B   $��62��6]   $��
12,376,0,0q�6i   $	��Top=�6}   $	��261��6�   $��36(�6�   ���	#4CFFFFFF$ -1��6�   $��24,5,5,5q�6�   5R      5S      5T      