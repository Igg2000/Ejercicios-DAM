   M S B A M L   `   `   `  ����M  ITema 5 Ejercicio 4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null7 clr-namespace:Tema_5_Ejercicio_4Tema_5_Ejercicio_4  5   	   J FComponenteBanco, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullJ6clr-namespace:ComponenteBanco;assembly=ComponenteBancoComponenteBanco 5   	   #    Tema_5_Ejercicio_4.MainWindow   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   2local clr-namespace:Tema_5_Ejercicio_4     5   	   RComponenteBanco6clr-namespace:ComponenteBanco;assembly=ComponenteBanco     5   	     � Title$  
MainWindow��5	   	   $	��400��6   $	��600��6)   ���#0A47A9.��5
      � $��
20,0,20,20q�6    � RowDefinitions 5   
   �� 5      $
��Auto �6   �� 5      $��* �6   .+�5   
   � $��0��6   $��Stretch=�6   $	��Top=�6:   $��40��6R    � ColumnDefinitions 5      �� 5      $
��Auto �6#   �� 5      $��* �6#   �� 5      $
��Auto �6#   .+�5      �� $	��ATM��6   $
��Left=�6"   $��Center=�6=   $
��10,0q�6X   $��0��6f   
�������$��24(�6�   $
��Bold"�6�   �� 5!      $��Card Return��6   $��Right=�6*   $��Center=�6F   $
��10,0q�6a   $��2��6o   ���	#7FFFFFFF$��16(�6�   $
��Bold"�6�   5"      � 5%   
   $��1��6    5'      �� 5(      $��* �6#   �� 5)      $��3* �6#   .+�5-      �� $��0��6   $	��Top=�6)   $��10q�6A   .+�5.      �� $��Welcome��6   
�������$��16(�6>   $��0,20,0,0q�6L   �� 5/      $��Ignacio Garcia��6   
�������$��18(�6E   $
��Bold"�6S   �� 51      $��0,30,0,0q�6   .+�52      �� $��
Account #1��6    
�������$��16(�6E   %  ComponenteBanco.controlarDinero  53      -   5          Name$ dineroCuenta��53   6   $��24(�6L   $
��Bold"�6Z      ForegroundColor
 �����6l   �� 55      $��
Savings #2��6    
�������$��16(�6E   $��0,20,0,0q�6S   �� 56      $
��$795��6    
�������$��24(�6?   $
��Bold"�6M   58      59      �� 5<      $��1��6   $��Center=�6)   $��Center=�6F   $	��350��6a   .+�5=      A�  A� Columns$ 2��6    A� Rows$ 4��6*   $��Center=�63   $	��Top=�6P   $	��250��6h   $	��350��6u   .+�5>      �� -   5         ��Name$ bGetCash��5>      $��Get Cash��6/   ���#5AC4F8
�������$��16(�6j   $��5q�6x   6�   �� 5?      -   5        $ bDeposit��5?      $��Deposit��6/   ���#5AC4F8
�������$��16(�6i   $��5q�6w   6�   �� 5@      -   5        $ 	bPayments��5@      $��Payments��60   ���#5AC4F8
�������$��16(�6k   $��5q�6y   6�   �� 5A      -   5        $ bCreditCard��5A      $��Credit Card��62   ���#5AC4F8
�������$��16(�6p   $��5q�6~   6�   �� 5B      -   5        $ bAccountSettings��5B      $��Account Settings��67   ���#5AC4F8
�������$��16(�6z   $��5q�6�   6�   �� 5C      -   5        $ bOther��5C      $��Other��6-   ���#38598F���	#7FFFFFFF$��16(�6i   $��5q�6w   6�   5D      A� 5E      $ 2��6   $ 1��6*   $��Center=�63   $	��Top=�6P   $��50��6h   $	��350��6t   ���	#FFFF4F78.+�5F      �� -   5         ��Name$ cantidadAModificar��5F      $��Center=�6:   	 �� TextWrapping$
	 Wrap=�6W   $��$0,00��6k   $��Center=�6x   $	��120��6�   $��16(�6�   
�������$
��Bold"�6�   $��Center=�6�   ��6�   Z� ��6�   Z� 6�   �� 5H      $��     Quick Cash     >��6   $��Center=�6?   $��Center=�6\   $��
0,10,10,10q�6w   ���	#7FFFFFFF$��16(�6�   $
��Bold"�6�   ��6�   Z� 6�   5I      5J      5K      5L      5M      