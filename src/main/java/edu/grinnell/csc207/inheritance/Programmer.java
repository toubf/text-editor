package edu.grinnell.csc207.inheritance;

/** A programmer. */
public class Programmer extends Employee {
    /**
     * Constructs a new programmer.
     *
     * @param name the programmer's name.
     * @param id the programmer's ID.
     */
    public Programmer(String name, String id) {
        this.name = "(PROG) " + name;
        this.id = id;
        this.salary = 160000;
        this.workNoise = "arf clack clack";
    }

}
