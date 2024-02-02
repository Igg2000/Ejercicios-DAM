#include <stdio.h>

int main(int argc, char *argv[]) {
	
	
	int n,salir;
	
	salir=0;
	
	
	do
	{
		fflush(stdin);
		scanf("%d",&n);
		switch (n)
		{
			case 1:{
				printf("  ^   ^    \n");
				printf("    ·      \n");
				printf(" \\_____/   \n");
				break;
			}
			
			case 2:{
				printf("  v   v    \n");
				printf("    ·      \n");
				printf("  _____    \n");
				printf(" /     \\  \n");
				break;
			}
			case 3:{
				printf("  o   o    \n");
				printf("    ·      \n");
				printf("  _____   \n");
				break;
			}
			default: {
				salir=1;
				break;
			}
		};
	}while (salir==0);
	return 0;
}

