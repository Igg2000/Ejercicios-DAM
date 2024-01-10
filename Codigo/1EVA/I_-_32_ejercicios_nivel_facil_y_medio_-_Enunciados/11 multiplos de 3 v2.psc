Algoritmo multiplos3
	
	x,i,cont,re es entero;
	
	Escribir  "Escribe el numero maximo";
	
	leer x;
	cont<-0;
	Para i<-1 Hasta x Con Paso 1 Hacer
		
		re<-i*3;
		si re < x Entonces
			escribir i " x " 3 " = " re ;
			cont<-cont+1;
		FinSi
		
	Fin Para

	escribir " Hay " cont " multiplos";
FinAlgoritmo
