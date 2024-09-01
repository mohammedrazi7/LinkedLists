import java.util.Scanner;

class Node {
    int data;
    Node next;

    // Constructor to initialize a new node with data
    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

public class searchKey {

    // Checks whether key is present in linked list
    static boolean searchKey(Node head, int key) {
        // Initialize curr with the head of linked list
        Node curr = head;

        // Iterate over all the nodes
        while (curr != null) {
            // If the current node's value is equal to key, return true
            if (curr.data == key)
                return true;

            // Move to the next node
            curr = curr.next;
        }

        // If there is no node with value as key, return false
        return false;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new linked list dynamically
        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("List must contain at least one element.");
            return;
        }

        // Read the elements for the linked list
        System.out.println("Enter the elements of the linked list:");
        Node head = new Node(scanner.nextInt());
        Node curr = head;
        for (int i = 1; i < n; i++) {
            curr.next = new Node(scanner.nextInt());
            curr = curr.next;
        }

        // Read the key to search
        System.out.println("Enter the key to search in the linked list:");
        int key = scanner.nextInt();

        // Search the key in the linked list
        if (searchKey(head, key))
            System.out.println("Yes");
        else
            System.out.println("No");

        scanner.close();
    }
}
