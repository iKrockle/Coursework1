public class Main {
    static int  id = 1;
    public static void main(String[] args) {


        Employee[] empArray = new Employee[10];
        empArray[0] = addEmployee("Петров Петр Петрович",1,203.23);
        empArray[1] = addEmployee("Петров Андрей Петрович",3,22.23);
        empArray[2] = addEmployee("Петров Петр Сидорович",2,2434.23);
        empArray[3] = addEmployee("Волков Петр Петрович",5,2534.23);
        empArray[4] = addEmployee("Андреев Лев Петрович",2,2001.23);
        empArray[5] = addEmployee("Артемов Артем Артемович",5,2230.23);
        empArray[6] = addEmployee("Нестеров Петр Андреевич",1,2056.23);
        empArray[7] = addEmployee("Искандеров Искандер Петрович",5,254.23);
        empArray[8] = addEmployee("Олегов Олег Олегович",1,212.23);
        empArray[9] = addEmployee("Егоров Егор Егорович",2,25342.23);

        showEmployees(empArray);
        System.out.println();
        double salSum = getSalarySum(empArray);
        System.out.println(String.format("%.2f",salSum));
        int minSalId = getMinSalary(empArray);
        System.out.println(minSalId);
        int maxSalId = getMaxSalary(empArray);
        System.out.println(maxSalId);
        double avgSal = getAvgSalary(empArray);
        System.out.println(String.format("%.2f",avgSal));
        System.out.println();
        showFioEmployees(empArray);
        System.out.println();
        indexSalary(empArray,10);
        showEmployees(empArray);
        System.out.println();
        int minSalJob = getMinSalary(empArray,true);
        System.out.println(minSalJob);
        System.out.println();
        int maxSalJob = getMaxSalary(empArray,true);
        System.out.println(maxSalJob);
        System.out.println();
        showSalByJob(empArray);
        System.out.println();
        showAvgSalByJob(empArray);
        System.out.println();
        indexSalaryForJob(empArray,5,3);
        showEmployees(empArray);
        System.out.println();
        showJobEmployees(empArray,2);
        System.out.println();
        showSalaryLessNum(empArray,1000);
        System.out.println();
        showSalaryOverNum(empArray,2000);
    }

    public static Employee addEmployee(String fio, int job, double sal){
        Employee employee = new Employee(fio,job,sal);
        id+=1;
        return employee;
    }

    public static void showEmployees(Employee[] empArray){
        for (Employee employee : empArray)
            if (employee != null) System.out.println(employee);
    }

    public static void showJobEmployees(Employee[] empArray,int job){
        for (Employee employee : empArray)
            if (employee != null)
                if (employee.getJob()==job)
                    System.out.println("ID=" + employee.getId() + " ФИО:" + employee.getFio() +
                        String.format(" зарплата:%.2f",employee.getSalary()));

    }

    public static double getSalarySum(Employee[] empArray){
        double salarySum = 0;
        for (Employee employee : empArray)
            if (employee != null) salarySum += employee.getSalary();
        return salarySum;
    }

    public static int getMinSalary(Employee[] empArray){
        double minSalary = 0;
        for (Employee employee : empArray)
            if (employee != null) {
                minSalary = employee.getSalary();
                break;
            }

        int id = 0;
        for (Employee employee : empArray) {
            if (employee != null) {
                if (minSalary > employee.getSalary()) {
                    minSalary = employee.getSalary();
                    id = employee.getId();
                }
            }
        }
        return id;
    }

    public static int getMaxSalary(Employee[] empArray){
        double maxSalary = 0;
        int id = 0;
        for (Employee employee : empArray) {
            if (employee != null) {
                boolean chk = maxSalary < employee.getSalary();
                if (chk) {
                    maxSalary = employee.getSalary();
                    id = employee.getId();
                }
            }
        }
        return id;
    }

    public static double getAvgSalary(Employee[] empArray){
        return getSalarySum(empArray)/empArray.length;
    }

    public static void showFioEmployees(Employee[] empArray){
        for (Employee employee : empArray) {
            if (employee != null) System.out.println("ФИО:" + employee.getFio());
        }
    }

    public static void indexSalary(Employee[] empArray, double indexPercent){
        for (Employee employee : empArray)
            if (employee != null)
                employee.setSalary(employee.getSalary()+employee.getSalary()*indexPercent/100);
    }

    public static void showSalByJob(Employee[] empArray){
        double[] salByJob = new double[5];
        int i=0;
        for (Employee employee : empArray)
            if (employee != null) salByJob[employee.getJob()-1] += employee.getSalary();

        for (double sal : salByJob) {
            i++;
            System.out.println("Для отдела " + i + String.format(" нужно подготовить %.2f",sal) +" рублей");
        }
    }

    public static void showAvgSalByJob(Employee[] empArray){
        double[] salByJob = new double[5];
        int[] cntByJob = new int[5];
        int i=0;
        double avgSal;

        for (Employee employee : empArray)
            if (employee != null) {
                salByJob[employee.getJob()-1] += employee.getSalary();
                cntByJob[employee.getJob()-1] ++;
            }

        for (double sal : salByJob) {
            i++;
            avgSal = 0;
            if (cntByJob[i-1]!=0)
                avgSal = sal/cntByJob[i-1];
            System.out.println("Средняя зарплата по отделу " + i +
                    String.format(" %.2f",avgSal) +" рублей");
        }
    }

    public static void indexSalaryForJob(Employee[] empArray, double indexPercent,int job){
        for (Employee employee : empArray)
            if (employee != null&&employee.getJob()==job)
                employee.setSalary(employee.getSalary()+employee.getSalary()*indexPercent/100);
    }

    public static int getMinSalary(Employee[] empArray,boolean returnJob){
        double minSalary = 0;
        for (Employee employee : empArray)
            if (employee != null) {
                minSalary = employee.getSalary();
                break;
            }

        int id = 0;
        int job = 0;
        for (Employee employee : empArray) {
            if (employee != null) {
                if (minSalary > employee.getSalary()) {
                    minSalary = employee.getSalary();
                    id = employee.getId();
                    job = employee.getJob();
                }
            }
        }
        if (returnJob) return job;
        else return id;
    }

    public static int getMaxSalary(Employee[] empArray,boolean returnJob){
        double maxSalary = 0;
        int id = 0;
        int job = 0;
        for (Employee employee : empArray) {
            if (employee != null) {
                boolean chk = maxSalary < employee.getSalary();
                if (chk) {
                    maxSalary = employee.getSalary();
                    id = employee.getId();
                    job = employee.getJob();
                }
            }
        }
        if (returnJob) return job;
        else return id;
    }

    public static void showSalaryLessNum(Employee[] empArray,double num){
        for (Employee employee : empArray) {
            if (employee != null) {
                if (num > employee.getSalary()) {
                    System.out.println("ID=" + employee.getId() + " ФИО:" + employee.getFio() +
                            String.format(" зарплата:%.2f",employee.getSalary()));
                }
            }
        }
    }

    public static void showSalaryOverNum(Employee[] empArray,double num){
        for (Employee employee : empArray) {
            if (employee != null) {
                if (num <= employee.getSalary()) {
                    System.out.println("ID=" + employee.getId() + " ФИО:" + employee.getFio() +
                            String.format(" зарплата:%.2f",employee.getSalary()));
                }
            }
        }
    }
}