Proceso ejercicio34
	
	i,fact,PerteneceFibonacci es entero;
	//los he tenido que poner como numeros ya que los resultados ocupaban mas espacio de el que hay reservado para un numero entero
	acum,k,a,b,c es numero;
	
	acum<-1;
	a<-0;
	b<-1;
	PerteneceFibonacci<-0;
	
	escribir "Debes introduzcas un numero menor que 300 perteneciente a la serie de fibonacci";
	
	Repetir
		leer fact;
		si no fact<300
			escribir "El factorial es igual o mayor a 300";
			escribir "Porfavor, introduce un numero menor que 300";
		finsi
	Hasta Que fact<300
	
	//hacemos un acumulador que multiplique todos los numeros hasta el numero introducido para sacar el factorial del numero introducido
	Para k<-1 Hasta fact Con Paso 1 Hacer
		acum<-acum*k;
	Fin Para
	
	//creamos una variable que equivale a la suma de a+b, a toma el valor de b, y b toma el valor de c (a+b) haciendo que b sea siempre la suma de los dos anteriores numeros
	//y como a va a tomar el valor de b antes de hacer la suma pues escogemos a
	Para i<-1 Hasta 300 Con Paso 1 Hacer
		c<-a+b;
		a<-b;
		b<-c;
		//ya que a pasa por cada numero de la serie de fibonacci debemos de preguntar dentro del bucle
		//si el numero introducido pertenece a fibonacci cambiamos una variable para indicarlo
		si fact == a
			PerteneceFibonacci<-1;
		FinSi
	Fin Para
	
	//segun si el numero introducido pertenece a la serie de fibonacci o no, escribimos el resultado o escribimos que no pertenece a la serie de fibonacci
	si PerteneceFibonacci==1
		escribir "El factorial de " fact " es " acum;
	sino
		escribir fact " no pertenece a la serie de fibonacci";
	FinSi

	
FinProceso
