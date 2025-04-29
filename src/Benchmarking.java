import java.util.Random;

public class Benchmarking {
    MetodosOrdenamiento metodosOrdenamiento=new MetodosOrdenamiento();

    public Benchmarking() {
        long inicioMillis = System.currentTimeMillis();
        long inicioNano = System.nanoTime();

        //System.out.println("milisegundos: " + inicioMillis);
        //System.out.println("nanosegundos: " + inicioNano);

        metodosOrdenamiento=new MetodosOrdenamiento();
        int[]arreglo=generarArregloAleatorio(1000000);
        Runnable tarea=()->metodosOrdenamiento.burbujaTradicional(arreglo);
    }

    public int[] generarArregloAleatorio(int i){
        int[] arreglo = new int[i];
        Random random = new Random();
        for (int j = 0; j < i; j++) {
            arreglo[j] = random.nextInt(10000);
        }

    return arreglo;
    }

    public double medirConNanoTime(Runnable tarea){
        long inicio =System.nanoTime();
        tarea.run();
        long fin =System.nanoTime();
        return(fin-inicio)/1000000;
    }

    public double medirConCurrenTime(Runnable tarea){
        long inicio =System.currentTimeMillis();
        tarea.run();
        long fin =System.currentTimeMillis();
        return(fin-inicio)/1000;
    }
}
