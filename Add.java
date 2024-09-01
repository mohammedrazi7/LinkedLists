import java.util.Scanner;

class LinkedListNode {
    int data;
    LinkedListNode nextNode;  // Updated to 'nextNode'

    LinkedListNode(int val) {
        data = val;
        nextNode = null;  // Updated to 'nextNode'
    }
}

public class Add {

    // Function to reverse the linked list
    static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode next;

        while (curr != null) {
            next = curr.nextNode;  // Updated to 'nextNode'
            curr.nextNode = prev;  // Updated to 'nextNode'
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to add two numbers represented by linked list
    static LinkedListNode addTwoLists(LinkedListNode num1, LinkedListNode num2) {
        LinkedListNode res = null;
        LinkedListNode curr = null;
        int carry = 0;

        num1 = reverse(num1);
        num2 = reverse(num2);

        // Iterate till either num1 is not empty or num2 is
        // not empty or carry is greater than 0
        while (num1 != null || num2 != null || carry != 0) {
            int sum = carry;

            // If num1 linked list is not empty, add it to sum
            if (num1 != null) {
                sum += num1.data;
                num1 = num1.nextNode;  // Updated to 'nextNode'
            }

            // If num2 linked list is not empty, add it to sum
            if (num2 != null) {
                sum += num2.data;
                num2 = num2.nextNode;  // Updated to 'nextNode'
            }

            // Create a new node with sum % 10 as its value
            LinkedListNode newNode = new LinkedListNode(sum % 10);

            // Store the carry for the next nodes
            carry = sum / 10;

            // If this is the first node, then make this node
            // as the head of the resultant linked list
            if (res == null) {
                res = newNode;
                curr = newNode;
            } else {
                // Append new node to resultant linked list
                // and move to the next node
                curr.nextNode = newNode;  // Updated to 'nextNode'
                curr = curr.nextNode;     // Updated to 'nextNode'
            }
        }

        // Reverse the resultant linked list to get the
        // required linked list
        return reverse(res);
    }

    static void printList(LinkedListNode head) {
        LinkedListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.nextNode;  // Updated to 'nextNode'
        }
        System.out.println();
    }

    static LinkedListNode createList(Scanner scanner) {
        System.out.println("Enter the number of digits in the linked list:");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("List must contain at least one digit.");
            return null;
        }

        System.out.println("Enter the digits of the linked list:");
        LinkedListNode head = new LinkedListNode(scanner.nextInt());
        LinkedListNode curr = head;
        for (int i = 1; i < n; i++) {
            curr.nextNode = new LinkedListNode(scanner.nextInt());  // Updated to 'nextNode'
            curr = curr.nextNode;  // Updated to 'nextNode'
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create two linked lists from user input
        System.out.println("Creating first linked list:");
        LinkedListNode num1 = createList(scanner);

        System.out.println("Creating second linked list:");
        LinkedListNode num2 = createList(scanner);

        // Add the two linked lists
        LinkedListNode sum = addTwoLists(num1, num2);

        // Print the result
        System.out.println("Resultant linked list:");
        printList(sum);

        scanner.close();
    }
}
