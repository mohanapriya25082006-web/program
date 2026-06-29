// =============================
// Functional Interface
// =============================
@FunctionalInterface
interface BonusCalculator {
    double calculateBonus(double salary);

    default void message() {
        System.out.println("Bonus Calculation Completed.");
    }
}

// =============================
// Parent Interface
// =============================
interface Person {

    void displayProfile();

    default void welcome() {
        printHeader();
        System.out.println("Welcome to Employee Portal");
    }

    private void printHeader() {
        System.out.println("----------------------------");
    }

    static void company() {
        System.out.println("ABC Technologies");
    }
}

// =============================
// Child Interface
// =============================
interface Employee extends Person {

    void work();

    default void attendance() {
        System.out.println("Attendance Marked");
    }
}

// =============================
// Another Interface
// =============================
interface Department {

    void departmentName();

    default void meeting() {
        System.out.println("Department Meeting Scheduled");
    }
}

// =============================
// Payroll Interface
// =============================
interface Payroll {

    double calculateSalary();

    default void generateSlip() {
        System.out.println("Salary Slip Generated");
    }
}

// =============================
// Developer Class
// =============================
class Developer implements Employee, Department, Payroll {

    private int id;
    private String name;
    private double basicSalary;

    public Developer(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.basicSalary = salary;
    }

    @Override
    public void displayProfile() {
        System.out.println("Employee ID : " + id);
        System.out.println("Employee Name : " + name);
    }

    @Override
    public void work() {
        System.out.println(name + " is developing Java applications.");
    }

    @Override
    public void departmentName() {
        System.out.println("Department : Software Development");
    }

    @Override
    public double calculateSalary() {
        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.10;
        return basicSalary + hra + da;
    }
}

// =============================
// Manager Class
// =============================
class Manager implements Employee, Department, Payroll {

    private int id;
    private String name;
    private double salary;

    public Manager(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void displayProfile() {
        System.out.println("Manager ID : " + id);
        System.out.println("Manager Name : " + name);
    }

    @Override
    public void work() {
        System.out.println(name + " is managing projects.");
    }

    @Override
    public void departmentName() {
        System.out.println("Department : Project Management");
    }

    @Override
    public double calculateSalary() {
        return salary + salary * 0.30;
    }
}

// =============================
// Main Class
// =============================
public class Company {

    public static void main(String[] args) {

        Person.company();

        System.out.println();

        Employee emp1 = new Developer(101, "John", 50000);

        emp1.welcome();
        emp1.displayProfile();
        emp1.work();
        emp1.attendance();

        Department d1 = (Department) emp1;
        d1.departmentName();
        d1.meeting();

        Payroll p1 = (Payroll) emp1;

        System.out.println("Developer Salary = " + p1.calculateSalary());
        p1.generateSlip();

        System.out.println();

        Employee emp2 = new Manager(201, "David", 80000);

        emp2.welcome();
        emp2.displayProfile();
        emp2.work();
        emp2.attendance();

        Department d2 = (Department) emp2;
        d2.departmentName();

        Payroll p2 = (Payroll) emp2;

        System.out.println("Manager Salary = " + p2.calculateSalary());

        System.out.println();

        // Functional Interface using Lambda
        BonusCalculator bonus = salary -> salary * 0.15;

        double developerBonus = bonus.calculateBonus(50000);

        System.out.println("Developer Bonus = " + developerBonus);

        bonus.message();

        System.out.println();

        try {

            int workingHours = 9;

            if (workingHours > 8)
                throw new Exception("Overtime Allowed");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {

            System.out.println("Attendance Process Completed");

        }
    }
}