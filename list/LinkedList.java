import java.util.Iterator;

public class LinkedList<T> implements List<T>, Iterable<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = new Node<T>(null, null);
        tail = head;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(T element) {

        if( size == 0) {
            head.setElement(element);
            
        }
        else{
            Node<T> newNode = new Node<T>(element, null);
            tail.setNext(newNode);
            tail = tail.getNext();
            
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        Node<T> current = head;
        int i = 0;
        if ( index == size ) {
            tail.setElement(element);
            
        }
       while (current != null ) { 
            if( i == index){
                current.setElement(element);
                break;
            }
            current = current.getNext();
            i++;
        }
        size++;
    }

    @Override
    public T get(int index) {
        Node<T> current = head;
        int i = 0;
        if (index == size || index == 0) {
            return tail.getElement();
        }

        while (current.getNext() != null ) { 
            if (i == index) {
                return current.getElement();
                
            }
            current = current.getNext();
            i++;
        }
        return null;
        
    }

    @Override
    public T remove(int index) {
        Node<T> previus = null;
        Node<T> current = head;
        int i = 0;
        
        T element = current.getElement();
        while( current != null) {
            if (i == index ) {
                previus.setNext(current.getNext());
            }
            previus = current;
            current = current.getNext();
            i++;
        }
        size--;
        

        return element;
        
    }

    @Override 
    public String toString() {
        Node<T> current = head;
        String str = "[";
        
        while ( current != null){
            str += current.getElement();
            str+=" ";
            current = current.getNext();
        }
        str +="]";
        return str; 
        
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            Node<T> current = head;
            @Override
            public boolean hasNext() {
                return current.getNext() != null;
            }

            @Override
            public T next() {
                if(!hasNext()){
                    try {
                        throw new Exception("no Next");
                    } catch (Exception e) {
                       
                        e.printStackTrace();
                    }
                }
                return current.getNext().getElement();
            }
            
        };
    }

    
}
