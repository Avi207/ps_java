import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class GenerateUsername {
    public static void main(String[] args) {

        try{
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter your name (First Last): ");
            String name = sc.nextLine();

            System.out.print("Enter your date of birth (dd-mm-yyyy): ");
            String dobStr = sc.nextLine();

            System.out.print("Enter your Aadhar card number: ");
            String aadhar = sc.nextLine();

            if (!name.matches("[a-zA-Z ]+")) {
                throw new IllegalArgumentException("Name should only contain alphabets and spaces.");
            }

            String[] nameParts = name.split(" ");
            if (nameParts.length != 2) {
                throw new IllegalArgumentException("Name should contain first name and last name separated by space.");
            }

            String nameWithoutSpaces = name.replaceAll("\\s+", "");

            LocalDate dob = LocalDate.parse(dobStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            if (Period.between(dob, LocalDate.now()).getYears() < 18) {
                throw new IllegalArgumentException("You should be at least 18 years old till date.");
            }

            if (!aadhar.matches("\\d{12}")) {
                throw new IllegalArgumentException("Aadhar card number should be a 12-digit number.");
            }

            String username = nameWithoutSpaces.substring(0, 4) + dob.format(DateTimeFormatter.ofPattern("ddyyyy"))+ aadhar.substring(aadhar.length() - 4);
            System.out.println("Generated username: " + username);
        }catch(Exception e){
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
