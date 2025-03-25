#include <stdio.h>
#include <stdlib.h>

void gotoxy( int x, int y )
{
    printf( "\033[%d;%df", y, x );//Se pone al revés xq xa la consola es fila,columna

} // Fin de la funcion gotoxy


void borrarPantalla(){
	
	//Forma 1:	
	system( "cls" );
	
	//Forma 2:	
	printf("\033[2J");
}


	
	
void borrarLinea(){
	printf("\033[2K");
}


int main(void)
{
    borrarPantalla();
    gotoxy( 3, 10 );
    printf( "Hola\n" );
    return 0;

} // Fin de la funcion main
