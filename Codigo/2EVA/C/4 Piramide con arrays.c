#include <stdio.h>
#define Alto 15
#define Ancho 29 /*Altura x2 -1*/

void PintarMargen(int n)
{
	int i;
	for (i=0;i<n;i++)
		putchar(' ');
}

void InicializarPantalla(char pantalla[Alto][Ancho])
{
	int i,j;
	
	for (i=0;i<Alto;i++)
	{
		for(j=0;j<Ancho;j++)
		{
			
			if ((i+j>Alto-1) && (j-i<Alto-1) )
				pantalla[i][j]='X';
			else
				pantalla[i][j]=' ';	
			
		}
	}
}

void PintarPantalla(char pantalla[Alto][Ancho])
{
	int i,j;
	
	for (i=0;i<Alto;i++)
	{
		PintarMargen(Ancho);
		for(j=0;j<Ancho;j++)
		{
			putchar(pantalla[i][j]);
		}
		putchar('\n');
	}
}

int main(int argc, char *argv[]) {
	
	char pantalla[Alto][Ancho];
	
	InicializarPantalla(pantalla);
	PintarPantalla(pantalla);
	
	
	return 0;
}

