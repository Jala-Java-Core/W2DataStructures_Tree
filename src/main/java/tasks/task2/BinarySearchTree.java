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
		if (n == null || n.value == val) {
			return n;
		}

		if (n.value.compareTo(val) > 0) {
			return findNode(n.leftChild, val);
		}

		return findNode(n.rightChild, val);
	}

	// Method #2.
	public int depth(E val) {
		return depth(root, val, 0);
	}

	protected int depth(Node n, E val, int depth) {
		if (n == null || val == null) {
			return -1;
		}

		if (n.value == val) {
			return depth;
		}

		if (n.value.compareTo(val) > 0) {
			return depth(n.leftChild, val, depth + 1);
		}

		return depth(n.rightChild, val, depth + 1);
	}
	

	// Method #3.
	public int height(E val) {
		if (val == null) {
			return -1;
		}
		Node n = findNode(val);
		return height(n, 0);
	}

	protected int height(Node n, int height) {
		if (n == null) {
			return -1;
		}
		if (n.leftChild == null && n.rightChild == null) {
			return height;
		}

		return Math.max(height(n.leftChild, height + 1), height(n.rightChild, height + 1));
	}

	// Method #4.
	public boolean isBalanced(Node n) {
		if (n == null) {
			return false;
		}
		return Math.abs(height(n.leftChild, 0) - height(n.rightChild, 0)) <= 1;
	}
	
	// Method #5. .
	public boolean isBalanced() {
		return isBalanced(root);
	}

}
