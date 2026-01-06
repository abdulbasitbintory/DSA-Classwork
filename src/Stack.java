public class Stack {

    private Node top;
    private int[] array;
    private int arrayTop;
    private boolean useArray;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Stack(int size) {
        array = new int[size];
        arrayTop = -1;
        useArray = true;
    }

    public Stack() {
        top = null;
        useArray = false;
    }

    public void push(int value) {
        if (useArray) {
            if (arrayTop == array.length - 1) {
                resize();
            }
            array[++arrayTop] = value;
        } else {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (isEmpty()) return -1;

        if (useArray) {
            return array[arrayTop--];
        } else {
            int val = top.data;
            top = top.next;
            return val;
        }
    }

    public int peek() {
        if (isEmpty()) return -1;

        if (useArray) {
            return array[arrayTop];
        } else {
            return top.data;
        }
    }

    public boolean isEmpty() {
        if (useArray) {
            return arrayTop == -1;
        }
        return top == null;
    }

    private void resize() {
        int[] newArray = new int[array.length * 2];
        for (int i = 0; i <= arrayTop; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void printStack() {
        if (useArray) {
            for (int i = arrayTop; i >= 0; i--) {
                System.out.print(array[i] + " ");
            }
        } else {
            Node temp = top;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
        System.out.println();
    }

    public int findMax() {
        if (isEmpty()) return -1;
        int max = peek();
        while (!isEmpty()) {
            int val = pop();
            if (val > max) max = val;
        }
        return max;
    }

    public int findSum() {
        int sum = 0;
        while (!isEmpty()) {
            sum += pop();
        }
        return sum;
    }

    public double findAverage() {
        if (isEmpty()) return 0;
        int sum = 0, count = 0;
        while (!isEmpty()) {
            sum += pop();
            count++;
        }
        return (double) sum / count;
    }

    public Stack reverseStack() {
        Stack temp = new Stack();
        while (!isEmpty()) {
            temp.push(pop());
        }
        return temp;
    }

    public boolean isPalindrome() {
        Stack copy = new Stack();
        Stack temp = new Stack();

        Node current = top;
        while (current != null) {
            copy.push(current.data);
            temp.push(current.data);
            current = current.next;
        }

        Stack reversed = temp.reverseStack();

        while (!copy.isEmpty() && !reversed.isEmpty()) {
            if (copy.pop() != reversed.pop()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(10);
        s.push(20);
        s.push(30);
        s.printStack();

        s.pop();
        s.printStack();

        s.push(40);
        s.push(50);
        s.printStack();

        System.out.println(s.peek());
        System.out.println(s.isPalindrome());

        Stack reversed = s.reverseStack();
        reversed.printStack();
    }
}
