public class MyLinkedList<E> {
    Node<E> head;
    int numbNode=0;

    public MyLinkedList() {
    }
    public void addFirst(E e){
        Node newNode = new Node<E>(e);
        newNode.next=head;
        head=newNode;
        numbNode++;
    }
    public void addLast(E e){
        if(numbNode==0){
            addFirst(e);
        }else{
            Node newNode = new Node<E>(e);

        }
    }
}
