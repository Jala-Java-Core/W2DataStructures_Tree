public class Heap {
    // Code W2-8
    int[] values;
    int size = 0;

    public Heap(int maxHeight) {
        values = new int[(int) (Math.pow(2, maxHeight) - 1)];
    }

    public void swapValues(int index1, int index2) {
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }
    // Code W2-9
    public void add(int value) {
        if (size == values.length) {
            throw new Error();
        }
        values[size] = value;
        bubbleUp(size);
        size++;
    }

    public void bubbleUp(int index) {
        if (index == 0) {
            return;
        }
        int parentIndex = (index - 1) / 2;
        if (values[parentIndex] < values[index]) {
            swapValues(index, parentIndex);
            bubbleUp(parentIndex);
        }
    }

    //Code W2-10
    public int extract() {
        if (size == 0) {
            throw new Error();
        }
        int extractMax = values[size - 1];
        bubbleDown(0);
        size -= 1;
        return extractMax;
    }

    public void bubbleDown(int index) {
        int greaterChild;
        int leftIndex = (index * 2) + 1;
        int rightIndex = (index * 2) + 2;
        if (rightIndex < size && values[rightIndex] > values[leftIndex]) {
            greaterChild = rightIndex;
        } else if (leftIndex < size) {
            greaterChild = leftIndex;
        } else {
            return;
        }
        if (values[index] < values[greaterChild]) {
            swapValues(index, greaterChild);
            bubbleDown(greaterChild);
        }
    }
}
