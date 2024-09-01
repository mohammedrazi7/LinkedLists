import java.util.Scanner;

public class insertNode {
    // A linked list Node
    static class Node {
        public int data;
        public Node nextNode;

        // Inserting the required data
        public Node(int data) {
            this.data = data;
            this.nextNode = null;  // Initialize nextNode to null
        }
    }

    // Function to create and return a Node
    static Node GetNode(int data) {
        return new Node(data);
    }

    // Function to insert a Node at the required position
    static Node InsertPos(Node headNode, int position, int data) {
        Node head = headNode;
        if (position < 1) {
            System.out.println("Invalid position");
            return head;
        }

        // If position is 1, insert at the head
        if (position == 1) {
            Node newNode = new Node(data);
            newNode.nextNode = headNode;
            head = newNode;
        } else {
            Node current = headNode;
            int currentPosition = 1;
            while (currentPosition < position - 1 && current != null) {
                current = current.nextNode;
                currentPosition++;
            }

            if (current == null) {
                System.out.println("Position out of range");
            } else {
                Node newNode = GetNode(data);
                newNode.nextNode = current.nextNode;
                current.nextNode = newNode;
            }
        }
        return head;
    }

    static void PrintList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.nextNode;
            if (node != null)
                System.out.print(", ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a linked list dynamically
        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("List must contain at least one element.");
            scanner.close();
            return;
        }

        System.out.println("Enter the elements of the linked list:");
        Node head = GetNode(scanner.nextInt());
        Node curr = head;
        for (int i = 1; i < n; i++) {
            curr.nextNode = GetNode(scanner.nextInt());
            curr = curr.nextNode;
        }

        System.out.print("Linked list before insertion: ");
        PrintList(head);

        // Insert at a specific position
        System.out.println("Enter the position to insert at:");
        int pos = scanner.nextInt();
        System.out.println("Enter the data to insert:");
        int data = scanner.nextInt();
        head = InsertPos(head, pos, data);
        System.out.print("Linked list after insertion: ");
        PrintList(head);

        scanner.close();
    }
}
