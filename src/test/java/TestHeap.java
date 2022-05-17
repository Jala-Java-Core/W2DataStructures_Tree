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
        Heap heap = new Heap(5);
        heap.add(2);
        heap.add(3);
        heap.add(5);
        heap.add(4);
        heap.add(1);
        assertEquals(5, heap.values[0]);
        assertEquals(4, heap.values[1]);
        assertEquals(3, heap.values[2]);
        assertEquals(2, heap.values[3]);
        assertEquals(1, heap.values[4]);
    }
}
