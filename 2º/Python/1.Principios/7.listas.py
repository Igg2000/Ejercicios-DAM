#Aqui a una lista le puedes meter distintos tipos de variable

lista=['elem1','elem2',1,2,3.5,True,False,["elemnLista1","elemnLista2"]]

print(lista)

#pintar un elemento de la lista
print(lista[2])

#pintar una parte
print(lista[:3]) #antes del 3
print(lista[3:]) #el 3 y despues del 3
print(lista[1:3]) #entre el 1 y el 3 sin incluir el 3

#añadir un elemento a la lista
lista.append('hola')
print(lista)



#añadir un elemento a la lista
lista.extend(['elemenExtra1','elemenExtra2'])
print(lista)

#añadir un elemento en un lugar concreto
lista.insert(4,"elementoInsertado")
print(lista)

#acceder al indice de un elemento
a=lista.index("hola")
print(a)

#para ver si un elemento esta en la lista
print("hola" in lista)
print("adios" in lista)

#para eliminar un elemento
lista.remove("hola")
print(lista)

#para eliminar el ultimo
lista.pop()
print(lista)

#para unir dos listas
lista2=["123","456"]
lista3=lista+lista2
print(lista3)

#para meter varios elementos en medio
lista3[4:4]=lista2
print(lista3)