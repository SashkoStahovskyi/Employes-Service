import java.util.Random;

public class EmployeeFactory {

    Employee[] getDefaultEmployees() {

        Developer developer = new Developer("Sasha", 1, 36,
                3500, "man", 25);
        Developer developer1 = new Developer("Yuriy", 2, 40,
                3500, "man", 13);
        Developer developer2 = new Developer("Anatoliy", 3, 44,
                3500, "man", 19);
        Developer developer3 = new Developer("Olga", 4, 33,
                3500, "woman", 20);

        Designer designer = new Designer(5, "Vladimir", 37, 4000,
                "man", 5, 24);
        Designer designer1 = new Designer(6, "Taras", 33, 4000,
                "man", 7, 22);
        Designer designer2 = new Designer(6, "Sasha", 33, 4000,
                "man", 7, 22);


        Manager manager = new Manager("Nazar", 7, 29, 4500, "man");


        Employee[] employeeFactory = {developer, developer1, developer2, developer3, designer, designer1,designer2, manager};
        return employeeFactory;
    }

    Employee[] generateEmployees(int size) { // потрыбно допрацювати
        String[] employeeName = {"Sasha", "Yuriy","Olga", "Nazar", "Artem", "Maks","Arsen","Boris"};
        String[] employeeGender = {"Woman","Man"};
        Random random = new Random();
        Employee[] randomEmployees = new Employee[size];

        for (int i = 0; i < size; i++) {
            Employee employee = new Employee();
            employee.id = i + 1;
            employee.salary = random.nextInt(4500) + 3000;
            employee.gender = employeeGender[random.nextInt(employeeGender.length)]; // потрібно знайти рішення по Gender + Name
            employee.name = employeeName[random.nextInt(employeeName.length)];
            employee.age = random.nextInt(65) + 25;

            randomEmployees[i] = employee;
        }

        return randomEmployees;
    }
}
