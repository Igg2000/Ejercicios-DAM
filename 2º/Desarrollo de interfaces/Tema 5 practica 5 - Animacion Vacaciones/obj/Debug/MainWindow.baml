   M S B A M L   `   `   `  ����L  HTema 5 practica 5, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null5clr-namespace:Tema_5_practica_5Tema_5_practica_5  5   	   "    Tema_5_practica_5.MainWindow   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   1localclr-namespace:Tema_5_practica_5     5   	   -   5          � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)    � 	Resources 5
         	animacion �� 
TargetName �� TargetProperty9  3System.Windows.Media.Animation.EasingDoubleKeyFrame O� KeyTime O� Value��%  &	        �� 5   
   .��5      U� $ image��6,   $ (UIElement.Opacity)�6J   .\�5        $ 00:00:00��6'   $ 0Q�6:     5      $ 00:00:02��6'   $ 1Q�6:   5      U� 5      $ 	textBlock��6,   $ (UIElement.Opacity)�6N   .\�5        $ 00:00:00��6'   $ 0Q�6:     5      $ 00:00:01��6'   $ 0Q�6:     5      $ 00:00:03��6'   $ 1Q�6:   5      U� 5      $ button��6,   $ (UIElement.Opacity)�6K   .\�5        $ 00:00:00��6'   $ 0Q�6:     5      $ 00:00:02��6'   $ 0Q�6:     5      $ 00:00:04��6'   $ 1Q�6:   5      5      5      .��5      � -   5         �Name$ ImagenFondo��5      .+�5   
   �� -   5         ��Name$ image��5      $
��Left=�6   $	��Top=�6:   $��/fondoVacaciones.jpg��6R   $
��Fill=�6p   �� 5   
   -   5         ��Name$ 	textBlock��5      $��Center=�6'   $
��Wrap=�6D   $	��Top=�6X   $��60(�6p   ���	#FFD3D2D2$
��Bold"�6�   	 J� Effect	 5       3  -System.Windows.Media.Effects.DropShadowEffect  5!      �� 5"   !   
 � Language$
 es-es�6%   $�Vamonos de vacaciones��66   6V   �� 5#   
   -   5         ��Name$ button��5#      $��Reserva tus vacaciones��6!   $��Center=�6B   $��0,0,0,84q�6_   $	��294��6q   $��78��6}   $��Bottom=�6�   ���	#FFED6A61$��24(�6�   $
��Bold"�6�   
���   ���6�   Z� 6�   5$      5%      