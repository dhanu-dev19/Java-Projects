import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService
{
  private List<Employee> employees;

  public EmployeeService(List<Employee> employees)
  {
      this.employees = employees;
  }

  //1. List of all employess
    public void listEmployees()
    {
      employees.forEach(System.out::println);
    }
    //2. Filter employees by department
    public List<Employee> filterByDepartment(String Department)
    {
        return employees.stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase(Department))
                .collect(Collectors.toList());
    }
    //3. Get Employess with the highest Salary
    public Optional<Employee> getHighestPaidEmployee()
    {
            return employees.stream()
                    .max(Comparator.comparingDouble(Employee::getSalary));
    }

    //4. Get Employee with the lowest Salary
    public Optional<Employee> getLowestPaidEmployee()
    {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
    }

    //5. Calculate Average Salary per Department
    public Map<String , Double> averageSalaryByDepartment()
    {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }
    //6. Sort Employess by name
    public List<Employee> sortByName()
    {
        return  employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    //7 Sort employess by salary (Descending)
    public List<Employee> sortBySalaryDescending()
    {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }

    //Group employess by department
    public Map<String, List<Employee>> groupByDepartment()
    {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}
