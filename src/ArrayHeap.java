public class ArrayHeap {
    int heap[];
    int currentMaxIndex;

    ArrayHeap(int length) {
        this.heap = new int[length];
    }

    public void bubble(int value) {
        currentMaxIndex += 1;
        int currentPosition = currentMaxIndex + 1;
        heap[currentPosition] = value;
        
        int previousPostion = (currentPosition - 2) / 2;
        if ((currentPosition%2)== 0 ) {
            previousPostion = (currentPosition - 2) / 2;
        }
        else
        {previousPostion = (currentPosition - 1) / 2;}
        while (heap[currentPosition] > heap[previousPostion]) {
            int tempValue = heap[currentPosition];
            heap[previousPostion] = heap[currentPosition];
            heap[currentPosition] = tempValue;

            currentPosition = previousPostion;
            previousPostion = (currentPosition - 2) / 2;
        }
    }
}
