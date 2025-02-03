
diccionario={"Aroer":"Garcia","David":"Perez","Julio":"Barbero"}
print(diccionario)

#para añadir un elemento al diccionario
diccionario["Jose"]="Garcia"
print(diccionario)

#para eliminar un elemento del diccionario
del(diccionario["Aroer"])
print(diccionario)

#para modificar un elemento del diccionario
diccionario["David"]="Garcia"
print(diccionario)

#para saber si un elemento esta en el diccionario
print("David" in diccionario)

#para sacar el valor de un elemento
print(diccionario["David"])

#para sacar el valor de un elemento con get
print(diccionario.get("David"))

#para sacar las claves del diccionario
print(diccionario.keys())

#para sacar los valores del diccionario
print(diccionario.values())