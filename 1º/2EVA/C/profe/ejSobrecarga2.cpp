#include <iostream>

#include <stdio.h>

using namespace std;
/*
Haz una app q tenga una función q pinte un cuadrado o una X en pantalla

Ej:
dibuja(1, n)
dibuja('*', n)
dibuja(1, n, m)-->pinta un cuad con 1 de n*n con margen m


dibuja(int n, int m)	-->pinta un cuad de n*m
dibuja(char c, int n)	-->pinta una X de n*n con el car c
dibuja(int n, int m, int x)	-->pinta un cuad de n*m con margen x
*/

void pintaMargen(int);
void dibuja(int , int);
void dibuja(char , int );
void dibuja(int, int, int);


int main(int argc, char *argv[]) {

	dibuja(4, 5);

	puts("");

	dibuja(4, 5, 25);

	puts("");

	dibuja('*', 10);


	return 0;
}


/*Ej=3,4
	****
	****
	****
	*/
void dibuja(int fil, int col)
{
	int i,j;
	for(i=0;i<fil;i++)
	{
		for(j=0;j<col;j++)
			printf(" %c ",'*');

		puts("");
	}
}

/*Ej='*',4-->par
	*  *
	 **
	 **
	*  *

Ej='*',5 -->Impar
	*   *
	 * *
      *
	 * *
	*   *
*/
void dibuja(char cc, int nn){

	int i,j;

	for(i=0;i<nn;i++)
	{
		for(j=0;j<nn;j++)
			if(j==i || j==nn-i-1)
				putchar(cc);
			else
				putchar(' ');

		printf("\n");
	}
}





void dibuja(int fil, int col, int x){
	int i,j;
	for(i=0;i<fil;i++)
	{
		pintaMargen(x);
		for(j=0;j<col;j++)
			printf(" %c ",'*');

		puts("");
	}

}


void pintaMargen(int x)
{
	int i;
	for(i=0;i<x;i++)
		printf(" ");

}
