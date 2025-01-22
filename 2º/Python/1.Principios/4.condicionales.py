
a=5

if a<=4:
    print("a es menor o igual que 4")
else:
    print("a es mayor que 4")

#Tambien se pueden hacer mas de dos casos

if a<=4:
    print("a es menor o igual que 4")
elif a==5:
    print("a es 5")
else:
    print("a es mayor que 5")


#para hacer un switch se usa un diccionario

def switch_demo(argument):
    switcher = {
        1: "Enero",
        2: "Febrero",
        3: "Marzo",
        4: "Abril",
        5: "Mayo",
        6: "Junio",
        7: "Julio",
        8: "Agosto",
        9: "Septiembre",
        10: "Octubre",
        11: "Noviembre",
        12: "Diciembre"
    }
    return switcher.get(argument, "Mes no valido")

print(switch_demo(1))