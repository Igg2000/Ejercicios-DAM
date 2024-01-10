#include <stdio.h>

int main(int argc, char *argv[]) {
	
	char x;
	printf ("escribe S o N\n");
	scanf ("%c",&x);
	
	switch (x)
	{
		case 's':
		case 'S':
			printf ("escribiste S");
			break;
		case 'N':
		case 'n':
			printf ("escribiste N");
			break; 
		default :
			printf ("Error");
			break;
	}	
	return 0;
}

