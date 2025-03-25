#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include "colores.h"
#include <unistd.h> /*Esta es enteoria la libreria de sleep*/

/*Por algun motivo no me funciona sleep en su libreria 
y esto me permite usarlo, lo he sacado de internet*/
#ifdef _WIN32
#include <windows.h>
#define sleep(x) Sleep(x * 1000) 
#else
#include <unistd.h>
#endif

#define TamPantalla 120
#define AnchoLaberinto 20
#define AltoLaberinto 20
#define Jugador '*'
#define Meta '$'
#define Muros '#'
#define Marco '/'
#define ColorMuros /*BLACK*/
#define ColorJugador /*BLUE*/ ORANGE
#define ColorMeta LGREEN
#define ColorFondo /*BG_YELLOW*/
#define ColorMarco LBLUE
#define ColorMenu ORANGE
#define ColorVictoria LGREEN
#define ColorDerrota RED
#define CentrarLaberinto 0 /*1 para centrar laberinto y 0 para no centrarlo*/
#define Tiempo 60	


void pintarMargen(int max);
void mostrarMapa(int laberinto[AltoLaberinto][AnchoLaberinto], int dificultad);
void generarMapa(int laberinto[AltoLaberinto][AnchoLaberinto],int dificultad);
void jugar(int dificultad);
void pintarCentrado(char *cadena); /*Este metodo funciona como un printf solo que te lo escribe en el medio de la pantalla*/
void pintarCentradoSinSalto(char *cadena); /*este metodo es el mismo pero sin salto de linea*/
void pintarMenu(); /*Este metodo pinta el menú principal del programa*/
int menuDificultad(); /*Esta funcion pinta el menú de seleccion de dificultad y le pide al usuario que seleccione
una de las tres dificultades ademas de devolver el valor de la dificultad elegida*/
int cambiarMapa();
int moverJugador(int laberinto[AltoLaberinto][AnchoLaberinto]);
int validarMovimiento(int laberinto[AltoLaberinto][AnchoLaberinto],char direccion);
void pantallaVictoria();
void pantallaDerrota();
void cuentaRegresiva();

