import java.util.*;
import java.util.stream.*;

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;

    public Employee(int id, String name,
                    String department,
                    double salary,
                    int age) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {

        return id + " "
                + name + " "
                + department + " "
                + salary + " "
                + age;
    }
}

public class View {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(

                new Employee(101,"John","IT",50000,25),
                new Employee(102,"David","HR",35000,30),
                new Employee(103,"Alice","IT",70000,28),
                new Employee(104,"Bob","Finance",60000,35),
                new Employee(105,"Kevin","IT",90000,40),
                new Employee(106,"Nancy","HR",45000,29),
                new Employee(107,"Tom","Finance",75000,45),
                new Employee(108,"Maria","Sales",40000,27),
                new Employee(109,"Sophia","Sales",65000,31),
                new Employee(110,"James","IT",55000,26)

        );

        System.out.println("----------- All Employees -----------");

        employees.forEach(System.out::println);

        System.out.println("\n----------- IT Employees -----------");

        employees.stream()

                .filter(e -> e.getDepartment().equals("IT"))

                .forEach(System.out::println);

        System.out.println("\n----------- Salary > 60000 -----------");

        employees.stream()

                .filter(e -> e.getSalary() > 60000)

                .forEach(System.out::println);

        System.out.println("\n----------- Employee Names -----------");

        employees.stream()

                .map(Employee::getName)

                .forEach(System.out::println);

        System.out.println("\n----------- Sorted By Salary -----------");

        employees.stream()

                .sorted(Comparator.comparing(Employee::getSalary))

                .forEach(System.out::println);

        System.out.println("\n----------- Highest Salary -----------");

        Employee maxEmployee =

                employees.stream()

                        .max(Comparator.comparing(Employee::getSalary))

                        .get();

        System.out.println(maxEmployee);

        System.out.println("\n----------- Lowest Salary -----------");

        Employee minEmployee =

                employees.stream()

                        .min(Comparator.comparing(Employee::getSalary))

                        .get();

        System.out.println(minEmployee);

        System.out.println("\n----------- Average Salary -----------");

        double average =

                employees.stream()

                        .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println(average);

        System.out.println("\n----------- Total Salary -----------");

        double total =

                employees.stream()

                        .map(Employee::getSalary)

                        .reduce(0.0, Double::sum);

        System.out.println(total);

        System.out.println("\n----------- Count -----------");

        long count =

                employees.stream()

                        .count();

        System.out.println(count);

        System.out.println("\n----------- Group By Department -----------");

        Map<String,List<Employee>> group =

                employees.stream()

                        .collect(Collectors.groupingBy(Employee::getDepartment));

        group.forEach((dept,list)->{

            System.out.println(dept);

            list.forEach(System.out::println);

        });

        System.out.println("\n----------- Find First -----------");

        employees.stream()

                .findFirst()

                .ifPresent(System.out::println);

        System.out.println("\n----------- Any Match -----------");

        boolean result =

                employees.stream()

                        .anyMatch(e -> e.getSalary() > 80000);

        System.out.println(result);

        System.out.println("\n----------- All Match -----------");

        boolean ageResult =

                employees.stream()

                        .allMatch(e -> e.getAge() > 20);

        System.out.println(ageResult);

        System.out.println("\n----------- Top 3 Highest Salary -----------");

        employees.stream()

                .sorted(Comparator.comparing(Employee::getSalary).reversed())

                .limit(3)

                .forEach(System.out::println);

        System.out.println("\n----------- Skip First 2 -----------");

        employees.stream()

                .skip(2)

                .forEach(System.out::println);

        System.out.println("\n----------- Distinct Departments -----------");

        employees.stream()

                .map(Employee::getDepartment)

                .distinct()

                .forEach(System.out::println);

        System.out.println("\n----------- Parallel Stream -----------");

        employees.parallelStream()

                .map(Employee::getName)

                .forEach(System.out::println);

        System.out.println("\n----------- Salary Increment 10% -----------");

        employees.stream()

                .map(e -> e.getName() + " : " +
                        (e.getSalary() * 1.10))

                .forEach(System.out::println);

    }
}