import java.util.*;

public class EmployeeService {
    Employee[] employees;

    public EmployeeService(Employee[] employees) {
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

    public void printEmployees() {
        for (Employee currentEmployees : employees) {
            System.out.println(" Id " + currentEmployees.id);
            System.out.println(" name " + currentEmployees.name);
            System.out.println(" salary " + currentEmployees.salary);
            System.out.println(" gender " + currentEmployees.gender);
            System.out.println(" age " + currentEmployees.age);
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

    Employee edit(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            Employee currentEmployee = employees[i];
            if (currentEmployee.id == employee.id) {
                employees[i] = employee;
                return currentEmployee;
            }
        }
        return null;
    }

    Employee remove(long id) {
        int count = employees.length;
        for (int i = 0; i < count; i++) {
            Employee current = employees[i];
            if (current.id == id) {
                employees[i] = employees[i + 1];
                return current;
            }
            count = employees.length - 1;
            Employee[] array = new Employee[count];
            for (int j = 0; j < array.length; j++) {
                array[i] = employees[i];
            }
        }
        return null;
    }

    void add(Employee newEmployee) {

        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            count++;
        }
        Employee[] newArray = new Employee[count+1];
        for (int j = 0; j < newArray.length - 1; j++) {
            newArray[j] = employees[j];
            newArray[count] = newEmployee;
        }
        employees = newArray;
    }
}








