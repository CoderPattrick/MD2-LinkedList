public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int numbNode=0;

    public MyLinkedList() {
        head=tail=null;
        numbNode=0;
    }
    public MyLinkedList<E> clone(){
        if(numbNode==0){
            return null;
        }
        else {
            MyLinkedList<E> clone = new MyLinkedList<>();
            Node temp = head;
            for (int i = 0; i < numbNode; i++) {
                clone.add(i,(E)temp.getData());
                temp=temp.next;
            }
            return clone;
        }
    }
    public void addFirst(E e){
        Node newNode = new Node<E>(e);
        newNode.next=head;
        head=newNode;
        numbNode++;
        if(numbNode==1){
            tail=newNode;
        }
    }
    public void addLast(E e){
        if(numbNode==0){
            addFirst(e);
        }else{
            Node newNode = new Node<E>(e);
            tail.next=newNode;
            tail=newNode;
            numbNode++;
        }
    }
    public void add(int index,E e){
        if(index<0){
            return;
        }
        else if(index==0){
            addFirst(e);
        }
        else if(index>=numbNode){
            addLast(e);
        }
        else{
            Node temp = head;
            Node newNode = new Node<E>(e);
            for (int i = 1; i < index; i++) {
                temp=temp.next;
            }
            newNode.next=temp.next.next;
            temp.next=newNode;
            numbNode++;
        }
    }
    public E remove(int index){
        if(index<0||numbNode==0){
            return null;
        }
        else if(index>=numbNode-1){
            return removeLast();
        }
        else if(index==0){
            return removeFirst();
        }
        else {
            Node temp = head;
            for (int i = 1; i < index ; i++) {
                temp=temp.next;
            }
            Node view=temp.next;
            temp.next=view.next;
            view.next=null;
            numbNode--;
            return (E) view.getData();
        }
    }

    public E removeLast() {
        if(numbNode==0){
            return null;
        }
        else if(numbNode==1){
            return removeFirst();
        }
        else {
            Node temp = head;
            for (int i = 1; i < numbNode-1; i++) {
                temp=temp.next;
            }
            Node view = tail;
            temp.next=null;
            tail=temp;
            numbNode--;
            return (E) view.getData();
        }
    }

    public E removeFirst() {
        if(numbNode==0){
            return null;
        }
        else if(numbNode==1){
            Node view = head;
            head=tail=null;
            numbNode--;
            return (E) view.getData();
        }
        else {
            Node view = head;
            head = head.next;
            view.next=null;
            numbNode--;
            return (E) view.getData();
        }
    }
    public boolean remove(Object e){
        Node temp = head;
        for (int i = 0; i < numbNode; i++) {
            if(((E)temp.getData()).equals(e)){
                remove(i);
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public int size(){
        return numbNode;
    }
    public boolean contains(E o){
        Node temp = head;
        for (int i = 0; i < numbNode; i++) {
            if(((E)temp.getData()).equals(o)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public int indexOf(E o){
        Node temp = head;
        for (int i = 0; i < numbNode; i++) {
            if(((E)temp.getData()).equals(o)){
                return i;
            }
            temp=temp.next;
        }
        return -1;
    }
    public void ensureCapacity(int amount){
        numbNode+=amount;
    }

    public E get(int index) {
        if(index<0||index>=numbNode){
            return null;
        }
        Node result = head;
        for (int i = 0; i < index; i++) {
            result=result.next;
        }
        return (E)result.getData();
    }

    public E getFirst() {
        return (E)head.getData();
    }
    public E getLast() {
        return (E)tail.getData();
    }
    public void clear(){
        head=tail=null;
        numbNode=0;
    }
    public void printList(){

    }
}
