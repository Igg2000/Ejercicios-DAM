Algoritmo letrafrase
	
	x es caracter;
	z,cont es entero;
	
	z<-0;
	cont<-0;
	escribir "introduce una frase, letra a letra y acaba con un punto";
	Mientras z=0 Hacer
		leer x;
		Segun x Hacer
			'a':
				cont<-cont+1;
			'e':
				cont<-cont+1;
			'i':
				cont<-cont+1;
			'o':
				cont<-cont+1;
			'u':
				cont<-cont+1;
			'.':
				z<-1;
		Fin Segun
	Fin Mientras
	escribir "la frase contiene " cont " vocales ";
FinAlgoritmo
