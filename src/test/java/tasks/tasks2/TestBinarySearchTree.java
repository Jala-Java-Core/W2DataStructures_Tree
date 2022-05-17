package tasks.tasks2;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import tasks.task2.BinarySearchTree;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinarySearchTree {



    @Before
    public void setup() {
    }

    @After
    public void cleanup() {

    }

    @Test
    public void findNode() {
        BinarySearchTree tree = new BinarySearchTree();;

        tree.add(10);
        tree.add(7);
        tree.add(15);
        tree.add(6);

        BinarySearchTree.Node response = tree.findNode(7);
        assertEquals(response.value, 7);
    }

    @Test
    public void height() {

        BinarySearchTree tree = new BinarySearchTree();;

        tree.add(8);
        tree.add(16);
        tree.add(6);
        tree.add(20);
        tree.add(10);
        tree.add(4);
        tree.add(12);
        tree.add(9);
        tree.add(2);
        /**
         *                                      8
         *              6                                                   16
         *         4                                           10                        20
         *     2                                           9        12
         */

        int response = tree.height(16);
        assertEquals(response, 2);
    }

    @Test
    public void isBalanced() {

        BinarySearchTree tree = new BinarySearchTree();;

        tree.add(8);
        tree.add(16);
        tree.add(6);
        tree.add(20);
        tree.add(10);
        tree.add(4);
        tree.add(12);
        tree.add(9);
        tree.add(2);
        /**
         *                                      8
         *              6                                                   16
         *         4                                           10                        20
         *     2                                           9         12
         *
         */

        BinarySearchTree.Node node = tree.findNode(16);
        assertEquals(tree.isBalanced(node), true);
    }
}


