package ru.otus.homeworks.diylist;

import java.util.*;
public class DIYarrayList<T> implements List<T> {
    private static final Object[] ARRAY_FOR_EMPTY_LIST = new Object[]{};
    private static final int ZERO_LENGTH_LIST = 0;
    private static final int DEFAULT_CAPACITY = 10;
    
    private Object[] arr;
    private int size;


    public DIYarrayList() {
        arr = ARRAY_FOR_EMPTY_LIST;
    }

    public DIYarrayList(int capacity) {
        if (capacity > ZERO_LENGTH_LIST)
            arr = new Object[capacity];
        else if (capacity == ZERO_LENGTH_LIST)
            arr = ARRAY_FOR_EMPTY_LIST;
        else
            throw new IllegalArgumentException("Illegal Capacity" + capacity);
    }

    public DIYarrayList(Collection<? extends T> e) {
        arr = e.toArray();
        if ((size = arr.length) != ZERO_LENGTH_LIST) {
            if (arr.getClass() != Object[].class)
                arr = Arrays.copyOf(arr, size, Object[].class);
        } else {
            // replace with empty array.
            this.arr = ARRAY_FOR_EMPTY_LIST;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == ZERO_LENGTH_LIST;
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
        if (size == arr.length) {
            if (size == ZERO_LENGTH_LIST)
                arr = Arrays.copyOf(arr, DEFAULT_CAPACITY);
            else
                arr = Arrays.copyOf(arr, size + (size >> 1));
        }
        arr[size++] = e;
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
        Object[] a = c.toArray();
        arr = Arrays.copyOf(arr, size + c.size());
        System.arraycopy(a, ZERO_LENGTH_LIST, arr, size, c.size());
        size += c.size();
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
        T oldElement = (T) arr[index];
        arr[index] = element;
        return oldElement;
    }

    void checkIndex(int index) {
        if ((index >= size) || (index < ZERO_LENGTH_LIST))
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
        return new ListItr(ZERO_LENGTH_LIST);
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

        Itr() {
        }

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
            if (lastRet < ZERO_LENGTH_LIST)
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