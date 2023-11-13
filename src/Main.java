public class Main {
    static int  id = 1;
    public static void main(String[] args) {
        EmployeeBook empBook = new EmployeeBook();

        empBook.addEmployee("Петров Петр Петрович",1,203.23);
        empBook.addEmployee("Петров Андрей Петрович",3,22.23);
        empBook.addEmployee("Петров Петр Сидорович",2,2434.23);
        empBook.addEmployee("Волков Петр Петрович",5,2534.23);
        empBook.addEmployee("Андреев Лев Петрович",2,2001.23);
        empBook.addEmployee("Артемов Артем Артемович",5,2230.23);
        empBook.addEmployee("Нестеров Петр Андреевич",1,2056.23);
        empBook.addEmployee("Искандеров Искандер Петрович",5,254.23);
        empBook.addEmployee("Олегов Олег Олегович",1,212.23);
        empBook.addEmployee("Егоров Егор Егорович",2,25342.23);

        empBook.showEmployees();
        System.out.println();
        double salSum = empBook.getSalarySum();
        System.out.println(String.format("%.2f",salSum));
        int minSalId = empBook.getMinSalary();
        System.out.println(minSalId);
        int maxSalId = empBook.getMaxSalary();
        System.out.println(maxSalId);
        double avgSal = empBook.getAvgSalary();
        System.out.println(String.format("%.2f",avgSal));
        System.out.println();
        empBook.showFioEmployees();
        System.out.println();
        empBook.indexSalary(10);
        empBook.showEmployees();
        System.out.println();
        int minSalJob = empBook.getMinSalary(true);
        System.out.println(minSalJob);
        System.out.println();
        int maxSalJob = empBook.getMaxSalary(true);
        System.out.println(maxSalJob);
        System.out.println();
        empBook.showSalByJob();
        System.out.println();
        empBook.showAvgSalByJob();
        System.out.println();
        empBook.indexSalaryForJob(5,3);
        empBook.showEmployees();
        System.out.println();
        empBook.showJobEmployees(2);
        System.out.println();
        empBook.showSalaryLessNum(1000);
        System.out.println();
        empBook.showSalaryOverNum(2000);
    }
}