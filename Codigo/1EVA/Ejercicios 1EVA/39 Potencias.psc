Algoritmo ejercicio39
	
	exponente,i,re es entero;
	base es real;
	
	escribir "Introduce la base y el exponente";
	leer base,exponente;
	
	re<-base;
	Para i<-2 Hasta exponente Con Paso 1 Hacer
		re<-re*base;
	Fin Para
	
	escribir "El resultado es" re;
FinAlgoritmo
