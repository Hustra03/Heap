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

        TreeHeapNode newNode=new TreeHeapNode(0, value);
        TreeHeap currentHeap = this;
        
        while (true) {

            if (newNode.getValue()<currentHeap.root.getValue()) {
                
            }
            boolean leftIsSmaller = false;
            if (left.root.getSubTreeSize() <= right.root.getSubTreeSize()) {
                leftIsSmaller = true;
            }
        }
    }

    TreeHeapNode removeNode() {

        return this.root;
    }
}