Algoritmo ejercicio29
	
	i,x es entero;
	
	
	
	escribir "Pulse cualquier tecla para generar una quiniela";
	esperar tecla;
	
	Para i<-1 Hasta 15 Con Paso 1 Hacer
		escribir sin saltar "Partido " i " : ";
		//asigno un valor aleatorio de 1 a 3 a una variable (lo he intentado poniendo directamente el aleatorio en el switch y a veces se lo saltaba)
		x<-aleatorio(1,3);
		//hacemos un Switch de la variable que contiene el numero aleatorio para que segun el numero escriba el ganador(1 o 2) o si hay empate(x)
		segun x
			1:
				escribir "1";
			2:
				escribir "2";
			3:
				escribir "X";
			
		FinSegun
		
	Fin Para
	
	
	
	
FinAlgoritmo
