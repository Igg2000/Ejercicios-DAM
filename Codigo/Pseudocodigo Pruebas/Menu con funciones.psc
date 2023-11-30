SubProceso LeerNumeros(a Por Referencia,b Por Referencia)
	
	escribir "Introduce 2 Numeros";
	leer a,b;

	
Fin SubProceso

SubProceso ordenar(a,b)
	
	si a<b
		escribir "El mayor numero introducido es: ",b;
	FinSi
	
	si a>b
		escribir "El mayor numero introducido es: ",a;
	FinSi
	
	si a==b
		escribir "Ambos numeros son iguales";
	FinSi
	
	
Fin SubProceso

SubProceso Pintarasteriscos(a,b)
	
	n,i es entero;
	
	n<-a*b;
	
	Para i<-1 Hasta n Con Paso 1 Hacer
		escribir sin saltar "*";
	Fin Para
	escribir "";
	
	
Fin SubProceso

SubProceso Sumar(a,b)
	
	escribir "la suma de ",a," y ",b," = ",a+b;
	
Fin SubProceso

SubProceso VisMenu
	Escribir "****************************************************************************************************";
	Escribir "1. Sumar";
	Escribir "2. Pintar un numero de asteriscos equivalente a la multiplicacion de ambos numeros";
	Escribir "3. Decir cual es el mayor";
	Escribir "****************************************************************************************************";
	Escribir "";
	Escribir "Elige una opcion: ";
	
Fin SubProceso






Proceso menu
	
	a,b,n,cont es entero;
	cont<-0;
	
	LeerNumeros(a,b);
	VisMenu;
	
	repetir
	leer n;
	Segun n Hacer
		1:
			Sumar(a,b);
			cont<-1;
		2:
			Pintarasteriscos(a,b);
			cont<-1;
		3:
			ordenar(a,b);
			cont<-1;
		De Otro Modo:
			Escribir "Debes elegir una opcion valida";
	Fin Segun
	hasta que cont==1;
	
FinProceso

