package tasks.task2;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinarySearchTree {
    BinarySearchTree<Integer> tree;

    @BeforeEach
    public void setup() {
        tree = new BinarySearchTree<>();
        tree.add(8);
        tree.add(6);
        tree.add(16);
        tree.add(4);
        tree.add(10);
        tree.add(20);
        tree.add(2);
        tree.add(9);
        tree.add(12);
    }

    @After
    public void cleanup() {

    }

    @Test
    public void findNode_Node() {
        BinarySearchTree.Node n = tree.findNode(16);
        Assertions.assertNotNull(n);
        Assertions.assertEquals(10, n.leftChild.value);
        Assertions.assertEquals(20, n.rightChild.value);
    }

    @Test
    public void findNode_Null() {
        BinarySearchTree.Node n = tree.findNode(58);
        Assertions.assertNull(n);
    }

    @Test
    public void depth_Root() {
        int depth = tree.depth(8);
        Assertions.assertEquals(0, depth);
    }

    @Test
    public void depth_Child() {
        int depth = tree.depth(16);
        Assertions.assertEquals(1, depth);
    }

    @Test
    public void depth_Grandchild() {
        int depth = tree.depth(4);
        Assertions.assertEquals(2, depth);
    }

    @Test
    public void depth_GreatGrandchild() {
        int depth = tree.depth(12);
        Assertions.assertEquals(3, depth);
    }

    @Test
    public void depth_NullVal() {
        int depth = tree.depth(null);
        Assertions.assertEquals(-1, depth);
    }

    @Test
    public void depth_NullValNotFound() {
        int depth = tree.depth(68);
        Assertions.assertEquals(-1, depth);
    }

    @Test
    public void height() {
        Assertions.assertEquals(3, tree.height(8));
        Assertions.assertEquals(2, tree.height(6));
        Assertions.assertEquals(2, tree.height(16));
        Assertions.assertEquals(1, tree.height(4));
        Assertions.assertEquals(1, tree.height(10));
        Assertions.assertEquals(0, tree.height(20));
        Assertions.assertEquals(0, tree.height(2));
        Assertions.assertEquals(0, tree.height(9));
        Assertions.assertEquals(0, tree.height(12));
    }

    @Test
    public void height_Null() {
        Assertions.assertEquals(-1, tree.height(null));
        Assertions.assertEquals(-1, tree.height(80));
    }

    @Test
    public void isBalanced_Node() {
        Assertions.assertTrue(tree.isBalanced(tree.findNode(8)));
        Assertions.assertTrue(tree.isBalanced(tree.findNode(16)));
        Assertions.assertTrue(tree.isBalanced(tree.findNode(10)));
        Assertions.assertFalse(tree.isBalanced(tree.findNode(6)));
    }

    @Test
    public void isBalanced_NodeNull() {
        Assertions.assertFalse(tree.isBalanced(tree.findNode(99)));
    }

    @Test
    public void isBalanced_TreeTrue() {
        Assertions.assertTrue(tree.isBalanced());
    }

    @Test
    public void isBalanced_TreeFalse() {
        tree = new BinarySearchTree<>();
        tree.add(10);
        tree.add(8);
        tree.add(6);
        tree.add(16);
        tree.add(4);
        tree.add(9);
        tree.add(20);
        tree.add(2);
        tree.add(12);
        Assertions.assertFalse(tree.isBalanced());
    }
}
