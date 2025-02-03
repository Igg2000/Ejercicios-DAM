#Operaciones aritmeticas

def mediaAritmetica(a,b):
    return (a+b)/2

print("La media aritmetica de 100 y 50 es",mediaAritmetica(100,50))
print()

#imc de una persona
def imc(peso,altura):
    return peso/(altura**2)


print("El imc es",imc(70,1.75))
#sacar solo 2 decimales
print("El imc es ",round(imc(70,1.75),2))


def segundosAMinutos(segundos):
    return segundos/60

print(f"3600 segundos son {segundosAMinutos(3600)} minutos")

def segundosASegundosMinutosYHoras(a):
    horas = a//3600
    minutos = (a%3600)//60
    segundos = (a%3600)%60
    return f"{a} segundos son {horas} horas {minutos} minutos y {segundos} segundos"

print (segundosASegundosMinutosYHoras(3661))

