/**
 * LList
 */
public class LList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static void printList(Node head) {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            System.out.print(current.val);
            current = current.next;
            if (current != null)
                System.out.print(" -> ");
        }
        System.out.println();
        System.out.println("Length of Linked List: " + count);
    }

    static int getLength(Node head) {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    static Node insertAtStart(Node head, int val) {
        Node nodeToBeInserted = new Node(val);
        nodeToBeInserted.next = head;
        head = nodeToBeInserted;
        return head;
    }

    static void insertAtEnd(Node head, int val) {
        Node nodeToBeInserted = new Node(val);
        Node current = head, prev = null;
        while (current != null) {
            prev = current;
            current = current.next;
        }

        prev.next = nodeToBeInserted;

    }

    static void insertAtMid(Node head, int val) {
        Node nodeToBeInserted = new Node(val);
        int len = getLength(head), count = 0;

        Node current = head, prev = null;
        while (current != null) {
            count++;
            if (count > (len / 2))
                break;
            prev = current;
            current = current.next;
        }

        nodeToBeInserted.next = current;
        prev.next = nodeToBeInserted;
    }

    static Node reverse(Node head) {
        // 1 -> 2 -> 3 -> X
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        printList(head);
        head = insertAtStart(head, -1);
        head = insertAtStart(head, 0);
        printList(head);
        insertAtEnd(head, 10);
        insertAtEnd(head, 11);
        printList(head);
        insertAtMid(head, 9);
        insertAtMid(head, 101);
        printList(head);
        head = reverse(head);
        printList(head);
    }
}
