public class Node<E> {
    Node next;
    E data;
    public Node(E data){
        this.data = data;
    }

    public E getData() {
        return data;
    }
}
