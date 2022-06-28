package com.training.collections.set.hashset;

import com.training.collections.Iterator;
import com.training.collections.list.linkedlist.LinkedList;
import com.training.collections.set.Set;
import com.training.collections.exceptions.DuplicatedElementException;

import java.util.NoSuchElementException;

public class HashSet<T> implements Set<T> {

    private LinkedList<T>[] buckets;
    private int currentBucketsSize = 4;
    private int maximumLinkedListSize = 5;
    private int currentSize;

    public HashSet() {
        buckets = (LinkedList<T>[]) new LinkedList[currentBucketsSize];
        for (int loop = 0; loop < currentBucketsSize; loop ++) {
            buckets[loop] = new LinkedList<>();
        }
    }

    @Override
    public void add(T data) {
        int dataFixedHash = fixedHash(data);

        if (buckets[dataFixedHash].contains(data)) {
            throw new DuplicatedElementException(data.toString());
        }
        if (buckets[dataFixedHash].size() >= maximumLinkedListSize) {
            reSize();
            dataFixedHash = fixedHash(data);
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
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int maximumBucketNumber = currentBucketsSize;
            private int currentBucket = 0;
            private Iterator<T> bucketIterator = buckets[currentBucket++].iterator();

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
    public Iterator<T> reverseIterator() {
        return new Iterator<>() {
            private int currentBucket = currentBucketsSize - 1;
            private Iterator<T> bucketIterator = buckets[currentBucket--].reverseIterator();

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
        Iterator<T> iterator = this.iterator();
        currentBucketsSize <<= 1;
        LinkedList<T>[] newbuckets = (LinkedList<T>[]) new LinkedList[currentBucketsSize];
        for (int loop = 0; loop < currentBucketsSize; loop ++) {
            newbuckets[loop] = new LinkedList<>();
        }
        while (iterator.hasNext()) {
            data = iterator.next();
            dataFixedHash = fixedHash(data);
            newbuckets[dataFixedHash].add(data);
        }
        buckets = newbuckets;
    }
}
