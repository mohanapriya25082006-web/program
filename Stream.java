import java.util.*;

class Employee {

    int id;
    String name;
    double salary;

    Employee(int id,String name,double salary){

        this.id=id;
        this.name=name;
        this.salary=salary;
    }
}

public class Stream {

    public static void main(String[] args) {

        List<Employee> emp = Arrays.asList(

                new Employee(1,"John",50000),

                new Employee(2,"David",70000),

                new Employee(3,"Alice",40000),

                new Employee(4,"Bob",90000)

        );

        emp.stream()

           .filter(e->e.salary>50000)

           .sorted((a,b)->Double.compare(b.salary,a.salary))

           .forEach(e->

           System.out.println(

           e.id+" "+e.name+" "+e.salary));

    }
}