Proceso ejercicio24
	
	x,n1,n2,n3,i es entero;
	//creamos 3 variables, una para cada numero (tambien se puede hacer un array)
	//introducimos el primer numero e inicializamos todas las variables a ese mismo numero
	Escribir "Introduce 3 numeros";
	leer x;
	n1<-x;
	n2<-x;
	n3<-x;
	
	
	Para i<-1 Hasta 2 Con Paso 1 Hacer
		leer x;
		//le preguntamos que si el numero introducido está entre el primer y el tercer numero
		si x<=n3 y x>=n1
			//si se cumple la condicion le damos el valor de la posicion del medio
			n2<-x;
		FinSi
		//le preguntamos que si el numero introducido es menor que el tercer numero
		si x<n3
			//si se cumple la posicion, x se convierte en el tercer numero (el menor de todos)
			n3<-x;
		FinSi
		//le preguntamos que si el numero introducido es mayor que el primero
		si x>n1
			//si se cumple la condicion, x se convierte en el primer numero (el mayor de todos)
			n1<-x;
		FinSi

	Fin Para
	
	Escribir "Los numeros que has introducido ordenados de mayor a menor son: " n1 " " n2 " " n3;
	
	
	
FinProceso
