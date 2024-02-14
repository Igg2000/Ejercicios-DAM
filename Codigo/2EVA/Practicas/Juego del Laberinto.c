#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#define TamPantalla 120
#define AnchoLaberinto 20
#define AltoLaberinto 20
#define Jugador '*'
#define Meta '$'
#define Muros '#'

void mostrarMapa(int laberinto[AltoLaberinto][AnchoLaberinto]);
void generarMapa(int laberinto[AltoLaberinto][AnchoLaberinto],int dificultad);
void jugar(int dificultad);
void pintarCentrado(char *cadena); /*Este metodo funciona como un printf solo que te lo escribe en el medio de la pantalla*/
void pintarCentradoSinSalto(char *cadena); /*este metodo es el mismo pero sin salto de linea*/
void pintarMenu(); /*Este metodo pinta el menú principal del programa*/
int menuDificultad(); /*Esta funcion pinta el menú de seleccion de dificultad y le pide al usuario que seleccione
una de las tres dificultades ademas de devolver el valor de la dificultad elegida*/

void mostrarMapa(int laberinto[AltoLaberinto][AnchoLaberinto]){
	
	int i,j;
	
	for(i=0;i<AltoLaberinto;i++){
		for(j=0;j<AnchoLaberinto;j++)
			printf("%3d",laberinto[i][j]);
	puts("");
	}
}
void generarMapa(int laberinto[AltoLaberinto][AnchoLaberinto],int dificultad){
	
	int i,j;
	
	
/*	aqui la idea es hacer un random segun cada dificultad y guardar las posiciones de los muros en un array, y si coinciden esas posiciones se colocará un muro*/
	
	for(i=0;i<AltoLaberinto;i++)
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
				}
			}
			
		}
		
	
	
}
void pintarCentradoSinSalto(char *cadena){
	
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
		pintarCentrado("	   __       _               _       _              ___                  _ ");
		pintarCentrado("	  / /  __ _| |__   ___ _ __(_)_ __ | |_ ___       /   \\__ _ _ __ ___   / |");
		pintarCentrado("	 / /  / _` | '_ \\ / _ \\ '__| | '_ \\| __/ _ \\     / /\\ / _` | '_ ` _ \\  | |");
		pintarCentrado("	/ /__| (_| | |_) |  __/ |  | | | | | || (_) |   / /_// (_| | | | | | | | |");
		pintarCentrado("	\\____/\\__,_|_.__/ \\___|_|  |_|_| |_|\\__\\___/   /___,' \\__,_|_| |_| |_| |_|");
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
	pintarCentrado("	   __       _               _       _              ___                  _ ");
	pintarCentrado("	  / /  __ _| |__   ___ _ __(_)_ __ | |_ ___       /   \\__ _ _ __ ___   / |");
	pintarCentrado("	 / /  / _` | '_ \\ / _ \\ '__| | '_ \\| __/ _ \\     / /\\ / _` | '_ ` _ \\  | |");
	pintarCentrado("	/ /__| (_| | |_) |  __/ |  | | | | | || (_) |   / /_// (_| | | | | | | | |");
	pintarCentrado("	\\____/\\__,_|_.__/ \\___|_|  |_|_| |_|\\__\\___/   /___,' \\__,_|_| |_| |_| |_|");
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
	mostrarMapa(laberinto);
	
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

