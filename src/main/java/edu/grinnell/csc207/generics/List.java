package edu.grinnell.csc207.generics;

public interface List <T>{

    public void add(T value);
    public T remove(int index);
    public T get(int index);
    public int size();

} 
