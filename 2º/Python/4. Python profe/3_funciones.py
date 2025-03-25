# Las funciones las definimos con def funcion ():
# Siempre con los paréntesis, aunque estén vacíos
# Lo que definamos dentro de la función, con identación
# Los parámeros dentro de los paréntesis
# El return es opcional y los parámetros también

def funcion():
    print("Esto es una función")

print("Esto no es una función")

# Para que actúe, tenemos que llamar a la función
funcion()





# Una función con parámetros
def multiplicacion(a,b):
    c=a*b
    print(c)

# Cuando la llamemos, hay que darle esos mismos parámetros
multiplicacion(3,4)





# Con return
def suma(a,b):
    c=a+b
    return c

print(suma(3,4))