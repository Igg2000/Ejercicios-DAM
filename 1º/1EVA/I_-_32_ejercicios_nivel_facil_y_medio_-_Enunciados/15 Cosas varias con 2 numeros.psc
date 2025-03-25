Algoritmo dosnums
	
	num,MIN,MAX,cont,contp,acumi,i es entero;
	
	Escribir "Escribe 2 numeros";
	Leer num;
	
	MIN<-num;
	MAX<-num;
	cont<-0;
	contp<-0;
	acumi<-0;
	Leer num;
	
	si num<MIN 
		MIN<-num;
	FinSi
	
	si num>MAX
		MAX<-num;
	FinSi
	
	Para i<-MIN Hasta MAX Con Paso 1 Hacer
		cont<-cont+1;
		Escribir Sin Saltar i " ";
	Fin Para
	
	escribir " ";
	escribir " ";
	Escribir "Hay " cont " numeros";
	
	escribir " ";
	escribir " ";
	escribir "los numeros pares son:";
	escribir " ";
	
	para i<-MIN hasta MAX con paso 1 Hacer
		si i MOD 2 =0 entonces
			contp<-contp+1;
			escribir Sin Saltar i " ";
		FinSi
	FinPara
	
	escribir " ";
	escribir " ";
	Escribir "Hay " contp " numeros pares";
	
	escribir "los numeros impares son:";
	escribir " ";
	
	para i<-MIN hasta MAX con paso 1 Hacer
		si i mod 2 <> 0
			acumi<-acumi+i;
			escribir Sin Saltar i " ";
		FinSi
	FinPara
	
	escribir " ";
	escribir " ";
	Escribir "La suma de los numeros impares es: " acumi ;
	
FinAlgoritmo
