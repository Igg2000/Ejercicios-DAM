#include <stdio.h>

void DibujarLetra(int letra, char c)
{
	
	
	
	switch (letra)
	{
	case 'a':
	case 'A':
	{
		printf("%c%c%c%c%c%c\n",c,c,c,c,c,c);
		printf("%c    %c\n",c,c);
		printf("%c    %c\n",c,c);
		printf("%c%c%c%c%c%c\n",c,c,c,c,c,c);
		printf("%c    %c\n",c,c);
		printf("%c    %c\n",c,c);
		printf("%c    %c\n",c,c);
		printf("%c    %c\n",c,c);
	
		break;
	}
	case 'b':
	case 'B':
	{
		printf("%c%c%c%c%c\n",c,c,c,c,c);
		printf("%c    %c\n",c,c);
		printf("%c    %c\n",c,c);
		printf("%c%c%c%c%c\n",c,c,c,c,c);
		printf("%c    %c\n",c,c);
		printf("%c    %c\n",c,c);
		printf("%c    %c\n",c,c);
		printf("%c%c%c%c%c\n",c,c,c,c,c);
		
		break;
	}
	case 'c':
	case 'C':
	{
		printf("%c%c%c%c%c%c\n",c,c,c,c,c,c);
		printf("%c     \n",c);
		printf("%c     \n",c);
		printf("%c     \n",c);
		printf("%c     \n",c);
		printf("%c     \n",c);
		printf("%c     \n",c);
		printf("%c%c%c%c%c\n",c,c,c,c,c);
		
		break;
	}
	default:
	{
		printf("Esa no la tengo");
		break;
	}
	};
	
	
	
}

int main(int argc, char *argv[]) {
	
	int FueraABC=0;
	int letra;
	
	char carLetra = 'º';
	
	do
	{
		fflush(stdin);
		scanf("%c",&letra);
		fflush(stdin);
		if (letra=='.')
			FueraABC=1;
		DibujarLetra(letra,carLetra);
		
	}while (FueraABC==0);
	
	return 0;
}

