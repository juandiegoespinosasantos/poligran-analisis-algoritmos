package co.edu.poligran.algoritmos.programaciondinamica;

/**
 * Objeto que representa el item a para guardar en la mochila.
 *
 * @author juespinosa2@poligran.edu.co
 * @author siespinosa1@poligran.edu.co
 * @version Jun 21, 2020
 * @since 1.8
 */
public class Item {

    /**
     * Nombre del item guardado
     */
    private String name;

    /**
     * Tamaño del item
     */
    private int size;

    /**
     * Valor o ganancia del item
     */
    private int value;

    /**
     * Constructor vacio
     */
    public Item() {
    }

    /**
     * Constructor
     *
     * @param name  Nombre del item guardado
     * @param size  Tamaño del item
     * @param value Valor o ganancia del item
     */
    public Item(String name, int size, int value) {
        this.name = name;
        this.size = size;
        this.value = value;
    }

    /**
     * Obtiene el nombre del item.
     *
     * @return Nombre del item
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del ítem.
     *
     * @param name Nuevo nombre del ítem.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el tamaño del ítem.
     *
     * @return Tamaño del ítem.
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño del ítem.
     *
     * @param size Nuevo tamaño del ítem.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Obtiene el valor o ganancia del ítem.
     *
     * @return Valor o ganancia del ítem.
     */
    public int getValue() {
        return value;
    }

    /**
     * Establece el valor o ganancia del ítem.
     *
     * @param value Nuevo valor o ganancia del ítem.
     */
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Box{" +
                "name='" + name + '\'' +
                ", weight=" + size +
                ", value=" + value +
                '}';
    }
}
