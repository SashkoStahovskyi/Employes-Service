import java.util.Random;

public class Developer extends Employee {
    int fixedBugs;

    Developer(String developerName, int developerId, int developerAge,
              int developerSalary, String developerGender, int developerFixedBugs) {
        id = developerId;
        name = developerName;
        age = developerAge;
        salary = developerSalary;
        gender = developerGender;
        fixedBugs = developerFixedBugs;
    }

    public int calculateSalary() {
        Random random = new Random();
        int resultSalary;
        resultSalary = (salary + fixedBugs * 5) * (random.nextBoolean() ? 2 : 0);
        return resultSalary;
    }
}
