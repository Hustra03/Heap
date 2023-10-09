public class LinearAddNHeap {
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

    public LinearAddNHeap() {
        this.first = null;
    }

    public Node getFirstCell() {
        return this.first;
    }

    public void setFirstCell(Node NewFirstCell) {
        this.first = NewFirstCell;
    }

    void add(Node newFirstCell) {
        Node nxt = this.first;
        while (nxt != null) {
            if (nxt.getHead() > newFirstCell.getHead()) {//If the current nxt is larger than new node, aka new node should be placed before. 
                newFirstCell.setTail(nxt);
                nxt.previousNode.setTail(newFirstCell);
                break;
            }
            nxt = nxt.tail;
        }
        if (nxt==null && nxt.previousNode!=newFirstCell) {//Only if this was not added in the list after nxt is null
            nxt.setTail(newFirstCell);
            newFirstCell.setPreviousNode(nxt);
        }
    }

    Node remove() {

        Node returnNode = this.first;
        this.first = this.first.tail;
        return returnNode;
    }
}
