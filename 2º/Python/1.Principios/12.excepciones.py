#para controlar las excepciones se usa try , except y finally


a= input("Introduce un número: ")
b= input("Introduce otro número: ")

try:
    a = int(a)
    b = int(b)
    c= a/b
    print(c)
except ZeroDivisionError:
    print("No se puede dividir por 0")
except ValueError:
    print("Introduce un número válido")
finally:
    print("Fin del programa")

