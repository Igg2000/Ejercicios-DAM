Proceso sin_titulo
	
	x es entero;
	precio es real;
	
	escribir "Introduce precio de la compra";
	leer precio;
	
	
	
	x<-aleatorio(1,21);
	//bola blanca 0%
	si x>0 y x<11
		escribir "Ha salido una bola blanca, no tienes descuento, te toca pagar: ",precio;
	FinSi
	
	//bola verde 10%
	si x>10 y x<16
		escribir "Ha salido una bola verde, tienes 10% descuento, te toca pagar: ",precio*0.10;
	FinSi
	
	//bola amarilla 25%
	si x>15 y x<19
		escribir "Ha salido una bola amarilla, tienes 25% descuento, te toca pagar: ",precio*0.25;
	FinSi
	
	//bola azul 50%
	si x>18 y x<21
		escribir "Ha salido una bola azul, tienes 50% descuento, te toca pagar: ",precio*0.50;
	FinSi
	
	//bola roja 100%
	si x==21
		escribir "Ha salido una bola roja, la compra te sale completamente gratis";
	FinSi
	
	
FinProceso
