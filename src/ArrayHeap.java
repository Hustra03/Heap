public class ArrayHeap {
    int heap[];
    int currentMaxIndex;

    ArrayHeap(int length) {
        this.heap = new int[length];
    }

    public void bubble(int value) {
        if (currentMaxIndex >= heap.length) {
            System.out.println("Array Maximum Size Reached");
            return;
        }
        int currentPosition = currentMaxIndex;
        heap[currentPosition] = value;

        int previousPostion;

        if ((currentPosition % 2) == 0) {
            previousPostion = (currentPosition - 2) / 2;
        } else {
            previousPostion = (currentPosition - 1) / 2;
        }
        while ((previousPostion >= 0) && (previousPostion <= heap.length - 1)
                && (heap[currentPosition] < heap[previousPostion])) {
            int tempValue = heap[currentPosition];
            heap[previousPostion] = heap[currentPosition];
            heap[currentPosition] = tempValue;

            currentPosition = previousPostion;
            if ((currentPosition % 2) == 0) {
                previousPostion = (currentPosition - 2) / 2;
            } else {
                previousPostion = (currentPosition - 1) / 2;
            }
        }
        if (currentMaxIndex < heap.length) {

            currentMaxIndex += 1;

        }

    }

    public int sink() {
        int returnValue = heap[0];

        if (currentMaxIndex <= 0) {
            System.out.println("All Elements Sunk");
            return returnValue;
        }
        currentMaxIndex -= 1;
        heap[0] = heap[currentMaxIndex];
        sinkElement(0);

        return returnValue;
    }

    public void increment(int incrementAmount) {
        heap[0] += incrementAmount;
        sinkElement(0);
    }

    private void sinkElement(int currentIndex) {

        int nextIndexLeft = (currentIndex) * 2 + 1;
        int nextIndexRight = (currentIndex) * 2 + 2;

        if (currentIndex < heap.length && nextIndexLeft < heap.length && nextIndexRight < heap.length) {

            if (heap[currentIndex] > heap[nextIndexLeft] || heap[currentIndex] > heap[nextIndexRight]) {
                if (heap[nextIndexLeft] < heap[nextIndexRight]) {
                    int tempValue = heap[nextIndexLeft];
                    heap[nextIndexLeft] = heap[currentIndex];
                    heap[currentIndex] = tempValue;
                    sinkElement(nextIndexLeft);
                } else {
                    if (heap[currentIndex] > heap[nextIndexRight]) {
                        int tempValue = heap[nextIndexRight];
                        heap[nextIndexRight] = heap[currentIndex];
                        heap[currentIndex] = tempValue;
                        sinkElement(nextIndexRight);
                    }
                }
            }
        }
    }

}
