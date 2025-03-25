# Las listas son como los array en otros lenguajes, más o menos
# Admiten distintos tipos de variables, incluso listas anidadas
# Pueden modificarse
# El índice empieza en 0
# Se definen con corchetes [] y sus elementos entre comas ,

lista = ['elem0', 'elem1', 2, 3, 4.4, 5.5, True, False, ["elem8_0","elem8_1"]]



# Para llamarla entera
print(lista)



# Para acceder a un elemento, se pone el índice al que queremos acceder
print(lista[4])



# Para acceder al indice de un elemento
a = lista.index("elem1")
print(a)



# Para acceder a una parte
# Tener en cuenta que los índices [i:j] son i incluido, j excluido
print(lista[:3]) # Este accede desde el inicio hasta el 2
print(lista[3:]) # Este accede desde 3 hasta el final
print(lista[1:5]) # Este accede desde 1 a 4



# Para añadir un elemento al final
lista.append("Pepe")
print(lista)



# Para añadir varios elementos al final
lista.extend([10,True])
print(lista)



# Para añadir UN elemento en un lugar concreto
lista.insert(2,'Josefa')
print(lista)



# Para ver si un elemento está en la lista
print("Pepa" in lista) # No está, False
print("Josefa" in lista) # Sí está, True



# Para eliminar un elemento
lista.remove("Josefa")
print(lista)



# Para eliminar el último elemento
lista.pop()
print(lista)



# Para unir dos listas
lista2 = ["Pepito", "Juanito"]
lista3 = lista + lista2
print(lista3)



# Para añadir VARIOS elementos en un lugar concreto
lista4 = ["Menganito", "Fulanito"]
lista[4:4] = lista4
print(lista)