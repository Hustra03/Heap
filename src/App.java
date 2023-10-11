public class App {
    public static void main(String[] args) throws Exception {
        //TreeHeapTest();
        ArrayHeapTest();
    }

    public static void TreeHeapTest() {
        TreeHeap heap = new TreeHeap();
        for (int i = 0; i < 10; i++) {
            heap.enqueue(i);
        }
        PrintTreeHeap(heap.root, 0);
        System.out.println( "Level : "+heap.increment(3));
        PrintTreeHeap(heap.root, 0);

    }

    public static void ArrayHeapTest()
    {
        ArrayHeap heap = new ArrayHeap(15);
        for (int i = 0; i < heap.heap.length; i++) {
            heap.bubble(i);
        }

        PrintArrayHeap(heap);
        
        for (int i = 0; i < heap.heap.length-3; i++) {
            if (heap.heap[0]!=i) {
                System.out.println("Wrong Answer got "+heap.heap[i]+ "| Correct:"+i );
            }
            heap.sink();
        } 

        PrintArrayHeap(heap);
    }

    public static void PrintArrayHeap(ArrayHeap heap)
    {
        int array[]=heap.heap;

        int level = 0;
        for (int i = 0; i < heap.currentMaxIndex; i++) {
            for (int j = 0; j < level-1; j++) {

                System.out.print("  |");
            }
            System.out.println("Position: "+i+"| Value:"+ array[i]);
            if (i>=(level)) {
                level+=1;
                level*=2;
                
            }
        }
        System.out.println("");
    }

    public static void PrintTreeHeap(TreeHeapNode root, int level) {

        if (root != null) {
            for (int i = 0; i < level; i++) {

                System.out.print("  |");
            }
            System.out.println("Current value :" + root.value + "| Current Size: "+ root.subTreeSize);
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
