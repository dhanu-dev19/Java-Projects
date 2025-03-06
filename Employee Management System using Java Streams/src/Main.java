import java.util.List;
import java.util.Map;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Alice", "HR", 50000),
                new Employee(2, "Bob", "IT", 70000),
                new Employee(3, "Charlie", "IT", 90000),
                new Employee(4, "David", "Finance", 60000),
                new Employee(5, "Eve", "HR", 55000),
                new Employee(6, "Frank", "Finance", 80000)
        );

        //1 Create Employee Service
        EmployeeService service = new EmployeeService(employees);

        //1.List Employees
        System.out.println("\n Employee List:");
        service.listEmployees();

        // 2. Filter Employees by Department
        System.out.println("\n📌 Employees in IT Department:");
        service.filterByDepartment("IT").forEach(System.out::println);

        // 3. Find Highest Paid Employee
        Optional<Employee> highestPaid = service.getHighestPaidEmployee();
        highestPaid.ifPresent(emp -> System.out.println("\n📌 Highest Paid Employee: " + emp));

        // 4. Find Lowest Paid Employee
        Optional<Employee> lowestPaid = service.getLowestPaidEmployee();
        lowestPaid.ifPresent(emp -> System.out.println("\n📌 Lowest Paid Employee: " + emp));

        // 5. Average Salary by Department
        System.out.println("\n📌 Average Salary by Department:");
        Map<String, Double> avgSalary = service.averageSalaryByDepartment();
        avgSalary.forEach((dept, salary) -> System.out.println(dept + ": $" + salary));

        // 6. Sort Employees by Name
        System.out.println("\n📌 Employees Sorted by Name:");
        service.sortByName().forEach(System.out::println);

        // 7. Sort Employees by Salary Descending
        System.out.println("\n📌 Employees Sorted by Salary (Descending):");
        service.sortBySalaryDescending().forEach(System.out::println);

        // 8. Group Employees by Department
        System.out.println("\n📌 Employees Grouped by Department:");
        Map<String, List<Employee>> grouped = service.groupByDepartment();
        grouped.forEach((dept, emps) -> {
            System.out.println("\n" + dept + ":");
            emps.forEach(System.out::println);
        });
    }
}