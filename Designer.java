public class Designer extends Employee {
    int rate;
    int workedDays;

    Designer(int Id, String designerName, int designerAge,
             int designerSalary, String designerGender, int designerRate, int designerWorkedDays) {
        id = Id;
        name = designerName;
        age = designerAge;
        salary = designerSalary;
        gender = designerGender;
        rate = designerRate;
        workedDays = designerWorkedDays;
    }

    public int calculateSalary () {
        int resultSalary;
        resultSalary = (salary + rate) * workedDays;
        return resultSalary;
    }
}

