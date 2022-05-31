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

		if(val == null || root == null) return null;

		return findNode(root, val);
	}

	protected Node findNode(Node node, E value) {

		int cmp = value.compareTo(node.value);

		if(cmp == 0) {
			return node;
		}
		else if(cmp < 0) {
			if(node.leftChild == null) return null;
			return findNode(node.leftChild, value);
		} else {
			if (node.rightChild == null) return null;
			return findNode(node.rightChild, value);
		}
	}

	public E getNodeValue(Node node) {
		return node.value;
	}

	// Method #3.
	public int height(E val) {
		if(val == null || root == null) return -1;
		int heightBase = 0;
		return height(root, val, heightBase);
	}

	protected int height(Node node, E value, int currentHeight) {

		int cmp = value.compareTo(node.value);

		if(cmp == 0) {
			return currentHeight;
		}
		else if (cmp < 0) {
			if(node.leftChild == null) return -1;
			return height(node.leftChild, value, currentHeight + 1);
		} else {
			if(node.rightChild == null) return -1;
			return height(node.rightChild, value, currentHeight + 1);
		}
	}

	
	// Method #5. .
	public boolean isBalanced() {
		if (root == null) return false;
		int baseHeight = 0;
		return isBalanced(root, baseHeight);
	}

	protected boolean isBalanced(Node node, int currentHeight) {

		if(node == null) return true;

		int heightLeftTree = node.leftChild == null? 0 : height(node.leftChild, currentHeight + 1);
		int heightRightTree = node.rightChild == null? 0 : height(node.rightChild, currentHeight + 1);

		if (Math.abs(heightLeftTree - heightRightTree) < 1
				&& isBalanced(node.leftChild, currentHeight + 1)
				&& isBalanced(node.rightChild, currentHeight + 1))
		{
			return true;
		} else {
			return false;
		}
	}

	public int height() {
		if(root == null) return -1;
		int heightBase = 0;
		return height(root, heightBase);
	}

	protected int height(Node node, int currentHeight) {

		int leftHeight, rightHeight;
		if (node.leftChild == null) {
			leftHeight = currentHeight;
		} else {
			leftHeight = height(node.leftChild, currentHeight + 1);
		}

		if (node.rightChild == null) {
			rightHeight = currentHeight;
		} else {
			rightHeight = height(node.rightChild, currentHeight + 1);
		}

		return Math.max(leftHeight, rightHeight);
	}

}
