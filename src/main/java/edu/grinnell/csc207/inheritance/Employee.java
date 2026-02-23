package edu.grinnell.csc207.inheritance;

/** An employee. */
public class Employee {
    protected int salary;
    protected String name;
    protected String id;
    protected String workNoise;

    /** @return the employee's name. */
    String getName(){
        return name;
    }

    /** @return the employee's ID. */
    String getId(){
        return id;
    }

    /** @return the employee's salary. */
    int getSalary(){
        return salary;
    }

    /** @return the noise the employee makes while working. */
    String makeWorkNoise(){
        return workNoise;
    }

}
