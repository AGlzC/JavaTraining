package com.training.collections.list.arraylist;

import com.training.collections.Iterator;
import com.training.collections.list.List;

import java.lang.reflect.Array;

public class ArrayList<T> implements List<T> {
    private int currentSize;
    private T[] dataArray;
    private int currentStorageSize = 4;


    public ArrayList() {
        dataArray = (T[])new Object[currentStorageSize];
    }
    public ArrayList(Class<T[]> clazz) {
        dataArray = clazz.cast(Array.newInstance(clazz.getComponentType(), currentStorageSize));
    }

    public void add(T data) {
        if (currentSize == currentStorageSize) {
            resizeArray();
        }
        dataArray[currentSize] = data;
        currentSize ++;
    }

    public void insert(int index, T data) {
        if (index < 0 || index > currentSize) {
            throw new IndexOutOfBoundsException(index);
        }
        if (currentSize == currentStorageSize) {
            resizeArray();
        }
        for (int loop = currentSize; loop > index; loop--) {
            dataArray[loop] = dataArray[loop - 1];
        }
        dataArray[index] = data;
        currentSize++;
    }

    public T getAt(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException(index);
        }
        return dataArray[index];
    }

    public void setAt(int index, T data) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException(index);
        }
        dataArray[index] = data;
    }

    public void remove(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index < currentSize - 1) {
            for (int loop = index; loop < currentSize - 1; loop++) {
                dataArray[loop] = dataArray[loop + 1];
            }
        }
        currentSize --;
        dataArray[currentSize] = null;
    }

    public void removeAll() {
        for (int loop = 0; loop < currentSize; loop++)
            dataArray[loop] = null;
        currentSize = 0;
    }

    public int size()
    {
        return currentSize;
    }

    public boolean contains(T data) {
        for (int loop = 0; loop < currentSize; loop++) {
            if (dataArray[loop].equals(data)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T data) {
        for (int loop = 0; loop < currentSize; loop++) {
            if (dataArray[loop].equals(data)){
                return loop;
            }
        }
        return -1;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public T next() {
                T data = null;
                if (currentIndex < currentSize) {
                    data = dataArray[currentIndex++];
                }
                return data;
            }

            @Override
            public boolean hasNext() {
                return (currentIndex < currentSize);
            }
        };
    }

    @Override
    public Iterator<T> reverseIterator() {
        return new Iterator<>() {
            private int currentIndex = currentSize - 1;

            @Override
            public T next() {
                T data = null;
                if (currentIndex >= 0) {
                    data = dataArray[currentIndex--];
                }
                return data;
            }

            @Override
            public boolean hasNext() {
                return (currentIndex >= 0);
            }
        };
    }

    private void resizeArray() {
        currentStorageSize <<= 1;
        T[] newArray = (T[]) Array.newInstance(dataArray.getClass().getComponentType(), currentStorageSize);
        System.arraycopy(dataArray, 0, newArray, 0, dataArray.length);
        dataArray = newArray;
    }
}
