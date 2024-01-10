Proceso ejercicio24
	
	n1,n2,n3 es entero;
	//creamos 3 variables, una para cada numero
	Escribir "Introduce 3 numeros";
	leer n1;
	leer n2;
	leer n3;
	
	//preguntamos si los 3 numeros son iguales y en caso contrario empezamos a preguntar todas las posibilidades
	si n1==n2 y n1==n3
		Escribir "Has escrito 3 numeros iguales";
	sino
		si n1>=n2
			si n3>=n1
				Escribir "Los numeros que has introducido ordenados de mayor a menor son: " n3 " " n1 " " n2;
			sino
				si n2>=n3
					Escribir "Los numeros que has introducido ordenados de mayor a menor son: " n1 " " n2 " " n3;
				SiNo
					Escribir "Los numeros que has introducido ordenados de mayor a menor son: " n1 " " n3 " " n2;
				FinSi
			FinSi
		SiNo
			si n1>=n3
				Escribir "Los numeros que has introducido ordenados de mayor a menor son: " n2 " " n1 " " n3;
			SiNo
				si n3>=n2
					Escribir "Los numeros que has introducido ordenados de mayor a menor son: " n3 " " n2 " " n1;
				SiNo
					Escribir "Los numeros que has introducido ordenados de mayor a menor son: " n2 " " n3 " " n1;
				FinSi
			FinSi
		FinSi
	FinSi
	
	
	
	
	
FinProceso
