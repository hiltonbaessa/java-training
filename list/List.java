public interface List<T> {


    int size();
    boolean isEmpty();
    void add(T element); //add the element at the end of the list
    void add(int index, T element); // Add the element at the index position
    T get(int index); //
    T remove(int index);
    

}