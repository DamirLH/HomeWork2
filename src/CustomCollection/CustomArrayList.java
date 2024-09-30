package CustomCollection;


import java.util.Arrays;
import java.util.Collection;

public class CustomArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayList(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldValue = get(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return oldValue;
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacity(size + numNew);
        System.arraycopy(a, 0, elements, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public int size() {
        return size;
    }

    public static <T extends Comparable<? super T>> void bubbleSort(CustomArrayList<T> list) {
        boolean sorted;
        for (int i = 0; i < list.size() - 1; i++) {
            sorted = true;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        elements[index] = element;
    }

    @Override
    public String toString(){
        if (size == 0){
            return "[]";
        }

        StringBuilder temp = new StringBuilder();
        temp.append("[");
        for (int i=0;i<size;i++){
            temp.append(elements[i]);
            if (i<size-1) {
                temp.append(", ");
            }
        }
        temp.append("]");
        return temp.toString();
    }

}

