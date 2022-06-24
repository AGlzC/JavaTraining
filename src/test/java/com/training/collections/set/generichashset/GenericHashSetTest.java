package com.training.collections.set.generichashset;

import com.training.collections.list.GenericIterator;
import com.training.collections.set.GenericHashSet.DuplicatedElementException;
import com.training.collections.set.GenericHashSet.GenericHashSet;
import com.training.collections.set.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class GenericHashSetTest {
    @Test
    void testHashSetCreation() {
        // given:
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

        // when:
        int size = hashSet.size();

        // then
        Assertions.assertEquals(0, size);
    }

    @Test
    void testHashSetAdd() {
        // given:
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

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
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

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
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

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
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        myCar = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCar);
        myCar = new Vehicle("Monza", "Chevrolet", 2007);
        hashSet.add(myCar);
        myCar = new Vehicle("Civic", "Honda", 2010);
        hashSet.add(myCar);
        myCar = new Vehicle("PickUp", "Ford", 2000);
        hashSet.add(myCar);
        myCar = new Vehicle("Kicks", "Nissan", 2018);
        hashSet.add(myCar);
        myCar = new Vehicle("A1", "Audi", 2021);
        hashSet.add(myCar);
        myCar = new Vehicle("CX3", "Mazda", 2015);
        hashSet.add(myCar);
        myCar = new Vehicle("Sonic", "Chevrolet", 2016);
        hashSet.add(myCar);
        myCar = new Vehicle("City", "Honda", 2016);
        hashSet.add(myCar);
        myCar = new Vehicle("S10", "Ford", 2002);
        hashSet.add(myCar);

        int size = hashSet.size();

        // then
        Assertions.assertEquals(13, size);
    }

    @Test
    void testHashSetRemoveFirst() {
        // given:
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

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
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

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
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

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
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

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
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

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
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

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
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

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
    void testHashSetIteratorHasNextTrue()
    {
        // given:
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        myCar = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCar);
        GenericIterator<Vehicle> iterator = hashSet.iterator();
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertTrue(flag);
    }

    @Test
    void testHashSetIteratorHasNextFalse()
    {
        // given:
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

        // when:
        GenericIterator<Vehicle> iterator = hashSet.iterator();
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertFalse(flag);
    }

    @Test
    void testHashSetIteratorNext()
    {
        // given:
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        myCar = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCar);
        GenericIterator<Vehicle> iterator = hashSet.iterator();
        Vehicle iteratorVehicle = iterator.next();

        // then
        Assertions.assertNotEquals(iteratorVehicle, null);
    }


    @Test
    void testHashSetReversedIteratorHasNextTrue()
    {
        // given:
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        myCar = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCar);
        GenericIterator<Vehicle> iterator = hashSet.reverseIterator();
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertTrue(flag);
    }

    @Test
    void testHashSetReversedIteratorHasNextFalse()
    {
        // given:
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

        // when:
        GenericIterator<Vehicle> iterator = hashSet.reverseIterator();
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertFalse(flag);
    }

    @Test
    void testHashSetReversedIteratorNext()
    {
        // given:
        GenericHashSet<Vehicle> hashSet = new GenericHashSet<>();

        // when:
        Vehicle myCar = new Vehicle("Tiida", "Nissan", 2014);
        hashSet.add(myCar);
        myCar = new Vehicle("Yaris", "Toyota", 2017);
        hashSet.add(myCar);
        myCar = new Vehicle("Versa", "Nissan", 2015);
        hashSet.add(myCar);
        myCar = new Vehicle("V8", "VW", 1976);
        hashSet.add(myCar);
        GenericIterator<Vehicle> iterator = hashSet.reverseIterator();
        Vehicle iteratorVehicle = iterator.next();

        // then
        Assertions.assertNotEquals(iteratorVehicle, null);
    }
}
