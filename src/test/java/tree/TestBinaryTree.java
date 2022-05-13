package tree;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import tree.BinaryTree;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinaryTree {
    @Before
    public void setup() {

    }

    @After
    public void cleanup() {

    }

    @Test
    public void search() {
        BinaryTree tree = new BinaryTree();
        tree.add(20);
        tree.add(10);
        tree.add(23);
        tree.add(27);
        tree.add(5);
        tree.add(15);
        tree.add(17);
        assertEquals(true, tree.binaryTreeSearch(tree.getRoot(), 17));
    }

    @Test
    public void remove() {
        BinaryTree tree = new BinaryTree();
        tree.add(16);
        tree.add(5);
        tree.add(22);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.add(12);
        tree.add(18);
        tree.add(23);
        tree.add(24);
        boolean result = tree.remove(tree.getRoot(), tree.getRoot(), 5);
    }
}
