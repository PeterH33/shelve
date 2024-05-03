// To create an abstration of the double and single linked list nodes, I am simply creating a double linked node, but when it is used as a SLL node, all of the prev nodes will simply remain as null. This is a minor increace in memory useage for a reduction in overall code and reduction of repeated code.
/**
 * Node Class for use in data structures, organizaed to allow for use in
 * multiple structures.
 * 
 * @author Peter Hartnett
 */
public class Node<T> {
    private T value;
    private Node<T> nextNode = null;
    private Node<T> previousNode = null;

    /**
     * Simple initialization with next and prev nodes set to NULL
     * 
     * @param value object to store in the node
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Use this method to init a Doubly linked node, identifying the node before and
     * after
     * 
     * @param value        The value or information of the node
     * @param nextNode
     * @param previousNode
     */
    public Node(T value, Node<T> nextNode, Node<T> previousNode) {
        this.value = value;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
    }

    public Node<T> getNext() {
        return this.nextNode;
    }

    public void setNext(Node<T> node) {
        this.nextNode = node;
    }

    public Node<T> getPreviousNode() {
        return this.previousNode;
    }

    public void setPreviousNode(Node<T> node) {
        this.previousNode = node;
    }

    public String toString() {
        return value.toString();
    }

    // This will let us abstract away getting the id of objects in the system.
    public int getHash() {
        return value.hashCode();
    }

    public T getValue() {
        return value;
    }
}
