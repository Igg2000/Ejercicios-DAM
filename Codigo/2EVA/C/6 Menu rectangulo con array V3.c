#include <stdio.h>
#include "Nacho.h"

#define ancho 80
#define alto 10
/*
void DibujarRectangulo( char Rectangulo[alto][ancho], char CarContorno, char CarRelleno)
{
	int i,j;
	
	for(i=1;i<=alto;i++)
	{
		for(j=1;j<=ancho;j++)
		{
			if (j==1 || i==1 || i==alto || j==ancho)
			{
				Rectangulo[i][j]=(CarContorno);
			}
			else
			{
				Rectangulo[i][j]=(CarRelleno);
			}
		}
	}



	for(i=1;i<=alto;i++)
	{
		for(j=1;j<=ancho;j++)
		{
			printf("%c",Rectangulo[i][j]);
		}
		printf("\n");
	}

}
*/

void pintarMenu()
{
	printf("____________________ \n");
	printf("1. Dibujar contorno \n");
	printf("2. Dibujar relleno \n");
	printf("3. Dibujar ambos \n");
	printf("____________________ \n");
}
int main(int argc, char *argv[]) {
	
	char opcion;
	
	/*
	
	printf("Introduce el alto del retangulo \n");
	fflush(stdin);
	scanf("%d",&alto);
	printf("Introduce el ancho del retangulo \n");
	fflush(stdin);
	scanf("%d",&ancho);
	printf("\n");
	
	*/
	
	char CarContorno='X';
	char CarRelleno='/';
	int salida=0;
	
	pintarMenu();
	
	
	printf("Elige una opcion \n");
	
	do
	{
		fflush(stdin);
		scanf("%c",&opcion);
		fflush(stdin);
		
		 switch (opcion)
		 {
			case '1': 
			{
				DibujarRectangulo(alto,ancho, CarContorno, ' ');
				salida=1;
				break;
			}
				 
			case '2': 
			{
				DibujarRectangulo(alto,ancho,' ', CarRelleno);
				salida=1;
				break;
			}
				 
			case '3': 
			{
				DibujarRectangulo(alto,ancho,CarContorno, CarRelleno);
				salida=1;
				break;
			}
				
			case 'S':
			case 's':
			{
				salida=1;
				break; 
			}	
			default:
				printf("Elige una opcion valida\n");
		 }
		 printf("salida: %d",salida);
	} while(!salida);
	
	return 0;
}

