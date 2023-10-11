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

    public int incrementNode(int level) {

        TreeHeapNode currentNode = this;

        if (currentNode.left != currentNode.right) {

            if (currentNode.left != null) {
                if (currentNode.left.getValue() < this.value && (currentNode.right == null
                        || currentNode.right.getSubTreeSize() >= currentNode.left.getSubTreeSize())) {
                    level += 1;
                    int temp = currentNode.left.value;
                    currentNode.left.setValue(currentNode.getValue());
                    currentNode.setValue(temp);// Swaps values of current Node and current Node left node
                    level = currentNode.left.incrementNode(level);
                }
            } else {
                if (currentNode.right.getValue() < this.value) {// We do not need the same additional conditions since
                                                                // that
                                                                // is to check if the other branch is smaller, if we
                                                                // reach
                                                                // here the other branch is null or is longer
                    level += 1;
                    int temp = currentNode.right.value;
                    currentNode.right.setValue(currentNode.getValue());
                    currentNode.setValue(temp);// Swaps values of current Node and current Node left node
                    level = currentNode.right.incrementNode(level);
                }
            }
        }

        return level;
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
