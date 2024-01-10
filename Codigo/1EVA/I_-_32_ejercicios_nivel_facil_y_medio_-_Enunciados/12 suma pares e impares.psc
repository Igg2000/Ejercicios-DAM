Algoritmo sumapareseimpares
	
	i,contp, conti es entero;
	contp<-0;
	conti<-0;
	Para i<-1 Hasta 100 Con Paso 1 Hacer
		escribir Sin Saltar i " ";
		si i mod 2 = 0
			contp<-contp+1;
			sino
				conti<-conti+1;
		FinSi
	Fin Para
	escribir " ";
	escribir "hay " contp " numeros pares";
	escribir "hay " conti " numeros impares";
FinAlgoritmo
