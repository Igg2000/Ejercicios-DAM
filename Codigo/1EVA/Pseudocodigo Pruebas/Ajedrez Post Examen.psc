SubProceso T<-PedirTamaño
	
	T es entero;
	
	Escribir "Elige el tamaño del tablero: ";
	T<-NumeroValido;
	
FinSubProceso



SubProceso n<-NumeroValido
	
	n es entero;
	nValid es logico;
	
	nValid<-falso;
	
	Repetir
		Escribir "Introduce un numero par entre 4 y 16";
		Leer n;
		si n<4 o n>16 o n mod 2 <> 0
			Escribir "El numero introducido no es valido";
			nValid<-Falso;
		SiNo
			nValid<-Verdadero;
		FinSi
	Hasta Que nValid==Verdadero
	
FinSubProceso

SubProceso inicializarTablero(tam,tablero)
	fila,columna es entero;
	
	Para fila<-0 Hasta tam-1 Con Paso 1 Hacer
		Para columna<-0 Hasta tam-1 Con Paso 1 Hacer
			si (fila+columna) mod 2 == 0
				tablero[fila,columna]<-0;
			SiNo
				tablero[fila,columna]<-1;
			FinSi
			
		Fin Para
	Fin Para
	
FinSubProceso

SubProceso pintarTablero(tam,tablero)
	
	fila,columna es entero;
	
	Para fila<-0 Hasta tam-1 Con Paso 1 Hacer
		Para columna<-0 Hasta tam-1 Con Paso 1 Hacer
			Segun tablero[fila,columna] Hacer
				0:
					Escribir sin saltar " X ";
				1:
					Escribir Sin Saltar " O ";
				2:
					Escribir Sin saltar " 1 ";
				3:
					Escribir Sin saltar " 2 ";
			Fin Segun
		Fin Para
		escribir "";
	Fin Para
	
	
FinSubProceso

Proceso Ajedrez
	
	tam,tablero es entero;
	
	tam<-PedirTamaño;
	dimension tablero[tam,tam];
	inicializarTablero(tam,tablero);
	pintarTablero(tam,tablero);
	
	
FinProceso