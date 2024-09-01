import java.util.Scanner;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    // Helper method to print the linked list
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) System.out.print(" -> ");
        }
        System.out.println();
    }

    // Method to create a linked list from user input
    public ListNode createList(Scanner scanner) {
        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("List must contain at least one element.");
            return null;
        }

        System.out.println("Enter the elements of the linked list (sorted order):");
        ListNode head = new ListNode(scanner.nextInt());
        ListNode curr = head;
        for (int i = 1; i < n; i++) {
            curr.next = new ListNode(scanner.nextInt());
            curr = curr.next;
        }
        return head;
    }

    // Driver code to test the solution
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        // Create a linked list from user input
        ListNode head = solution.createList(scanner);

        if (head != null) {
            System.out.print("Original list: ");
            solution.printList(head);

            ListNode result = solution.deleteDuplicates(head);

            System.out.print("List after removing duplicates: ");
            solution.printList(result);
        }

        scanner.close();
    }
}
