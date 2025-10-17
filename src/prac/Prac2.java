package prac;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee{
    String name;

    public String getDept() {
        return dept;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    String dept;
    int salary;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}
public class Prac2 {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee("Alice", "HR", 50000)) ;
        employees.add(new Employee("Bob", "IT", 60000));
        employees.add(new Employee("Charlie", "HR", 55000));
    /*average sal of ech dept

like for IT:- 60000
HR:- 52500
 */
        Map<String,Double> employeeList=employees.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(employeeList);
    }
}

//User
