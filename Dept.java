import java.util.*;
import java.util.stream.*;

class Employee {

    String name;
    String department;

    Employee(String n,String d){

        name=n;
        department=d;
    }
}

public class Dept {

    public static void main(String[] args) {

        List<Employee> list=Arrays.asList(

                new Employee("John","IT"),

                new Employee("David","HR"),

                new Employee("Alice","IT"),

                new Employee("Bob","Finance")

        );

        Map<String,List<Employee>> result=

        list.stream()

        .collect(Collectors.groupingBy(e->e.department));

        result.forEach((k,v)->{

            System.out.println(k);

            v.forEach(x->System.out.println(x.name));

        });

    }
}