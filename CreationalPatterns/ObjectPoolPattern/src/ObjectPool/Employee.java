package objectPool;

import java.util.ArrayList;
import java.util.Arrays;

public class Employee {
    public static ArrayList<String> possibleNames = new
            ArrayList<>(Arrays.asList("Tony", "Niko", "Tommy", "Johnny", "CJ", "Claude"));

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    // Shout out your name to System.out
    public void doStuff() {
        System.out.println("\tMy name is " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
