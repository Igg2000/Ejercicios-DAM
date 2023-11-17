Algoritmo multiplos_2_o_3
	
	i,re2,re3,cont2,cont3 es entero;
	re2<-0;
	re3<-0;
	cont2<-0;
	cont3<-0;
	
	Para i<-1 Hasta 100 Con Paso 1 Hacer
		re2<-i*2;
		si re2<=100 Entonces
			si re2 mod 2 = 0
				Escribir sin saltar re2 " ";
				cont2<-cont2+1;
			FinSi
		FinSi
	Fin Para
	
	escribir " ";
	escribir " ";
	escribir " ";
	
	Para i<-1 Hasta 100 Con Paso 1 Hacer
		re3<-i*3;
		si re3<=100 Entonces
			si re3 mod 3 = 0
				escribir sin saltar re3 " ";
				cont3<-cont3+1;
			FinSi
		FinSi
	Fin Para
	
	escribir " ";
	escribir " ";
	escribir " ";
	
	Escribir "hay " cont2 " multiplos de 2";
	Escribir "hay " cont3 " multiplos de 3";
	
FinAlgoritmo
