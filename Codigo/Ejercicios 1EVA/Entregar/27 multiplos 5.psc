Proceso ejercicio27
	
	i,j,re es entero;
	
	
	Para i<-1 Hasta 50 Con Paso 1 Hacer
		Para j<-1 Hasta i Con Paso 1 Hacer
			//asigno la suma a una variable por comodidad
			re<-j+i;
			//pregunto que si la suma de j+i da como resultado un multiplo de 5 y si es menor que 50
			si re MOD 5 == 0 y re<50
				//si es el caso escribo la suma
				escribir j " + " i " = " re;
			FinSi
		Fin Para
	Fin Para
	
FinProceso