import java.util.Scanner;

public class LinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    private Node head;
    private int size;

    LinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        size--;
    }

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }

    public int searchElement(int value) {
        Node curr = head;
        int index = 0;

        while (curr != null) {
            if (curr.data == value)
                return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    public void deleteGreaterThan(int limit) {
        while (head != null && head.data > limit) {
            head = head.next;
            size--;
        }

        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.data > limit) {
                curr.next = curr.next.next;
                size--;
            } else {
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }

        System.out.print("\nInitial List: ");
        list.printList();

        list.addFirst(100);
        list.addLast(200);

        System.out.print("After addFirst & addLast: ");
        list.printList();

        list.removeFirst();
        list.removeLast();

        System.out.print("After removeFirst & removeLast: ");
        list.printList();

        System.out.println("Current Size: " + list.getSize());

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        int index = list.searchElement(key);

        if (index != -1)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Element not found");

        System.out.print("Enter limit to delete greater than: ");
        int limit = sc.nextInt();
        list.deleteGreaterThan(limit);

        System.out.print("Final List: ");
        list.printList();

        System.out.println("Final Size: " + list.getSize());
    }
}
