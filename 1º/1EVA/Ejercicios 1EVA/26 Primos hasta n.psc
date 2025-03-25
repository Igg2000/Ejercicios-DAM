Proceso ejercicio26
	
	MAX es entero;
	i,j,cont es entero;
	
	Escribir "Escribe el numero Maximo (debe ser menor a 500)";
	//hacemos un bucle que se repite hasta que introduzcas un numero valido
	repetir
		Leer MAX;
		//si introduces un numero incorrecto te sale un mensaje al respecto
		si no MAX<500
			Escribir "El numero introducido no es menor a 500, porfavor, introduce un numero valido";
		finsi
	hasta que MAX<500
	
	Escribir "Los numeros primos por debajo de " MAX " son : ";
	//hacemos un bucle que vaya hasta el numero maximo
	Para i<-1 Hasta MAX Con Paso 1 Hacer
		//inicializamos a 0 cada vez que empieze el bucle
		cont<-0;
		//hacemos un bucle que vaya hasta el valor actual de i con el que preguntamos si las divisiones entre todos los numeros hasta i, siendo divididos por i dan de resto 0
		//si dan de resto 0 significa que son divisibles
		Para j<-1 Hasta i Con Paso 1 Hacer
			si i mod j = 0
				//contamos cuantos numeros son divisibles
				cont<-cont+1;
			FinSi
		Fin Para
		//si solo hay dos numeros divisibles quiere decir que solo es divisible entre 1 y el mismo numero, por lo cual es primo y escribimos i
		si cont==2
			escribir sin saltar i " ";
		FinSi
	Fin Para
	escribir "";
FinProceso
