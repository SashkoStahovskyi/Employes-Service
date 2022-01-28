
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {

        Developer developer = new Developer("Sasha", 1, 36,
                3500, "man", 25);

        Designer designer = new Designer(5, "Vladimir", 37, 4000,
                "man", 5, 24);

        Manager manager = new Manager("Nazar", 7, 29, 4500, "man");

        int employeeSalary;
        employeeSalary = manager.calculateSalary();
        System.out.println("Employee Salary : " + employeeSalary);
        System.out.println();

        // ====================== EMPLOYEES SERVICE ========================== //

        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee[] randomEmployers = employeeFactory.generateEmployees(5);
        EmployeeService employeeService = new EmployeeService(randomEmployers);

        System.out.println("================ generateEmployees ================");

        Employee[] randomEmployees = employeeFactory.generateEmployees(5); // метод генерує працівників
        for (Employee randomEmployee : randomEmployees) {
            print(randomEmployee);
            System.out.println();
        }

        System.out.println("================ getById ================");

        Employee employeesById = employeeService.getById(2);
        print(employeesById);
        System.out.println();

        System.out.println("================Print Information ================");

        employeeService.printEmployees();

        System.out.println("================ sortByName ================");

        Employee[] employeesName = employeeService.sortByName(employeeFactory.generateEmployees(5));
        for (Employee a : employeesName) {
            System.out.println("name " + a.name);
        }
        System.out.println();

        System.out.println("================ Total Salary================");

        double totalSalary;
        totalSalary = employeeService.calculateSalaryAndBonus(designer.rate, designer.workedDays, developer.fixedBugs, manager.salary);
        System.out.println("Employee month salary : " + totalSalary);

        System.out.println("================ getByName ================");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert employee name : ");
        String findName = scanner.nextLine();
        Employee[] name = employeeService.getByName(findName);
        for (Employee employee : name) {
            System.out.println("employee name: " + employee.name);
        }

        System.out.println("================ sortByNameAndSalary ================");

        Employee[] result = employeeService.sortByNameAndSalary(employeeFactory.generateEmployees(5));
        for (Employee a : result) {
            System.out.println("name " + a.name + " salary " + a.salary);
        }

        System.out.println("================ edit ================");
        System.out.println();

        Manager newManager = new Manager("Denis", 4, 35, 3500, "transgender");
        Employee empl = employeeService.edit(newManager);
        print(empl);

        System.out.println("================  ================");
        employeeService.printEmployees();

        System.out.println("================ remove ================");
        System.out.println();

        Employee deleteEmployee = employeeService.remove(4);
        print(deleteEmployee);

        System.out.println("================ add ================");
        System.out.println();
        employeeService.printEmployees();
        System.out.println("----------------------------------");

        Designer newDesigner = new Designer(15, "Rudolf", 55, 5500, "man", 5, 24);
        employeeService.add(newDesigner);
        employeeService.printEmployees();


    }

    static void print(Employee employee) {
        System.out.println(" id " + employee.id);
        System.out.println(" name " + employee.name);
        System.out.println(" age " + employee.age);
        System.out.println(" salary " + employee.salary);
        System.out.println(" gender " + employee.gender);


    }
}
