import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        // TreeHeapTest();
        // ArrayHeapTest();
        HeapBenchmark();
    }

    public static void HeapBenchmark() {

        Random rnd = new Random();

        Long minimumIncrement = Long.MAX_VALUE;

        Long minimumDequeue = Long.MAX_VALUE;


        Long minimumArray = Long.MAX_VALUE;

        for (int h = 0; h < 100; h++) {

            TreeHeap heap1 = new TreeHeap();
            TreeHeap heap2 = new TreeHeap();
            Long t0 = System.nanoTime();

            for (int i = 0; i < 1023; i++) {
                int randomInt = rnd.nextInt(10000);
                heap1.enqueue(randomInt);

            }
            for (int i = 0; i < 1023; i++) {
                int randomInt = rnd.nextInt(10, 100);
                heap1.increment(randomInt);
            }

            Long t1 = System.nanoTime() - t0;
            if (minimumIncrement > (t1)) {
                minimumIncrement = (t1);
            }

            t0 = System.nanoTime();
            for (int i = 0; i < 1023; i++) {
                int randomInt = rnd.nextInt(10000);
                heap2.enqueue(randomInt);

            }
            for (int i = 0; i < 1023; i++) {
                int randomInt = rnd.nextInt(10, 100);
                int dequeuedInt = heap2.dequeue();
                heap2.enqueue(dequeuedInt + randomInt);
            }
            t1 = System.nanoTime() - t0;

            if (minimumDequeue > (t1)) {
                minimumDequeue = (t1);
            }

            ArrayHeap heap3 = new ArrayHeap(1023);

            t0 = System.nanoTime();
            for (int i = 0; i < 1023; i++) {
                int randomInt = rnd.nextInt(10000);
                heap3.bubble(randomInt);

            }
            for (int i = 0; i < 1023; i++) {
                int randomInt = rnd.nextInt(10, 100);
                heap3.increment(randomInt);
            }
            t1 = System.nanoTime() - t0;

            if (minimumArray > (t1)) {
                minimumArray = (t1);
            }

        }

        System.out.println("Enqueue and Increment :" + (minimumIncrement) + " ns");

        System.out.println("Enqueue and Dequeue   :" + (minimumDequeue) + " ns");

        System.out.println("Bubble and Increment  :" + (minimumArray) + " ns");
    }

    public static void TreeHeapTest() {
        TreeHeap heap = new TreeHeap();
        for (int i = 0; i < 10; i++) {
            heap.enqueue(i);
        }
        PrintTreeHeap(heap.root, 0);
        heap.increment(2);
        PrintTreeHeap(heap.root, 0);

    }

    public static void ArrayHeapTest() {
        ArrayHeap heap = new ArrayHeap(15);
        for (int i = 0; i < heap.heap.length; i++) {
            heap.bubble(i);
        }

        PrintArrayHeap(heap);

        for (int i = 0; i < heap.heap.length; i++) {
            if (heap.heap[0] != i) {
                System.out.println("Wrong Answer got " + heap.heap[i] + "| Correct:" + i);
            }
            heap.sink();

            PrintArrayHeap(heap);
        }

        PrintArrayHeap(heap);
    }

    public static void PrintArrayHeap(ArrayHeap heap) {
        int array[] = heap.heap;

        int level = 0;
        for (int i = 0; i < heap.currentMaxIndex; i++) {
            for (int j = 0; j < level - 1; j++) {

                System.out.print("  |");
            }
            System.out.println("Position: " + i + "| Value:" + array[i]);
            if (i >= (level)) {
                level += 1;
                level *= 2;

            }
        }
        System.out.println("");
    }

    public static void PrintTreeHeap(TreeHeapNode root, int level) {

        if (root != null) {
            for (int i = 0; i < level; i++) {

                System.out.print("  |");
            }
            System.out.println("Current value : " + root.value + " |Current Size: " + root.subTreeSize);
            if (root.left != null) {
                PrintTreeHeap(root.left, level + 1);
            }
            if (root.right != null) {
                PrintTreeHeap(root.right, level + 1);
            }
            if (level == 0) {
                System.out.println("Complete");
                System.out.println("");
            }
        }

    }
}
