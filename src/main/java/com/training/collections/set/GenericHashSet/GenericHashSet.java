package com.training.collections.set.GenericHashSet;

import com.training.collections.list.GenericIterator;
import com.training.collections.list.genericlinkedlist.GenericLinkedList;
import com.training.collections.set.GenericSet;

import java.util.NoSuchElementException;

public class GenericHashSet<T> implements GenericSet<T> {

    private GenericLinkedList<T>[] buckets;
    private int currentBucketsSize = 4;
    private int maximumLinkedListSize = 5;
    private int currentSize;

    public GenericHashSet() {
        buckets = (GenericLinkedList<T>[]) new GenericLinkedList[currentBucketsSize];
        for (int loop = 0; loop < currentBucketsSize; loop ++) {
            buckets[loop] = new GenericLinkedList<>();
        }
    }

    @Override
    public void add(T data) {
        int dataFixedHash = fixedHash(data);

        if (buckets[dataFixedHash].contains(data)) {
            throw new DuplicatedElementException(data.toString());
        }
        if (buckets[dataFixedHash].size() == maximumLinkedListSize) {
            reSize();
        }
        buckets[dataFixedHash].add(data);
        currentSize++;
    }

    @Override
    public void remove(T data) {
        int dataFixedHash = fixedHash(data);
        int indexOfData =buckets[dataFixedHash].indexOf(data);
        if (indexOfData == -1) {
            throw new NoSuchElementException("Non existing element :" + data);
        }
        buckets[dataFixedHash].remove(indexOfData);
        currentSize--;
    }

    @Override
    public void removeAll() {
        for (int loop = 0; loop < currentBucketsSize; loop++)
            buckets[loop].removeAll();
        currentSize = 0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean contains(T data) {
        int dataFixedHash = fixedHash(data);

        return buckets[dataFixedHash].contains(data);
    }

    @Override
    public GenericIterator<T> iterator() {
        return new GenericIterator<>() {
            private int maximumBucketNumber = currentBucketsSize;
            private int currentBucket = 0;
            private GenericIterator<T> bucketIterator = buckets[currentBucket++].iterator();

            @Override
            public T next() {
                T data = null;

                if (bucketIterator.hasNext()){
                    data = bucketIterator.next();
                }
                return data;
            }

            @Override
            public boolean hasNext() {
                while (!bucketIterator.hasNext() && currentBucket < maximumBucketNumber) {
                    bucketIterator = buckets[currentBucket++].iterator();
                }
                return bucketIterator.hasNext();
            }
        };
    }

    @Override
    public GenericIterator<T> reverseIterator() {
        return new GenericIterator<>() {
            private int currentBucket = currentBucketsSize - 1;
            private GenericIterator<T> bucketIterator = buckets[currentBucket--].reverseIterator();

            @Override
            public T next() {
                T data = null;
                if (bucketIterator.hasNext()){
                    data = bucketIterator.next();
                }
                return data;
            }

            @Override
            public boolean hasNext() {
                while (!bucketIterator.hasNext() && currentBucket >= 0) {
                    bucketIterator = buckets[currentBucket--].iterator();
                }
                return bucketIterator.hasNext();
            }
        };
    }

    private int fixedHash(T data) {
        return Math.abs(data.hashCode() % currentBucketsSize);
    }

    private void reSize() {
        T data;
        int dataFixedHash;
        GenericIterator<T> iterator = this.iterator();
        currentBucketsSize <<= 1;
        GenericLinkedList<T>[] newbuckets = (GenericLinkedList<T>[]) new GenericLinkedList[currentBucketsSize];
        for (int loop = 0; loop < currentBucketsSize; loop ++) {
            newbuckets[loop] = new GenericLinkedList<>();
        }
        while (iterator.hasNext()) {
            data = iterator.next();
            dataFixedHash = fixedHash(data);
            newbuckets[dataFixedHash].add(data);
        }
        buckets = newbuckets;
    }
}
