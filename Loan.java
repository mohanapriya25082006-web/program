abstract class Employee {

    protected int id;
    protected String name;
    protected double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateSalary();

    abstract void work();

    void display() {
        System.out.println("ID      : " + id);
        System.out.println("Name    : " + name);
        System.out.println("Salary  : " + calculateSalary());
    }

    final void company() {
        System.out.println("Company : ABC Technologies");
    }
}

class Developer extends Employee {

    Developer(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    double calculateSalary() {
        return salary + salary * 0.20;
    }

    @Override
    void work() {
        System.out.println(name + " is developing software.");
    }
}

class Manager extends Employee {

    Manager(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    double calculateSalary() {
        return salary + salary * 0.35;
    }

    @Override
    void work() {
        System.out.println(name + " is managing projects.");
    }
}

public class Loan {

    public static void main(String[] args) {

        Employee emp1 = new Developer(101, "John", 50000);

        emp1.company();
        emp1.display();
        emp1.work();

        System.out.println();

        Employee emp2 = new Manager(201, "David", 80000);

        emp2.company();
        emp2.display();
        emp2.work();
    }
}