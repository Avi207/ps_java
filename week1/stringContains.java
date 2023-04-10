import java.util.Scanner;

public class stringContains
{
	public static void main(String[] args) {
        
	    Scanner sc = new Scanner(System.in);
	    
		System.out.println("Enter First String: ");
		String str1 = sc.nextLine();
		
		System.out.println("Enter Second String: ");
		String str2 = sc.nextLine();
		
		if(str1.contains(str2) || str2.contains(str1)){
		    System.out.println("One string is present in the string.");
		}else{
		    System.out.println("Both the string is different from each other.");
		}
	}
}
