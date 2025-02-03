import random

def juego21(jugador1,jugador2):

    limitePuntos = 21

    print("Empieza el juego")
    tiradasJ1 = [random.randint(1,10) for i in range(3)]
    tiradasJ2 = [random.randint(1,10) for i in range(3)]
    print(f"{jugador1} ha sacado {tiradasJ1[0]} , {tiradasJ1[1]} y {tiradasJ1[2]}, en total = {sum(tiradasJ1)}")
    print(f"{jugador2} ha sacado {tiradasJ2[0]} , {tiradasJ2[1]} y {tiradasJ2[2]}, en total = {sum(tiradasJ2)}")

    j1SePasa= False
    j2SePasa= False

    if sum(tiradasJ1) > limitePuntos:
        j1SePasa = True
    
    if sum(tiradasJ2) > limitePuntos:
        j2SePasa = True

    resultado = 0

    if sum(tiradasJ1) == sum(tiradasJ2) or (j1SePasa and j2SePasa):
        resultado = 0
    elif sum(tiradasJ1) > sum(tiradasJ2) and not j1SePasa or j2SePasa:
        resultado = 1
    elif sum(tiradasJ1) < sum(tiradasJ2) and not j2SePasa or j1SePasa:
        resultado = 2
    else:
        resultado = 3

    resultados={0:"Empate",1:f"{jugador1} ha ganado",2:f"{jugador2} ha ganado",3:"Error"}

    print(resultados[resultado])

    volverAJugar=input("Quiere volver a jugar? [S/N]: ")

    while volverAJugar.upper() != "S" and volverAJugar.upper() != "N":
        volverAJugar=input("Debes introducir 'S' o 'N': ")

    if volverAJugar.upper() == "S":
        juego21(jugador1,jugador2)
    elif volverAJugar.upper() == "N":
        print("Gracias por jugar")


juego21("Carlos","Juan") # 1