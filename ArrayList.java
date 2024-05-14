import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**Emhenya Supreme 
 * The ArrayList class implements the List interface and represents a dynamic array that can grow or shrink in size.
 *
 * @param <E> The type of elements stored in the ArrayList.
 */
public class ArrayList<E> implements List<E> {

    private static final int CAPACITY = 4; // default size
    private E[] data; // internal array to store elements
    private int size = 0; // current size of the ArrayList

    /**
     * Constructs an ArrayList with the default capacity.
     */
    public ArrayList() {
        this(CAPACITY);
    }

    /**
     * Constructs an ArrayList with the specified capacity.
     *
     * @param cap The initial capacity of the ArrayList.
     */
    public ArrayList(int cap) {
        data = (E[]) new Object[cap];
    }

    /**
     * Returns the number of elements in the ArrayList.
     *
     * @return The number of elements in the ArrayList.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the ArrayList is empty.
     *
     * @return true if the ArrayList is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the element at the specified index in the ArrayList.
     *
     * @param i The index of the element to return.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return data[i];
        }
    }

    /**
     * Replaces the element at the specified index in the ArrayList with the specified element.
     *
     * @param i The index of the element to replace.
     * @param e The new element to be stored at the specified index.
     * @return The element previously at the specified position.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public E set(int i, E e) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            E oldValue = data[i];
            data[i] = e;
            return oldValue;
        }
    }

    /**
     * Resizes the internal array to the specified capacity.
     *
     * @param cap The new capacity of the internal array.
     */
    public void resize(int cap) {
        E[] temp = (E[]) new Object[cap];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    /**
     * Inserts the specified element at the specified position in the ArrayList.
     *
     * @param i The index at which the specified element is to be inserted.
     * @param e The element to be inserted.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public void add(int i, E e) {
        if (i > size || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size == data.length) {
            resize(2 * size);
        }
        for (int j = size; j > i; j--) {
            data[j] = data[j - 1];
        }
        data[i] = e;
        size++;
    }

    /**
     * Appends the specified element to the end of the ArrayList.
     *
     * @param e The element to be appended to the end of the ArrayList.
     */
    public void add(E e) {
        if (size == data.length) {
            resize(2 * size);
        }
        data[size] = e;
        size++;
    }

    /**
     * Removes the element at the specified position in the ArrayList.
     *
     * @param i The index of the element to be removed.
     * @return The element that was removed from the ArrayList.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public E remove(int i) {
        if (isEmpty()) {
            return null;
        }

        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size < data.length / 4) {
            resize(data.length / 2);
        }
        E removedElement = data[i];
        for (int j = i; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        data[size - 1] = null;
        size--;
        return removedElement;
    }

    /**
     * Compares this ArrayList with the specified object for equality.
     *
     * @param obj The object to be compared for equality.
     * @return true if the specified object is equal to this ArrayList, false otherwise.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArrayList)) {
            return false;
        }
        ArrayList<E> other = (ArrayList<E>) obj;
        if (this.size != other.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(this.get(i), other.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a string representation of the ArrayList.
     *
     * @return A string representation of the ArrayList.
     */
    public String toString() {
        E[] temp = (E[]) new Object[this.size];
        for (int i = 0; i < size; i++) {
            temp[i] = this.data[i];
        }
        return Arrays.toString(temp);
    }

    /**
     * Iterator implementation for ArrayList.
     */
    private class ArrayIterator implements Iterator<E> {
        private int currentIndex = 0;

        /**
         * Checks if there is a next element in the ArrayList.
         *
         * @return true if there is a next element, false otherwise.
         */
        public boolean hasNext() {
            return currentIndex < size;
        }

        /**
         * Returns the next element in the ArrayList.
         *
         * @return The next element in the ArrayList.
         * @throws NoSuchElementException if there are no more elements to iterate over.
         */
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("no next element");
            }
            E element = data[currentIndex];
            currentIndex++;
            return element;
        }

        /**
         * Removes the last element returned by the iterator.
         *
         * @throws UnsupportedOperationException if the remove operation is not supported.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Returns an iterator over the elements in the ArrayList.
     *
     * @return An iterator over the elements in the ArrayList.
     */
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }
}
