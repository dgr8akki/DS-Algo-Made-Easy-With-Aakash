public class LList {
  class Node {
    public int data;
    public Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  private Node head;

  public void insertAtBegining(int data) {
    Node nodeToBeInserted = new Node(data);
    nodeToBeInserted.next = head;
    head = nodeToBeInserted;
  }

  public void insertAtEnd(int data) {
    if (head == null) {
      insertAtBegining(data);
      return;
    }
    Node nodeToBeInserted = new Node(data);
    Node current = head;
    Node prev = null;
    while(current != null) {
      prev = current;
      current = current.next;
    }

    prev.next = nodeToBeInserted;
  }

  public Node getHead () {
    return head;
  }

  public void print() {
    System.out.println();
    Node current = head;
    while(current != null) {
      System.out.print(current.data + " => ");
      current = current.next;
    }
    if (current == null)
      System.out.print("X");
  }

  public void reverse() {
    Node current = head;
    Node prev = null;
    while(current != null) {
      Node next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head = prev;
  }

  public static void main(String[] args) {
    LList list = new LList();
    list.insertAtBegining(1);
    list.insertAtBegining(2);
    list.insertAtBegining(3);
    list.insertAtBegining(4);
    list.insertAtBegining(5);
    list.print();
    list.reverse();
    list.print();
  }
}