# Los condicionales los comenzamos con if condición:
# Lo de dentro del concicional, identado
# else es opcional

a=int(input("Dame un número: "))
b=int(input("Dame otro número: "))

if a<b:
    print(f"{a} es menor que {b}")
    print("Esto que va identado está dentro de la condición")
print("Esto que va sin identar queda fuera de la condición")





# Con else

if a<b:
    print(f"{a} es menor que {b}")

else:
    print(f"{a} es mayor que {b}")





# Para distintos casos, usamos else if - elif
# Nótese que acepta varios operadores en la misma condición

edad=int(input("¿Cuántos años tienes?: "))

if edad < 0:
    print("No puedes tener edad negativa")

elif 0 <= edad < 18:
    print("A estudiar")

elif 18 <= edad < 65:
    print("A trabajar")

else:
    print("Disfruta de la jubilación")





# and not or

ciudad = input("Dónde vives: ").lower() # Método para poner todo el texto en minúsculas
sueldo = int(input("Cuánto ganas al mes: ")) # Función para que lo convierta en número
edad = int(input("Cuántos años tienes: "))

if sueldo < 1500 and ciudad=="madrid" or edad <= 18:
    print("Toma, una entrada de cine gratis")

elif ciudad!="madrid" and not sueldo > 2000:
    print("Toma, una entrada de cine gratis")

else:
    print("No tienes entrada")