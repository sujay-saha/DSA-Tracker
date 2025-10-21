package streamsJava;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Employee{
    int employeeId;
    String employeeName;
    int age;

    public Employee(int employeeId, String employeeName, int age) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
    }
    @Override
    public String toString(){
        return "Id: "+this.employeeId+" _ Name: "+this.employeeName+" _ Age: "+this.age+" ";
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

public class StreamExplorer {
    public static void main(String[] args) {
        List<Integer> valuesList = new ArrayList<>(Arrays.asList(50,60,100,150,499,588,100,499));
        valuesList.stream()
                .filter(val->val%5==0)
                .collect(Collectors.toList())
                .forEach(val-> System.out.println(val));
        System.out.println("----------------------Distinct Values");
        valuesList.stream()
                .distinct()
                .forEach(System.out::println);
        System.out.println("----------------------Value *2");
        valuesList.stream()
                .map(val->val*2)
                .forEach(System.out::println);
        System.out.println("----------------------Employees");
        employeeStreamExamples();

        int arr[] = {1,3,2,5,8,9,9};

        Map<Integer, List<Integer>> groupedByValue = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(x->x));
        System.out.println("Grouping-----------\n"+groupedByValue);
        Map<Integer, Long> groupedByValue2 = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(x->x,Collectors.counting()));
        System.out.println("Grouping with count-----------\n"+groupedByValue2);
    }

    public static void employeeStreamExamples(){
        List<Employee> employeesList = new ArrayList<>(Arrays.asList(
                new Employee(1,"A",30),
                new Employee(2,"B",35),
                new Employee(3,"C",30),
                new Employee(4,"D",28),
                new Employee(5,"E",35)
        ));
        System.out.println("-----------------------NOW-------------------------------");
        Map<Integer,List<Employee>> ageMap =employeesList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getAge()));
        ageMap.entrySet().stream().forEach((entry)->{if(entry.getKey()>30)
            System.out.println(entry.getValue());});
        List<Employee> sortedemployeesList =employeesList.stream()
                                                         .sorted((n,o)->n.getAge()-o.getAge())
                                                         .collect(Collectors.toList());
        List<Employee> sortedemployeesList2 =employeesList.stream()
                                                            .sorted(Comparator.comparingInt(Employee::getAge))
                                                            .collect(Collectors.toList());

    }
}
