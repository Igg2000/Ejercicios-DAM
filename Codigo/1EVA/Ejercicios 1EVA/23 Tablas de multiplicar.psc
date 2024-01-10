Algoritmo ejercicio23
	
	num,i es entero;
	
	// Con un bucle limitamos del 1 al 10 el numero entero que nos da el usuario
	Repetir
		Escribir sin saltar "Elige que tabla de multiplicar del 1 al 10 quieres visualizar";
		leer num;
	Hasta Que num<11 y num>0
	
	//creamos un bucle que llegue hasta 10 (como cualquier tabla de multiplicar)
	//hacemos que cada bucle escriba el numero que le has introducido, una x, el numero a multiplicar, un = y el resultado de la operacion
	Para i<-1 Hasta 10 Con Paso 1 Hacer
		escribir num " x " i " = " num*i;
	Fin Para
	
	
FinAlgoritmo
