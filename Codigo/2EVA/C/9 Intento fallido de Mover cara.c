#include <stdio.h>
#define Ancho 80
#define Alto 40

void InicializarPantalla(int pantalla[Alto][Ancho]);
void ColocarCarInicial(int pantalla[Alto][Ancho]);
void PintarPantalla(int pantalla[Alto][Ancho], char caras[][3][10],int m);
void MoverCar(int pantalla[Alto][Ancho]);

void InicializarPantalla(int pantalla[Alto][Ancho]){
	
	int i,j;
	
	for(i=0;i<Alto;i++)
		for(j=0;j<Ancho;j++)
			pantalla[i][j]=0;
	
}

void ColocarCarInicial(int pantalla[Alto][Ancho]){
	
	pantalla[Alto/2][Ancho/2]=1;
	
}

void PintarPantalla(int pantalla[Alto][Ancho], char caras[][3][10], int m){
	
	int i,j,x,y;
	
	for(i=0;i<Alto;i++){
		for(j=0;j<Ancho;j++){
			
			if (pantalla[i][j]==0){
				printf(".");
			}
			else{
				/*printf("X");*/
				for(x=0;x<3;x++){
					for(y=0;y<10;y++)
					printf("%c",caras[0][x][y]);
				
				puts("");
				}
			};
			
		}
		puts("");
	}
}

void MoverCar(int pantalla[Alto][Ancho]){
	
	
	
	
	
}

int main(int argc, char *argv[]) {
	
	
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
	
	
	
	
	int pantalla[Alto][Ancho];
	
	InicializarPantalla(pantalla);
	ColocarCarInicial(pantalla);
	
	PintarPantalla(pantalla,caras,0);
	/*MoverCar(pantalla);*/
	
	
	return 0;
}

