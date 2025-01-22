# Con la almohadilla para comentar

"""
Esto es una string, pero al no guardarlo en una variable, 
se convierte en un comentario
"""

'''
Tambien se puede hacer con comillas simples
'''

#Las variables se declaran con letras numeros o _
#Pero no pueden empezar con un numero

variable1=3
variable2=4
_variable3=5
#4variable=6 da error
# variable@=7 da error
print()
print(variable1)
print(variable2)
print(_variable3)


#Pueden ser:
#numeros: enteros o flotantes
#strings: cadenas de texto
#booleanos: True o False

a=False
b="Soy un texto"
c=3.14
print()
print(a)
print(b)
print(c)

print()

#La linea invertida sirve para decir que sigues en otra linea

d=1+2+3+4+\
    5+6+7+8

print(d)

#con parentesis se puede hacer en varias lineas
e=(1+2+3+4+
    5+6+7+8)
print(e)


#con punto y coma se pueden poner varias instrucciones en una linea pero te protesta
g=1; h=2; i=3  # noqa: E702
print(g);print(h);print(i)  # noqa: E702


print()
#para interactuar con el usuario se usa input()

nombre=input("Cual es tu nombre? ")
#asi se puede concatenar
print("Hola",nombre)
print("Hola "+nombre)


#Para convertir un tipo de variable a otro se usa int(), str(), float(), bool()

#tambien se puede concatenar usando string formateadas

print(f"Hola {nombre} la variable g vale {g}")
