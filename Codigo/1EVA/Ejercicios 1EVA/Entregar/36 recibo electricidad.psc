Algoritmo ejercicio36
	
	num1,num2,sumacont es entero;
	precio es real;
	

	escribir "Escribe las dos ultimas lecturas del contador (Kw)";
	
	leer num1,num2;
	
	si num1<=0 o num2<=0
		Repetir
			escribir "No has escrito una lectura valida, porfavor, vuelva a introducir los datos correctamente";
			leer num1,num2;
		Hasta Que num1>0 y num2>0
	FinSi
	
	//entiendo que hay que sumarlas, pero no estoy seguro ya que no se como funciona un contador de luz
	sumacont<-num1+num2;
	
	
	si sumacont>250 
		precio<- 0.50*100 + 0.35*150 + (sumacont-250)*0.20 + 10;
	sino 
		si sumacont>100
			precio<- 0.50*100 + 0.35*(sumacont-100) + 10;
		sino 
			precio<- 0.50*sumacont + 10;
		FinSi
	FinSi
	
	
	escribir "Debe pagar " precio " euros";
	
	
	
	
	
	
FinAlgoritmo
