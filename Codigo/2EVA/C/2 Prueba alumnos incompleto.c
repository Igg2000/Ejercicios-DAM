#include <stdio.h>
#define MAX 5

int main(int argc, char *argv[]) {
	
	
	int edalum[MAX]; /*edad alumno*/
	char nomalum[MAX,20]; /*nombre alumno*/
	int i=0;
	
	
	for(i=0;i<MAX;i++) 
	{
		printf ("Alumno %d\n",(i+1));
		printf ("---------------\n");
		printf ("¿Cual es el nombre del alumno\n");
		/*tengo que hacer un bucle extra para el array bidimensional*/
		scanf ("%c", &nomalum[i]);
		
		printf ("¿Cual es la edad del alumno\n");
		
		do 
		{
			fflush(stdin); /*borrar el buffer*/
			scanf ("%d", &edalum[i]);
			if (edalum[i]<3 || edalum[i]>50)
			{
				printf ("Dudo mucho que con %d años seas alumno, introduce una edad valida\n",edalum);
			}
			
		}
		while (edalum[i]<3 || edalum[i]>50);
		
		printf ("\n");
		printf ("\n");
	}
	
	
	
	return 0;
}

