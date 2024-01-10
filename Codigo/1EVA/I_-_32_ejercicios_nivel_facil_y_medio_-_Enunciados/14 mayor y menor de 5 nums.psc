Algoritmo mayorymenorde5nums
	
	min,max,num,i es entero;
	
	Escribir  "escribe un numero";
	
	leer num;
	min<-num;
	max<-num;
	
	Para i<-1 Hasta 4 Con Paso 1 Hacer
		leer num;
		si num<min
			min<-num;
		FinSi
		
		si num>max
			max<-num;
		FinSi
		
	Fin Para
	
	Escribir "El mayor numero de los 5 es " max;
	Escribir "El menor numero de los 5 es " min;
	
FinAlgoritmo
