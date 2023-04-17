import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.time.LocalDate;
import java.time.Period;

class Employee {
    private int id;
    private String name;
    private String joiningDate;
    private String employmentType;
    private String role;
    private String domain;

    public Employee(int id, String name, String joiningDate, String employmentType, String role, String domain) {
        this.id = id;
        this.name = name;
        this.joiningDate = joiningDate;
        this.employmentType = employmentType;
        this.role = role;
        this.domain = domain;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public String getRole() {
        return role;
    }

    public String getDomain() {
        return domain;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getExperience() {
        LocalDate today = LocalDate.now();
        LocalDate joiningDate = LocalDate.parse(this.joiningDate); 
        Period period = Period.between(joiningDate, today);
        return period.getYears();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", joiningDate='" + joiningDate + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", role='" + role + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}

public class EmployeeFileReader {

    private List<Employee> employeeList = new ArrayList<>();

    public void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String joiningDate = data[2];
                String employmentType = data[3];
                String role = data[4];
                String domain = data[5];
                Employee employee = new Employee(id, name, joiningDate, employmentType, role, domain);
                employeeList.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayEmployeeDetails(int employeeId) {
        for (Employee employee : employeeList) {
            if (employee.getId() == employeeId) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Employee with Id: "+ employeeId+ " is not found in the file.");
    }

    public void displayEmployeesByRole(String role) {
        for (Employee employee : employeeList) {
            if (employee.getRole().equalsIgnoreCase(role)) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Employee with Role: "+ role+ " is not found in the file.");
    }

    public void displayEmployeesByExperience(int minExperience) {
        for (Employee employee : employeeList) {
            if (employee.getExperience() >= minExperience) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Employee with minExperience: "+ minExperience+ " is not found in the file.");
    }

    public static void main(String[] args) {
        EmployeeFileReader employeeFileReader = new EmployeeFileReader();
        employeeFileReader.readFile("employee.txt");
        employeeFileReader.displayEmployeeDetails(1001);
        employeeFileReader.displayEmployeesByRole("Developer");
        employeeFileReader.displayEmployeesByExperience(18);
    }
}

