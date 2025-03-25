
#include <stdio.h>

#define MAXAlto 30
#define MAXAncho 100

void dibujarRectangulo(int alto, int ancho, char CarContorno, char CarRelleno);


void dibujarRectangulo(int alto, int ancho, char CarContorno, char CarRelleno)
{
	int i,j;

	char Rectangulo[MAXAlto][MAXAncho];

	//Relleno el array
	for(i=0;i<alto;i++)
		for(j=0;j<ancho;j++)
			if (j==0 || i==0 || i==alto-1 || j==ancho-1)
				Rectangulo[i][j]=CarContorno;
			else
				Rectangulo[i][j]=CarRelleno;

    //Pinto el contenido del array
	for(i=0;i<alto;i++)
    {
		for(j=0;j<ancho;j++)
			printf("%c",Rectangulo[i][j]);

		printf("\n");
	}

	printf("\nFIN");

}


