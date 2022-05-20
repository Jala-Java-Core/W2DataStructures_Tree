import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHeap {

    @Before
    public void setup() {

    }

    @Test
    public void add() {
        Heap heap = new Heap(5);
        heap.add(2);
        heap.add(3);
        heap.add(5);
        heap.add(4);
        heap.add(1);
        assertEquals(heap.values[0], 5);
        assertEquals(heap.values[1], 4);
        assertEquals(heap.values[2], 3);
        assertEquals(heap.values[3], 2);
        assertEquals(heap.values[4], 1);
    }

    @Test
    public void extract() {
        Heap heap = new Heap(12);
        heap.add(20);
        heap.add(18);
        heap.add(14);
        heap.add(9);
        heap.add(16);
        heap.add(8);
        heap.add(10);
        heap.add(5);
        heap.add(2);
        heap.add(15);
        heap.add(1);
        heap.add(7);
        //heap.add(17);
        assertEquals(20, heap.values[0]);
        assertEquals(18, heap.values[1]);
        assertEquals(14, heap.values[2]);
        assertEquals(9, heap.values[3]);
        assertEquals(16, heap.values[4]);
        int extracted = heap.extractLast();
        assertEquals(7, extracted);
        extracted = heap.extractLast();
        assertEquals(1, extracted);
    }
}
