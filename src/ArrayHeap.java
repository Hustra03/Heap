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

        int previousPostion = (currentPosition - 2) / 2;

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
        currentMaxIndex += 1;
    }

    public int sink() {
        int returnValue = heap[0];
        if (currentMaxIndex == heap.length) {
            currentMaxIndex -= 1;
        }

        heap[0] = heap[currentMaxIndex];

        int currentPosition = 0;

        int nextPositionLeft = (currentPosition) * 2 + 1;
        int nextPositionRigth = (currentPosition + 1) * 2;

        boolean Swap = true;
        boolean SwapWithLeft = true;

        while (true) {

            if ((nextPositionLeft < 0) || (nextPositionLeft > heap.length)) {
                break;
            }
            if ((nextPositionRigth < 0) || (nextPositionRigth > heap.length)) {
                break;
            }

            if (heap[currentPosition] > heap[nextPositionLeft] || heap[currentPosition] > heap[nextPositionRigth]) {
                Swap = true;
                if (heap[nextPositionLeft] <= heap[nextPositionRigth]) {
                    SwapWithLeft = true;
                } else {
                    SwapWithLeft = false;
                }
            }
            if (Swap) {
                if (SwapWithLeft) {
                    int tempValue = heap[currentPosition];
                    heap[currentPosition] = heap[nextPositionLeft];
                    heap[nextPositionLeft] = tempValue;

                    currentPosition = nextPositionLeft;

                } else {
                    int tempValue = heap[currentPosition];
                    heap[currentPosition] = heap[nextPositionRigth];
                    heap[nextPositionRigth] = tempValue;

                    currentPosition = nextPositionRigth;
                }
            }

            Swap = false;

            nextPositionLeft = (currentPosition) * 2 + 1;
            nextPositionRigth = (currentPosition + 1) * 2;

        }

        if (currentMaxIndex < heap.length - 1) {
            currentMaxIndex -= 1;
        }
        return returnValue;
    }

    public void increment(int incrementAmount) {
        heap[0] += incrementAmount;
        this.sink();
        currentMaxIndex += 1;
    }

}
