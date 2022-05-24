package tasks.task2;


public class BinarySearchTree<E extends Comparable<E>> {
	class Node {
		E value;
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

	protected Node findNode(Node n, E val) {
		if (n == null) return null;
		if (val.compareTo(n.value) == 0) return n;

		return val.compareTo(n.value) < 0 ? findNode(n.leftChild, val) : findNode(n.rightChild, val);
	}

	// Method #2.
	public int depth(E val) {
		return depth(root, val);
	}

	protected int depth(Node n, E val) {
		if (n == null || val == null) return -1;

		int nodeDepth = -1;

		if (
			val.compareTo(n.value) == 0 ||
			(
				val.compareTo(n.value) < 0 &&
				(nodeDepth = depth(n.leftChild, val)) >= 0
			) ||
			(
				val.compareTo(n.value) > 0 &&
				(nodeDepth = depth(n.rightChild, val)) >= 0
			)
		) {
			return nodeDepth + 1;
		}

		return nodeDepth;
	}

	// Method #3.
	public int height(E val) {
		if (val == null) return -1;

		Node node = findNode(val);
		if (node == null) return -1;

		return height(node);
	}

	protected int height(Node n) {
		if (n == null) return -1;
		int leftHeight = height(n.leftChild);
		int rightHeight = height(n.rightChild);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	
	// Method #4.
	public boolean isBalanced() {
		if (root == null) return false;

		return isBalanced(root) && isBalancedCheckChildren(root);
	}

	protected boolean isBalancedCheckChildren(Node n) {
		if (n == null) return true;

		return isBalanced(n) &&
				isBalancedCheckChildren(n.leftChild) &&
				isBalancedCheckChildren(n.rightChild);
	}

	public boolean isBalanced(E val) {
		if (val == null) return false;

		Node node = findNode(val);
		if (node == null) return false;

		return isBalanced(node);
	}

	public boolean isBalanced(Node n) {
		if (n == null) return false;

		int leftHeight = height(n.leftChild);
		int rightHeight = height(n.rightChild);

		return Math.abs(leftHeight - rightHeight) <= 1;
	}
}
