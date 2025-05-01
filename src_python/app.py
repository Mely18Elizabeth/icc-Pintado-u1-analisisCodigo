# from benchmarking import Benchmarking  # si benchmarking.py está en el mismo directorio
from benchmarking import Benchmarking
from metodos_ordenamiento import MetodosOrdenamiento

if __name__ == "__main__":
    print("Funciona")

    # Prueba básica de copia de listas
    a = [2, 4, 6]
    b = a.copy()
    print("a original:", a)
    print("b copia   :", b)
    b = b * 2
    print("a después :", a)
    print("b * 2     :", b)

    # Instanciar clases
    metodos = MetodosOrdenamiento()
    benchmarking = Benchmarking()

    tam = 1000
    arreglo_base = benchmarking.build_arreglo(tam)


    metodosD= {
        "burbuja": metodos.sortByBubble,
        "seleccion": metodos.sortBySeleccion
    }

    resultados = []
    for nombre, metodo in metodosD.items():
        tiempo=benchmarking.medir_tiempo(metodo, arreglo_base)
        tuplaResultado=(tam,nombre,tiempo)
        resultados.append(tuplaResultado)

    for resultado in resultados:
        tam,nombre,tiempo=resultado
        print(f"tamano: {tam}, metodo:  {nombre}, tiempo: {tiempo:.6f} segundos")