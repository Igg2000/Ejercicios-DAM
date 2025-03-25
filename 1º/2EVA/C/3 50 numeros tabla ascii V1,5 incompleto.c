#include <stdio.h>
#define MIN 97 /*Define en que numero va a empezar la lista*/
#define MAX 25 /*Define como de grande va a ser la lista*/
int main(int argc, char *argv[])
{
	int i;
	int HayN=0;
	int lista[MAX];
	
	for (i=0;i<MAX+1;i++)
	{
		/*	Esto es para que cuando toque una o ponga una ñ, ya que va antes de la o*/
		if (i+MIN==111)
		{
		/*	printf ("%c ",164);*/
			lista[i]=164;
			int HayN=1;
		}
		
		/*	Esto comprueba si hay una ñ, en ese caso el programa empieza a escribir el numero anterior a i, y si no lo hay pinta i*/
		if (HayN==1)
		{
			/* printf ("%c ",(i+MIN-1));*/
			lista[i]=(i+MIN-1);
		}
		else
		{
			/* printf ("%c ",(i+MIN));*/
			lista[i]=(i+MIN);
		}
				
		/*
			Si i entre 10 es igual a 0 (es decir, cada 10 numeros), se pinta un salto de linea, excepto si i es 0
	
		if ((i%10==0) && (i!=0))
		{
			printf ("\n");
		}
		
		*/
	} 
		
	for (i=0;i<MAX+1;i++)
	{
		printf("%c",lista[i]);
		
		if ((i%10==0) && (i!=0))
		{
			printf ("\n");
		}
	}
	
	printf ("\n");
	return 0;
}
