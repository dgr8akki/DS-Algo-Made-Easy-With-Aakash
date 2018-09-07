public class BST {
    public class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }
    private Node root;

    private void printRootValue() {
        System.out.print(this.root.value);
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }
        if (val >= head.value) head.right = insert(head.right, val);
        else head.left = insert(head.left, val);
        return head;
    }

    public void createTree(int[] arr) {
        for (int el: arr)
            insert(el);
    }

    public void inorder() {
        inorderTraversal(this.root);
    }

    private void inorderTraversal(Node head) {
        if (head == null) return;
        inorderTraversal(head.left);
        System.out.print(head.value + " ");
        inorderTraversal(head.right);
    }

    public void preorder() {
        preorderTraversal(this.root);
    }

    private void preorderTraversal(Node head) {
        if (head == null) return;
        System.out.print(head.value + " ");
        preorderTraversal(head.left);
        preorderTraversal(head.right);
    }

    public void postorder() {
        inorderTraversal(this.root);
    }

    private void postorderTraversal(Node head) {
        if (head == null) return;
        postorderTraversal(head.left);
        postorderTraversal(head.right);
        System.out.print(head.value + " ");
    }

    public void searchInBST(int key) {
        if (search(this.root, key) == null) {
            System.out.println("NOT FOUND");
        } else {
            System.out.println("KEY FOUND" + search(this.root, key).value);
        }
    }

    private Node search(Node head, int k) {
        if (head == null || head.value == k) return head;
        if (k < head.value) head.left = search(head.left, k);
        else if (k > head.value) head.right = search(head.right, k);
        return null;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] input = {-1,
            2,
            3,
            1,
            4,
            12,
            21,
            11
        };
        bst.createTree(input);
        bst.insert(100);
        bst.insert(10);
        bst.preorder();
        System.out.println();
        bst.inorder();
        System.out.println();
        bst.postorder();
        bst.searchInBST(-1);
    }
}