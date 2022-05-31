package task2;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import tasks.task2.BinarySearchTree;
import tree.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinarySearchTree {
    @Test
    public void FindNode() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(50);
        tree.add(30);
        tree.add(60);
        tree.add(62);
        tree.add(52);
        tree.add(54);
        tree.add(51);
        tree.add(58);
        assertEquals(62, tree.getNodeValue(tree.findNode(62)));
    }

    @Test
    public void height() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(50);
        tree.add(30);
        tree.add(60);
        tree.add(62);
        tree.add(52);
        tree.add(54);
        tree.add(51);
        tree.add(58);
        assertEquals(4, tree.height(58));
    }

    @Test
    public void isBalanced_false() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(50);
        tree.add(30);
        tree.add(60);
        tree.add(62);
        tree.add(52);
        tree.add(54);
        tree.add(51);
        tree.add(58);
        assertEquals(false, tree.isBalanced());
    }

    @Test
    public void isBalanced_true() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(50);
        tree.add(25);
        tree.add(75);
        tree.add(10);
        tree.add(40);
        tree.add(60);
        tree.add(100);
        assertEquals(true, tree.isBalanced());
    }
}
