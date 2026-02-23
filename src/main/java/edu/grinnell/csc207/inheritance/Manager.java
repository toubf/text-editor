package edu.grinnell.csc207.inheritance;

import java.util.List;

/** A manager. */
public class Manager extends Employee {
    private List<Employee> reportees;

    /**
     * Constructs a new manager.
     *
     * @param name the manager's name.
     * @param id the manager's ID.
     * @param reportees the manager's direct reports.
     */
    public Manager(String name, String id, List<Employee> reportees) {
        this.name = "(MGR) " + name;
        this.id = id;
        this.reportees = reportees;
        this.salary = 120000;
        this.workNoise = "Do Work *whines* Do Work";
    }

}
