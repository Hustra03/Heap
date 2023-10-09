public class LinearRemoveNHeap {

    public class Node {
        int head;
        Node previousNode;
        Node tail;

        Node(int val, Node tl, Node prvNode) {
            head = val;
            tail = tl;
            previousNode = prvNode;
        }

        public int getHead() {
            return this.head;
        }

        public Node getTail() {
            return this.tail;
        }

        public Node getPreviousNode() {
            return this.previousNode;
        }

        public void setTail(Node newTail) {
            this.tail = newTail;
        }

        public void setHead(int newHead) {
            this.head = newHead;
        }

        public void setPreviousNode(Node newprvNode) {
            this.previousNode = newprvNode;
        }
    }

    Node first;

    public LinearRemoveNHeap() {
        this.first = null;
    }

    public Node getFirstCell() {
        return this.first;
    }

    public void setFirstCell(Node NewFirstCell) {
        this.first = NewFirstCell;
    }

    void add(Node newFirstCell) {
        newFirstCell.setTail(this.first);
        this.first = newFirstCell;
    }

    Node remove() {

        Node returnNode = null;
        Node nxt = this.first;
        while (nxt != null) {
            if (returnNode == null || nxt.getHead() < returnNode.getHead()) {
                returnNode = nxt;
            }
            nxt = nxt.tail;
        }
        if (returnNode != null) {
            returnNode.getPreviousNode().setTail(returnNode.getTail());
            returnNode.getTail().setPreviousNode(returnNode.getPreviousNode());
        }
        return returnNode;
    }

}
