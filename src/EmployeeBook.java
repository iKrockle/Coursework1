public class EmployeeBook {
    private final Employee[] empArray = new Employee[10];
    private int  id = 1;

    public void addEmployee(String fio, int job, double sal){
        Employee employee = new Employee(fio,job,sal);
        for (int i=0;i<empArray.length;i++){
            if (empArray[i]==null) {
                empArray[i] = employee;
                break;
            }
        }
        id++;
    }

    public void delEmployee(String fio){
        for (int i=0;i<empArray.length;i++){
            if (empArray[i].getFio().equals(fio)) {
                empArray[i] = null;
                break;
            }
        }
    }

    public void delEmployee(int id){
        for (int i=0;i<empArray.length;i++){
            if (empArray[i].getId()==id) {
                empArray[i] = null;
                break;
            }
        }
    }

    public void delEmployee(int id,String fio){
        for (int i=0;i<empArray.length;i++){
            if (empArray[i].getId()==id&&empArray[i].getFio().equals(fio)) {
                empArray[i] = null;
                break;
            }
        }
    }

    public void chgEmployee(String fio,double sal){
        for (Employee employee : empArray) {
            if (employee.getFio().equals(fio)) {
                employee.setSalary(sal);
                break;
            }
        }
    }

    public void chgEmployee(String fio,int job){
        for (Employee employee : empArray) {
            if (employee.getFio().equals(fio)) {
                employee.setJob(job);
                break;
            }
        }
    }

    public void chgEmployee(String fio,int job,double sal){
        for (Employee employee : empArray) {
            if (employee.getFio().equals(fio)) {
                employee.setJob(job);
                employee.setSalary(sal);
                break;
            }
        }
    }

    public void showEmployeesByJob(){
        int i = 1;
        while (i<=5)
        {
            System.out.println("Отдел "+i);
            for (Employee employee : empArray){
                if(employee.getJob()==i){
                    System.out.println(employee.getFio());
                }
            }
            i++;
        }
    }

    public void showEmployees(){
        for (Employee employee : empArray)
            if (employee != null) System.out.println(employee);
    }

    public void showJobEmployees(int job){
        for (Employee employee : empArray)
            if (employee != null)
                if (employee.getJob()==job)
                    System.out.println("ID=" + employee.getId() + " ФИО:" + employee.getFio() +
                            String.format(" зарплата:%.2f",employee.getSalary()));

    }

    public double getSalarySum(){
        double salarySum = 0;
        for (Employee employee : empArray)
            if (employee != null) salarySum += employee.getSalary();
        return salarySum;
    }

    public int getMinSalary(){
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

    public int getMaxSalary(){
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

    public double getAvgSalary(){
        return getSalarySum()/empArray.length;
    }

    public void showFioEmployees(){
        for (Employee employee : empArray) {
            if (employee != null) System.out.println("ФИО:" + employee.getFio());
        }
    }

    public void indexSalary(double indexPercent){
        for (Employee employee : empArray)
            if (employee != null)
                employee.setSalary(employee.getSalary()+employee.getSalary()*indexPercent/100);
    }

    public void showSalByJob(){
        double[] salByJob = new double[5];
        int i=0;
        for (Employee employee : empArray)
            if (employee != null) salByJob[employee.getJob()-1] += employee.getSalary();

        for (double sal : salByJob) {
            i++;
            System.out.println("Для отдела " + i + String.format(" нужно подготовить %.2f",sal) +" рублей");
        }
    }

    public void showAvgSalByJob(){
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

    public void indexSalaryForJob(double indexPercent,int job){
        for (Employee employee : empArray)
            if (employee != null&&employee.getJob()==job)
                employee.setSalary(employee.getSalary()+employee.getSalary()*indexPercent/100);
    }

    public int getMinSalary(boolean returnJob){
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

    public int getMaxSalary(boolean returnJob){
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

    public void showSalaryLessNum(double num){
        for (Employee employee : empArray) {
            if (employee != null) {
                if (num > employee.getSalary()) {
                    System.out.println("ID=" + employee.getId() + " ФИО:" + employee.getFio() +
                            String.format(" зарплата:%.2f",employee.getSalary()));
                }
            }
        }
    }

    public void showSalaryOverNum(double num){
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
