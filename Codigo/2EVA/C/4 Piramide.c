#include <stdio.h>
#define AnchoPantalla 100

void PintarMargen(int n)
{
	int x;
	
	for (x=0;x<n;x++)
	{
		putchar(' ');
	}
}

void PintarPiramide(int n)
{
	int x,i,cont;
		cont=n;
	
		for (x=0;x<n;x++)
	{
		PintarMargen(AnchoPantalla/2);
	
		cont--;
		
		for (i=cont;i>0;i--)
		{
			putchar(' ');
			
		}
		
		
		for (i=0;i<=x*2;i++)
		{
			putchar('X');
		
		}
		
			putchar('\n');
	}
	
}


int validarEntero(n,vMin,vMax)
{
	if (n<vMin || n>vMax)
		return 0;
	else
		return 1;
}

int main(int argc, char *argv[])
{
	int n,x;
	
	do
	{
		putchar('\n');
		printf("Escribe la altura de la piramide: ");
		fflush(stdin);
		scanf("%d",&n);
		
	} while (validarEntero(n,3,25)==0);
	
	PintarPiramide(n);
		
	
	return 0;
}
