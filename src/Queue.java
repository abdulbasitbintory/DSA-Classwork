class QueueBase {
    void enqueue(int value) {}
    int dequeue() { return -1; }
    int peek() { return -1; }
    boolean isEmpty() { return true; }
    void printQueue() {}
}
class QueueArray extends QueueBase {

    private int[] arr;
    private int size;
    private int rear;

    public QueueArray(int capacity) {
        arr = new int[capacity];
        size = 0;
        rear = -1;
    }

    public void enqueue(int value) {
        if (size == arr.length) {
            resize();
        }
        arr[++rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty())
            return -1;

        int removed = arr[0];

        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }

        rear--;
        size--;
        return removed;
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return arr[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < size; i++)
            newArr[i] = arr[i];
        arr = newArr;
    }

    public void printQueue() {
        for (int i = 0; i <= rear; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
class QueueLinkedList extends QueueBase {

    private Node front;
    private Node rear;

    private class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (isEmpty())
            return -1;

        int removed = front.data;
        front = front.next;

        if (front == null)
            rear = null;

        return removed;
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void printQueue() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class Queue {
    public static void main(String[] args) {

        QueueBase q1 = new QueueArray(3);
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        q1.dequeue();
        q1.enqueue(40);
        q1.printQueue();

        QueueBase q2 = new QueueLinkedList();
        q2.enqueue(5);
        q2.enqueue(15);
        q2.enqueue(25);
        q2.dequeue();
        q2.printQueue();
    }
}
