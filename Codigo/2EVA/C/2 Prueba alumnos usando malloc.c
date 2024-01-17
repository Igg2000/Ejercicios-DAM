#include <stdio.h>
#define MAX 3

int main(int argc, char *argv[]) {
	
	
	int edalum[MAX]; /*edad alumno*/
	char nomalum2[MAX][10]; /*nombre alumno*/
	int i=0;
	int mayor= 0;
		
	for(i=0;i<MAX;i++) 
	{
		printf ("Alumno %d\n",(i+1));
		printf ("---------------\n");
		printf ("Indica el nombre del alumno\n");
		fflush(stdin); /*borrar el buffer*/
		gets (nomalum2[i]);
		
		/*tengo pendiente usar lo del malloc aqui*/
		printf ("Indica la edad del alumno\n");
		
		do 
		{
			fflush(stdin); /*borrar el buffer*/
			scanf ("%d", &edalum[i]);
			if (edalum[i]<3 || edalum[i]>50)
			{
				printf ("Dudo mucho que con %d seas alumno, introduce una edad valida\n",edalum[i]);
			}
			
		}
		while (edalum[i]<3 || edalum[i]>50);
		
		printf ("\n");
		printf ("\n");
	}
	

	
	for (i=1;i<MAX;i++)
	{
		if (edalum[i]>edalum[mayor])
		{
			mayor=i;
		}
			
	}
	
	
	printf ("El alumno mas mayor es %s con una edad de %d \n",nomalum[mayor],edalum[mayor]);

	return 0;
}

