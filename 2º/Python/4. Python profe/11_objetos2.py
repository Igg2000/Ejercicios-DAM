# Si no queremos darle valor a los atributos desde el inicio

class moto():
    # Atributos
    ruedas=0
    largo=0
    ancho=0
    cilindrada=0
    arrancada=False
    
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
honda=moto()
suzuki=moto()

honda.largo=2
honda.ruedas=2
honda.cilindrada=600
honda.ancho=0.5

suzuki.cilindrada=500

print(honda.atributos())