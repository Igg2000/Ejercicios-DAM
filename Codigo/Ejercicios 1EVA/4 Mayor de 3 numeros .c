#include <stdio.h>

int main(int argc, char *argv[]) {
	
	int MAX,n,i;
	
	MAX=0;
	
	printf ("Escribe un numero\n");
	scanf ("%d",& n);
	MAX=n;
	
	
	for (i=1;i<3;i++)
	{
		printf ("Escribe un numero\n");
		scanf ("%d",& n);
		if (n>MAX){
			MAX=n;}
	}
	
	printf ("El mayor de estos numeros es %d",MAX) ;
	
	
	return 0;
}

