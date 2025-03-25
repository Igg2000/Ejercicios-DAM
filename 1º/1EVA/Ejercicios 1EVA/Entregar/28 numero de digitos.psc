Proceso ejercicio28
	num es entero;
	cad es cadena;
	
	escribir "escribe un numero";
	//para poder leer el numero con la funcion longitud debe ser de tipo cadena
	leer cad;
	//esta funcion te convierte la cadena en un entero, lo que hace que si metes algo que no sea un numero te salte un error
	num<-convertiranumero(cad);
	//con la funcion de longitud sacamos directamente la longitud
	Escribir num " contiene " longitud(cad) " digitos ";
	
	
FinProceso
