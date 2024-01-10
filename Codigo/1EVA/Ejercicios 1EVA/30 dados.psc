Algoritmo ejercicio30
	
	dado1,dado2,i es entero;
	//generamos dos numeros aleatorios independientes y los guardamos en dos variables
	dado1<-aleatorio(1,6);
	dado2<-aleatorio(1,6);
	
	//escribimos que numeros han salido
	Escribir "El dado 1 has sacado un " dado1;
	Escribir "El dado 2 has sacado un " dado2;
	
	//escribimos el resultado de la suma de los dos dados
	Escribir Sin Saltar "la suma de los dados es " dado1+dado2;
	
	//comprobamos si la suma de los dados es mayor a 9 y en caso de que sea cierto escribimos felicidades
	si (dado1+dado2)>9
		escribir " felicidades";
	SiNo
		//en caso contrario ponemos un salto de linea para que el "ejecucion finalizada" no aparezca en la misma linea
		escribir "";
	FinSi
	
	
FinAlgoritmo
