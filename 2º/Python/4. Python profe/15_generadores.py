# Los generadores son funciones que crean un objeto iterable.
# Va tomando valores cada vez que la llamas y después se para.
# A diferencia de las funciones que ejecutan todo.

lista=[0]
i=1
while i <= 100:
    lista.append(i)
    i+=1

print(lista)

# El generador va con la palabra yield
def naturalesiterable(max):
    j=0
    while j <= max:
        yield j
        j+=1


natural=naturalesiterable(100)

# Cada vez que lo llamamos nos da la siguiente salida, en vez de generar una lista con todo.
print(next(natural))
print(next(natural))
print(next(natural))
print(next(natural))
print(next(natural))


for k in naturalesiterable(15):
    print(k)