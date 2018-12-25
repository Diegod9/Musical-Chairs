
//Diego Delgado

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LoopList<E> implements Iterable {

    //Keeps track of where we are in the LoopList
    int position = 0;

    Node<E> current;
    private Node<E> head = null;
    int size;

    //LoopList constructor
    LoopList() {
        current = null;
        size = 0;


    }


    //Adds a new element at the current position
    //The newly added element becomes the current
    public void add(E item) {

        if(size == 0){
            position = (position + 1);
            current = new Node<E>(item);
            current.next = current;


        }else{
            position = (position + 1) % size;
            Node temp;
            temp = new Node<E>(item);

            temp.next = current.next;
        }
        size++;


    }

    //Gets position of Node
    public int get() {
        if (size == 0) {
            System.out.println("No node to get");
            return 0;
        } else {
            return position;
        }
    }

    //Returns the number of elements in the LoopList
    public int size() {

        return size;
    }

    public Iterator<E> iterator() {
        return new LoopListIterator();

    }

    //Start of Node private inner class
    private class Node<E>{

        E data;
        Node next;

        //Node constructor
        public Node(E item){
            next = null;
            data = item;
        }

    }

    public class LoopListIterator implements Iterator{

        Node<E> next;
        Node<E> previous;
        boolean nextCalled;

        //LoopListIterator constructor
        public LoopListIterator(){
            next = current;
            previous = null;
            nextCalled = true;

        }

        //Checking if there is a next element
        public boolean hasNext() {
            while (size != 0) {
                return true;
            }
            return false;

        }


        //Gets the next element
        public E next() {
            if (hasNext() == false) {
                throw new NoSuchElementException();
            } else {
                position = (position + 1) % size;
                current = current.next;
                return current.data;

            }
        }

        //Removes the Node from the list
        public void remove(){

             if (!nextCalled) {
                 throw new IllegalStateException();
             }

                else if (size == 1){
                     current = null;
                     size--;

                 }
                 Node<E>tempNode;
                 tempNode = current;
                 if(current == previous){
                     current = tempNode;

                 }
                 current.next.next = tempNode.next;

             }

        }
    }