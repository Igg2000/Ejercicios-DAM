#include <stdio.h>

int main(int argc, char *argv[]) {
	
	char frase[50];
	int x,i;
	
	i=0;
	x=1;
	while (x==1) {
		printf ("Escribe una frase\n");
		scanf ("%49[^\n]",frase);
		i=i+1;
		printf ("¿Quieres escribir otra frase?\n");
		printf ("1=Si\n");
		printf ("2=No\n");
		scanf ("%d",&x);
	}
	
	printf ("Has escrito %d frases",i);
	
	/* para que esto funcione en C hay que hacer piruetas   [^] te salta los espacios %49 es el limite de palabras*/
	return 0;
}

