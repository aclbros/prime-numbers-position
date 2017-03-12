package com.example.antonio.primeratarea;

import java.util.ArrayList;

/**
 * Clase que realiza todos los cálculos relativos a números primos y su almacenamiento
 * en un array de tipo ArrayList.
 *
 * @author antonio
 */
class CalculaPrimos {

    // Declaración de variables
    private static ArrayList<Integer> listaPrimos;

    /**
     * El constructor inicializa el ArrayList y añade los primeros datos al array. Esto es necesario
     * ya que vamos a usar el método de la raíz cuadrada para calcular los números primos, por lo
     * que números con raíz cuadrada por debajo de 4 no tendrían sentido para los cálculos.
     */
    protected CalculaPrimos() {
        listaPrimos = new ArrayList<>();
        listaPrimos.add(0);
        listaPrimos.add(1);
        listaPrimos.add(2);
        listaPrimos.add(3);
        listaPrimos.add(5);
        listaPrimos.add(7);
        listaPrimos.add(11);
    }

    /**
     * Devuelve el número primo en la posición indicada si lo tenemos almacenado y si
     * no llama al método para a&ntilde;adirlo.
     *
     * @param posicion Posición del número primo a calcular.
     */
    protected int devolverPrimos(int posicion) {
        if (posicion < listaPrimos.size()) {
            return listaPrimos.get(posicion);
        } else {
            aniadirPrimos(posicion);
        }
        return listaPrimos.get(posicion);
    }

    /**
     * A&ntilde;ade los números primos desde el último almacenado hasta el que estamos
     * buscando.
     *
     * @param posicion Posición del número primo a calcular.
     */
    private static void aniadirPrimos(int posicion) {
        int proximoIndice = listaPrimos.size();
        if (proximoIndice == posicion) {
            calcularPrimo(listaPrimos.get(proximoIndice - 1));
        } else {
            int i = proximoIndice;
            while (i <= posicion) {
                calcularPrimo(listaPrimos.get(i - 1));
                i++;
            }
        }
    }

    /**
     * Calcula el siguiente número primo al pasado por parámetro usando el
     * método de la raíz cuadrada y lo guarda en un ArrayList.
     *
     * @param primo último número primo calculado.
     */
    private static boolean calcularPrimo(Integer primo) {
        int candidato = primo + 1;
        if (candidato % 2 == 0) {
            return calcularPrimo(candidato);
        } else {
            for (int i = 3; i <= Math.round(Math.sqrt(candidato)); i++) {
                if (candidato % i == 0) {
                    return calcularPrimo(candidato);
                }
            }
        }
        return listaPrimos.add(candidato);
    }
}
