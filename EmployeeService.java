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
        Employee[] employeesName = new Employee[employees.length];
        for (int i = 0; i < employees.length; i++) {
            Employee currentEmployees = employees[i];
            if (isSimilar(currentEmployees, name)) {
                employeesName[i] = currentEmployees; // не допрацьована логіка
            }
        }
        return employeesName;
    }

    static boolean isSimilar(Employee first, String name) {
        String firstName = first.name;
        return firstName.compareTo(name) == 0; // порівняння стрінги і клас тип
    }


    public void printEmployees(Employee[] employee) {
        for (Employee currentEmployees : employees) {
            System.out.println("Employee Id " + currentEmployees.id);
            System.out.println("Employee name " + currentEmployees.name);
            System.out.println("Employee salary " + currentEmployees.salary);
            System.out.println("Employee gender " + currentEmployees.gender);
            System.out.println("Employee age " + currentEmployees.age);
            System.out.println();
        }
    }

    public Employee[] sortByName(Employee[] employees) {
        Employee result;
        for (int i = 0; i < employees.length; i++) {
            for (int j = 1; j < employees.length - 1; j++) {
                Employee employee1 = employees[j - 1];
                Employee employee2 = employees[i];
                if (isBiggerName(employee1, employee2)) {
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

    /*static boolean isBigger(Employee first, Employee second) {
        String firstName = first.name;
        String secondName = second.name;
        return firstName.compareTo(secondName) > 0;
    }*/

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

    public Employee[] sortByNameAndSalary(Employee[] employees) { //незавершена логіка
        //Employee [] result = new Employee[employees.length];
        Employee pmb ;
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees.length - 1; j++) {
                Employee employeeSalary1 = employees[i];
                Employee employeeSalary2 = employees[j + 1];
                if (employeeSalary1.salary > employeeSalary2.salary) {
                    pmb = employees[i];
                    employees[i] = employees[j + 1];
                    employees[j + 1] = pmb;
                }
            }
        }
        return employees;
    }


}


