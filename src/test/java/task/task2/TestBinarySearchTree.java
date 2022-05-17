package task.task2;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import tasks.task2.BinarySearchTree;

import static org.junit.jupiter.api.Assertions.*;

public class TestBinarySearchTree {
    @Before
    public void setup() {
    }

    @After
    public void cleanup() {
    }

    @Test
    public void findNodeReturnFalse() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        BinarySearchTree.Node response = tree.findNode(7);
        assertEquals(response, null);
    }

    @Test
    public void findNodeReturnTrue() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        BinarySearchTree.Node response = tree.findNode(4);
        assertEquals(response.value, 4);
    }

    @Test
    public void heightWithOneValue() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(1);
        int responseHeight = tree.height(1);
        assertEquals(responseHeight, 1);
    }

    @Test
    public void heightWithTwoValues() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(1);
        tree.add(2);
        tree.add(3);

        int responseHeight = tree.height(2);
        assertEquals(responseHeight, 2);
    }

    @Test
    public void heightWithValues() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        int responseHeight = tree.height(2);
        assertEquals(responseHeight, 3);
    }

    @Test
    public void isBalancedReturnsTrue() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        BinarySearchTree.Node node = tree.findNode(5);
        assertTrue(tree.isBalanced(node));
    }

    @Test
    public void isBalancedReturnsFalse() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        BinarySearchTree.Node node = tree.findNode(3);
        assertFalse(tree.isBalanced(node));
    }
}
