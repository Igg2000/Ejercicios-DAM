SubProceso TurnoJ1<-SortearTurno(TurnoJ1)
	
	x es entero;
	
	x<-Aleatorio(1,10);
	
	si x>5
		TurnoJ1<-Verdadero;
	SiNo
		TurnoJ1<-Falso;
	FinSi
	
	
FinSubProceso

SubProceso InicializarTablero (t,MAX)
	
	i,j es entero;
	Para i<-0 Hasta MAX-1 Con Paso 1 Hacer
		Para j<-0 Hasta MAX-1 Con Paso 1 Hacer
			t[i,j]<-0;
		Fin Para
	Fin Para
	
Fin SubProceso

SubProceso VisualizarTablero (t,MAX,cad)
	
	i,j es entero;
	
	
	escribir "  1 2 3";
	Para i<-0 Hasta MAX-1 Con Paso 1 Hacer
		escribir sin saltar i+1 " ";
		Para j<-0 Hasta MAX-1 Con Paso 1 Hacer
			
			Segun t[i,j] Hacer
				0: 
					cad <- "-";
				1: 
					cad <- "X";
				2: 
					cad <- "O";
			Fin Segun
			escribir sin saltar cad " ";
		Fin Para
		escribir"";
	Fin Para
	
Fin SubProceso





SubProceso LeerCoordenada(Coords,TurnoJ1)
//SubProceso LeerCoordenada
	cordx,cordy es entero;
	
	
	si TurnoJ1==Verdadero
		escribir "Turno de J1";
	SiNo
		escribir "Turno de J2";
	FinSi
	
	Escribir "Escribe la coordenada de la ficha. Orden: Fila y Columna";
	
	cordx<-0;
	cordy<-0;
	Mientras cordx<1 o cordx>3 o cordy<1 o cordy>3 Hacer
		Leer cordx,cordy;
		si cordx<1 o cordx>3 o cordy<1 o cordy>3
			Escribir "Tienes que introducir valores entre 1 y 3";
		FinSi
	Fin Mientras
	
	Coords[0]<-cordx-1;
	Coords[1]<-cordy-1;
	
	
FinSubProceso



SubProceso RegistrarTirada(t,Coords,TurnoJ1)
	
	posx,posy es entero;
	
	posx<-Coords[0];
	posy<-Coords[1];
	
	si TurnoJ1==Verdadero
		t[posx,posy]<-1;
	SiNo
		t[posx,posy]<-2;
	FinSi
	
	
	
FinSubProceso

SubProceso r<-PosicionValida(t,Coords)
	
	posx,posy es entero;
	r es logico;
	
	posx<-coords[0];
	posy<-coords[1];
	
	si t[posx,posy]=0
		r<-Verdadero;
	SiNo
		r<-Falso;
	FinSi
	
FinSubProceso

	

SubProceso HayGanador<-ComprobarGanador(t,TurnoJ1)
	
//	HayGanador es logico;
//	
//	si t[0,0] == t[1,1] == t[2,2]
//		HayGanador<-Verdadero;
//	FinSi
	
	
	
FinSubProceso

Proceso ejercicio50
	
	t es entero;
	MAX es entero;
	cad es cadena;
	Coords es entero;
	TurnoJ1 es logico;
	Nturnos es entero;
	HayGanador es logico;
	PosValida es logico;
	
	HayGanador<-Falso;
	
	Dimension Coords[2];
	
	Nturnos<-0;
	TurnoJ1<-Falso;
	cad<-"x";
	MAX<-3;
	dimension t[3,3];
	
	InicializarTablero(t,MAX);
	
	VisualizarTablero(t,MAX,cad);
	
	TurnoJ1<-SortearTurno(TurnoJ1);
	
	repetir 
		
		repetir
			LeerCoordenada(Coords,TurnoJ1);
			PosValida<-PosicionValida(t,Coords);
			si PosValida==Falso
				escribir "Esa posicion está ocupada";
			FinSi
		hasta que PosValida==verdadero
		
		RegistrarTirada(t,Coords,TurnoJ1);
		Nturnos<-Nturnos+1;
		Borrar Pantalla;
		VisualizarTablero(t,MAX,cad);
		HayGanador<-ComprobarGanador(t,TurnoJ1);
		TurnoJ1<-!TurnoJ1;
		
	Hasta Que HayGanador==Verdadero o NTurnos==9


	
	
	
	
	
FinProceso




