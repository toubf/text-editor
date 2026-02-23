package edu.grinnell.csc207.inheritance;

/** An accountant. */
public class Accountant extends Employee {
    

    /**
     * Constructs a new accountant
     * @param name the accountant's name
     * @param id the accountant's ID
     */
    public Accountant(String name, String id) {
        this.name = "(ACCT) " + name;
        this.id = id;
        this.salary = 80000;
        this.workNoise = "$$$ (ch-ching) $$$";
    }
}