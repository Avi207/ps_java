import java.util.Scanner;

public class enumJob {
    enum TechStack {
        JAVA(8, 0.45, "Manager"),
        SAP(4, 0.3, "Sr. Associate"),
        QA(3, 0.2, "Associate");
        
        private int minExp;
        private double increment;
        private String role;
        
        private TechStack(int minExp, double increment, String role) {
            this.minExp = minExp;
            this.increment = increment;
            this.role = role;
        }
        
        public int getMinExp() {
            return minExp;
        }
        
        public double getIncrement() {
            return increment;
        }
        
        public String getRole() {
            return role;
        }
    }
    
    public static void main(String[] args) {
        try{
            
            Scanner sc = new Scanner(System.in);
            
            System.out.print("Enter your tech stack: ");
            String techStackInput = sc.nextLine();

            System.out.print("Enter your years of experience: ");
            int yearsOfExp = sc.nextInt();

            System.out.print("Enter your current salary (considered as in Lacs): ");
            double currentSalary = sc.nextDouble();
            
            TechStack techStack = null;
            for (TechStack ts : TechStack.values()) {
                if (ts.name().equalsIgnoreCase(techStackInput) && yearsOfExp >= ts.getMinExp()) {
                    techStack = ts;
                    break;
                }
            }
            
            if (techStack != null) {
                double increment = techStack.getIncrement();
                String role = techStack.getRole();
                double expectedSalary = currentSalary + (currentSalary * increment);
                System.out.println("Congratulations! You're eligible for the role of " + role + " in the " + techStackInput + " team.");
                System.out.println("Your expected salary would be " + expectedSalary +"Lacs.");
            } else {
                System.out.println("Sorry, there are no open roles for the " + techStackInput + " team with your experience level.");
            }
        }catch(Exception e){
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
