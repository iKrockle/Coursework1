public class Employee {
    int id = Main.id;

    String fio;
    int job;
    double salary;

    Employee(String inFio, int inJob, double inSalary)
    {
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
                getJob() + " зарплата:" + getSalary();
    }
}
