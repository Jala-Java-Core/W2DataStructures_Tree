package tree;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class TestRedBlackTree {

    @Before
    public void setup() {

    }

    @After
    public void cleanup() {

    }

    @Test
    public void add() {
        RedBlackTreeV1 tree = new RedBlackTreeV1();
        tree.insert(20);
        tree.insert(8);
        tree.insert(22);
        tree.insert(5);
        tree.insert(14);
        tree.insert(27);
        tree.insert(9);
        tree.insert(16);
        tree.printTree();
    }

    @Test
    public void add2() {
        RedBlackTree tree = new RedBlackTree();
        tree.insertNode(14);
        tree.insertNode(20);
        tree.insertNode(8);
        tree.insertNode(22);
        tree.insertNode(5);
        tree.insertNode(27);
        tree.insertNode(9);
        tree.insertNode(16);
        tree.printTree();
        tree.deleteNode(14);
        tree.printTree();
    }
}
