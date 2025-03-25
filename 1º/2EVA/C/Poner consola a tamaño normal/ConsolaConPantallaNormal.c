#include <stdio.h>
#include <windows.h>

int main(int argc, char *argv[]) {
	
	// Obtener el identificador de la consola
	HWND consoleWindow = GetConsoleWindow();
	// Cambiar al modo de ventana normal
	ShowWindow(consoleWindow, SW_RESTORE);
	
	printf("Hola");
	return 0;
}

