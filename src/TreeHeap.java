public class TreeHeap {

    TreeHeapNode root;
    TreeHeap left, right;

    public class TreeHeapNode {

        public Integer subTreeSize;
        public Integer value;

        public TreeHeapNode(Integer subTreeSize, Integer value) {
            this.subTreeSize = subTreeSize;
            this.value = value;
        }

        public Integer getSubTreeSize() {
            return this.subTreeSize;
        }

        public Integer getValue() {
            return this.value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public void setSubTreeSize(Integer subTreeSize) {
            this.subTreeSize = subTreeSize;
        }

    }

    TreeHeap() {
        this.root = null;
        this.left = this.right = null;
    }

    TreeHeap(TreeHeapNode node) {
        this.root = node;
        this.left = this.right = null;
    }

    void addNode(int value) {

        boolean leftIsSmaller = false;
        if (left.root.getSubTreeSize() <= right.root.getSubTreeSize()) {
            leftIsSmaller = true;
        }
        if (value <= this.root.getValue()) {
            TreeHeapNode newRoot = new TreeHeapNode(this.root.getSubTreeSize() + 1, value);
            TreeHeap newTreeHeap = new TreeHeap(this.root);
            this.root.setSubTreeSize(this.root.getSubTreeSize() - 2);
            if (leftIsSmaller) {
                newTreeHeap.left = left;
                this.left = newTreeHeap;
            } else {
                newTreeHeap.right = right;
                this.right = newTreeHeap;
            }
        } else {
            if (leftIsSmaller) {
                addNodeRecursive(left, value);
            } else {
                addNodeRecursive(right, value);
            }
        }
    }

    void addNodeRecursive(TreeHeap previousHeap, int value) {

    }

    TreeHeapNode removeNode() {

        return this.root;
    }
}