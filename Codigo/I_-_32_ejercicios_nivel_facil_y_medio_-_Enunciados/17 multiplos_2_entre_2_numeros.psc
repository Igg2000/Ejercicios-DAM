Algoritmo multiplos_2_entre_2_numeros
	
MIN,MAX,i,re,cont,acum es entero;	

Escribir "Escribe un numero";
Leer MIN;
cont<-0;
acum<-0;

Repetir
	Escribir "Escribe otro numero mayor o igual al anterior";
	Leer MAX;
Hasta Que MAX>=MIN

Para i<-1 Hasta MAX Con Paso 1 Hacer
	re<-2*i;
	si re<= MAX y re>= MIN
		cont<-cont+1;
		acum<-acum+re;
		escribir "2 x " i " = " re;
	FinSi
Fin Para

Escribir "Desde " MIN " hasta " MAX " hay " cont " multiplos ";
Escribir "y la suma de sus multiplos es : " acum ; 

	
	
FinAlgoritmo
