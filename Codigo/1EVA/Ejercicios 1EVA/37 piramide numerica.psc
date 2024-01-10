Proceso ejercicio 37
	
	
	MAX,i,j es entero;
	
	
	MAX<-5;
	
	Para i<-1 Hasta MAX Con Paso 1 Hacer
		
		//Este bucle va escribiendo espacios desde el numero maximo hasta el numero actual por lo que cada vez va metiendo menos espacios
		Para j<-MAX Hasta i Con Paso -1 Hacer
			escribir sin saltar " ";
		Fin Para
		//Este bucle hace una escalera de numeros a la inversa, que llega hasta 2, ya que si llega hasta 1 se repetiría el 1
		Para j<-i Hasta 2 Con Paso -1 Hacer
			escribir sin saltar j;
		Fin Para
		//Este bucle hace una escalera de numeros
		Para j<-1 Hasta i Con Paso 1 Hacer
			escribir sin saltar j;
		Fin Para
		escribir "";
	Fin Para
	
FinProceso
