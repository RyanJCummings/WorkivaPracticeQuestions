public class Node {
    private int value;
    private Node next;
    private boolean first = false;

    public Node(int value) {
        this.value = value;
    }

    public Node getNode(int value) {
        if (value == this.value) {
            return this;
        }
        else return null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public boolean getFirst() {
        return first;
    }

    public void setValue(int newValue) {
        this.value = newValue;
    }

    public void setNext(Node newNext) {
        this.next = newNext;
    }

    public void setFirst(boolean newFirst) {
        this.first = newFirst;
    }


}
