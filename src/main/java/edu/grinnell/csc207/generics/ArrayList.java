package edu.grinnell.csc207.generics;

import java.util.Arrays;

/**
 * An array-based implementation of a list, specialized to ints.
 */
public class ArrayList<T> implements List<T>{

    private static final int INITIAL_SIZE = 8;

    private T[] data;

    private int sz;

    /**
     * Constructs a new, empty array list.
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.data = (T[])(new Object[INITIAL_SIZE]);
        this.sz = 0;
    }

    private void ensureCapacity() {
        if (sz == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(T value) {
        ensureCapacity();
        data[sz++] = value;
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public T get(int index) {
        if (index < 0 || index >= sz) {
            throw new IndexOutOfBoundsException(index);
        }
        return data[index];
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public T remove(int index) {
        if (index < 0 || index >= sz) {
            throw new IndexOutOfBoundsException(index);
        } else {
            T ret = data[index];
            sz -= 1;
            return ret;
        }
    }

    /** Place a new element sep of type T inbetween each pair of existing elements
     * 
     * @param sep the element to insert
     */
    private void intersperse(T sep){
        T[] peeeww = this.data;
        this.data = (T[])(new Object[2*this.size()]);
        for( int i = 0; i < (peeeww.length - 2); i++){
            this.add(peeeww[i]);
            this.add(sep);
        } 
        this.add(peeeww[peeeww.length-1]);
    }

    /** Comparison cannot be made over type T, because comparisons are specific
     * to object type
     *  
     */ 
    private T maximum(){
        throw new UnsupportedOperationException();
    }

    /** Returns the array list as a string in the form "[x, x1,... xn]"
     * 
     * @return String 
    */
    private String makeIntoString(){
        String contents = "[";
        for(int i = 0; i < this.size(); i++){
            contents += this.get(i) + ", ";
        }
        contents += "]";
        return contents;
        
    }
    /** Comparison cannot be made over type T, because comparisons are specific
     * to object type
     * We feel sad about this :C
     */ 
    private void insertionSort(){
        throw new UnsupportedOperationException();
    }
}
