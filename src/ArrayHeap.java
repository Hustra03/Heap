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

        currentMaxIndex -= 1;
        heap[0] = heap[currentMaxIndex];

        int currentPosition = 0;

        int nextPositionLeft = (currentPosition) * 2 + 1;
        int nextPositionRight = (currentPosition) * 2 + 2;

        boolean SwapWithLeft = true;

        while (true) {

            if ((nextPositionLeft < 0) || (nextPositionLeft > heap.length)) {
                break;
            }
            if ((nextPositionRight < 0) || (nextPositionRight > heap.length)) {
                break;
            }

            if (heap[currentPosition] > heap[nextPositionLeft] || heap[currentPosition] > heap[nextPositionRight]) {

                if (heap[nextPositionLeft] < heap[nextPositionRight]) {
                    SwapWithLeft = true;
                } else {
                    SwapWithLeft = false;
                }
            } else {
                break;
            }

            if (SwapWithLeft) {
                int tempValue = heap[currentPosition];
                heap[currentPosition] = heap[nextPositionLeft];
                heap[nextPositionLeft] = tempValue;

                currentPosition = nextPositionLeft;

            } else {
                int tempValue = heap[currentPosition];
                heap[currentPosition] = heap[nextPositionRight];
                heap[nextPositionRight] = tempValue;

                currentPosition = nextPositionRight;
            }

            nextPositionLeft = (currentPosition) * 2 + 1;
            nextPositionRight = (currentPosition) * 2 + 2;

        }

        return returnValue;
    }

    public void increment(int incrementAmount) {
        heap[0] += incrementAmount;

        int currentPosition = 0;
        int nextPositionLeft = (currentPosition) * 2 + 1;
        int nextPositionRight = (currentPosition) * 2 + 2;

        while (true) {

            if ((nextPositionLeft < 0) || (nextPositionLeft > heap.length)) {
                break;
            }
            if ((nextPositionRight < 0) || (nextPositionRight > heap.length)) {
                break;
            }

            if (heap[currentPosition] > heap[nextPositionLeft]) {

                if (heap[nextPositionLeft] <= heap[nextPositionRight]) {

                    int tempValue = heap[currentPosition];
                    heap[currentPosition] = heap[nextPositionLeft];
                    heap[nextPositionLeft] = tempValue;

                    currentPosition = nextPositionLeft;
                }
            } else {
                if (heap[currentPosition] > heap[nextPositionRight]) {

                    int tempValue = heap[currentPosition];
                    heap[currentPosition] = heap[nextPositionRight];
                    heap[nextPositionRight] = tempValue;

                    currentPosition = nextPositionRight;
                } else {
                    break;
                }
            }

            nextPositionLeft = (currentPosition) * 2 + 1;
            nextPositionRight = (currentPosition + 1) * 2;
        }
    }

}
