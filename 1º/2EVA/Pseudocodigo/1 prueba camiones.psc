Proceso camiones
	
	pcam,ncam es entero;
	i es entero;
	
	dimension ncam[5];
	dimension pcam[5];

	Para i<-0 Hasta 4 Con Paso 1 Hacer
		escribir "Llega un camión";
		escribir "_______________";
		escribir sin saltar "Cual es el numero de camión?";
		Repetir
			leer ncam[i];
			si ncam[i]<1 o ncam[i]>5
				escribir "El garaje no tiene mas que 5 camiones, debes introducir un numero entre 1 y 5";
			FinSi
		Hasta Que ncam[i]>0 y ncam[i]<6
		
		escribir sin saltar "Cuantos Kg lleva de carga el camión?";
		leer pcam[i];
		escribir "";
	Fin Para
	
	escribir "///////////////////";
	escribir "En orden de llegada";
	escribir "///////////////////";
	
	Para i<-0 Hasta 4 Con Paso 1 Hacer
		escribir "El camion " ncam[i] " cargaba " pcam[i] " Kg";
	Fin Para
	
	escribir "///////////////////";
	escribir "En orden de salida";
	escribir "///////////////////";
	
	Para i<-4 Hasta 0 Con Paso -1 Hacer
		escribir "El camion " ncam[i] " cargaba " pcam[i] " Kg";
	Fin Para
	
FinProceso
