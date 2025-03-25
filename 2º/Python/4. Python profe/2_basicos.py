# La almohadilla para comentar

"""Las comillas tres veces
para poder comentar en varias
lineas
aunque esto no como tal un comentario, sino una string
pero al no darle valor en una variable 
no afecta en nada al código
"""

'''También valen las comillas simples
poniéndolas 3 veces
'''





# Las variables se declaran con letras, números y _
# Pueden empezar con letra o _, no con número
# Es sensible a mayúsculas y minúsculas
# No hace falta declarar las variables previamente,
    # lo podemos hacer en cualquier momento,
    # incluso cambiarle el tipo
# Pueden ser de los tipos:
    # Número: entero int, real float, complejos también
    # Texto string
    # Booleanos True, False

variable1=3
Variable2=4
_variable3=5
#4variable=3 # Da error

print(variable1)
print(Variable2)
print(_variable3)
#print(4variable)

a=False
b="Soy un texto"
c=7

print(a)
print(b)
print(c)





# Cada instrucción debe ir en una línea y no hace falta poner punto y coma ;
# Se puede usar ; para separar varias instrucciones en una misma línea,
    # algo no recomendado, para ayudar a leer mejor el código
print(5)
print(7); print("Hasta luego")

# La barra invertida sirve para cambiar de línea una misma instrucción
# Por lo general no se usará nunca, solo cuando la instrucción sea muy larga,
    # siempre con la idea de mejorar la legibilidad
a = 5 + 6 + 9 \
      + 3 + 5
print(a)





# Con las 3 comillas, hemos visto que podemos saltar de línea en las string
texto="""En un lugar de La Mancha,
de cuyo nombre no quiero acordarme,
no ha mucho tiempo que vivía un hidalgo
de los de lanza en astillero,
adarga antigua, rocín flaco y galgo corredor."""
print(texto)





# Para interactuar y pedir datos usamos input()
# input() trae una string, con lo que habría que transformar a número
# Esto lo hacemos con int()
# Lo contrario lo hacemos con str()
numero1=int(input("Dame un número para multiplicarlo por otro: "))
numero2=int(input("Dame el otro número: "))
producto=numero1*numero2
print(producto)

# Para imprimir mensajes
# Podemos crear una sola string concatenando con + y str()
print("El resultado de multiplicar " + str(numero1) + " y " + str(numero2) + " da " + str(producto))

# Podemos dar varias instrucciones de impresión con coma ,
print("El resultado de multiplicar", numero1, "y", numero2, "da", producto)

# O también podemos usar las string formateadas, es decir las f-string
# Antes de comenzar la string, ponemos una f, luego las comillas,
    # y dentro vamos llamando variables con llaves {}
print(f"El resultado de multiplicar {numero1} y {numero2} da {producto}")





# El tipado es fuerte
a="7"
b=3
#c=a+b # Da error
#print(c)
d=int(a)
print(d+b)





# Operadores
    # Lógicos: and, or, not
    # Aritméticos: + - * / % //
    # Comparativos: == != < > >= <=
    # Asignar: = += -= *= /= %= //=
    # Especiales: in, not in, is, is not