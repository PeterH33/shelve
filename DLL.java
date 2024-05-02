public class DLL<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    public int getSize() {
        return this.size;
    }

    /**
     * Add the input object to the list as the tail
     * @param input object of type T stored in this list
     */
    public void add(T input) {
        Node<T> node = new Node<T>(input);
        //O(1) appending node
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPreviousNode(tail);
            tail = node;
        }
        size++;
    }

    public void sort(){
        // TODO implement merge-Sort here
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
    }

    public Node<T> findNode(Node<T> node){
        // TODO this needs to be able to specify how we search for a node to retrieve it
        //Then perform binary search
        throw new UnsupportedOperationException("Unimplemented method 'findNode'");
    }
}
