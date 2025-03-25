#include <stdio.h>

int main(int argc, char *argv[]) {
	
	int MAX,MIN,num;
	
	printf ("Escribe un numero\n");
	
	scanf ("%d",&num);
	
	MAX=num;
	MIN=num;
	
	printf ("Escribe un numero\n");
	
	scanf ("%d",&num);
	
	if (num<MAX){
		MIN=num;
	}
	else {
		MAX=num;
	}
	
	printf ("Que quieres hacer con estos numeros \n");
	printf ("1. Sumarlos\n");
	printf ("2. Restarlos\n");
	
	scanf ("%d",&num);
	
	switch (num)
	{
		case 1:
			printf ("%d", MAX + MIN);
			break;
		case 2:
			printf ("%d", MAX - MIN);
			break;
		default:
			printf ("Error");
			break;
	}
	
	return 0;
}

