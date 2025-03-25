#Los generadores son funciones que crean un objeto iterable
#Va tomando valores cada vez que la llamas y despues se para
#a diferencia de las funciones que ejecutan todo 




def naturales():
    lista=[0]
    i=1

    while i <= 100:
        lista.append(i)
        i+=1

    print(lista)


def naturalesiterable(max):
    j=0
    for i in range(max):
        j+=1
        yield j


#naturales()
generador = naturalesiterable(10)

print("\nGenerador\n______________________")
print(next(generador))
print(next(generador))

nuevogenerador = naturalesiterable(25)

print("\nNuevo generador\n______________________")
for i in nuevogenerador:
    print(i)



