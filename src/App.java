public class App {
    public static void main(String[] args) throws Exception {
        TreeHeapTest();
    }

    public static void TreeHeapTest() {
        TreeHeap heap = new TreeHeap();
        for (int i = 0; i < 10; i++) {
            heap.enqueue(i);
        }
        PrintTreeHeap(heap.root, 0);

    }

    public static void PrintTreeHeap(TreeHeapNode root, int level) {

        if (root != null) {
            for (int i = 0; i < level; i++) {

                System.out.print("  |");
            }
            System.out.println("Current value :" + root.value);
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
