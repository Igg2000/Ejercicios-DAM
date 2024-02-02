#include <stdio.h>

/*
void inicializarCaras(char caras[][10]){
	
	
	caras[][10] =
	{ 
		
			"  ^   ^   ",
			"    ·     ",
			" \\_____/ ",
	};
	
	
}
*/
int main(int argc, char *argv[]) {
	
	
	int n,i,j,k;
	
	
	char caras[][3][10] =
	{
		{ 
			"  ^   ^   ",
			"    ·     ",
			" \\_____/ ",
		},
		{
			"  v   v   ",
			"  _____   ",
			" /     \\ ",
		},
		{
			"  o   o  ",
			"    ·    ",
			"  _____  ",			
		}
			
	};
	
	
	/*n=getch();*/	
	
	
	do{
		fflush(stdin);
		scanf("%d",&i);
		for(j=0;j<3;j++)
		{
			for(k=0;k<10;k++)
				if (i>=1 && i<=3)
				printf("%c",caras[i-1][j][k]);
		puts("");
		}
	}while (i>=1 && i<=3);
	/*
	salir=0;
	

	
	inicializarCaras(caras);
	*/
	/*
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
	*/
	return 0;
}

