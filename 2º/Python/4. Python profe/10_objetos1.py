# Los objetos funcionan similar a otros lenguajes.
# Definimos una clase de objetos, y luego cada ejemplar de esta clase es un objeto.
class moto():
    ruedas=2
    largo=2
    ancho=0.5
    cilindrada=600
    arrancada=False
    # Aquí los atributos, las propiedades de la clase

    # Para los métodos, definimos como funciones
    def arrancar(self):
        self.arrancada=True

    def estado(self):
        if self.arrancada:
            return "La moto está arrancada"
        else:
            return "La moto está parada"

# Para definir objetos/ejemplares/instancias a partir de la clase
honda=moto()
yamaha=moto()

# Para llamar a los atributos de los objetos
print("Tu moto tiene",honda.ruedas,"ruedas")


honda.arrancar()
print(honda.estado())
print(yamaha.estado())