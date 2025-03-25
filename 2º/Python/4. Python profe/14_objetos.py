# Herencia

# Clase padre o super clase o clase super
class vehiculo():
    def __init__(self, ruedas, largo, ancho):
        self.ruedas=ruedas
        self.ancho=ancho
        self.largo=largo

    # Método de acceso get
    def getatributos(self):
        return f"Ruedas: {self.ruedas}, Ancho: {self.ancho}, Largo: {self.largo}"
    
    #Métodos
    def arrancar():
        print("Motor en marcha")

    def parar():
        print("Motor parado")


        
    

# Para definir una clase hija, ponemos su clase padre entre paréntesis
class moto(vehiculo):
    # Constructor
    def __init__(self, ruedas, largo, ancho, cilindrada):
        super().__init__(ruedas, largo, ancho)
        self.cilindrada=cilindrada

    # Método get
    def getatributos(self):
        return super().getatributos() + " Cilindrada: " + str(self.cilindrada)
    



# Objetos/ ejemplares/ instancias
fordfocus=vehiculo(4,4,2)
print(fordfocus.getatributos())

hondacbf=moto(2,2,1,600)
print(hondacbf.getatributos())