void cuentaRegresiva(max){
	
	int i;
	/*Esto lo que hace es pintar un caracter, y esperar un segundo en bucle hasta que llegue al limite de segundos*/
	for(i=0;i<max;i++){ 
		printf("/");
	}
}
void pintarMargen(int max){
	
	int i;
	for(i=0;i<max;i++)
		printf(" ");
	
	
	
}
void mostrarMapa(int laberinto[AltoLaberinto][AnchoLaberinto], int dificultad){
	
	int i,j;
	char *cardificultad;
	
	
	switch(dificultad){
	case 1: cardificultad= "Facil"; break;
	case 2: cardificultad= "Medio"; break;
	case 3: cardificultad= "Dificil"; break;
	}
	
	if (CentrarLaberinto==1)
	pintarMargen(TamPantalla/2-((AnchoLaberinto/2)));
	

	
	printf("Dificultad: ");
	switch(dificultad){
	case 1: printf("%s\n",cardificultad); break;
	case 2:	printf(ORANGE"%s\n"RESET,cardificultad); break;
	case 3:	printf(RED"%s\n"RESET,cardificultad); break;
	}
	
	
	if (CentrarLaberinto==1)
		pintarMargen(TamPantalla/2-((AnchoLaberinto/2))); 
	/*para centrarlo cojo la mitad del tamaño de la pantalla y le resto el la mitad del ancho del laberinto
	multiplicada por 3 ( ya que el laberinto se muestra en 3 espacios cada caracter*/
	
	for(i=0;i<=AnchoLaberinto+1;i++) /*esto pinta la parte de arriba del marco*/
		printf(ColorMarco "%c" RESET,Marco);
	puts("");
	for(i=0;i<AltoLaberinto;i++){
		if (CentrarLaberinto==1)
			pintarMargen(TamPantalla/2-((AnchoLaberinto/2)));
		printf(ColorMarco "%c" RESET,Marco); /*esto pinta la parte izquierda del marco*/
		for(j=0;j<AnchoLaberinto;j++)
			/*printf("%3d",laberinto[i][j]);*/
			switch(laberinto[i][j]){ /* esto lee el array del laberinto y si encuentra un 0 pinta espacios, si lee un 1 pinta un jugador, si lee 2 la meta y si lee 3 los muros*/
			case 0:	printf(ColorFondo" "RESET); break;
			case 1: printf(ColorFondo ColorJugador"%c"RESET,Jugador);break;
			case 2: printf(ColorFondo ColorMeta"%c"RESET,Meta);break;
			case 3: printf(ColorFondo ColorMuros"%c"RESET,Muros);break;
			};
			printf(ColorMarco "%c" RESET,Marco); /*esto pinta la parte derecha del marco*/
	puts("");
	}
	if (CentrarLaberinto==1)
		pintarMargen(TamPantalla/2-((AnchoLaberinto/2)));
	for(i=0;i<=AnchoLaberinto+1;i++) /*esto pinta la parte de abajo del marco*/
		printf(ColorMarco "%c" RESET,Marco);
	puts("");
}
void generarMapa(int laberinto[AltoLaberinto][AnchoLaberinto],int dificultad){
	
	int i,j,k,numMuros;
	int posXMuros[900]; /*esto es la posicion de las filas de los muros*/
	int posYMuros[900]; /*esto es la posicion de las columnas de los muros*/
	
		
	/*esto es para decidir el numero de muros que va a haber en funcion de la dificultad*/
	switch(dificultad){
	case 1: numMuros=(((AltoLaberinto*AnchoLaberinto))/20); break;
	case 2: numMuros=(((AltoLaberinto*AnchoLaberinto))/10); break;
	case 3: numMuros=(((AltoLaberinto*AnchoLaberinto))/5); break;
	default: break;
	}

	
	for(i=0;i<numMuros;i++){
		posXMuros[i]= rand() %(AltoLaberinto); /* esto me rellena un array de posiciones aleatorias de altura*/
		posYMuros[i]= rand() %(AnchoLaberinto); /* esto me rellena un array de posiciones aleatorias de anchura*/
	}
	
/*	ESTO ES PARA SOLUCIONAR ERRORES
	
	printf("%d\n",numMuros);  ESTO ES PARA VER LA CANTIDAD DE MUROS
	
	puts("Las pos x de los muros son:"); ESTO ES PARA VER LAS POSICIONES DE ALTURA
	for(i=0;i<numMuros;i++){
		printf("%d ",posXMuros[i]);
	}
	puts("");
	
	puts("Las pos y de los muros son:"); ESTO ES PARA VER LAS POSICIONES DE ANCHURA
	for(i=0;i<numMuros;i++){
		printf("%d ",posYMuros[i]);
	}
	puts("");
	*/
	
	for(i=0;i<AltoLaberinto;i++){
		for(j=0;j<AnchoLaberinto;j++){
			
			if (i==3 && j==3){
				laberinto[i][j]=1; /*Un 1 en el array significara la posicion del jugador, su posicion inicial sera en la casilla 3,3*/
			}
			else{
				if ((i==AltoLaberinto-4) && (j==AnchoLaberinto-4)){
					laberinto[i][j]=2; /*Un 2 en el array significara la posicion de la meta, su posicion inicial sera en la casilla 16,16*/
				}
				else { 
					laberinto[i][j]=0;
					
					for(k=0;k<numMuros;k++){
						if(i==posXMuros[k] && j==posYMuros[k]){ /*esto hace que si la altura y la anchura del laberinto coinciden con las posiciones
																donde debe haber un Muro, se coloque el muro*/
							laberinto[i][j]=3;	
						}
					}
					
				}
			}
			
		}
	}	

}
int cambiarMapa(){
	
	int op=0;
	char opcion;
	do{
		if (CentrarLaberinto==1){
			pintarCentrado("¿Quieres jugar este mapa? (S/N)");
		}else{
			puts("¿Quieres jugar este mapa? (S/N)");
		}
		
		do{
			opcion=getch();
		} while(tolower(opcion)!='s' && tolower(opcion)!='n');
		
		
		switch(tolower(opcion)){ /*dependiendo de la opcion que eligas la funcion va a devolver una cosa u otra*/
		case 's': op=1; break;
		case 'n': op=2; break;
		default: op=0; break;
		};
	} while(op==0);
	
	return op;
}
int moverJugador(int laberinto[AltoLaberinto][AnchoLaberinto]){
	
	int i,j,posX,posY,movimientoValido;
	char direccion='o';
	
	for(i=0;i<AltoLaberinto;i++){
		for(j=0;j<AnchoLaberinto;j++){
			if(laberinto[i][j]==1){ /*Esto lo que hace es buscar la posicion de jugador y guardarla en dos variables*/
				posX=i;
				posY=j;
			}
		}
	}
	
/*	do{*/
/*		direccion=getch();*/
/*	} while(direccion!=tolower('a') && direccion!=tolower('d') && direccion!=tolower('w') && direccion!=tolower('s'));*/
	
	if(kbhit())
		direccion=getch();
	
	movimientoValido=validarMovimiento(laberinto,direccion);
	
	if (movimientoValido==0){
		switch(tolower(direccion)){
		case'a': 
			laberinto[posX][posY]=0;
			laberinto[posX][posY-1]=1;
			break;
		case'd':
			laberinto[posX][posY]=0;
			laberinto[posX][posY+1]=1;
			break;
		case'w': 
			laberinto[posX][posY]=0;
			laberinto[posX-1][posY]=1;
			break;
		case's': 
			laberinto[posX][posY]=0;
			laberinto[posX+1][posY]=1;
			break;
		}
	}
	
	return movimientoValido;
}

