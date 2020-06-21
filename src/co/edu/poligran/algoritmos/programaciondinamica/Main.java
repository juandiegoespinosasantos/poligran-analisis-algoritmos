package co.edu.poligran.algoritmos.programaciondinamica;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejemplo del Problema de la Mochila (Knapsack Problem).
 * Dada una mochila de capacidad C y un conjunto de N cajas diferentes con valores V1, ..., Vn y tamaños S1, ..., Sn
 * se debe seleccionar un subconjunto de objetos para guardarlos en la mochila cuya suma de tamaños no supere a C y cuya
 * suma de valores sea la mayor posible.
 *
 * @author juespinosa2@poligran.edu.co
 * @author siespinosa1@poligran.edu.co
 * @version Jun 19, 2020
 * @since 1.8
 */
public class Main {

    private static final int MAX_CAPACITY = 140;

    public static void main(String[] args) {
        List<Item> knapsack = initKnapsack();
        KnapsackSolution solution = getMaxValue(knapsack);

        System.out.println("La capacidad máxima de la mochila es: " + MAX_CAPACITY);

        int[] qtys = solution.getQtys();
        Item item;

        for (int i = 0; i < qtys.length; i++) {
            item = knapsack.get(i);
            int size = item.getSize();
            int value = item.getValue();
            int maxQty = qtys[i];
            int total = value  * maxQty;

            System.out.printf("%s,\tTamaño: %d,\tValor: %d,\tCantidad máxima: %d,\tTotal: %d * %d = %d\n",
                    item.getName(), size, value, maxQty, value, maxQty, total);
        }

        System.out.println("La ganancia máxima obtenida es: " + solution.getMaxValue());
    }

    /**
     * Método que obtiene la lista de items con tamaño y valor.
     *
     * @return Lista de items para evaluar su valor máximo.
     */
    private static List<Item> initKnapsack() {
        List<Item> knapsack = new ArrayList<>();
        knapsack.add(new Item("Item 1", 84, 420));
        knapsack.add(new Item("Item 2", 42, 196));
        knapsack.add(new Item("Item 3", 56, 224));
        knapsack.add(new Item("Item 4", 28, 126));

        return knapsack;
    }

    /**
     * Método que obtiene el máximo valor de ganancia para una maleta de capacidad W
     *
     * @return Valor de la máxima ganancia que se puede obtener al guardar cajas en la mochila.
     */
    private static KnapsackSolution getMaxValue(final List<Item> knapsack) {
        int[] maxValues = new int[MAX_CAPACITY + 1]; // Se crea un arreglo para almacenar las soluciones desde 0 hasta la capacidad máxima de la mochila.
        int[] selected = new int[MAX_CAPACITY + 1]; // Se almacenan los items seleccionados.
        int[] qtysPerItem = new int[knapsack.size()]; // Respuestas de cantidades por item.

        maxValues[0] = 0; // Se resuelve el caso base.

        // Se revuelven de los casos más fáciles a los difíciles recorriendo todas las posibles soluciones.
        for (int size = 0; size < maxValues.length; size++) {
            int maxValue = 0; // Valor máximo.
            int maxItem = -1; // Posición del item con el máximo.

            // Se recorren los items de la mochila calculando el máximo valor.
            for (int i = 0; i < knapsack.size(); i++) {
                Item currentItem = knapsack.get(i);
                int currentSize = currentItem.getSize();
                int currentValue = currentItem.getValue();

                // Verificar que se pueda agregar el item en la mochila.
                if (size >= currentSize) {
                    int value = maxValues[size - currentSize] + currentValue; // Se evalúa la ganancia de guardar el i en la mochila.

                    // Si la el valor es mayor que el máximo, se reemplaza.
                    if (value > maxValue) {
                        maxValue = value;
                        maxItem = i;
                    }
                }
            }

            maxValues[size] = maxValue; // Se guarda en el arreglo en la posición actual el nuevo valor máximo.
            selected[size] = maxItem; // Se guarda la posición del máximo.
        }

        // Se reconstruye las decisiones seleccionadas a partir de la respuesta.
        int item = 0;

        for (int size = MAX_CAPACITY; ((size > 0) && (item != -1)); ) {
            item = selected[size]; // Se evalúa la desición tomada.

            qtysPerItem[item]++; // Incrementar la cantidad de items en 1.

            size -= knapsack.get(item).getSize(); // Devolverse al caso anterior.
        }

        // Se retorna la última posición del arreglo en donde se encuentra la solución más óptima.
        return new KnapsackSolution(maxValues[MAX_CAPACITY], qtysPerItem);
    }
}
