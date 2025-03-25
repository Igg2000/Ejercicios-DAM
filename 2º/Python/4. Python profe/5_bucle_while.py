# Los bucles indeterminados while funcionan de forma muy similar a otros lenguajes
# Se escribe while condición:
    # lo de dentro del bucle, identado
# Mientras se cumpla la concición, se repite el bucle

i=0

while i<=10:
    print(i)
    i+=1 # Para incrementar el valor de i por cada iteración
    #i++ # Da error



# Tenemos continue para saltar una iteración
i=0
while i<=10:
    if i==7:
        i+=1
        continue
    print(i)
    i+=1



# Tenemos break para detener el bucle
i=0
while i<=10:
    if i==7:
        break
    print(i)
    i+=1