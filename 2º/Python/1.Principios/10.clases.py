
class moto():

    ruedas = 2
    largo = 2
    ancho = 1
    cilindrada = 125
    arrancada = False

    def __init__(self, marca, modelo, color):
        self.marca = marca
        self.modelo = modelo
        self.color = color

    def arrancar(self):
        if not self.arrancada:
            self.arrancada = True
            print("Arrancando la moto")
        else:
            print("La moto ya está arrancada")
        

    def acelerar(self):
        if self.arrancada:
            print("Acelerando la moto")
        else:
            print("Primero arranca la moto")

    def frenar(self):
        if self.arrancada:
            print("Frenando la moto")
        else:
            print("Primero arranca la moto")

    def apagar(self):
        if self.arrancada:
            self.arrancada = False
            print("Apagando la moto")
        else:
            print("La moto ya está apagada")

    def estado(self):
        return


moto1 = moto("Yamaha", "FZ", "Negra")

moto1.arrancar()