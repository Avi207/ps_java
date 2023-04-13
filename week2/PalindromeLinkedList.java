import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeLinkedList {
    
    static boolean isPalindrome(LinkedList<Character> list) {
        if (list.isEmpty()) {
            return true;
        }
        
        // find the middle index of the linked list
        int n = list.size();
        int mid = n / 2;
        
        // reverse the second half of the linked list
        for (int i = mid; i < n; i++) {
            list.add(i, list.removeLast());
        }
        
        // check whether the first half and the reversed second half of the linked list are identical
        for (int i = 0; i < mid; i++) {
            if (list.get(i) != list.get(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        LinkedList<Character> list = new LinkedList<>();
        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            char element = scanner.nextLine().charAt(0);
            list.add(element);
        }
        
        if (isPalindrome(list)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }

}
