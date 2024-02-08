#include <stdio.h>
#include <conio.h>
#define TamX 27
#define Barrido 15


void inicializarX(int x[TamX][TamX]);
void pintar(int x[TamX][TamX]);
void pintarMargen(int x);

void pintarMargen(int x){
	
int i;

for (i=0;i<x;i++)
	printf(" ");
	
}

void inicializarX(int x[TamX][TamX]){
	
	int i,j;
	
	for (i=0;i<TamX;i++)
		for (j=0;j<TamX;j++)
			if (i==j || i+j==(TamX-1))
				x[i][j]=1;
			else
				x[i][j]=0;
}

void pintar(int x[TamX][TamX]){
	
	int i,j,k,cont,contEspacio;
	cont=TamX;
	contEspacio=0;
	
	for (k=0;k<Barrido;k++){
	
		for (i=0;i<TamX;i++){
			pintarMargen(contEspacio);
			for (j=0;j<cont;j++){
				if (x[i][j]==1){
					printf("X");}
				else{
					printf(" ");}
			}
			puts("");
			
		}
		getch();
		system("cls");
		cont--;
		contEspacio++;
	}
}

int main(int argc, char *argv[]) {
	
	int x[TamX][TamX];
	
	
	inicializarX(x);
	
	
	pintar(x);
	
	
	return 0;
}

