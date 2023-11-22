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

SubProceso LeerCoordenada(t,cad)
	
	TurnoJ1 es logico;
	cordx,cordy es entero;
	
	TurnoJ1<-Verdadero;
	
	Escribir "Escribe la coordenada de la ficha";
	
	cordx<-0;
	cordy<-0;
	
	Mientras cordx<1 o cordx>3 o cordy<1 o cordy>3 Hacer
		Leer cordx,cordy;
		si cordx<1 o cordx>3 o cordy<1 o cordy>3
			Escribir "Tienes que introducir valores entre 1 y 3";
		FinSi
	Fin Mientras
	
	t[cordx-1,cordy-1]<-;
	
	
	
FinSubProceso



Proceso ejercicio50
	
	t es entero;
	MAX es entero;
	cad es cadena;
	
	cad<-"x";
	MAX<-3;
	dimension t[3,3];
	
	InicializarTablero(t,MAX);
	
	VisualizarTablero(t,MAX,cad);
	
	LeerCoordenada(t,cad);
	
	
FinProceso




