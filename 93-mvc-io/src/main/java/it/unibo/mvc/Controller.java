package it.unibo.mvc;

/**
 * interface to implements a controller of I/O.
 *
 * @param <T>
 *          the type of data to manage
 */
public interface Controller<T> {
    /** 
     * to print in the output strem.
    */
    void print();

    /** 
     * to read and store the input.
     * 
     * @param input
     *          the data to store
    */
    void read(T input);
}
