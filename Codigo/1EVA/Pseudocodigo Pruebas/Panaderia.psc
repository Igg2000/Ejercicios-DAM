Proceso sin_titulo
	
	x es cadena;
	Pa,Pb,Pc,ultimapulsacion,finalizardia,PorcentajeA,PorcentajeB,PorcentajeC es numero;
	
	finalizardia<-0;
	ultimapulsacion<-0;
	Pa<-0;
	Pb<-0;
	Pc<-0;

	Escribir "**********************************************:";
	Escribir "Pulsa segun el tipo de barra de pan que vendas:";
	Escribir "a. Pistola (0,45)";
	Escribir "b. Gallega (0,50)";
	Escribir "c. Integral (0,60)";
	Escribir "cancelar";
	Escribir "fin";
	Escribir "**********************************************:";
	
	
	//esto es para que el switch lo reconozca e interprete cancelar como una d, y fin como una e
	repetir
		leer x;
		si x == 'cancelar'
			x<-'d';
		FinSi
		
		si x == 'fin'
			x<-'e';
		FinSi 
		//esto es para que segun lo que introduzcas haga una cosa u otra
		Segun x Hacer
			'a':
				//añadimos un contado para cada barra de pan, para saber cuantas hemos vendido y mas tarde poder multiplicarlas
				Pa<-Pa+1;
				//creamos una variable para saber cual es la ultima tecla que hemos pulsado
				ultimapulsacion<-1;
				escribir "Has vendido una barra de pan: Pistola (+0,45)";
			'b':
				Pb<-Pb+1;
				ultimapulsacion<-2;
				escribir "Has vendido una barra de pan: Gallega (+0,50)";
			'c':
				Pc<-Pc+1;
				ultimapulsacion<-3;
				escribir "Has vendido una barra de pan: Integral (+0,60)";
			'd':
				//dependiendo de la ultima tecla que hemos pulsado
				si ultimapulsacion ==1
					Pa<-Pa-1;
					escribir "Se ha cancelado la venta de la barra de pan: Pistola (-0,45)";
				FinSi
				si ultimapulsacion ==2
					Pb<-Pb-1;
					escribir "Se ha cancelado la venta de la barra de pan: Gallega (-0,50)";
				FinSi
				si ultimapulsacion ==3
					Pc<-Pc-1;
					escribir "Se ha cancelado la venta de la barra de pan: Integral (-0,60)";
				FinSi
				si ultimapulsacion ==0
					escribir "Solo puedes cancelar una venta";
				FinSi
				ultimapulsacion<-0;
			'e':
				finalizardia<-1;
				escribir "El dia a finalizado";
			De Otro Modo:
				Escribir "No has pulsado un boton valido";
		Fin Segun
	Hasta Que finalizardia==1
//esto es para saber el porcentaje de barras vendidas
PorcentajeA<-Pa*100/(Pa+Pb+Pc);
PorcentajeB<-Pb*100/(Pa+Pb+Pc);
PorcentajeC<-Pc*100/(Pa+Pb+Pc);

//aqui he calculado el dinero total multiplicando el precio de cada barra por el numero de barras vendidas
Escribir "**********************************************:";
Escribir "Has vendido:";
Escribir Pa," (" PorcentajeA "%) Pistolas (" Pa*0.45 ") euros";
Escribir Pb," (" PorcentajeB "%) Gallegas (" Pb*0.50 ") euros";
Escribir Pc," (" PorcentajeC "%) Integrales (" Pc*0.60 ") euros";
Escribir "Hoy en total has vendido " Pa+Pb+Pc " barras de pan y has generado: ", (Pa*0.45)+(Pb*0.50)+(Pc*0.60) " euros";
Escribir "fin";
Escribir "**********************************************:";


	
FinProceso