int validarMovimiento(int laberinto[AltoLaberinto][AnchoLaberinto],char direccion){
	
	int elementoAdyacente; /*esta variable va a guardar un 0 si no hay nada 1 si tiene un muro, 2 si está la meta*/
	
	int i,j,posX,posY;
	
	for(i=0;i<AltoLaberinto;i++){
		for(j=0;j<AnchoLaberinto;j++){
			if(laberinto[i][j]==1){ /*Esto lo que hace es buscar la posicion de jugador y guardarla en dos variables*/
				posX=i;
				posY=j;
			}
		}
	}
	
	switch(tolower(direccion)){
	case'a': 
		if(posY==0){elementoAdyacente=1;} /*Esto es para prohibir que te salgas del mapa, si estas a la izquierda del todo e intentas moverte a la izquierda pierdes*/
		else{
			if(laberinto[posX][posY-1]==0) {elementoAdyacente=0;}  /*si en la posicion a la que te vas a poner hay un 0(espacio vacio), elemento adyacente devuelve 0(espacio vacio)*/
			else{
				if(laberinto[posX][posY-1]==3) {elementoAdyacente=1;}  /*si en la posicion a la que te vas a poner hay un 3(muro) elemento adyacente devuelve 1(muro)*/
				else{
					if(laberinto[posX][posY-1]==2) {elementoAdyacente=2;} /*si en la posicion a la que te vas a poner hay un 2(la meta), elemento adyacente devuelve 2(la meta)*/
				}
			}
		}
		break;
	case'd':
		if(posY==AnchoLaberinto-1){elementoAdyacente=1;} 
		else{
			if(laberinto[posX][posY+1]==0) {elementoAdyacente=0;} 
			else{
				if(laberinto[posX][posY+1]==3) {elementoAdyacente=1;} 
				else{
					if(laberinto[posX][posY+1]==2) {elementoAdyacente=2;} 
				}
			}
		}
		break;
	case'w': 
		if(posX==0){elementoAdyacente=1;} 
		else{
			if(laberinto[posX-1][posY]==0) {elementoAdyacente=0;} 
			else{
				if(laberinto[posX-1][posY]==3) {elementoAdyacente=1;} 
				else{
					if(laberinto[posX-1][posY]==2) {elementoAdyacente=2;} 
				}
			}
		}
		break;
	case's': 
		if(posX==AltoLaberinto-1){elementoAdyacente=1;} 
		else{
		   if(laberinto[posX+1][posY]==0) {elementoAdyacente=0;} 
		   else{
			   if(laberinto[posX+1][posY]==3) {elementoAdyacente=1;} 
			   else{
				   if(laberinto[posX+1][posY]==2) {elementoAdyacente=2;} 
			   }
		   }
		}
		break;
	}
	return elementoAdyacente;
	
}
void pintarCentradoSinSalto(char cadena[]){
	
	int i;
	int longitud = strlen(cadena);
	
	/*la logica de esta funcion es pintar espacios hasta la mitad de la pantalla (TamPantalla/2) pero si le metemos una cadena
	de longitud 10 por ejemplo, tendriamos que quitar 5 espacios (longitud/2) para que quede centrado, 
		si no simplemente se pintaría a partir del centro de la pantalla */
		
	for (i=0;i<((TamPantalla/2)-(longitud/2));i++)  
		printf(" ");
	
	printf("%s",cadena);
	
}
void pintarCentrado(char *cadena){
	
	pintarCentradoSinSalto(cadena);
	puts("");
	
}

