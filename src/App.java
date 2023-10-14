import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        // TreeHeapTest();
        // ArrayHeapTest();
        HeapBenchmark();
        //HeapIncrementDepthBenchmark();
    }

    public static void HeapBenchmark() {

        Random rnd = new Random();

        int randomArrayLength[] = { 64, 128, 256, 512, 1024, 2048 };

        int incrementTimes = 1000;
        int randomIncrementValue[] = new int[incrementTimes];

        for (int f : randomArrayLength) {

            Long minimumIncrement = Long.MAX_VALUE;
            Long minimumDequeue = Long.MAX_VALUE;

            Long minimumArrayDequeue = Long.MAX_VALUE;
            Long minimumArrayIncrement = Long.MAX_VALUE;

            int randomStartingValue[] = new int[f];

            for (int h = 0; h < 250; h++) {

                TreeHeap heap1 = new TreeHeap();
                TreeHeap heap2 = new TreeHeap();

                for (int i = 0; i < f; i++) {
                    randomStartingValue[i] = rnd.nextInt(10000);

                }
                for (int i = 0; i < incrementTimes; i++) {
                    randomIncrementValue[i] = rnd.nextInt(10, 100);
                }

                Long t0 = System.nanoTime();

                for (int i = 0; i < f; i++) {
                    int randomInt = randomStartingValue[i];
                    heap1.enqueue(randomInt);
                }
                for (int i = 0; i < incrementTimes; i++) {
                    int randomInt = randomIncrementValue[i];
                    heap1.increment(randomInt);
                }

                Long t1 = System.nanoTime() - t0;
                if (minimumIncrement > (t1)) {
                    minimumIncrement = (t1);
                }

                t0 = System.nanoTime();
                for (int i = 0; i < f; i++) {
                    int randomInt = randomStartingValue[i];
                    heap2.enqueue(randomInt);

                }
                for (int i = 0; i < incrementTimes; i++) {
                    int randomInt = randomIncrementValue[i];
                    int dequeuedInt = heap2.dequeue();
                    heap2.enqueue(dequeuedInt + randomInt);
                }
                t1 = System.nanoTime() - t0;

                if (minimumDequeue > (t1)) {
                    minimumDequeue = (t1);
                }

                ArrayHeap heap3 = new ArrayHeap(f);

                ArrayHeap heap4 = new ArrayHeap(f);

                t0 = System.nanoTime();
                for (int i = 0; i < f; i++) {
                    int randomInt = randomStartingValue[i];
                    heap3.bubble(randomInt);

                }
                for (int i = 0; i < incrementTimes; i++) {
                    int randomInt = randomIncrementValue[i];
                    int dequeuedInt = heap3.sink();
                    heap3.bubble(dequeuedInt + randomInt);
                }
                t1 = System.nanoTime() - t0;

                if (minimumArrayDequeue > (t1)) {
                    minimumArrayDequeue = (t1);
                }

                t0 = System.nanoTime();
                for (int i = 0; i < f; i++) {
                    int randomInt = randomStartingValue[i];
                    heap4.bubble(randomInt);

                }
                for (int i = 0; i < incrementTimes; i++) {
                    int randomInt = randomIncrementValue[i];
                    heap4.increment(randomInt);
                }
                t1 = System.nanoTime() - t0;

                if (minimumArrayIncrement > (t1)) {
                    minimumArrayIncrement = (t1);
                }

            }

            System.out.println("Size :" + f);

            System.out.println("Enqueue and Increment : " + (minimumIncrement) + " ns");

            System.out.println("Enqueue and Dequeue   : " + (minimumDequeue) + " ns");

            System.out.println("Bubble and Dequeue    : " + (minimumArrayIncrement) + " ns");

            System.out.println("Bubble and Increment  : " + (minimumArrayDequeue) + " ns");

            System.out.println("_________________________");
        }
    }

    public static void HeapIncrementDepthBenchmark() {
        Random rnd = new Random();
        int randomArrayLength = 1000;
        int incrementTimes = 5000;

        TreeHeap heap1 = new TreeHeap();
        ArrayHeap heap4 = new ArrayHeap(randomArrayLength);

        int randomStartingValue[] = new int[randomArrayLength];
        int randomIncrementValue[] = new int[incrementTimes];

        int binaryTreeDepth[] = new int[incrementTimes];
        int arrayDepth[] = new int[incrementTimes];

        for (int i = 0; i < randomArrayLength; i++) {
            randomStartingValue[i] = rnd.nextInt(10000);
        }

        for (int i = 0; i < incrementTimes; i++) {
            randomIncrementValue[i] = rnd.nextInt(10, 100);
        }

        for (int i = 0; i < randomArrayLength; i++) {
            int randomInt = randomStartingValue[i];
            heap1.enqueue(randomInt);

        }
        for (int i = 0; i < incrementTimes; i++) {
            int randomInt = randomIncrementValue[i];
            binaryTreeDepth[i] = heap1.increment(randomInt);
        }

        for (int i = 0; i < randomArrayLength; i++) {
            int randomInt = randomStartingValue[i];
            heap4.bubble(randomInt);

        }
        for (int i = 0; i < incrementTimes; i++) {
            int randomInt = randomIncrementValue[i];
            arrayDepth[i] = heap4.increment(randomInt);
        }

        System.out.print("Linked List : {");
        for (int i = 0; i < binaryTreeDepth.length; i++) {
            System.out.print(binaryTreeDepth[i] + ", ");
        }

        System.out.print("}");
        System.out.println("");

        System.out.print("Array : {");
        for (int i = 0; i < arrayDepth.length; i++) {
            System.out.print(arrayDepth[i] + ", ");
        }

        System.out.print("}");
        System.out.println("");
    }

    public static void TreeHeapTest() {

        TreeHeap heap = new TreeHeap();
        for (int i = 0; i < 10; i++) {
            heap.enqueue(i);
        }
        PrintTreeHeap(heap.root, 0);
        heap.increment(0);
        PrintTreeHeap(heap.root, 0);

    }

    public static void ArrayHeapTest() {
        ArrayHeap heap = new ArrayHeap(15);
        for (int i = 0; i < heap.heap.length; i++) {
            heap.bubble(i);
        }

        PrintArrayHeap(heap);

        // heap.increment(6);

        PrintArrayHeap(heap);
        int sinkAmount = 0;
        int resultArray[] = new int[15];
        for (int i = 0; i < sinkAmount; i++) {
            resultArray[i] = heap.sink();
        }

        heap.increment(5);

        PrintArrayHeap(heap);
        for (int i = 0; i < resultArray.length - heap.currentMaxIndex; i++) {
            System.out.println("Position :" + i + " Value: " + resultArray[i]);
        }
        System.out.println(heap.currentMaxIndex);

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

        for (int i = heap.currentMaxIndex; i < array.length; i++) {

            System.out.println("Unfilled Positions: " + i + "| Value:" + array[i]);
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
