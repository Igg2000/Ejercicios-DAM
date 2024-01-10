Algoritmo ejercicio21
	
	Elegir,num es entero;
	fc,cf es numero;
	
	//creamos la estetica del menú
	escribir "////////////////////////////////////////////";
	escribir "1. Transformar de ºFahrenheit a ºCelsius";
	escribir "2. Transformar de ºCelsius a ºFahrenheit";
	escribir "3. Salir";
	escribir "////////////////////////////////////////////";
	escribir "";
	
	//Creamos un bucle que no permita que introduzcas una opcion que no sea 1,2 o 3
	Repetir
		escribir sin saltar "Elige una opcion valida: ";
		leer Elegir;
	Hasta Que Elegir<4 y Elegir>0
	
	//Creamos un switch que nos permita elegir una de las 3 opciones
	Segun Elegir Hacer
		1:
			Escribir "Introduce un numero";
			Leer num;
			//asignamos el valor de la variable que pasa de Fahrenheit a Celsius para que se entienda mejor
			fc<-(num-32)/1.8;
			Escribir num "º Fahrenheit equivalen a " fc "º Celsius" ;
		2:
			Escribir "Introduce un numero";
			Leer num;
			//asignamos el valor de la variable que pasa de Celsius a Fahrenheit para que se entienda mejor
			cf<- num * 1.8 + 32;
			Escribir num "º Celsius equivalen a " cf "º Fahrenheit" ;
		3:
			Escribir "Hasta luego";
	Fin Segun
	
FinAlgoritmo
