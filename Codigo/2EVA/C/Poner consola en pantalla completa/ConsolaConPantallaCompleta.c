#include <stdio.h>
#include <windows.h>

int main(int argc, char *argv[]) {
	// Obtener el identificador de la consola
	HWND consoleWindow = GetConsoleWindow();
	
	// Cambiar al modo de pantalla completa
	ShowWindow(consoleWindow, SW_MAXIMIZE);
	
	printf("Hola");
	return 0;
}

