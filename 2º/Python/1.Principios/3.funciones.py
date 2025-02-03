#Se hace con def nombre_funcion(): y se llama con nombre_funcion()
#los parametros se ponen entre parentesis


def function():
    print("Esto esta en la funcion")

print("Esto esta fuera de la funcion")

#para que actua debemos llamarlo
function()

#se pueden pasar parametros
def multiplicar(a,b):
    print(a*b)

multiplicar(3,4)

#se pueden devolver valores
def suma(a,b):
    return a+b

print(suma(3,4))

#se pueden devolver varios valores
def variosValores(a,b):
    return a+b,a-b,a*b,a/b

print(variosValores(10,5))

