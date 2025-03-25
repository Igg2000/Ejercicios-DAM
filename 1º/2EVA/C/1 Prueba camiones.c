#include <stdio.h>
#define MAX 5

int main(int argc, char *argv[]) {
	
	
	int pcam[MAX]; /*peso de camiones*/
	int ncam[MAX]; /*numero de camiones*/
	int i=0;
	int num=0;
	
	for(i=0;i<MAX;i++) 
	{
		printf ("Llega un camión\n");
		printf ("---------------\n");
		printf ("¿Cual es el numero del camión?\n");
		do 
		{
			scanf ("%d", &ncam[i]);
			if (ncam[i]<0 || ncam[i]>6)
			{
				printf ("Tienes que introducir un numero de 1 a %d \n",MAX);
			}
		}
		while (ncam[i]<0 || ncam[i]>6);
		printf ("¿Cuantos Kg carga el camión?\n");
		scanf ("%d", &pcam[i]);
		printf ("\n");
		printf ("\n");
	}
	
	printf ("///////////////////\n");
	printf ("En orden de llegada\n");
	printf ("///////////////////\n");
	
	for (i=0;i<MAX;i++)
	{
		printf ("El camion %d carga %d Kg\n",ncam[i],pcam[i]);
	}
	
	printf ("\n");
	
	printf ("//////////////////\n");
	printf ("En orden de salida\n");
	printf ("//////////////////\n");
	
	for (i=MAX-1;i>-1;i--)
	{
		printf ("El camion %d carga %d Kg\n",ncam[i],pcam[i]);
	}
	
	return 0;
}

