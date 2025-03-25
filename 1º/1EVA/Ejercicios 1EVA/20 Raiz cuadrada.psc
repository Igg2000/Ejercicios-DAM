Algoritmo ejercicio20
	
	
	a,b,c es entero;
	//como me da error al ser un resultado decimal tengo que declararlo como numero
	x1,x2,comprobar es numero ;
	escribir "Introduce a, b y c";
	leer a;
	leer b;
	leer c;
	
	
	//si el numero dentro de la raiz es negativo no se puede hacer la raiz cuadrada, para ello hay que comprobarlo antes, si no saltaría un error
	comprobar<-b^2 -4 * a * c;
	si comprobar>=0
	
		x1<-(-b)+ raiz(b^2 -4 * a * c ) / (2 * a );
		x2<-(-b)- raiz(b^2 -4 * a * c ) / (2 * a );
		escribir "(-b) + raiz(b^2 -4 * a * c ) / (2 * a ) = " x1;
		escribir "(-b) - raiz(b^2 -4 * a * c ) / (2 * a ) = " x2;
	sino
		escribir "La raiz cuadrada da como resultado un numero negativo, por lo tanto no se puede calcular";
	finsi 
	
FinAlgoritmo
