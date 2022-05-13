package tree;

public class BinaryTree {
    // Code W2-1
    protected Node root = null;

    public Node getRoot() {
        return this.root;
    }

    // Code W2-2
    public void inorderTraversal(Node n) {
        if (n == null) {
            return;
        }
        inorderTraversal(n.leftChild);
        visit(n);
        inorderTraversal(n.rightChild);
    }

    public void visit(Node n) {
        System.out.println(n.value);
    }

    // Code W2-3
    public boolean binaryTreeSearch(Node n, int val) {
        if (n == null) {
            return false;
        }
        if (n.value == val) {
            return true;
        } else if (n.value > val) {
            return binaryTreeSearch(n.leftChild, val);
        } else {
            return binaryTreeSearch(n.rightChild, val);
        }
    }

    public Node treeSearch(Node n, int val) {
        if (n == null) {
            return n;
        }
        if (n.value == val) {
            return n;
        } else if (n.value > val) {
            return treeSearch(n.leftChild, val);
        } else {
            return treeSearch(n.rightChild, val);
        }
    }

    public boolean add(int val) {
        if (root == null) {
            root = new Node(val);
            return true;
        }
        return add(root, val);
    }

    //Code W2-4
    public boolean add(Node n, int val) {
        if (n.value == val) {
            return false;
        } else if (n.value > val) {
            if (n.leftChild == null) {
                n.leftChild = new Node(val);
                return true;
            } else {
                return add(n.leftChild, val);
            }
        } else {
            if (n.rightChild == null) {
                n.rightChild = new Node(val);
                return true;
            } else {
                return add(n.rightChild, val);
            }
        }
    }

    // Code W2-5
    public boolean remove(Node n, Node parent, int val) {
        if (n == null) {
            return false;
        }
        if (val < n.value) {
            return remove(n.leftChild, n, val);
        } else if (val > n.value) {
            return remove(n.rightChild, n, val);
        } else {
            if (n.leftChild != null && n.rightChild != null) {
                            n.value = maxValue(n.leftChild);
                remove(n.leftChild, n, n.value);
            } else if (parent.leftChild == n) {
                parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
            } else {
                parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
            }
            return true;
        }
    }

    protected int maxValue(Node n) {
        if (n.rightChild == null) {
            return n.value;
        } else {
            return maxValue(n.rightChild);
        }
    }
}
