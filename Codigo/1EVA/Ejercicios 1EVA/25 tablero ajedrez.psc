Proceso ejercicio25
	
	fila,columna es entero;
	//pintamos la linea del marco de arriba
	escribir " __________________________";
	//hacemos un cuadrado de 8 filas x 8 columnas
	Para fila<-1 Hasta 8 Con Paso 1 Hacer
		//pintamos la columna del marco de la izquierda
		escribir sin saltar "| ";
		//hacemos la distincion entre blanca y negras
		Para columna<-1 Hasta 8 Con Paso 1 Hacer
			//Hacemos la pregunta que nos permite colocar las torres
			si fila==1 y columna==1 o fila==1 y columna==8 o fila==8 y columna==1 o fila==8 y columna==8
				escribir sin saltar " T ";
			sino 
				//Hacemos la pregunta que nos permite colocar los cababallos
				//Aquí me he dado cuenta de lo que me he complicado la vida al no querer hacerlo con arrays
				si fila==1 y columna==2 o fila==1 y columna==7 o fila==8 y columna==2 o fila==8 y columna==7
					escribir sin saltar " C ";
				sino
					//Hacemos la pregunta que nos permite colocar los Alfiles
					si fila==1 y columna==3 o fila==1 y columna==6 o fila==8 y columna==3 o fila==8 y columna==6
						escribir sin saltar " A ";
					sino
						//Hacemos la pregunta que nos permite colocar las reinas
						si fila==1 y columna==5 o fila==8 y columna==4
							escribir sin saltar " r ";
						sino
							//Hacemos la pregunta que nos permite colocar los reyes
							si fila==1 y columna==4 o fila==8 y columna==5
								escribir sin saltar " R ";
							sino
								//Hacemos la pregunta que nos permite colocar los peones
								si fila==2 o fila==7
									escribir sin saltar " P ";
								sino
									//si no hay ninguna ficha pintamos el tablero normal
									si (fila+columna) mod 2 = 0
										escribir Sin Saltar " * ";
									SiNo
										escribir sin saltar " + ";
									FinSi
								FinSi
							FinSi
						FinSi
					FinSi
				FinSi
			finsi
	Fin Para
		//pintamos la columna del marco de la derecha
	escribir sin saltar " |";
	//este es el salto de linea que se hace cada vez que termina una fila
	escribir"";
	Fin Para
	//pintamos la linea de abajo
	escribir " __________________________";
	
	
FinProceso


