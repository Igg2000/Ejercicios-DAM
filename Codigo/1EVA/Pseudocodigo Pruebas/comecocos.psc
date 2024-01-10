Funcion x<-ValidarMovimiento(tablero, movimiento)
	
	x,i,j es entero;
	//posi,posj es entero;
	
	para i<-0 hasta 19 Hacer
		para j<-0 hasta 19 hacer
			si tablero[i,j]==2
				//posi<-i;
				//posj<-j;
				si movimiento=='a' o movimiento=='A'
					//si es 1 significa que a la izquierda hay un muro
					si tablero[i,j-1]==1
						x<-1;
					SiNo
						//si es 3 significa que a la izquierda hay monedas
						si tablero[i,j-1]==3
							x<-3;
						SiNo
							//si es 0 significa que no hay nada
							si tablero[i,j-1]==0
								x<-0;
							FinSi
						FinSi
					FinSi
				SiNo
					si movimiento=='d' o movimiento=='D'
						si tablero[i,j+1]==1
							x<-1;
						SiNo
							si tablero[i,j+1]==3
								x<-3;
							SiNo
								si tablero[i,j+1]==0
									x<-0;
								FinSi
							FinSi
						FinSi
					SiNo
						si movimiento=='w' o movimiento=='W'
							si tablero[i-1,j]==1
								x<-1;
							SiNo
								si tablero[i-1,j]==3
									x<-3;
								SiNo
									si tablero[i-1,j]==0
										x<-0;
									FinSi
								FinSi
							FinSi
						SiNo
							si movimiento=='s' o movimiento=='S'
								si tablero[i+1,j]==1
									x<-1;
								SiNo
									si tablero[i+1,j]==3
										x<-3;
									SiNo
										si tablero[i+1,j]==0
											x<-0;
										FinSi
									FinSi
								FinSi
							FinSi
						FinSi
					FinSi
				FinSi
			FinSi
		FinPara
	FinPara
	
Fin Funcion

Funcion moverficha(tablero, monedas Por Referencia)
	
	i,j,movimientovalido,posfila,poscolumna es entero;
	movimiento es caracter;
	direccionCorrecta es logico;
	
	escribir " Arriba: W ";
	escribir " Abajo: S ";
	escribir " Izquierda: A ";
	escribir " Derecha: D ";
	escribir sin saltar "selecciona a donde quieres moverte: ";
	
	repetir
		
		leer movimiento;
		
		Repetir
			si movimiento=='W' o movimiento=='w' o movimiento=='S' o movimiento=='s' o movimiento=='A' o movimiento=='a' o movimiento=='D' o movimiento=='d'
				direccionCorrecta<-Verdadero;
			SiNo
				direccionCorrecta<-Falso;
				escribir "La tecla que has pulsado no es un movimiento valido";
				leer movimiento;
			FinSi
		Hasta Que direccionCorrecta==Verdadero
		
		movimientovalido<-ValidarMovimiento(tablero, movimiento);
		si movimientovalido==1
			escribir "Existe un muro en esa posicion";
		FinSi
		
		si movimientovalido==3
			monedas<-monedas+1;
		FinSi
	hasta que movimientovalido==0 o movimientovalido==3 
	
	para i<-0 hasta 19 Hacer
		para j<-0 hasta 19 hacer
			si tablero[i,j]==2
				poscolumna<-j;
				posfila<-i;
			FinSi
		finpara
	finpara
	
	si movimiento=='a' o movimiento=='A'
		tablero[posfila,poscolumna]<-0;
		tablero[posfila,poscolumna-1]<-2;
	SiNo
		si movimiento=='d' o movimiento=='D'
			tablero[posfila,poscolumna]<-0;
			tablero[posfila,poscolumna+1]<-2;
		SiNo
			si movimiento=='w' o movimiento=='W'
				tablero[posfila,poscolumna]<-0;
				tablero[posfila-1,poscolumna]<-2;
			SiNo
				si movimiento=='s' o movimiento=='S'
					tablero[posfila,poscolumna]<-0;
					tablero[posfila+1,poscolumna]<-2;
				FinSi
			FinSi
		FinSi
	FinSi
	
	
	
Fin Funcion

Funcion pintartablero(tablero,monedas)
	
	i,j es entero;
	
	Escribir "Monedas: " monedas;
	
	para i<-0 hasta 19 Hacer
		para j<-0 hasta 19 hacer
			Segun tablero[i,j] Hacer
				0:
					escribir sin saltar " . ";
				1:
					escribir sin saltar " X ";
				2:
					escribir sin saltar " * ";
				3:
					escribir sin saltar " $ ";
			Fin Segun
		FinPara
		escribir "";
	FinPara
	
Fin Funcion

Funcion inicializartablero(tablero)
	i,j es entero;
	
	para i<-0 hasta 19 Hacer
		para j<-0 hasta 19 hacer
			si i==0 o i==19 o j==0 o j==19 Entonces
				// si hay un 1 pondremos muros
				tablero[i,j]<-1;
			SiNo
				si i==10 y j==10
					//si hay un dos pondremos el personaje
					tablero[i,j]<-2;
				sino
					Si i==3 y j==3 o i==3 y j==4 o i==3 y j==5 o i==4 y j==5 Entonces
						//si hay un 3 pondremos monedas
						tablero[i,j]<-3;
					SiNo
						//si hay un 0 estará vacio
						tablero[i,j]<-0;
					Fin Si
				FinSi
			FinSi
		FinPara
	FinPara
	
	
Fin Funcion

Algoritmo comecocos
	
	i es entero;
	tablero,monedas es entero;
	
	monedas<-0;
	
	dimension tablero[20,20];
	
	Borrar Pantalla;
	inicializartablero(tablero);
	pintartablero(tablero, monedas);
	
	Para i<-1 Hasta 20 Con Paso 1 Hacer
		moverficha(tablero, monedas);
		Borrar Pantalla;
		pintartablero(tablero, monedas);
	Fin Para
	

FinAlgoritmo
