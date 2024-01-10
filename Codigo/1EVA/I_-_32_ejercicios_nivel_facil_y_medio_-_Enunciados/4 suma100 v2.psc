Algoritmo suma100
	
	i,j,x,w es entero;
	MAX,MARGEN es entero;
	
	MAX<-50;
	j<-0;
	x<-0;

	Para i<-1 Hasta MAX Con Paso 1 Hacer
		j<-j+i;
		Para x<-1 Hasta i-1 Con Paso 1 Hacer
			escribir Sin Saltar x "+";
		Fin Para
		Escribir i "= " j;
		
	Fin Para
	Escribir j;
	
	
FinAlgoritmo