int menuDificultad(){
	
	int n= 0;
	char op;
	
	do{				
		pintarCentrado("______________________________________________________________________________");
		pintarCentrado("______________________________________________________________________________");
		printf(ColorMenu);
		pintarCentrado("	   __       _               _       _              ___                  _ ");
		pintarCentrado("	  / /  __ _| |__   ___ _ __(_)_ __ | |_ ___       /   \\__ _ _ __ ___   / |");
		pintarCentrado("	 / /  / _` | '_ \\ / _ \\ '__| | '_ \\| __/ _ \\     / /\\ / _` | '_ ` _ \\  | |");
		pintarCentrado("	/ /__| (_| | |_) |  __/ |  | | | | | || (_) |   / /_// (_| | | | | | | | |");
		pintarCentrado("	\\____/\\__,_|_.__/ \\___|_|  |_|_| |_|\\__\\___/   /___,' \\__,_|_| |_| |_| |_|" RESET);
		pintarCentrado("______________________________________________________________________________");
		pintarCentrado("______________________________________________________________________________");
		
		puts("\n\n\n\n");
		pintarCentrado("_________________________");
		pintarCentrado(" 1. Fácil");
		pintarCentrado(" 2. Medio");
		pintarCentrado(" 3. Dificil");
		pintarCentrado("_________________________");
		pintarCentradoSinSalto(" Elige el nivel de dificultad: ");
		
		fflush(stdin);
		/*scanf("%d",&n);*/
		op =getch();
		system("cls");  /*borro pantalla para que se borre el ultimo numero introducido en caso de que no sea valido*/
	} while(op!='1' && op!='2' && op!='3'); /*esto obliga al usuario a introducir una opcion valida*/
	
	switch(op){
	case '1': n=1; break;
	case '2': n=2; break;
	case '3': n=3; break;
	}
	
	return n;
}
void pintarMenu(){
	
	
	/* Soy plenamente consciente de que podría meterlo en un array y poner delante un "pintarMargen" pero me he dado cuenta tarde,
	asi que para no rehacerlo he pensado que podia hacer mi propio printf pero que me lo hiciera centrado*/
	
	pintarCentrado("______________________________________________________________________________");
	pintarCentrado("______________________________________________________________________________");
	printf(ColorMenu);
	pintarCentrado("	   __       _               _       _              ___                  _ ");
	pintarCentrado("	  / /  __ _| |__   ___ _ __(_)_ __ | |_ ___       /   \\__ _ _ __ ___   / |");
	pintarCentrado("	 / /  / _` | '_ \\ / _ \\ '__| | '_ \\| __/ _ \\     / /\\ / _` | '_ ` _ \\  | |");
	pintarCentrado("	/ /__| (_| | |_) |  __/ |  | | | | | || (_) |   / /_// (_| | | | | | | | |");
	pintarCentrado("	\\____/\\__,_|_.__/ \\___|_|  |_|_| |_|\\__\\___/   /___,' \\__,_|_| |_| |_| |_|"RESET);
	pintarCentrado("______________________________________________________________________________");
	pintarCentrado("______________________________________________________________________________");
	
	puts("\n\n\n\n");
	pintarCentrado("_________________________");
	pintarCentrado(" 1. Jugar");
	pintarCentrado(" 2. Cambiar dificultad");
	pintarCentrado(" 3. Salir");
	pintarCentrado("_________________________");
	
	
}

