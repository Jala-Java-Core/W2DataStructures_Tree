package tasks.task2;


public class BinarySearchTree<E extends Comparable<E>> {
	public class Node {
		public E value;
		Node leftChild = null;
		Node rightChild = null;
		Node(E value) {
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			@SuppressWarnings("unchecked")
			Node other = (Node)obj;
			return other.value.compareTo(value) == 0 &&
					other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}

	protected Node root = null;
	
	protected void visit(Node n) {
		System.out.println(n.value);
	}
	
	public boolean contains(E val) {
		return contains(root, val);
	}
	
	protected boolean contains(Node n, E val) {
		if (n == null) return false;
		
		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}
	
	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}
	
	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
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
	
	public boolean remove(E val) {
		return remove(root, null, val);
	}
	
	protected boolean remove(Node n, Node parent, E val) {
		if (n == null) return false;

		if (val.compareTo(n.value) == -1) {
				return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) == 1) {
				return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n){
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
	    } else {
	       return maxValue(n.rightChild);
	    }
	}

	
	/*********************************************
	 * 
	 * IMPLEMENT THE METHODS BELOW!
	 *
	 *********************************************/
	
	
	// Method #1.
	public Node findNode(E val) {
		return findNode(root, val);
	}

	private Node findNode(Node node, E val) {
		if (node == null) {
			return null;
		}

		if (node.value.equals(val)) {
			return node;
		} else if (node.value.compareTo(val) > 0) {
			return findNode(node.leftChild, val);
		} else {
			return findNode(node.rightChild, val);
		}
	}
	

	// Method #3.
	public int height(E val) {
		Node node = findNode(val);
		if (node == null) {
			return 0;
		}

		if (isLeaf(node)) {
			return 1;
		}

		int leftHeight = 0;
		int rightHeight = 0;

		if (node.leftChild != null) {
			leftHeight = height(node.leftChild.value);
		}

		if (node.rightChild != null) {
			rightHeight = height(node.rightChild.value);
		}
		return (getMax(leftHeight, rightHeight) + 1);
	}

	private boolean isLeaf(Node node){
		return node.leftChild == null && node.rightChild ==null;
	}

	private int getMax(int leftHeight, int rightHeight){
		return (leftHeight > rightHeight) ? leftHeight : rightHeight;
	}
	
	// Method #5. .
	public boolean isBalanced(Node node) {
		if (node == null ) {
			return false;
		}

		if (isLeaf(node)) {
			return true;
		}

		if (node.leftChild == null || node.rightChild == null) {
			return false;
		}

		return height(node.leftChild.value) == height(node.rightChild.value);
	}
}