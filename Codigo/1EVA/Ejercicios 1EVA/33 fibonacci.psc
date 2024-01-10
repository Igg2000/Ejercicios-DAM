Algoritmo ejercicio33
	//por algun motivo poniendolo como entero me daba error
	a,b,c,i es numero;
	
	a<-0;
	b<-1;
	//creamos una variable que equivale a la suma de a+b, a toma el valor de b, y b toma el valor de c (a+b) haciendo que b sea siempre la suma de los dos anteriores numeros
	//y como a va a tomar el valor de b antes de hacer la suma pues escribimos a
	Para i<-1 Hasta 20 Con Paso 1 Hacer
		c<-a+b;
		a<-b;
		b<-c;
		escribir a;
	Fin Para
	
	
FinAlgoritmo
