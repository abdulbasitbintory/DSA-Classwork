public class BinarySearchTree {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node root, int val) {
        if (root == null)
            return new Node(val);

        if (val < root.data)
            root.left = insertRec(root.left, val);
        else
            root.right = insertRec(root.right, val);

        return root;
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (key < root.data)
            return searchRec(root.left, key);
        else
            return searchRec(root.right, key);
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root == null)
            return;
        inorderRec(root.left);
        System.out.print(root.data + " ");
        inorderRec(root.right);
    }

    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorderRec(root.left);
        preorderRec(root.right);
    }

    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root == null)
            return;
        postorderRec(root.left);
        postorderRec(root.right);
        System.out.print(root.data + " ");
    }

    public int findMin() {
        Node curr = root;
        while (curr.left != null)
            curr = curr.left;
        return curr.data;
    }

    public int findMax() {
        Node curr = root;
        while (curr.right != null)
            curr = curr.right;
        return curr.data;
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(heightRec(root.left), heightRec(root.right));
    }

    public int countLeafNodes() {
        return countLeafRec(root);
    }

    private int countLeafRec(Node root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        return countLeafRec(root.left) + countLeafRec(root.right);
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null)
            return null;

        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            root.data = findMinRec(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int findMinRec(Node root) {
        while (root.left != null)
            root = root.left;
        return root.data;
    }

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int v : values)
            tree.insert(v);

        tree.inorder();
        tree.preorder();
        tree.postorder();

        System.out.println(tree.search(60));
        System.out.println(tree.findMin());
        System.out.println(tree.findMax());
        System.out.println(tree.height());
        System.out.println(tree.countLeafNodes());

        tree.delete(30);
        tree.inorder();
    }
}
