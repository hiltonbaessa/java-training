public class ArrayList<T> implements List<T>{
    
    private T[] list;
    private int initialSize;
    private int currentSize;
    


    public ArrayList(int initialSize){
        this.initialSize = initialSize;
        this.list = (T[]) new Object[initialSize];
        this.currentSize = 0;
    }

    public ArrayList(){
        this(10);
    }

    @Override
    public int size(){
        return currentSize;   
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public void add(T element) {
        add(currentSize, element);
    }

    @Override
    public void add(int index, T element) {
        if(currentSize == initialSize) {
            list = resizeList(list, 2*initialSize);

        }

        if( index < 0 || index > currentSize){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if ( index == currentSize) {
            currentSize++;
        }
        this.list[index] = element;
        
    }

    @Override
    public T get(int index) {
        if( index < 0 || index >= currentSize){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return this.list[index];
    }

    @Override
    public T remove(int index) {
        if( index < 0 || index >= currentSize){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        T element = list[index];
        for(int i = index; i<currentSize -1; i++ ) {
            list[i]=list[i+1];
        }
        currentSize--;
        return element;

        
    }

    private T[] resizeList(T[] target, int size) {
        
        T[] newList = (T[]) new Object[size];
        
        
        if (size <= initialSize) {
            return newList;
        }
        
        for ( int i = 0; i < initialSize; i++) {
            newList[i] = target[i];
        }
        return newList;
    }

    @Override 
    public String toString() {
        String str = "[ ";
        
        for(int i = 0; i< currentSize; i++){
            str += list[i];
            str+=" ";
        }
        str +=" ]";
        return str; 
        
    }

    




    



    
}
