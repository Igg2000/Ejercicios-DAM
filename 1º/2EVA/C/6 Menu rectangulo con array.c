#include <stdio.h>
#define ancho 80
#define alto 10
	
void RellenarRectangulo( char Rectangulo[alto][ancho], int opcion)
{
	int i,j;
	
	for(i=1;i<=alto;i++)
	{
		for(j=1;j<=ancho;j++)
		{
			if (opcion==1)
			{
				if (j==1 || i==1 || i==alto || j==ancho)
				{
					Rectangulo[i][j]=('X');
				}
				else
				{
					Rectangulo[i][j]=(' ');
				}
			}
			else
			{
				if (opcion==2)
				{
					if (j==1 || i==1 || i==alto || j==ancho)
					{
						Rectangulo[i][j]=(' ');
					}
					else
					{
						Rectangulo[i][j]=('/');
					}
				}
				else
				{					
					if (opcion==3)
					{
						if (j==1 || i==1 || i==alto || j==ancho)
						{
							Rectangulo[i][j]=('X');
						}
						else
						{
							Rectangulo[i][j]=('/');
						}
					}
				}
			}
		}
	}
}

void DibujarRectangulo(char Rectangulo[alto][ancho])
{
	
	int i,j;
	
	
	for(i=1;i<=alto;i++)
	{
		for(j=1;j<=ancho;j++)
		{
			printf("%c",Rectangulo[i][j]);
		}
		printf("\n");
	}
}
void pintarMenu()
{
	printf("____________________ \n");
	printf("1. Dibujar contorno \n");
	printf("2. Dibujar relleno \n");
	printf("3. Dibujar ambos \n");
	printf("____________________ \n");
}
int main(int argc, char *argv[]) {
	
	int opcion;
	
	/*
	
	printf("Introduce el alto del retangulo \n");
	fflush(stdin);
	scanf("%d",&alto);
	printf("Introduce el ancho del retangulo \n");
	fflush(stdin);
	scanf("%d",&ancho);
	printf("\n");
	
	*/
	
	char Rectangulo[alto][ancho];
	
	pintarMenu();
	
	
	printf("Elige una opcion \n");
	
	do
	{
		fflush(stdin);
		scanf("%d",&opcion);
		
		 switch (opcion){
			case 1: 
			{
				RellenarRectangulo(Rectangulo,1);
				DibujarRectangulo(Rectangulo);
			}
				 break;
			case 2: 
			{
				RellenarRectangulo(Rectangulo,2);
				DibujarRectangulo(Rectangulo);
			}
				 break;
			case 3: 
			{
				RellenarRectangulo(Rectangulo,3);
				DibujarRectangulo(Rectangulo);
			}
				break;
			default:
				printf("Elige una opcion valida\n");
		 }
	} while (opcion!= 1 && opcion!= 2 && opcion!= 3) ;
	
	return 0;
}

