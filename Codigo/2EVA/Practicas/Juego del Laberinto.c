#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include "colores.h"
#define TamPantalla 120
#define AnchoLaberinto 60
#define AltoLaberinto 20
#define Jugador '*'
#define Meta '$'
#define Muros ' '
#define Marco '/'
#define ColorMuros /*BLACK*/ BG_BLUE
#define ColorJugador /*BLUE*/ ORANGE
#define ColorMeta LGREEN
#define ColorFondo /*BG_YELLOW*/
#define ColorMarco LBLUE
#define ColorMenu ORANGE

void pintarMargen(int max);
void mostrarMapa(int laberinto[AltoLaberinto][AnchoLaberinto], int dificultad);
void generarMapa(int laberinto[AltoLaberinto][AnchoLaberinto],int dificultad);
void jugar(int dificultad);
void pintarCentrado(char *cadena); /*Este metodo funciona como un printf solo que te lo escribe en el medio de la pantalla*/
void pintarCentradoSinSalto(char *cadena); /*este metodo es el mismo pero sin salto de linea*/
void pintarMenu(); /*Este metodo pinta el menú principal del programa*/
int menuDificultad(); /*Esta funcion pinta el menú de seleccion de dificultad y le pide al usuario que seleccione
una de las tres dificultades ademas de devolver el valor de la dificultad elegida*/

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
	
	pintarMargen(TamPantalla/2-((AnchoLaberinto/2)));
	

	
	printf("Dificultad: ");
	switch(dificultad){
	case 1: printf("%s\n",cardificultad); break;
	case 2:	printf(ORANGE"%s\n"RESET,cardificultad); break;
	case 3:	printf(RED"%s\n"RESET,cardificultad); break;
	}
	
	
	pintarMargen(TamPantalla/2-((AnchoLaberinto/2))); /*para centrarlo cojo la mitad del tamaño de la pantalla y le resto el la mitad del ancho del laberinto
														multiplicada por 3 ( ya que el laberinto se muestra en 3 espacios cada caracter*/
	for(i=0;i<=AnchoLaberinto+1;i++) /*esto pinta la parte de arriba del marco*/
		printf(ColorMarco "%c" RESET,Marco);
	puts("");
	for(i=0;i<AltoLaberinto;i++){
		pintarMargen((TamPantalla/2)-((AnchoLaberinto/2)));
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
	pintarMargen(TamPantalla/2-((AnchoLaberinto/2)));
	for(i=0;i<=AnchoLaberinto+1;i++) /*esto pinta la parte de abajo del marco*/
		printf(ColorMarco "%c" RESET,Marco);
	puts("");
}
void generarMapa(int laberinto[AltoLaberinto][AnchoLaberinto],int dificultad){
	
	int i,j,k,numMuros;
	int posXMuros[900]; /*esto es la posicion de las filas de los muros*/
	int posYMuros[900]; /*esto es la posicion de las columnas de los muros*/
	srand(time(NULL)); /*esto enteoria genera una semilla para que cuando se llame a rand, genere un numero aleatorio en base a una semilla nueva cada vez*/
		
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
		scanf("%d",&n);
		system("cls");  /*borro pantalla para que se borre el ultimo numero introducido en caso de que no sea valido*/
	} while(n<1 || n>3); /*esto obliga al usuario a introducir una opcion valida*/
	
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

void jugar(dificultad){
	
	int laberinto[AltoLaberinto][AnchoLaberinto];
		
	generarMapa(laberinto,dificultad);
	mostrarMapa(laberinto,dificultad);
	
	getch(); /*esto es para hacer pruebas sin que vuelva al menu*/
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

