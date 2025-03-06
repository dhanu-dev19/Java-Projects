import models.Employee;
import models.Product;
import repository.GenericRepository;
import repository.GenericRepositoryImpl;

import java.util.Optional;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //Employee Repository

        GenericRepository<Employee> employeeRepo = new GenericRepositoryImpl<>(Employee::getId);

        employeeRepo.save(new Employee(1,"Alice",50000));
        employeeRepo.save(new Employee(2,"Bob",60000));

        System.out.println("\n Find Employee by Id (1):");
        Optional<Employee> emp = employeeRepo.findById(1);
        emp.ifPresent(System.out::println);


        System.out.println("\n All Employees");
        employeeRepo.findAll().forEach(System.out::println);

        System.out.println("\n Update Employee(2)");
        employeeRepo.update(2, new Employee(2,"Charlie", 65000));

        System.out.println("\n Delete employee (1)");
        employeeRepo.delete(1);

        //Product Reposiory

        GenericRepository<Product> productRepo = new GenericRepositoryImpl<>(Product::getId);

        productRepo.save(new Product(101,"Laptop",1200.50));
        productRepo.save(new Product(102,"Phone", 800.99));

        System.out.println("\n Find Product by Id");
        Optional<Product> prod = productRepo.findById(101);
        prod.ifPresent(System.out::println);

        System.out.println("\n All Products");
        productRepo.findAll().forEach(System.out::println);

        System.out.println("\n Update Product (102)");
        productRepo.update(102, new Product(102, "smartPhone", 899.9));


        System.out.println("\n Delete Product (101):");
        productRepo.delete(101);






    }
}