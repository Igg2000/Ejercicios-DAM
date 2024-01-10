Algoritmo ejercicio40
	
	num1,num2,op es entero;
	
	Escribir "Introduce un numero";
	leer num1;
	
	
	Escribir "///////////////////////////////////////";
	Escribir "1. Sumar";
	Escribir "2. Restar";
	Escribir "3. Multiplicar";
	Escribir "4. Dividir";
	Escribir "///////////////////////////////////////";
	Escribir "Elige una opcion : ";
	leer op;
	
	si op>4 o op<1
		Repetir
			escribir "Debes introducir un valor correcto";
			leer op;
		Hasta Que op<5 y op>0
	FinSi
	
	
	Escribir "Introduce otro numero";
	leer num2;
	
	Segun op Hacer
		1:
			escribir num1 " + " num2 " = " num1+num2;
		2:
			escribir num1 " - " num2 " = " num1-num2;
		3:
			escribir num1 " x " num2 " = " num1*num2;
		4:
			escribir num1 " / " num2 " = " num1/num2;
	Fin Segun
	
FinAlgoritmo
