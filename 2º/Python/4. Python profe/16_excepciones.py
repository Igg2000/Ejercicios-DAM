# Para controlar excepciones usamos las palabras try, except y finally
# Encerramos en try lo susceptible de fallar
# Con except decimos lo que debería hacer en caso de fallo
# Podemos espedificar los tipos de fallos y dar instrucciones para cada, o no indicar, que sería el general.
# La palabra finally sirve para ejecutar pase lo que pase, haya error o no.


a=float(input("Dame un número: "))
b=float(input("Dame otro número: "))

try:
    c=a/b
    print(f"El resultado de dividir {a} entre {b} es {c}")
except ZeroDivisionError:
    print("No puedes dividir por cero")
except ValueError:
    print("No me has dado números")
finally:
    print("Yo me ejecuto pase lo que pase")