package edu.grinnell.csc207.generics;

/**
 * interface outline for a list
 */
public interface List<T> {

    /**
     * adds element to list
     * @param value element to add
     */
    public void add(T value);

    /**
     * removes element from list at specified position
     * @param index to remove
     * @return removed value
     */
    public T remove(int index);

    /**
     * @param index
     * @return element at specified position
     */
    public T get(int index);

    /**
     * @return size of list
     */
    public int size();

} 
