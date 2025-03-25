#include <stdio.h>
#include <conio.h>
#include <unistd.h>
#include <stdlib.h>


void mostrarMenu();
void menuFontanero();
void mostrarMenuFontanero();
void menuCarpintero();
void mostrarMenuCarpintero();
void menuConductor();
void mostrarMenuConductor();


void mostrarMenuFontanero(){
	
	puts("-------------------");
	puts("1. Cambiar tubería");
	puts("2. Cambiar lavabo");
	puts("-------------------");
	puts("V. Volver");
	
}

void mostrarMenu(){
	
	puts("--------------");
	puts("1. Fontanero");
	puts("2. Carpintero");
	puts("3. Conductor");
	puts("--------------");
	puts("S. Salir");
	
	
}

void menuFontanero(){
	
	char opMenu;
	int salir=0;
	
	do{
		/*muestra las opciones del menu*/
		mostrarMenuFontanero();
		/*elige la opcion del menu*/
		opMenu=getch();
		/*en funcion de la opcion elegida hace una funcion u otra*/
		switch(opMenu){
			case'1': system("cls"); puts("Cambiando tubería"); sleep(3);  puts("tubería cambiada"); sleep(1); break;
			case'2': system("cls"); puts("Cambiando lavabo"); sleep(3);  puts("lavabo cambiado"); sleep(1); break;
			case'v':
			case'V': salir=1; break;
		}
		/*se borra pantalla antes de volver al menu anterior*/
		system("cls");
	}while (salir==0);
	
	
}
	
void mostrarMenuCarpintero(){
	
	puts("-------------------------------");
	puts("1. Elegir tamaño de tablero");
	puts("2. Tipo de herramienta");
	puts("3. Visualizar datos guardados");
	puts("-------------------------------");
	puts("V. Volver");
	
}

void menuCarpintero(){
	
	char opMenu;
	int herramienta=0,alto=0,ancho=0,salir=0;
	
	
	do{
		/*muestra las opciones del menu*/
		mostrarMenuCarpintero();
		/*se elige la opcion del menu*/
		opMenu=getch();
		
		switch(opMenu){
			case'1': 
				system("cls");
				puts("Introduce el alto");
				scanf("%d",&alto);
				fflush(stdin);
				puts("Introduce el ancho");
				scanf("%d",&ancho);
				fflush(stdin);
				break;
			case'2': 
				do{
					system("cls"); 
					puts("--------------");
					puts("1. Martillo");
					puts("2. Destornillador");
					puts("--------------");
					herramienta=getch();
				}while(herramienta<'1' || herramienta>'2');
				
				break;
			case'3':
				if(herramienta==0 || alto==0 || ancho==0){
					system("cls"); 
					puts("Primero debes rellenar todos los datos");}
				else{
					system("cls"); 
					printf(" El tablero tiene %d mm de alto y %d mm de ancho\n",alto,ancho);
					if (herramienta=='1')
						printf("La herramienta utilizada es el Martillo\n");
					else
						printf("La herramienta utilizada es el Destornillador\n");				
				}
				printf("\n\nPulsa cualquier tecla para continuar...");
				getch();
			break;
			case'v':
			case'V': salir=1; break;
		}
		/*se borra pantalla antes de volver al menu anterior*/
		
		system("cls");
	}while (salir==0);
	
}
void mostrarMenuConductor(){
	
	
	puts("-------------------------------");
	puts("1. Indica origen del viaje");
	puts("2. Indica destino del viaje");
	puts("3. Indica la carga del viaje");
	puts("4. Visualizar datos guardados");
	puts("-------------------------------");
	puts("V. Volver");
	
}

void menuConductor(){
	
	char origen[40];
	char destino[40];
	char opMenu;
	int carga=0, origenindicado=0 , destinoindicado=0, salir=0;
	
	
	do{
		/*muestra las opciones del menu*/
		mostrarMenuConductor();
		/*se elige la opcion del menu*/
		opMenu=getch();
		
		switch(opMenu){
			case'1': 
				system("cls");
				puts("Indica el origen del viaje");
				gets(origen);
				origenindicado=1;
				break;
			case'2': 
				system("cls");
				puts("Indica el origen del viaje");
				gets(destino);
				destinoindicado=1;
				break;
			case'3': 
				system("cls");
				puts("Indica el peso de la carga en Kg");
				scanf("%d",&carga);
				fflush(stdin);
				break;
			case'4':
				if(origenindicado==0 || destinoindicado==0 || carga==0){
					system("cls"); 
					puts("Primero debes rellenar todos los datos");}
				else{
					system("cls"); 
					printf(" El viaje va desde %s hasta %s \n",origen,destino);
					printf(" La carga es de %d Kg \n",carga);
			
				}
				printf("\n\nPulsa cualquier tecla para continuar...");
				getch();
				break;
				case'v':
					case'V': salir=1; break;
		}
		system("cls");
	}while (salir==0);
	
	
	system("cls");
	
}
	
int main(int argc, char *argv[]) {
	
	char opMenu;
	int salir=0;

	
	do{
		/* Muestra el menu principal*/
		mostrarMenu();
		/*Elige la opcion del menu*/
		opMenu=getch();
		
		switch(opMenu){
			case'1': system("cls");menuFontanero(); break;
			case'2': system("cls");menuCarpintero(); break;
			case'3': system("cls");menuConductor();break;
			case's':
			case'S': salir=1; break;
			default: system("cls"); puts("debes elegir una opcion valida"); sleep(1); system("cls"); break;
		}
		
	} while(salir==0);
	
	return 0;
}

