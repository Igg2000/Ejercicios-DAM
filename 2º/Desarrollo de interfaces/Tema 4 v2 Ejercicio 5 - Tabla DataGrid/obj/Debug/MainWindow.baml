   M S B A M L   `   `   `  ����P  LTema 4 v2 Ejercicio 5, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null=#clr-namespace:Tema_4_v2_Ejercicio_5Tema_4_v2_Ejercicio_5  5   	   &     Tema_4_v2_Ejercicio_5.MainWindow   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   5local#clr-namespace:Tema_4_v2_Ejercicio_5     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   ��5	      �� 5
   
    �� ImageSource$% /fondo practica 4 tema 4 v2.png��6   .��5      � $��Center=�6   $��Center=�6(   .+�5   
   &   System.Windows.Controls.DataGrid  -   5          Name$ dg��5      $��3��6@   $��20(�6P      CanUserAddRows .     AutoGenerateColumns .  ���	#FFA0153E��6   �� *
personas+ � 	Resources 5      )  #System.Windows.Controls.DataGridRow �� 
TargetType �� Property �� Value	 �� Triggers
 P� Property P� Value��%�  '        �� 5      "  6   .�5      ��  � �� �	#FFFF204E63   �� 5       � �� �#00224D63   	 5      P� 5      
 �@J�IsMouseOver . . �5      ��  � �� �#00224D6;   �� 5       � ��
 �����6;   5      P� 5      
 �@ 
IsSelected . . �5      ��  � �� �#5D0E416;   �� 5       � ��
 �����6;   5      5!      5"         Columns 5$      0  *System.Windows.Controls.DataGridTextColumn  5%      ,  &System.Windows.Controls.DataGridColumn   Header$ Nombre��6%   1  +System.Windows.Controls.DataGridBoundColumn   Binding 65   �� *Nombre+  5&      $
 Edad��6%    63   �� *Edad+  5'      $ Hijos��6%      SortMemberPath$ Hijos��6N    64   �� *Hijos+6N   5)      5*      5+      