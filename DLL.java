public class DLL<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    // private int size = 0;

    // public boolean isEmpty() {
    // return size == 0;
    // }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    // public int getSize() {
    // return this.size;
    // }

    /**
     * Create a node, Add the input object to the node, and add node as to DLL as
     * tail
     * 
     * @param input object of type T stored in this list
     */
    public void add(T input) {
        Node<T> node = new Node<T>(input);
        // O(1) appending node
        // if (size == 0) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPreviousNode(tail);
            tail = node;
        }
        // size++;
    }

    /**
     * Add a node to the list
     * 
     * @param node
     */
    public void addNode(Node<T> node) {
        // if (size == 0) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPreviousNode(tail);
            tail = node;
        }
        // size++;
    }

    public void removeNode(Node<T> node) {
        // if list empty, do nothing
        if (head == null || node == null) {
            return;
        }
        // if node is only one in list
        if (head == node) {
            head = node.getNext();
        }
        if (node.getNext() != null) {
            node.getNext().setPreviousNode(node.getPreviousNode());
        }
        if (node.getPreviousNode() != null) {
            node.getPreviousNode().setNext(node.getNext());
        }
    }

    public void printAll() {
        if (head == null) {
            return;
        }
        Node<T> tempNode = head;
        while (tempNode != null) {
            // for (int i = 0; i < size; i++) {
            System.out.print(tempNode.toString() + ", ");
            tempNode = tempNode.getNext();
        }
        System.out.println("");
    }

    /**
     * Sort this List in place using merge sort
     */
    public void sort() {
        head = mergeSort(head);
    }

    public Node<T> findNode(Node<T> node) {
        // TODO this needs to be able to specify how we search for a node to retrieve it
        // Then perform binary search
        throw new UnsupportedOperationException("Unimplemented method 'findNode'");
    }

    /**
     * Join this DLL with otherDLL in place adding other to the end of this DLL
     * 
     * @param otherDll
     */
    public void joinWith(DLL<T> otherDll) {
        if (otherDll.head == null) {
            // System.out.println("if");
            // do nothing, no join to occur
        } else if (head == null) {
            // System.out.println("else if");
            // set the this head and tail to be otherDLL and then clear other
            head = otherDll.head;
            tail = otherDll.tail;
            otherDll.head = null;
            otherDll.tail = null;
            // size += otherDll.size;
        } else {
            // join this.tail to other.head
            tail.setNext(otherDll.getHead());
            otherDll.head.setPreviousNode(tail);
            // redefine the tail to be for this and other to null
            tail = otherDll.tail;
            // size += otherDll.size;
            otherDll.tail = null;
            otherDll.head = null;
            // otherDll.size = 0;
        }
    }

    // *************************************** */
    // Merge sort methods here
    private Node<T> split(Node<T> head) {
        Node<T> fast = head, slow = head;
        while (fast.getNext() != null
                && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        Node<T> temp = slow.getNext();
        slow.setNext(null);
        return temp;
    }

    private Node<T> mergeSort(Node<T> node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        Node<T> second = split(node);

        // Recur for left and right halves
        node = mergeSort(node);
        second = mergeSort(second);

        // Merge the two sorted halves
        return merge(node, second);
    }

    // Function to merge two linked lists
    private Node<T> merge(Node<T> first, Node<T> second) {
        // If first linked list is empty
        if (first == null) {
            return second;
        }

        // If second linked list is empty
        if (second == null) {
            return first;
        }

        // Pick the smaller value
        // TODO: right here is where the comparator interface probly needs to go, I am
        // going to test first with a simple string comparison
        if (first.toString().compareTo(second.toString()) < 0) {
            first.setNext(merge(first.getNext(), second));
            first.getNext().setPreviousNode(first);
            first.setPreviousNode(null);
            return first;
        } else {
            second.setNext(merge(first, second.getNext()));
            second.getNext().setPreviousNode(second);
            second.setPreviousNode(null);
            return second;
        }
    }

}
