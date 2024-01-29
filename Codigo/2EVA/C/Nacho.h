#include <stdio.h>


void DibujarRectangulo(int alto, int ancho, char CarContorno, char CarRelleno)






void DibujarRectangulo(int alto, int ancho, char CarContorno, char CarRelleno)
{
	int i,j;
	
	char Rectangulo[alto][ancho];
	
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


