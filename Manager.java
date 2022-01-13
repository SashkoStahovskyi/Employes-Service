
public class Manager extends Employee {

    Manager(String managerName, int managerId, int managerAge, int managerSalary, String managerGender) {
        name = managerName;
        id = managerId;
        age = managerAge;
        salary = managerSalary;
        gender = managerGender;
    }

    public int calculateSalary () {
        int resultSalary;
        resultSalary = salary;
        return resultSalary;
    }
}
