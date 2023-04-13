import java.util.Scanner;

public class PalindromeLinkedList {
    
    static class Node {
        char data;
        Node next;
        
        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static boolean isPalindrome(Node head) {
        if (head == null) {
            return true;
        }
        
        // find the middle node of the linked list
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the second half of the linked list
        Node prev = null;
        Node curr = slow.next;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow.next = prev;
        
        // check whether the first half and the reversed second half of the linked list are identical
        Node p1 = head;
        Node p2 = prev;
        while (p2 != null) {
            if (p1.data != p2.data) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of nodes in the linked list: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        Node head = null;
        Node tail = null;
        System.out.println("Enter the data for each node:");
        for (int i = 0; i < n; i++) {
            char data = scanner.nextLine().charAt(0);
            Node node = new Node(data);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        
        if (isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }

}
