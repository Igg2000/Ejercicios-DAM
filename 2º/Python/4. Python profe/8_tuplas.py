# Las tuplas son listas con particularidades
# No se pueden modificar
# Se definen con paréntesis () y sus elementos entre comas ,

tupla = ('elem0', 'elem1', 2, 3, 4.4, 5.5, True, False, ["elem8_0","elem8_1"])
print(tupla)



# También pueden definirse sin paréntesis
# Esto se llama empaquetar una tupla
tupla2 = 'elem0', 'elem1', 2, 3, 4.4, 5.5, True, False, ["elem8_0","elem8_1"]
print(tupla2)



# Podemos convertir una tupla en una lista con list() y al revés con tuple()
lista = list(tupla)
tupla3 = tuple(lista)
print(lista)
print(tupla3)



# Para acceder a un elemento, se pone el índice al que queremos acceder
print(tupla[4])



# Para acceder al índice de un elemento
a = tupla.index("elem1")
print(a)



# Para ver si un elemento está en una tupla
print("elem4" in tupla) # No está, False
print("elem1" in tupla) # Está, True



# Para saber cuántas veces hay un elemento en una lista o tupla
print(tupla.count("elem0"))
print(lista.count("elem0"))



# Para saber la longitud de una lista o tupla
print(len(tupla))
print(len(lista))



# Igual que podemos empaquetar una tupla, podemos desempaquetar
# Desempaquetar una tupla es definir variables de una sola vez
a,b,c,d,e,f,g,h,i=tupla
print(a)
print(b)
print(c)