import java.util.*;
class node {
    int data;
    node ptr;
    node(int d) {
        ptr = null;
        data = d;
    }
}
public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create linked list from user input
        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("List must contain at least one element.");
            scanner.close();
            return;
        }

        System.out.println("Enter the elements of the linked list:");
        node head = new node(scanner.nextInt());
        node curr = head;
        for (int i = 1; i < n; i++) {
            curr.ptr = new node(scanner.nextInt());
            curr = curr.ptr;
        }

        // Check if the linked list is a palindrome
        boolean condition = isPalindrome(head);
        System.out.println("Is Palindrome: " + condition);

        scanner.close();
    }

    static boolean isPalindrome(node head) {
        node slow = head;
        boolean ispalin = true;
        Stack<Integer> stack = new Stack<>();

        // Push all elements of the linked list onto the stack
        while (slow != null) {
            stack.push(slow.data);
            slow = slow.ptr;
        }

        // Compare elements from stack with the linked list
        while (head != null) {
            int i = stack.pop();
            if (head.data != i) {
                ispalin = false;
                break;
            }
            head = head.ptr;
        }

        return ispalin;
    }
}


