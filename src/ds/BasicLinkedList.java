package ds;

public class BasicLinkedList<X> {

    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList() {
        first = null;
        last = null;
        nodeCount = 0;
    }

    public int size() {
        return nodeCount;

    }

    // add at front
    public void add(X item) {
        if (first == null) {
            first = new Node(item);
            last = first;
        } else {
            // grab the last node and updae its value
            Node newLastNode = new Node(item);
            last.setNextNode(newLastNode);
            last = newLastNode;
        }
        nodeCount++;
    }

    public void insert(X item, int position) {
        if (size() < position) {
            throw new IllegalStateException("The LinkedList is smaller than the position you are given");
        }

        Node currentNode = first;

        // start at 1 beacuse we are already on the first node
        for (int i = 1; i < position && currentNode != null; i++) {
            currentNode = currentNode.getNextNode();
        }

        // severs the link chain and reconnects with the new node
        Node newNode = new Node(item);
        Node nextNode = currentNode.getNextNode();
        currentNode.setNextNode(nextNode);
        newNode.setNextNode(nextNode);
        nodeCount++;
    }

    public X removeAt(int position) {
        if (first == null) {
            throw new IllegalStateException("The linkedList is empty and there are no items to remove");
        }

        Node currentNode = first;
        Node prevNode = first;

        // start at 1 because we are already on the first node
        for (int i = 1; i < position && currentNode != null; i++) {
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        // update the poiners and throw away the old first
        X nodeItem = currentNode.getNodeItem();
        prevNode.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return nodeItem;
    }

    // add at back
    public X remove() {
        if (first == null) {
            throw new IllegalStateException("The LinkedList is empty");
        }

        X nodeItem = first.getNodeItem();

        // now update the first pointer and throw away the old first
        first = first.getNextNode();
        nodeCount--;
        return nodeItem;
    }

    public X get(int position) {
        if (first == null) {
            throw new IllegalStateException("The LinkedList is empty and there are no items to get");
        }

        Node currentNode = first;
        for (int i = 1; i < size() && currentNode != null; i++) {
            if (i == position) {
                return currentNode.getNodeItem();
            }
            currentNode = currentNode.getNextNode();
        }

        // if we didn't find it
        return null;
    }

    public int find(X item) {
        if (first == null) {
            throw new IllegalStateException("The LinkedList is empty and there are no items to find");
        }

        Node currentNode = first;
        for (int i = 1; i < size() && currentNode != null; i++) {
            if (currentNode.getNodeItem().equals(item)) {

                return i;
            }

            currentNode = currentNode.getNextNode();
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuffer contents = new StringBuffer();
        Node currNode = first;

        while (currNode != null) {
            contents.append(currNode.getNodeItem());
            currNode = currNode.getNextNode();

            if (currNode != null) {
                contents.append(", ");
            }
        }
        return contents.toString();
    }

    public class Node {
        private Node nextNode;
        private X nodeItem;

        public Node(X item) {
            this.nextNode = null;
            this.nodeItem = item;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public X getNodeItem() {
            return nodeItem;
        }
    }
}
