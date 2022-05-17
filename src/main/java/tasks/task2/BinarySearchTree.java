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

	protected Node findNode(Node n, E val) {
		if (n == null) {
			return null;
		}

		if (n.value.equals(val)) {
			return n;
		} else if (n.value.compareTo(val) > 0) {
			return findNode(n.leftChild, val);
		} else {
			return findNode(n.rightChild, val);
		}
	}
	

	// Method #3.
	public int height(E val) {

		Node node = findNode(val);
		if (node == null) {
			return -1;
		}
		int height = height(node.leftChild, node.rightChild);
		return height;
	}
	protected int height(Node leftChild, Node rightChild) {
		if (leftChild == null && rightChild == null) {
			return 0;
		} else {
			int leftChildHeight = 0;
			int rightChildHeight = 0;

			if (leftChild!= null &&  rightChild != null) {
				leftChildHeight = height(leftChild.leftChild, leftChild.rightChild) + 1;
				rightChildHeight = height(rightChild.leftChild, rightChild.rightChild) + 1;
				if (leftChildHeight > rightChildHeight) {
					return leftChildHeight;
				} else {
					return rightChildHeight;
				}
			} else if (leftChild == null) {
				rightChildHeight = height(rightChild.leftChild, rightChild.rightChild) + 1;
				return rightChildHeight;
			} else {
				leftChildHeight = height(leftChild.leftChild, leftChild.rightChild) + 1;
				return leftChildHeight;
			}
		}
	}
	// Method #5. .
	public boolean isBalanced(Node node) {
		boolean response = false;
		if (node == null ) {
			return response;
		}

		int leftChildHeight = -1;
		if (node.leftChild != null) {
			leftChildHeight = height(node.leftChild.value);
		}

		int rightChildHeight = -1;
		if (node.rightChild != null) {
			rightChildHeight = height(node.rightChild.value);
		}

		if (Math.abs(leftChildHeight - rightChildHeight) <= 1) {
			response = true;
		}
		
		return response;

	}

}
