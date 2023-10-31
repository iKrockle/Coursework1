public class Main {
    static int  id = 1;
    public static void main(String[] args) {


        Employee[] empArray = new Employee[10];
        empArray[0] = addEmployee("Петров Петр Петрович",1,203.23);
        empArray[1] = addEmployee("Петров Андрей Петрович",3,22.23);
        empArray[2] = addEmployee("Петров Петр Сидорович",2,2434.23);
        empArray[3] = addEmployee("Волков Петр Петрович",5,2534.23);
        empArray[4] = addEmployee("Андреев Лев Петрович",2,2001.23);
        empArray[5] = addEmployee("Артемов Артем Артемович",6,2230.23);
        empArray[6] = addEmployee("Нестеров Петр Андреевич",1,2056.23);
        empArray[7] = addEmployee("Искандеров Искандер Петрович",6,254.23);
        empArray[8] = addEmployee("Олегов Олег Олегович",1,212.23);
        empArray[9] = addEmployee("Егоров Егор Егорович",2,25342.23);

        showEmployees(empArray);
        double salSum = getSalarySum(empArray);
        System.out.printf("%.2f",salSum);
        System.out.println();
        int minSalId = getMinSalary(empArray);
        System.out.println(minSalId);
        int maxSalId = getMaxSalary(empArray);
        System.out.println(maxSalId);
        double avgSal = getAvgSalary(empArray);
        System.out.printf("%.2f",avgSal);
        System.out.println();
        showFioEmployees(empArray);
    }

    public static Employee addEmployee(String fio, int job, double sal){
        Employee employee = new Employee(fio,job,sal);
        id+=1;
        return employee;
    }

    public static void showEmployees(Employee[] empArray){
        for (Employee employee : empArray) {
            System.out.println(employee.toString());
        }
    }

    public static double getSalarySum(Employee[] empArray){
        double salarySum = 0;
        for (Employee employee : empArray) {
            salarySum += employee.getSalary();
        }
        return salarySum;
    }

    public static int getMinSalary(Employee[] empArray){
        double minSalary = 0;
        int id = 0;

        for (Employee employee : empArray) {
            boolean chk = minSalary > employee.getSalary() && employee.getSalary() != 0||minSalary==0;
            if (chk) {
                minSalary = employee.getSalary();
                id = employee.getId();
            }
        }
        return id;
    }

    public static int getMaxSalary(Employee[] empArray){
        double maxSalary = 0;
        int id = 0;

        for (Employee employee : empArray) {
            boolean chk = maxSalary < employee.getSalary() && employee.getSalary() != 0;
            if (chk) {
                maxSalary = employee.getSalary();
                id = employee.getId();
            }
        }
        return id;
    }

    public static double getAvgSalary(Employee[] empArray){
        return getSalarySum(empArray)/empArray.length;
    }

    public static void showFioEmployees(Employee[] empArray){
        for (Employee employee : empArray) {
            System.out.println("ФИО:" + employee.getFio());
        }
    }
}