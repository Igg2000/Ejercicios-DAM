#include <iostream>

#include <stdio.h>

#define FIL 40
#define COL 100


using namespace std;
/*
Haz una app q tenga una función devuelva un cuadrado o una X usando un array

Ej:
rellena(1, n)
rellena('*', n)
rellena(1, n, m)-->pinta un cuad con 1 de n*n con margen m


rellena(int n, int m)	-->pinta un cuad de n*m
rellena(char c, int n)	-->pinta una X de n*n con el car c
rellena(int n, int m, int x)	-->pinta un cuad de n*m con margen x
*/

void pintaMargen(int);


//Si le paso una 'x' relleno con x; caso contrario relleno con cuad
void rellena(short a[FIL][COL], char);
void rellena(short a[FIL][COL], int , int, char);


void pinta(short a[FIL][COL],int fil, int col, char car);
void pinta(short a[FIL][COL],int fil, int col, char car, int margen);

int main(int argc, char *argv[]) {

    short a[FIL][COL];

	//rellena(a,4, 5);

	//rellena(a,4, 5, 25);

	rellena(a,9,9, 'x');

	pinta(a,9,9,'$',20);

	return 0;
}


/*Ej=3,4
	****
	****
	****
	*/
void rellena(short a[FIL][COL],int fil, int col, char c)
{
	int i,j;

	if(tolower(c)=='x')
    { //relleno en forma de X

    for(i=0;i<fil;i++)
    {
        for(j=0;j<col;j++)
            if(j==i || i==(col-j-1))
                a[i][j]=1;
            else
                a[i][j]=0;
    }

	}else
	{ //Relleno en forma de cuad
        for(i=0;i<fil;i++)
        {
            for(j=0;j<col;j++)
                a[i][j]=1;
        }
	}
}

void rellena(short a[FIL][COL], char c)
{
	rellena(a,FIL-1, COL-1, c);
}

void pinta(short a[FIL][COL],int fil, int col, char car){

    pinta(a, fil, col, car, 0);
}

void pinta(short a[FIL][COL],int fil, int col, char car, int margen){

int i,j;
	for(i=0;i<fil;i++)
	{
	    pintaMargen(margen);
		for(j=0;j<col;j++)
            if(a[i][j]==0)
                printf(" ");
            else
                printf("%c..",car);

		puts("");
	}
}

void pintaMargen(int x)
{
	int i;
	for(i=0;i<x;i++)
		printf(" ");

}
