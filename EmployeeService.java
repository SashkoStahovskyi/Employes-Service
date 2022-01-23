import java.util.*;

public class EmployeeService extends Employee {
    Employee[] employees;

    public EmployeeService(Employee[] employees) {
        super();
        this.employees = employees;
    }

    Employee getById(long id) {
        for (int i = 0; i < employees.length; i++) {
            Employee currentEmployees = employees[i];
            if (currentEmployees.id == id) {
                return currentEmployees;
            }
        }
        return null;
    }


    public Employee[] getByName(String name) {
        int count = 0;
        for (Employee employee : employees) {
            if (Objects.equals(employee.name, name)) {
                count++;
            }
        }
        Employee[] nameArray = new Employee[count];
        int index = 0;
        for (Employee employeeSecond : employees) {
            if (Objects.equals(employeeSecond.name, name)) {
                nameArray[index] = employeeSecond;
                index++;
            }
        }
        return nameArray;
    }

    public void printEmployees(Employee[] employees) {
        for (Employee currentEmployees : employees) {
            System.out.println("Employee Id " + currentEmployees.id);
            System.out.println("Employee name " + currentEmployees.name);
            System.out.println("Employee salary " + currentEmployees.salary);
            System.out.println("Employee gender " + currentEmployees.gender);
            System.out.println("Employee age " + currentEmployees.age);
        }
    }

    public Employee[] sortByName(Employee[] employees) {
        Employee result;
        for (int i = 0; i < employees.length; i++) {
            for (int j = 1; j < employees.length - 1; j++) {
                Employee employeeFirst = employees[j - 1];
                Employee employeeSecond = employees[i];
                if (isBiggerName(employeeFirst, employeeSecond)) {
                    result = employees[j - 1];
                    employees[j - 1] = employees[i];
                    employees[i] = result;
                }
            }
        }
        return employees;
    }

    public boolean isBiggerName(Employee first, Employee second) {
        String firstName = first.name;
        String secondName = second.name;
        return firstName.compareTo(secondName) > 0;
    }

    public double calculateSalaryAndBonus(int rate, int workedDays, int fixedBugs, int salary) {
        Random random = new Random();
        int designerSalary, developerSalary, resultSalary;
        int managerSalary = 4500;   //  стопер - я передаю в параметер методу перемінну salary,
        // але не можу в логікі використати саме managerSalary !!!??
        // тому змушений ініціалізувати перемінну в тілі методу. це не вірно
        designerSalary = (salary + rate) * workedDays;
        developerSalary = (salary + fixedBugs * 5) * (random.nextBoolean() ? 2 : 0);
        resultSalary = designerSalary + developerSalary + managerSalary;
        return resultSalary;
    }

    public Employee[] sortByNameAndSalary(Employee[] employees) { // працює не коректно

        for (int i = 0; i < employees.length; i++) {
            for (int j = 1; j < employees.length - 1; j++) {
                Employee employeeFirst = employees[j - 1];
                Employee employeeSecond = employees[j];

                if (compareByNameAndSalary(employeeFirst, employeeSecond)) {
                    Employee temp = employees[j - 1];
                    employees[j - 1] = employees[j];
                    employees[j] = temp;
                }
            }
        }
        return employees;
    }

    public boolean compareByNameAndSalary(Employee first, Employee second) {
        String firstName = first.name;
        String secondName = second.name;
        int firstSalary = first.salary;
        int secondSalary = second.salary;

        if (firstName.compareTo(secondName) > 0) {
            return true;
        }
        if (firstName.compareTo(secondName) < 0) {
            return false;
        }
        if (firstName.compareTo(secondName) == 0)
            return firstSalary > secondSalary;

        return false;
    }
}


