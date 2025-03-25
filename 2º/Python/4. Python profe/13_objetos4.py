# Para encapsular, python no funciona como Java u otros.
# Poniendo una barra baja _ protegemos, pero las hijas pueden modificar.
# Poniendo dos barras bajas, las hijas tampoco pueden modificar.

class moto():
    # Atributos
    _ruedas=0
    largo=0
    ancho=0
    cilindrada=0

    # Constructor:
    def __init__(self, ruedas, largo, ancho, cilindrada):
        self._ruedas=ruedas
        self.largo=largo
        self.ancho=ancho
        self.cilindrada=cilindrada
    
    # Métodos
    def arrancar(self):
        self.arrancada=True

    def estado(self):
        if self.arrancada:
            return "La moto está arrancada"
        else:
            return "La moto está parada"
    
    # Método tipo get
    def atributos(self):
        return "Tu moto tiene " + str(self._ruedas) + " ruedas, " + \
            str(self.cilindrada) + " centímeros cúbicos de cilindrada, mide " + \
            str(self.ancho) + " de ancho y " + str(self.largo) + " de largo."
    
    # Método set
    def setruedas(self, ruedas):
        self._ruedas=ruedas

# Para definir objetos/ejemplares/instancias a partir de la clase
honda=moto(2,2,0.5,600,False)
suzuki=moto(2,2,0.4,500,False)

print(honda.atributos())