#include <stdio.h>
#define Tam 8

void rellenar_A(int letras[Tam][Tam])
{
	int i,j;
	/*i=fila j=columna */

	for(i=0;i<Tam;i++)
		for(j=0;j<Tam;j++)
			if (i==0 || j==0 || j==Tam-1 || i==(Tam/4+1))
				letras[i][j]=1;
			else
				letras[i][j]=0;
	
}

void rellenar_B(int letras[Tam][Tam])
{
	int i,j;
	/*i=fila j=columna */
	
	for(i=0;i<Tam;i++)
		for(j=0;j<Tam;j++) 
			/*El primer () es para que la primera fila no llegue al final, el segundo () es para que la ultima columna no pinte el primer y ultimo hueco
			Y el tercer parentesis es para que la ultima fila no llegue al final*/
			if ((i==0 && j<Tam-1) || j==0 || (j==Tam-1 && i>0 && i<Tam-1) || (i==Tam-1 && j<Tam-1) || i==(Tam/2-1))
				letras[i][j]=1;
			else
				letras[i][j]=0;
			
}

void rellenar_C(int letras[Tam][Tam])
{
	int i,j;
	/*i=fila j=columna */
	
	for(i=0;i<Tam;i++)
		for(j=0;j<Tam;j++)
			if (i==0 || j==0 || i==Tam-1)
				letras[i][j]=1;
			else
				letras[i][j]=0;
			
}

void rellenar_O(int letras[Tam][Tam])
{
	int i,j;
	/*i=fila j=columna */
	
	for(i=0;i<Tam;i++)
		for(j=0;j<Tam;j++)
			if (i==0 || j==0 || j==Tam-1 || i==Tam-1)
				letras[i][j]=1;
			else
				letras[i][j]=0;
			
}

void pintarLetras(char c,int letras[Tam][Tam],char car)
{
	int i,j;
	
	rellenar_C(letras);
	
	
	
	for(i=0;i<Tam;i++)
	{
		for(j=0;j<Tam;j++)
			if(letras[i][j]==1)
				printf("%c",car);
			else
				printf(" ");
		
		puts("");
	}
}

int main(int argc, char *argv[]) {
	
	
	
	int letras[Tam][Tam];
	char car;
	
	car='$';
	
	
	pintarLetras('A',letras,car);
	
	
	return 0;
}

