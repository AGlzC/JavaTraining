package com.training.collections.set.hashset;

import com.training.collections.Iterator;
import com.training.collections.set.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.training.collections.exceptions.DuplicatedElementException;

import java.util.NoSuchElementException;

public class HashSetTest {
    @Test
    void testHashSetCreation() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        int size = hashSet.size();

        // then
        Assertions.assertEquals(0, size);
    }

    @Test
    void testHashSetAdd() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);

        int size = hashSet.size();

        // then
        Assertions.assertEquals(1, size);
    }

    @Test
    void testHashSetMultipleAdd() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        myCar = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCar);

        int size = hashSet.size();

        // then
        Assertions.assertEquals(4, size);
    }

    @Test
    void testHashSetDuplicatedAdd() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);

        int size = hashSet.size();

        // then:
        Vehicle duplicatedMyCar = new Vehicle("Versa", "Nissan", 2015);
        DuplicatedElementException thrown = Assertions.assertThrows(
                DuplicatedElementException.class,
                () -> hashSet.add(duplicatedMyCar),
                "Expected exception throw by adding duplicated data"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Duplicated element"));
        Assertions.assertEquals(3, size);
    }

    @Test
    void testHashSetMultipleAddForceResize() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();
        Vehicle[] testCars = new Vehicle[]{
                new Vehicle("Tiida", "Nissan", 2014),
                new Vehicle("S10", "Ford", 2002),
                new Vehicle("Yaris", "Toyota", 2017),
                new Vehicle("Versa", "Nissan", 2015),
                new Vehicle("V8", "VW", 1976),
                new Vehicle("Monza", "Chevrolet", 2007),
                new Vehicle("Civic", "Honda", 2010),
                new Vehicle("PickUp", "Ford", 2000),
                new Vehicle("Kicks", "Nissan", 2018),
                new Vehicle("A1", "Audi", 2021),
                new Vehicle("CX3", "Mazda", 2015),
                new Vehicle("Sonic", "Chevrolet", 2016),
                new Vehicle("City", "Honda", 2016)
        };

        // when:
        for (Vehicle vehicle : testCars) {
            hashSet.add(vehicle);
        }

        int size = hashSet.size();

        // then
        Assertions.assertEquals(testCars.length, size);
        for (Vehicle vehicle : testCars) {
            Assertions.assertTrue(hashSet.contains(vehicle));
        }
    }

    @Test
    void testHashSetMultipleAddForceResize2() {
        // given:
        HashSet<String> hashSet = new HashSet<>();

        // when:
        for (int loop = 0; loop < 25; loop ++) {
            hashSet.add("Item" + loop);
        }

        int size = hashSet.size();

        // then
        for (int loop = 0; loop < 25; loop ++) {
            Assertions.assertTrue(hashSet.contains("Item" + loop), "loop" + loop);
        }
        Assertions.assertEquals(25, size);
    }

    @Test
    void testHashSetRemoveFirst() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Vehicle myCarOriginal = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCarOriginal);
        Vehicle myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        myCar = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCar);

        hashSet.remove(myCarOriginal);
        int size = hashSet.size();

        // then
        Assertions.assertEquals(3, size);
    }

    @Test
    void testHashSetRemoveMiddle() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Vehicle myCarOriginal = new Vehicle("Tiida", "Nissan", 2014);
        Vehicle myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        hashSet.add(myCarOriginal);
        myCar = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCar);

        hashSet.remove(myCarOriginal);
        int size = hashSet.size();

        // then
        Assertions.assertEquals(3, size);
    }

    @Test
    void testHashSetRemoveLast() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        Vehicle myCarOriginal = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCarOriginal);

        hashSet.remove(myCarOriginal);
        int size = hashSet.size();

        // then
        Assertions.assertEquals(3, size);
    }

    @Test
    void testHashSetRemoveNonExistent() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        Vehicle myCarOriginal = new Vehicle("V8", "VW", 1975);
        myCar = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCar);
        int size = hashSet.size();

        // then:
        NoSuchElementException thrown = Assertions.assertThrows(
                NoSuchElementException.class,
                () -> hashSet.remove(myCarOriginal),
                "Expected exception throw by remove for non existent data"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Non existing element"));
        Assertions.assertEquals(4, size);
    }

    @Test
    void testHashSetRemoveAll() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        Vehicle myCarOriginal = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCarOriginal);

        hashSet.removeAll();
        int size = hashSet.size();

        // then
        Assertions.assertEquals(0, size);
    }

    @Test
    void testHashSetContainsExistent() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        Vehicle myCarOriginal = new Vehicle("V8", "VW", 1975);
        hashSet.add(myCarOriginal);
        boolean flag = hashSet.contains(myCarOriginal);

        // then
        Assertions.assertTrue(flag);
    }

    @Test
    void testHashSetContainsNonExistent() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        myCar = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCar);
        Vehicle myCarOriginal = new Vehicle("V8", "VW", 1975);
        boolean flag = hashSet.contains(myCarOriginal);

        // then
        Assertions.assertFalse(flag);
    }

    @Test
    void testHashSetIteratorHasNextTrue() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        myCar = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCar);
        Iterator<Vehicle> iterator = hashSet.iterator();
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertTrue(flag);
    }

    @Test
    void testHashSetIteratorHasNextFalse() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Iterator<Vehicle> iterator = hashSet.iterator();
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertFalse(flag);
    }

    @Test
    void testHashSetIteratorNext() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        myCar = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCar);
        Iterator<Vehicle> iterator = hashSet.iterator();
        Vehicle iteratorVehicle = iterator.next();

        // then
        Assertions.assertNotEquals(iteratorVehicle, null);
    }


    @Test
    void testHashSetReversedIteratorHasNextTrue() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        myCar = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCar);
        Iterator<Vehicle> iterator = hashSet.reverseIterator();
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertTrue(flag);
    }

    @Test
    void testHashSetReversedIteratorHasNextFalse() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Iterator<Vehicle> iterator = hashSet.reverseIterator();
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertFalse(flag);
    }

    @Test
    void testHashSetReversedIteratorNext() {
        // given:
        HashSet<Vehicle> hashSet = new HashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        myCar = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCar);
        Iterator<Vehicle> iterator = hashSet.reverseIterator();
        Vehicle iteratorVehicle = iterator.next();

        // then
        Assertions.assertNotEquals(iteratorVehicle, null);
    }
}
