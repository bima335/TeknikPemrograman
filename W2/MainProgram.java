import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class MainProgram {
    public static void main(String[] args) {
        Department deptIT = new Department("IT Department");
        EmploymentType typeFullTime = new EmploymentType("Full-Time");

        Employee emp1 = new Employee(101, "Asep", deptIT, typeFullTime, 5000000);
        Employee emp2 = new Employee(102, "Budi", deptIT, typeFullTime, 6000000);

        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);
        service.addEmployee(emp2);

        System.out.println("Gaji awal " + emp1.getName() + ": Rp" + emp1.getSalary());
        service.raiseSalary(101, 10); // Naik 10%
        System.out.println("Gaji setelah kenaikan: Rp" + emp1.getSalary());

        System.out.println("\nTotal Employee terdaftar: " + Employee.getTotalEmployees());
    }
}