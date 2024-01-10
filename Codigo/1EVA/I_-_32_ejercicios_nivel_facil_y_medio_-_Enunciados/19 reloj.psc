Algoritmo reloj
	
	minutos, horas, MAXMinutos, MAXHoras es entero;
	
	MAXMinutos<-59;
	MAXHoras<-23;
	
	Para horas<-0 hasta MAXHoras con paso 1 Hacer
		Para minutos<-1 Hasta MAXMinutos Con Paso 1 Hacer
			si horas<10
				escribir Sin Saltar "0";
			FinSi
			escribir sin saltar horas;
			escribir sin saltar ":";
			si minutos<10
				escribir Sin Saltar "0";
			FinSi
			escribir sin saltar minutos;
			Esperar Tecla;
			Limpiar Pantalla;
		Fin Para
	FinPara
	//00:01 00:02 00:03 ... 00:59 01:00
	
FinAlgoritmo
