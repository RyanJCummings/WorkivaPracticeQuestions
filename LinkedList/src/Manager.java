import javax.annotation.processing.SupportedSourceVersion;

public class Manager {

    //Class maintains a reference to the first node in the linked list
    private Node firstNode = null;

    public void addNodeFirst(int value) {
        Node node = new Node(value);
        node.setFirst(true);
        if (isEmpty()) {
            node.setNext(null);
            this.firstNode = node;
        } else {
            node.setNext(firstNode);
            firstNode.setFirst(false);
            firstNode = node;
        }
    }

    public void addNodeLast(int value) {
        //Node node = new Node(value);
        if (isEmpty()) {
            addNodeFirst(value);
        } else {
            Node node = new Node(value);
            Node prev = iterateList(null);
            prev.setNext(node);
            node.setNext(null);
        }
    }

    public void addNodeMiddle(int prev, int value) {

        Node temp = iterateList(prev).getNext();
        if (isEmpty()) {
            addNodeFirst(value);
        } else {
            Node node = new Node(value);
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
    }

    /**
     * Deletes a node from the list
     * @param value     integer value of the node to be deleted
     */
    public void deleteNode(int value) {
        System.out.println("Deleted Node " + value);
        Node temp = iterateList(value).getNext();
        if (temp.getFirst()) {
            temp.getNext().setFirst(true);
            temp.setNext(null);
        } else {
            temp = iterateList(value);
            temp.setNext(temp.getNext().getNext());
            temp.setNext(null);
        }
    }

    /**
     * Helper function to check if list is empty
     * @return  returns a corresponding boolean
     */
    public boolean isEmpty() {
        return firstNode == null;
    }

    /**
     * A helper function to iterate through linked list
     * @param stopNode     The node to match
     * @return             Returns the node prior to the matching the stop value
     */
    public Node iterateList(Node stopNode) {
        Node iteratorNode = firstNode;
        while (iteratorNode.getNext() != stopNode) {
            iteratorNode = iteratorNode.getNext();
        }
        return iteratorNode;
    }

    /**
     * Overloaded iteratorList method that takes an integer instead of a node
     * @param stopValue     Integer value contained in the stop node
     * @return              Returns the node previous to the node containing the stop value
     */
    public Node iterateList(int stopValue) {
        Node iteratorNode = firstNode;
        while (iteratorNode.getNext().getValue() != stopValue) {
            iteratorNode = iteratorNode.getNext();
        }
        return iteratorNode;
    }

    /**
     * Prints the linked list
     */
    public void printList() {
        Node current = firstNode;
        int i = 0;

        while(current.getNext() != null) {
            // Print list
            System.out.println(current.getValue());
            current = current.getNext();
            i++;
        }
        // Print last node
        System.out.println(current.getValue());
    }

    public static void main (String[] Args) {
        Manager list = new Manager();
        // Add initial node
        list.addNodeFirst(1);
        list.addNodeLast(2);
        //list.addNodeMiddle(1, 3);
        list.printList();
        list.deleteNode(2);
        list.printList();
    }
}
