package co.edu.poligran.algoritmos.programaciondinamica;

import java.util.Arrays;

/**
 * Objeto que representa la solución del Problema de la Mochila.
 *
 * @author juespinosa2@poligran.edu.co
 * @author siespinosa1@poligran.edu.co
 * @version Jun 21, 2020
 * @since 1.8
 */
public class KnapsackSolution {

    /**
     * Valor máximo obtenido de todos los items de la mochila.
     */
    private int maxValue;

    /**
     * Cantidades por item que fueron guardados en la mochila.
     */
    private int[] qtys;

    /**
     * Constructor vacio.
     */
    public KnapsackSolution() {
    }

    /**
     * Constructor.
     *
     * @param maxValue Valor máximo obtenido de todos los items de la mochila.
     * @param qtys     Arreglo de cantidades por item que fueron guardados en la mochila.
     */
    public KnapsackSolution(int maxValue, int[] qtys) {
        this.maxValue = maxValue;
        this.qtys = qtys;
    }

    /**
     * Obtiene el valor máximo obtenido de todos los items de la mochila.
     *
     * @return Valor máximo obtenido de todos los items de la mochila.
     */
    public int getMaxValue() {
        return maxValue;
    }

    /**
     * Establece el valor máximo obtenido de todos los items de la mochila.
     *
     * @param maxValue Nuevo valor máximo obtenido de todos los items de la mochila.
     */
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * Obtiene el arreglo de cantidades por item que fueron guardados en la mochila.
     *
     * @return Arreglo de cantidades por item que fueron guardados en la mochila.
     */
    public int[] getQtys() {
        return qtys;
    }

    /**
     * Establece un arreglo de cantidades por item que fueron guardados en la mochila.
     *
     * @param qtys Nuevo arreglo de cantidades por item que fueron guardados en la mochila.
     */
    public void setQtys(int[] qtys) {
        this.qtys = qtys;
    }

    @Override
    public String toString() {
        return "KnapsackSolution{" +
                "maxValue=" + maxValue +
                ", qtys=" + Arrays.toString(qtys) +
                '}';
    }
}
