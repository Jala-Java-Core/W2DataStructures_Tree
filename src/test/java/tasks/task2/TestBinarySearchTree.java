package tasks.task2;

import org.junit.jupiter.api.BeforeEach;
import tasks.task2.BinarySearchTree.Node;
import org.junit.After;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBinarySearchTree {
    BinarySearchTree<Integer> binarySearchTree;

    @BeforeEach
    public void setup() {
        binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(8);
        binarySearchTree.add(6);
        binarySearchTree.add(16);
        binarySearchTree.add(4);
        binarySearchTree.add(10);
        binarySearchTree.add(20);
        binarySearchTree.add(2);
        binarySearchTree.add(9);
        binarySearchTree.add(12);
    }

    @After
    public void cleanup() {

    }

    @Test
    public void findNodeExisting() {
        Node node = binarySearchTree.findNode(10);

        assertEquals(10, node.value);
        assertEquals(9, node.leftChild.value);
        assertEquals(12, node.rightChild.value);
    }

    @Test
    public void findNodeNonExisting() {
        Node node = binarySearchTree.findNode(11);

        assertNull(node);
    }

    @Test
    public void depthRoot() {
        int depth = binarySearchTree.depth(8);

        assertEquals(0, depth);
    }

    @Test
    public void depthChildren() {
        int depth = binarySearchTree.depth(6);

        assertEquals(1, depth);
    }

    @Test
    public void depthGrandChildren() {
        int depth = binarySearchTree.depth(4);

        assertEquals(2, depth);
    }

    @Test
    public void depthValueNull() {
        int depth = binarySearchTree.depth(null);

        assertEquals(-1, depth);
    }

    @Test
    public void depthNonExisting() {
        int depth = binarySearchTree.depth(11);

        assertEquals(-1, depth);
    }

    @Test
    public void heightExisting() {
        int height = binarySearchTree.height(16);

        assertEquals(2, height);
    }

    @Test
    public void heightNonExisting() {
        int height = binarySearchTree.height(11);

        assertEquals(-1, height);
    }

    @Test
    public void heightNull() {
        int height = binarySearchTree.height((Integer) null);

        assertEquals(-1, height);
    }

    @Test
    public void isBalancedTrue() {
        boolean isBalanced = binarySearchTree.isBalanced(16);

        assertTrue(isBalanced);
    }

    @Test
    public void isBalancedFalse() {
        boolean isBalanced = binarySearchTree.isBalanced(6);

        assertFalse(isBalanced);
    }

    @Test
    public void isBalancedExistingNode() {
        Node node = binarySearchTree.findNode(16);

        boolean isBalanced = binarySearchTree.isBalanced(node);

        assertTrue(isBalanced);
    }

    @Test
    public void isBalancedNonExistingNode() {
        Node node = binarySearchTree.findNode(6);

        boolean isBalanced = binarySearchTree.isBalanced(node);

        assertFalse(isBalanced);
    }

    @Test
    public void isBalancedFull() {
        BinarySearchTree<Integer> balancedTree = new BinarySearchTree();

        balancedTree.add(8);
        balancedTree.add(6);
        balancedTree.add(16);
        balancedTree.add(4);
        balancedTree.add(7);
        balancedTree.add(10);
        balancedTree.add(20);

        boolean isBalanced = balancedTree.isBalanced();

        assertTrue(isBalanced);
    }

    @Test
    public void isBalancedNotFull() {
        BinarySearchTree<Integer> nonBalancedTree = new BinarySearchTree();

        nonBalancedTree.add(8);
        nonBalancedTree.add(6);
        nonBalancedTree.add(16);
        nonBalancedTree.add(4);
        nonBalancedTree.add(10);
        nonBalancedTree.add(20);
        nonBalancedTree.add(2);
        nonBalancedTree.add(9);
        nonBalancedTree.add(12);

        boolean isBalanced = nonBalancedTree.isBalanced();

        assertFalse(isBalanced);
    }
}
