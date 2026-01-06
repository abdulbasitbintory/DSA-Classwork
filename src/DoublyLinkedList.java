public class DoublyLinkedList {

    private Node head;
    private Node tail;

    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void deleteFirst() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void deleteLast() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    public void deleteByValue(int value) {
        if (head == null) return;

        if (head.data == value) {
            deleteFirst();
            return;
        }

        Node temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) return;

        if (temp == tail) {
            deleteLast();
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public void deleteAfterValue(int value) {
        Node temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) return;

        if (temp.next == tail) {
            deleteLast();
            return;
        }

        temp.next = temp.next.next;
        temp.next.prev = temp;
    }

    public void deleteBeforeValue(int value) {
        Node temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null || temp.prev == null) return;

        if (temp.prev == head) {
            deleteFirst();
            return;
        }

        temp.prev = temp.prev.prev;
        temp.prev.next = temp;
    }

    public void printForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ⇆ ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ⇆ ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public int search(int key) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == key) return index;
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public void reverseDLL() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }

        Node swap = head;
        head = tail;
        tail = swap;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addFirst(20);
        dll.addFirst(10);
        dll.addLast(30);
        dll.addLast(40);

        dll.printForward();
        dll.printBackward();

        dll.deleteFirst();
        dll.printForward();

        dll.deleteLast();
        dll.printForward();

        dll.deleteByValue(20);
        dll.printForward();

        dll.addLast(50);
        dll.addLast(60);
        dll.printForward();

        dll.deleteAfterValue(30);
        dll.printForward();

        dll.deleteBeforeValue(50);
        dll.printForward();

        System.out.println(dll.search(50));

        dll.reverseDLL();
        dll.printForward();
    }
}
