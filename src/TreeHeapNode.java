public class TreeHeapNode {

    public Integer subTreeSize;
    public Integer value;

    TreeHeapNode left, right;

    public TreeHeapNode(Integer subTreeSize, Integer value) {
        this.subTreeSize = subTreeSize;
        this.value = value;
        this.subTreeSize = 1;
    }

    public void add(int value) {
        TreeHeapNode currentNode = this;
        subTreeSize += 1;
        if (currentNode.getValue() > value) {
            int temp = value;
            value = currentNode.getValue();
            currentNode.setValue(temp);// Swaps values of newNode and currentHeap
        }
        if (currentNode.right == null) {
            currentNode.right = new TreeHeapNode(subTreeSize, value);
        } else {
            if (currentNode.left == null) {
                currentNode.left = new TreeHeapNode(subTreeSize, value);
            } else {
                if (currentNode.right.subTreeSize < currentNode.left.subTreeSize) {
                    TreeHeapNode tmp = left;
                    right.add(value);
                    left = right;
                    right = tmp;
                } else {
                    TreeHeapNode tmp = right;
                    left.add(value);
                    right = left;
                    left = tmp;
                }
            }
        }

    }

    public TreeHeapNode remove() {
        subTreeSize -= 1;
        if (this.right == null) {
            return left;
        } else {
            if (left == null) {
                return right;
            } else {
                if (left.getValue() < right.getValue()) {
                    value = left.value;
                    left = left.remove();

                } else {
                    value = right.value;
                    right = right.remove();
                }
                return this;
            }
        }
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
