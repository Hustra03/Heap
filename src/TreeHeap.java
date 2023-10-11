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

        if (root == null) {
            return -1;
        }
        if (root.left == null || root.right == null) {
            if (root.left == null) {
                TreeHeapNode temp = root;
                root = root.right;
                return temp.getValue();
            } else {

                TreeHeapNode temp = root;
                root = root.left;
                return temp.getValue();
            }
        } else {
            return root.remove().value;
        }
    }

    public int increment(int incrementAmount) {
        int level = 0;

        if (root != null) {
            root.setValue(root.getValue() + incrementAmount);
            level = root.incrementNode(level);
        }

        return level;
    }

}