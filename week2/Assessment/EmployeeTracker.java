import java.util.*;
import java.time.*;

enum EmploymentType {
    CONTRACT,
    FULL_TIME
}

enum EmployeeStatus {
    ACTIVE,
    EXIT,
    SERVING_NOTICE
}

class Employee {
    private int employeeId;
    private String employeeName;
    private String joiningDate;
    private EmploymentType employmentType;
    private String role;
    private EmployeeStatus status;

    public Employee(Integer employeeId, String employeeName, String joiningDate, EmploymentType employmentType, String role, EmployeeStatus status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.joiningDate = joiningDate;
        this.employmentType = employmentType;
        this.role = role;
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public String getRole() {
        return role;
    }

    public EmployeeStatus getStatus() {
        return status;
    }
    
    public void updateEmploymentType(EmploymentType newEmploymentType) {
        this.employmentType = newEmploymentType;
    }

    @Override
    public String toString() {
        return String.format("Employee ID: %d Employee Name: %s Joining Date: %s Employment Type: %s Role: %s Status: %s\n",
            employeeId, employeeName, joiningDate.toString(), employmentType, role, status);
    }
}

public class EmployeeTracker {
    
    private List<Employee> employees = new ArrayList<>();
    
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    
    public Employee deleteEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                employee.setStatus(EmployeeStatus.EXIT);
                return employee;
            }
        }
        return null;
    }
    
    
    public Employee updateEmploymentType(int employeeId, EmploymentType employmentType) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                employee.setEmploymentType(employmentType);
                return employee;
            }
        }
        return null;
    }
    
    public Employee updateRole(int employeeId, String role) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                employee.setRole(role);
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getSeniorMostEmployees() {
        Collections.sort(employees, Comparator.comparing(Employee::getJoiningDate));
        ArrayList<Employee> seniorMostEmployees = new ArrayList<>();
        seniorMostEmployees.add(employees.get(0));
        for (int i = 1; i < employees.size(); i++) {
            if (employees.get(i).getJoiningDate().equals(employees.get(0).getJoiningDate())) {
                seniorMostEmployees.add(employees.get(i));
            } else {
                break;
            }
        }
        return seniorMostEmployees;
    }
    
    public List<Employee> getEmployeesByStatus(EmployeeStatus status) {
        ArrayList<Employee> employeesByStatus = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getStatus().equals(status)) {
                employeesByStatus.add(employee);
            }
        }
        return employeesByStatus;
    }

    public static void main(String[] args) {
        EmployeeTracker tracker = new EmployeeTracker();
        // Adding new employees
        tracker.addEmployee(new Employee(1001, "Avinash Kumar", "2021-01-01", EmploymentType.CONTRACT, "Developer", EmployeeStatus.ACTIVE));
        tracker.addEmployee(new Employee(1002, "Ankit Satyam", "2020-06-01", EmploymentType.FULL_TIME, "Manager", EmployeeStatus.ACTIVE));
        tracker.addEmployee(new Employee(1003, "Ravi Sharma", "2022-02-01", EmploymentType.CONTRACT, "Tester", EmployeeStatus.SERVING_NOTICE));

        //Print all the employee
        System.out.println("-------------------------\nList of all Employee: \n"+ tracker.employees);

        // Delete employee
        Employee deletedEmployee = tracker.deleteEmployee(1003);
        if (deletedEmployee != null) {
            System.out.println("---------\nDeleted Employee: \n" + deletedEmployee);
        }

        // Update employment type
        Employee updatedEmployment = tracker.updateEmploymentType(1001, EmploymentType.FULL_TIME);
        if(updatedEmployment != null){
            System.out.println("---------\nUpdated employment type: \n" + updatedEmployment);
        }

        // Update role
        Employee updatedRole = tracker.updateRole(1002, "Senior Manager");
        if(updatedRole != null){
            System.out.println("---------\nUpdated Role: \n" + updatedRole);
        }
        
        // Getting senior most employees
        List<Employee> seniorMostEmployees = tracker.getSeniorMostEmployees();
        System.out.println("---------\nSenior Most Employees: \n" + seniorMostEmployees);

        // Getting list of employees by status
        List<Employee> activeEmployees = tracker.getEmployeesByStatus(EmployeeStatus.ACTIVE);
        System.out.println("------------\nEmployees by status: \n" + activeEmployees);
    }
}

