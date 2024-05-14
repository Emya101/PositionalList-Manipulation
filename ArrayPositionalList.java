/**
 * 
 * Emhenya Supreme
 * 
 */
/**
 * The ArrayPositionalList class implements the PositionalList interface and represents a list
 * where elements are stored in an array, and each element is associated with its position in the array.
 *
 * @param <E> The type of elements stored in the ArrayPositionalList.
 */

public class ArrayPositionalList<E> implements PositionalList<E> {
/**
     * The nested ArrPosition class represents a position in the ArrayPositionalList.
     *
     * @param <E> The type of elements stored in the ArrayPositionalList.
     */
	private static class ArrPosition<E> implements Position<E> {

        private int index;
        private E element;

        /**
         * Constructs a new ArrPosition with the specified index and element.
         *
         * @param i The index of the position in the array.
         * @param e The element stored at this position.
         */

        public ArrPosition(int i, E e) {
            index = i;
            element = e;
        }
        /**
         * Returns the element stored at this position.
         *
         * @return The element stored at this position.
         * @throws IllegalStateException if the position is no longer valid.
         */

        public E getElement() throws IllegalStateException {
            if (index == -1) {
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }
        /**
         * Sets the element stored at this position.
         *
         * @param e The new element to be stored at this position.
         */
        public void setElement(E e) {
            element = e;
        }
        /**
         * Returns the index of this position in the array.
         *
         * @return The index of this position in the array.
         */
        public int getIndex() {
            return index;
        }
        /**
         * Sets the index of this position in the array.
         *
         * @param i The new index of this position in the array.
         */
        public void setIndex(int i) {
            index = i;
        }
    }

	public static final int CAPACITY = 16;
    private ArrPosition<E>[] data;
    private int size = 0;
    /**
     * Constructs an ArrayPositionalList with the default capacity.
     */

    public ArrayPositionalList() {
        this(CAPACITY);
    }
     /**
     * Constructs an ArrayPositionalList with the specified capacity.
     *
     * @param capacity The initial capacity of the ArrayPositionalList.
     */
    public ArrayPositionalList(int capacity) {
        data = (ArrPosition<E>[]) new ArrPosition[capacity];
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public ArrPosition<E> validate(Position<E>p){
        if(!(p instanceof ArrPosition)){
            throw new IllegalArgumentException("Invalid position");

        }
        ArrPosition<E> position=(ArrPosition<E>)p;
        if(position.getIndex()==-1){
            throw new IllegalArgumentException("Position is no longer valid");
        }
        return position;
        }

    public Position<E> before (Position<E> p)throws IllegalArgumentException{
        ArrPosition<E> position=validate(p);
        int index=position.getIndex();
        if(index==0||index>=size){
            return null;
        }
        return data[index-1];
    }

    public Position<E> after(Position<E> p)throws IllegalArgumentException{
        ArrPosition<E> position=validate(p);
        int index=position.getIndex();
        if(index<0||index>=size-1){
            return null;
        }
        return data[index+1];
    }

    public Position<E> addAtIndex(int index,E e){
        if(size==data.length){
            throw new IllegalStateException("List is Full");
        
        }
        if(index<0||index>size){
            throw new IllegalArgumentException("Invalid index");

        }
        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
            data[i].setIndex(i+1);
        }
        ArrPosition<E> newPosition=new ArrPosition<>(index,e);
        data[index]=newPosition;
        size++;
        return newPosition;
        
    }
    public Position<E> addFirst(E e){
        return addAtIndex(0,e);
    }

    public Position<E> addLast(E e){
        return addAtIndex(size,e);
    }

    public Position<E> first(){
        if(isEmpty()){
            return null;
        }
        return data[0];
    }

    public Position<E> last(){
        if(isEmpty()){
            return null;
        }
        return data[size-1];
    }

    public E set(Position<E>p,E e)throws IllegalArgumentException{
        ArrPosition<E> position=validate(p);
        E oldValue=position.getElement();
        position.setElement(e);
        return oldValue;
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        ArrPosition<E> position = validate(p);
        E element = position.getElement();
        int index = position.getIndex();
        position.setIndex(-1); 
    
        
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
            data[i].setIndex(i); 
        }
    
        size--;
        return element;
    }
    


    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
       ArrPosition<E> position=validate(p);
       int index=position.getIndex();
       return addAtIndex(index,e);

    }


    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        ArrPosition<E> position=validate(p);
       int index=position.getIndex();
       return addAtIndex(index+1,e);
    }
    /** 
     * Returns a string representation of the ArrayPositionalList.
     *
     * @return A string representation of the ArrayPositionalList.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("[");
            }
            Position<E> position = data[i];
            sb.append(position.getIndex());
            sb.append("] ");
            sb.append(position.getElement());
            sb.append(" ");
        }
        return sb.toString();
    }
}