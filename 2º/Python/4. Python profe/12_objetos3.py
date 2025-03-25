# Si no queremos darle valor a los atributos desde el inicio

class moto():
    # Atributos
    ruedas=0
    largo=0
    ancho=0
    cilindrada=0
    arrancada=False

    # Para establecer un estado inicial, el constructor es:
    def __init__(self, ruedas, largo, ancho, cilindrada, arrancada):
        self.ruedas=ruedas
        self.largo=largo
        self.ancho=ancho
        self.cilindrada=cilindrada
        self.arrancada=arrancada
    
    # Métodos
    def arrancar(self):
        self.arrancada=True

    def estado(self):
        if self.arrancada:
            return "La moto está arrancada"
        else:
            return "La moto está parada"
        
    def atributos(self):
        return "Tu moto tiene " + str(self.ruedas) + " ruedas, " + \
            str(self.cilindrada) + " centímeros cúbicos de cilindrada, mide " + \
            str(self.ancho) + " de ancho y " + str(self.largo) + " de largo."

# Para definir objetos/ejemplares/instancias a partir de la clase
honda=moto(2,2,0.5,600,False)
suzuki=moto(2,2,0.4,500,False)

print(honda.atributos())