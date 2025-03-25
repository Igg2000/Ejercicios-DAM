# Los diccionarios son otra estructura parecida a tuplas y listas
# Funcionan como en otros lenguajes, con clave:valor
# Se definen con llaves {} y sus elementos entre comas ,
# Acepta todo tipo de datos, salvo las listas en la clave
    # En el valor sí que acepta las listas


diccionario = {"Pepita":"Pérez", "Menganita":"Méndez", 5:4, \
               True:False, (2,3) : [0, 1, "elem2", 3.3]}
# Recordamos que la barra invertida \ es para saltar de linea una misma instrucción
    # para mejorar la legibilidad



# Para llamar al diccionario entero
print(diccionario)



# Para acceder a un valor, llamamos a su clave
print(diccionario["Pepita"])



# Para añadir elementos, añadimos una clave y asinamos un valor
diccionario["Fulanito"] = "Fernández"
print(diccionario)



# Para modificar elementos, llamamos a su clave y reasignamos
diccionario["Fulanito"] = "García"
print(diccionario)



# Para eliminar elementos
del diccionario["Fulanito"]
print(diccionario)