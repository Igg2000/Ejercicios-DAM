#include <stdio.h>
#define MIN 97 /*Define en que numero va a empezar la lista*/
#define MAX 27 /*Define como de grande va a ser la lista*/
int main(int argc, char *argv[])
{
	int i;
	int HayN=0;
	int lista[MAX];
	int cont=0;
	
	for (i=0;i<MAX+1;i++)
	{
		/*	Esto es para que cuando toque una o ponga una ñ, ya que va antes de la o*/
		if (cont+MIN==111)
		{
			lista[cont]=164;
		 	cont=cont+1;
		 	HayN=1;
		}
		else
		{
			if (HayN==1)
			{
				lista[cont]=(cont+MIN-1);
				cont=cont+1;
			}
			else
			{
				lista[cont]=(cont+MIN);
				cont=cont+1;
			}	
		}		
	} 
		
	for (i=0;i<MAX;i++)
	{
	
		if ((i%10==0) && (i!=0))
		{
			printf ("\n");
		}
		
		printf(" %c ",lista[i]);
	}
	
	printf ("\n");
	return 0;
}
