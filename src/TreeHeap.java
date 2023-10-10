public class TreeHeap {

    TreeHeapNode root;

    TreeHeap() {
        this.root = null;
    }

    TreeHeap(TreeHeapNode node) {
        this.root = node;
    }

    public void enqueue(int value) {
        if (root == null) {
            root = new TreeHeapNode(0, value);
        } else {
            root.add(value);
        }
    }

    public int dequeue() {

        if (root==null) {
            return null;
        }

        return this.root.getValue();
    }

}