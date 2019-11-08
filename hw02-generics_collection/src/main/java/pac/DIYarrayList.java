package pac;

import java.util.*;

public class DIYarrayList<T> implements List<T> {
    private static final Object [] EMPTY =new Object [] {};
    private Object[] arr;
    private int size;


    public DIYarrayList(){
        arr=EMPTY;
    }

    public DIYarrayList (int capacity){
        if(capacity>0)
            arr=new Object [capacity];
        else if(capacity==0)
            arr=EMPTY;
        else
            throw new IllegalArgumentException("Illegal Capacity"+capacity);
    }

    public DIYarrayList(Collection<? extends T> e){
        arr=e.toArray();
        if ((size = arr.length) != 0) {
            if (arr.getClass() != Object[].class)
                arr = Arrays.copyOf(arr, size, Object[].class);
        } else {
            // replace with empty array.
            this.arr = EMPTY;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean add(T e) {
        if(size==arr.length) {
            if(size==0)
                arr = Arrays.copyOf(arr, 10);
            else
                arr = Arrays.copyOf(arr, size + (size>>1));
        }
        arr[size++]=e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object [] a=c.toArray();
        arr=Arrays.copyOf(arr,size+c.size());
        System.arraycopy(a, 0, arr, size,c.size());
        size+=c.size();
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) arr[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        T oldElement=(T) arr[index];
        arr[index]=element;
        return oldElement;
    }

    void checkIndex(int index){
        if((index>=size)||(index<0))
            throw new IndexOutOfBoundsException();
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListItr (0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private class Itr implements Iterator<T> {
        int cursor;
        int lastRet = -1;

        Itr() {}

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public T next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = DIYarrayList.this.arr;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (T) elementData[lastRet = i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }


    }

    private class ListItr extends Itr implements ListIterator<T> {
        ListItr(int index) {
            super();
            cursor = index;
        }

        public boolean hasPrevious() {
            throw new UnsupportedOperationException();
        }

        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @SuppressWarnings("unchecked")
        public T previous() {
            throw new UnsupportedOperationException();
        }

        public void set(T e) {
            if (lastRet < 0)
                throw new IllegalStateException();

            try {
                DIYarrayList.this.set(lastRet, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(T e) {
            throw new UnsupportedOperationException();
        }
    }
}