void pantallaVictoria(){
	
	pintarCentrado("___________________________________________");
	pintarCentrado("___________________________________________");
	printf(ColorVictoria"");
	pintarCentrado("        _        _                _        ");
	pintarCentrado("/\\   /\\(_)  ___ | |_  ___   _ __ (_)  __ _ ");
	pintarCentrado("\\ \\ / /| | / __|| __|/ _ \\ | '__|| | / _` |");
	pintarCentrado(" \\ V / | || (__ | |_| (_) || |   | || (_| |");
	pintarCentrado("  \\_/  |_| \\___| \\__|\\___/ |_|   |_| \\__,_|");
	printf(""RESET);
	pintarCentrado("___________________________________________");
	pintarCentrado("___________________________________________");
	puts("\n\n\n");
	pintarCentrado("Felicidades, has completado el nivel");
											  
											  
}
void pantallaDerrota(){
	
	pintarCentrado("___________________________________________");
	pintarCentrado("___________________________________________");
	printf(ColorDerrota"");
	pintarCentrado("       ___                         _            ");
	pintarCentrado("	  /   \\ ___  _ __  _ __  ___  | |_  __ _    ");
	pintarCentrado("	 / /\\ // _ \\| '__|| '__|/ _ \\ | __|/ _` | ");
	pintarCentrado("	/ /_//|  __/| |   | |  | (_) || |_| (_| |    ");
	pintarCentrado("   /___,'  \\___||_|   |_|   \\___/  \\__|\\__,_|   ");
	printf(""RESET);
	pintarCentrado("___________________________________________");
	pintarCentrado("___________________________________________");
	puts("\n\n\n");
	pintarCentrado("Has perdido, suerte la proxima vez");
	
	
}
void jugar(dificultad){
	
	int quieroCambiar,terminaPartida;
	int laberinto[AltoLaberinto][AnchoLaberinto];
	int cont=0;
	
	srand(time(NULL)); /*esto enteoria genera una semilla para que cuando se llame a rand 
	a la hora de generar muros, genere un numero aleatorio en base a una semilla nueva cada vez*/
	
	do{
		generarMapa(laberinto,dificultad);
		mostrarMapa(laberinto,dificultad);
		quieroCambiar= cambiarMapa();
		if(quieroCambiar==2)
			system("cls");
	} while(quieroCambiar==2);
	
	do{
		system("cls");
		mostrarMapa(laberinto,dificultad);
		
		do{
			terminaPartida=moverJugador(laberinto);
			system("cls");
			
			if(terminaPartida==0){
				mostrarMapa(laberinto,dificultad);
				cuentaRegresiva(cont);
				cont++;
			}
		
		}while(terminaPartida==0);
		
	/*	si terminPartida vale 1 quiere decir que ha intentado moverse a donde había un muro, y
		si terminaPartida vale 2, quiere decir que el jugador ha llegado a la meta*/
		
		
		
		if(terminaPartida==1) {
			pantallaDerrota();
			sleep(2); /*he metido una espera de 2 segundos para que no vuelvas al menu sin querer*/
			getch();}
		else{
			if (terminaPartida==2){
			pantallaVictoria();
			sleep(2);
			getch();}
			
		}
	}while(terminaPartida!=1 && terminaPartida!=2 );
}
int main(int argc, char *argv[]) {
	
	char opMenu;
	int dificultad=1,salir=0 ;
	
	
	do{
		system("cls");
		pintarMenu(); /*este metodo pinta el menu principal del juego*/
		opMenu=getch(); /*con un getch elegimos la opcion del menú*/
		switch(opMenu){
			case'1': 
				system("cls");
				jugar(dificultad);
				break;
			
			case'2': 
				system("cls");
				dificultad=menuDificultad(); /*de esta forma recibimos la dificultad que ha seleccionado el jugador en la funcion "menuDificultad"*/
				break;

			case'3': 
				salir=1;
				break;
			
			default: break;
		}
	} while(salir==0); /*esto hace que el programa no termine a no ser que selecciones la opcion "Salir" del menú*/
	
	
	return 0;
}

