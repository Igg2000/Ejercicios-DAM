Algoritmo ejercicio22
	
	x,a,i,cont,guion es entero;
	car es caracter;
	
	//Como en pseudocodigo hay que limitar los arrays lo limito a 50 por ejemplo
	Dimension x[50];
	
	//inicializamos todo en 0
	cont<-0;
	a<-0;
	guión<-0;
	
	//Le pedimos al usuario que escriba el numero digito a digito
	Escribir "Escribe un numero digito a digito";
	repetir 
		leer car;
		//Comparamos si el caracter introducido es un - en el primer ciclo o un numero del 0 al 9
		si car=='-' y cont==0 o car=='0' o car=='1' o car=='2' o car=='3' o car=='4' o car=='5' o car=='6' o car=='7' o car=='8' o car=='9' Entonces
			//Si es el primer ciclo del bucle y has introducido un guión, creamos una variable para indicar que hemos introducido un guión en la primera posicion
			//Si no es el caso convertimos el caracter introducido a numero y lo metemos en un array, ademas sumamos 1 a un contador que nos servirá para saber luego en que posicion acaba el numero
			si cont==0 y car=='-'
				guion<-guion+1;
			SiNo
				x[cont]<-ConvertirANumero(car);
				cont<-cont+1;
			FinSi
		sino
			//si el caracter introducido no es - en el primer ciclo del bucle o un numero del 0 al 9 sumamos 1 a la variable "a" para salir del bucle
			a<-1;
		FinSi
		
	Hasta Que a==1
	
	
	//si hay un guion lo introducimos antes de introducir el numero
	si guion==1
		escribir sin saltar "-";
	FinSi
	//hacemos un bucle que recorra y escriba todo el array hasta el ultimo numero introducido, que sería cont-1
	Para i<-0 Hasta cont-1 Con Paso 1 Hacer
		escribir Sin Saltar x[i];
	Fin Para
	
FinAlgoritmo
