#include <stdio.h>
#include <conio.h>

void pintarMargen(int x);

void pintarMargen(int x){
	
	int i;
	
	for (i=0;i<x;i++)
		printf(" ");
	
}

int main(int argc, char *argv[]) {
	
	int i,j,k,l,contEspacio ;
	
	char Pacman[3][4][7]=
	{
		{
			"  .--. ",
			" / ___·",
			" \\    .",
			"  ·--· ",
		},
		{ 
			"  .--. ",
			" / _.-·",
			" \\  ·-.",
			"  ·--· ",
		},
		{
		
			"  .--. ",
			" / _/  ",
			" \\  \\  ",
			"  ·--' ",
		
		}
	
	};
	

	
	contEspacio=0;
	
	puts("Pulse para comenzar");
	
	
	/*Esta parte se encarga de pintar el pacman*/
	
	for (l=0;l<20;l++){
		
		for (k=0;k<3;k++){
			
			getch();
			system("cls");
			
			for(i=0;i<4;i++){
				pintarMargen(contEspacio);
				for(j=0;j<7;j++){
					printf("%c",Pacman[k][i][j]);
				}
				puts("");
			}
			contEspacio++;
		}
		
	}
	return 0;
}

