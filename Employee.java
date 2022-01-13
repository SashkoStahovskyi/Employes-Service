
import java.lang.*;
import java.util.Comparator;

public class Employee implements Comparable<Employee>,Comparator<Employee> {
    int id;
    String name;
    int age;
    int salary;
    String gender;


    public String getName() {
        return name;
    }

    @Override
    public String toString () {
        return "name:" + this.name;
    }


    @Override
    public int compareTo(Employee employee) {
        return name.compareTo(employee.getName());
    }


    @Override
    public int compare(Employee o1, Employee o2) {
        return 0;
    }
}
