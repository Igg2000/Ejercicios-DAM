#include <stdio.h>
#include <conio.h>
/*si no funciona el system cls añadir #include <stdlib.h> */
#define SaltoV 3
#define SaltoH 1
void gotoxy( int x, int y );


void gotoxy( int x, int y )
{
	printf( "\033[%d;%df", y, x );
	
}


int main(int argc, char *argv[]) {
	
	int posx, posy;
	int i,j,cont,mov;
	
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
		},
		{
			"  º   º  ",
			"  _____  ",
			" |_____| ",	
		}	
	
	};
	
	
	
	cont=0;
	
	posx=50; /*horizontal Max 113*/
	posy=14; /*vertical Max 28*/
	
	
	for(i=0;i<3;i++){
		gotoxy(posx,(posy+cont));
		for(j=0;j<10;j++)
			printf("%c",caras[0][i][j]);
		cont++;
	}
	
	
	do{
	mov=getch();
	system("cls");
	cont=0;
	switch(mov)
	{
		case 'A':
		case 'a':{
			for(i=0;i<3;i++){
				gotoxy(posx - SaltoH, posy+cont);
				for(j=0;j<10;j++)
					printf("%c",caras[2][i][j]);
				cont++;
				
			}posx=(posx - SaltoH); 
			break;
		}
		case 'D':
		case 'd':{
			for(i=0;i<3;i++){
				gotoxy(posx + SaltoH, posy+cont);
				for(j=0;j<10;j++)
					printf("%c",caras[3][i][j]);
				cont++;
			
			}posx=(posx + SaltoH); 
		break;
		}	
		case 'W':
		case 'w':{
			for(i=0;i<3;i++){
				gotoxy(posx, posy-SaltoV+cont);
				for(j=0;j<10;j++)
					printf("%c",caras[0][i][j]);
				cont++;
			 
			}posy=(posy - SaltoV);
			break;
		}
		case 'S':
		case 's':{
			for(i=0;i<3;i++){
				gotoxy(posx, posy+SaltoV+cont);
				for(j=0;j<10;j++)
					printf("%c",caras[1][i][j]);
				cont++;
				
			}posy=(posy + SaltoV); 
			break;
		}	
	}
	
	}while (mov=='a' || mov=='A' || mov=='d' || mov=='D' || mov=='w' || mov=='W' || mov=='s' || mov=='S');
	
	return 0;
}

