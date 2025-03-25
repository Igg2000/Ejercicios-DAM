# Para los bucles determinados, en Python cambia un poco
    # respecto a otros lenguajes for(i=0, i<10, i++)



for i in range(5):
    print(i)
# Aquí hacemos que i vaya de 0 a 4
# Lo que hace range es crear un array con 5 elementos: 0,1,2,3,4



for i in range(60,69):
    print(i)
# Este va de 60 a 68
# El primer número incluido, el segundo excluido



for i in range(15,50,3):
    print(i)
# Este va de 15 a 49, con un incremento de 3 en 3



# Se puede hacer el bucle for sin usar range
# Podemos hacer que la variable i recorra una lista
for i in [4,7,15,"algo",2,56,True]:
    print(i)



# También podemos hacer que la variable i recorra una string
for i in "etybuearubatqkjgndtwi":
    print(i)

# Un ejemplo típico es recorrer un email

email=input("Dame tu email: ")
contador_arroba=0

for i in email:
    if i=="@":
        contador_arroba+=1

if contador_arroba==1:
    print("Tienes una @, ok")
elif contador_arroba==0:
    print("Te falta la @")
else:
    print("Has puesto más de una @")