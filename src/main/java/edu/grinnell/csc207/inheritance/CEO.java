package edu.grinnell.csc207.inheritance;

import java.util.List;

/** A CEO. */
public class CEO extends Employee{

    private List<Employee> reportees;

    /**
     * Constructs a new CEO.
     *
     * @param name the CEO's name.
     * @param id the CEO's ID.
     * @param reportees the CEO's direct reports.
     */
    public CEO(String name, String id, List<Employee> reportees) {
        this.name = "(CEO) " + name;
        this.id = id;
        this.reportees = reportees;
        this.salary = 8000000;
        this.workNoise = "MOANS *in exorbintant salery*";
    }
}
