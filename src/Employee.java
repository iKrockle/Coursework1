public class Employee {
    private final int id;

    private final String fio;
    private int job;
    private double salary;

    Employee(int inId, String inFio, int inJob, double inSalary)
    {
        id = inId;
        fio = inFio;
        job = inJob;
        salary = inSalary;
    }

    public int getId() {
        return id;
    }

    public String getFio(){
        return fio;
    }

    public int getJob(){
        return job;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setJob(int job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "ID=" + getId() + " ФИО:" + getFio() + " отдел:" +
                getJob() + String.format(" зарплата:%.2f",getSalary());
    }
}
