package com.training.collections.set.avltreesettest;

import com.training.collections.Iterator;
import com.training.collections.exceptions.DuplicatedElementException;
import com.training.collections.set.Vehicle;
import com.training.collections.set.avltreeset.AVLTreeSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class AVLTreeSetTest {
    @Test
    void testAVLTreeSetCreation() {
        // given:
        AVLTreeSet<Integer> AVLTree = new AVLTreeSet<>();

        // when:
        int size = AVLTree.size();

        // then
        Assertions.assertEquals(0, size);
    }

    @Test
    void testAVLTreeSetAddOneElement() {
        // given:
        AVLTreeSet<Vehicle> AVLTree = new AVLTreeSet<>();

        // when:
        AVLTree.add(new Vehicle("Tiida", "Nissan", 2014));
        int size = AVLTree.size();

        // then
        Assertions.assertEquals(1, size);
    }

    @Test
    void testAVLTreeSetAddRotateRight() {
        // given:
        AVLTreeSet<Vehicle> AVLTree = new AVLTreeSet<>();
        Vehicle[] cars = {
                new Vehicle("model", "brand", 2013),
                new Vehicle("model", "brand", 2011),
                new Vehicle("model", "brand", 2021),
                new Vehicle("model", "brand", 2008),
                new Vehicle("model", "brand", 2007)
        };

        // when:
        for (Vehicle vehicle : cars) {
            AVLTree.add(vehicle);
        }
        int size = AVLTree.size();

        // then
        for (Vehicle vehicle : cars) {
            Assertions.assertTrue(AVLTree.contains(vehicle), "data=" + vehicle);
        }
        Assertions.assertEquals(cars.length, size);
    }

    @Test
    void testAVLTreeSetAddRotateLeftRight() {
        // given:
        AVLTreeSet<Vehicle> AVLTree = new AVLTreeSet<>();
        Vehicle[] cars = {
                new Vehicle("model", "brand", 2013),
                new Vehicle("model", "brand", 2011),
                new Vehicle("model", "brand", 2021),
                new Vehicle("model", "brand", 2008),
                new Vehicle("model", "brand", 2009)
        };

        // when:
        for (Vehicle vehicle : cars) {
            AVLTree.add(vehicle);
        }
        int size = AVLTree.size();

        // then
        for (Vehicle vehicle : cars) {
            Assertions.assertTrue(AVLTree.contains(vehicle), "data=" + vehicle);
        }
        Assertions.assertEquals(cars.length, size);
    }

    @Test
    void testAVLTreeSetAddRotateLeft() {
        // given:
        AVLTreeSet<Vehicle> AVLTree = new AVLTreeSet<>();
        Vehicle[] cars = {
                new Vehicle("model", "brand", 2013),
                new Vehicle("model", "brand", 2011),
                new Vehicle("model", "brand", 2021),
                new Vehicle("model", "brand", 2025),
                new Vehicle("model", "brand", 2026)
        };

        // when:
        for (Vehicle vehicle : cars) {
            AVLTree.add(vehicle);
        }
        int size = AVLTree.size();

        // then
        for (Vehicle vehicle : cars) {
            Assertions.assertTrue(AVLTree.contains(vehicle), "data=" + vehicle);
        }
        Assertions.assertEquals(cars.length, size);
    }

    @Test
    void testAVLTreeSetAddRotateRightLeft() {
        // given:
        AVLTreeSet<Vehicle> AVLTree = new AVLTreeSet<>();
        Vehicle[] cars = {
                new Vehicle("model", "brand", 2013),
                new Vehicle("model", "brand", 2011),
                new Vehicle("model", "brand", 2021),
                new Vehicle("model", "brand", 2025),
                new Vehicle("model", "brand", 2024)
        };

        // when:
        for (Vehicle vehicle : cars) {
            AVLTree.add(vehicle);
        }
        int size = AVLTree.size();

        // then
        for (Vehicle vehicle : cars) {
            Assertions.assertTrue(AVLTree.contains(vehicle), "data=" + vehicle);
        }
        Assertions.assertEquals(cars.length, size);
    }

    @Test
    void testAVLTreeSetDuplicatedAdd() {
        // given:
        AVLTreeSet<Vehicle> AVLTree = new AVLTreeSet<>();
        Vehicle[] cars = {
                new Vehicle("model", "brand", 2013),
                new Vehicle("model", "brand", 2011),
                new Vehicle("model", "brand", 2021),
                new Vehicle("model", "brand", 2008),
                new Vehicle("model", "brand", 2009)
        };

        // when:
        for (Vehicle vehicle : cars) {
            AVLTree.add(vehicle);
        }
        int size = AVLTree.size();

        // then:
        Vehicle duplicatedMyCar = new Vehicle("Versa", "Nissan", 2013);
        DuplicatedElementException thrown = Assertions.assertThrows(
                DuplicatedElementException.class,
                () -> AVLTree.add(duplicatedMyCar),
                "Expected exception throw by adding duplicated data"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Duplicated element"));
        Assertions.assertEquals(5, size);
    }

    @Test
    void testAVLTreeSetRemoveRotateLeftRight() {
        // given:
        AVLTreeSet<Vehicle> AVLTree = new AVLTreeSet<>();
        Vehicle[] cars = {
                new Vehicle("model", "brand", 2013),
                new Vehicle("model", "brand", 2011),
                new Vehicle("model", "brand", 2021),
                new Vehicle("model", "brand", 2008),
                new Vehicle("model", "brand", 2009)
        };

        // when:
        for (Vehicle vehicle : cars) {
            AVLTree.add(vehicle);
        }
        AVLTree.remove(cars[0]);
        int size = AVLTree.size();

        // then
        Assertions.assertFalse(AVLTree.contains(cars[0]), "data=" + cars[0]);
        for (int loop = 1; loop < cars.length; loop++) {
            Assertions.assertTrue(AVLTree.contains(cars[loop]), "data=" + cars[loop]);
        }
        Assertions.assertEquals(cars.length - 1, size);
    }

    @Test
    void testAVLTreeSetRemoveRotateRightLeft() {
        // given:
        AVLTreeSet<Vehicle> AVLTree = new AVLTreeSet<>();
        Vehicle[] cars = {
                new Vehicle("model", "brand", 2013),
                new Vehicle("model", "brand", 2011),
                new Vehicle("model", "brand", 2021),
                new Vehicle("model", "brand", 2025),
                new Vehicle("model", "brand", 2024)
        };

        // when:
        for (Vehicle vehicle : cars) {
            AVLTree.add(vehicle);
        }
        AVLTree.remove(cars[0]);
        int size = AVLTree.size();

        // then
        Assertions.assertFalse(AVLTree.contains(cars[0]), "data=" + cars[0]);
        for (int loop = 1; loop < cars.length; loop++) {
            Assertions.assertTrue(AVLTree.contains(cars[loop]), "data=" + cars[loop]);
        }
        Assertions.assertEquals(cars.length - 1, size);
    }

    @Test
    void testAVLTreeSetRemoveNonExistent() {
        // given:
        AVLTreeSet<Vehicle> AVLTree = new AVLTreeSet<>();
        Vehicle[] cars = {
                new Vehicle("model", "brand", 2013),
                new Vehicle("model", "brand", 2011),
                new Vehicle("model", "brand", 2021),
                new Vehicle("model", "brand", 2025),
                new Vehicle("model", "brand", 2024)
        };
        Vehicle myCarOriginal = new Vehicle("V8", "VW", 1975);

        // when:
        for (Vehicle vehicle : cars) {
            AVLTree.add(vehicle);
        }
        int size = AVLTree.size();

        // then:
        NoSuchElementException thrown = Assertions.assertThrows(
                NoSuchElementException.class,
                () -> AVLTree.remove(myCarOriginal),
                "Expected exception throw by remove for non existent data"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Non existing element"));
        Assertions.assertEquals(5, size);
    }

    @Test
    void testAVLTreeSetRemoveAll() {
        // given:
        AVLTreeSet<Vehicle> AVLTree = new AVLTreeSet<>();
        Vehicle[] cars = {
                new Vehicle("model", "brand", 2013),
                new Vehicle("model", "brand", 2011),
                new Vehicle("model", "brand", 2021),
                new Vehicle("model", "brand", 2025),
                new Vehicle("model", "brand", 2024)
        };

        // when:
        for (Vehicle vehicle : cars) {
            AVLTree.add(vehicle);
        }
        AVLTree.removeAll();
        int size = AVLTree.size();

        // then
        Assertions.assertEquals(0, size);
    }

    @Test
    void testAVLTreeSetIterator() {
        // given:
        AVLTreeSet<Vehicle> AVLTree = new AVLTreeSet<>();
        Vehicle[] cars = {
                new Vehicle("model", "brand", 2013),
                new Vehicle("model", "brand", 2011),
                new Vehicle("model", "brand", 2021),
                new Vehicle("model", "brand", 2025),
                new Vehicle("model", "brand", 2024)
        };

        // when:
        for (Vehicle vehicle : cars) {
            AVLTree.add(vehicle);
        }
        Iterator<Vehicle> vehicleIterator = AVLTree.iterator();

        // then
        Assertions.assertTrue(vehicleIterator.hasNext());
        Assertions.assertEquals(vehicleIterator.next(), cars[1]);
        Assertions.assertTrue(vehicleIterator.hasNext());
        Assertions.assertEquals(vehicleIterator.next(), cars[0]);
        Assertions.assertTrue(vehicleIterator.hasNext());
        Assertions.assertEquals(vehicleIterator.next(), cars[2]);
        Assertions.assertTrue(vehicleIterator.hasNext());
        Assertions.assertEquals(vehicleIterator.next(), cars[4]);
        Assertions.assertTrue(vehicleIterator.hasNext());
        Assertions.assertEquals(vehicleIterator.next(), cars[3]);
        Assertions.assertFalse(vehicleIterator.hasNext());
    }

    @Test
    void testAVLTreeSetReverseIterator() {
        // given:
        AVLTreeSet<Vehicle> AVLTree = new AVLTreeSet<>();
        Vehicle[] cars = {
                new Vehicle("model", "brand", 2013),
                new Vehicle("model", "brand", 2011),
                new Vehicle("model", "brand", 2021),
                new Vehicle("model", "brand", 2025),
                new Vehicle("model", "brand", 2024)
        };

        // when:
        for (Vehicle vehicle : cars) {
            AVLTree.add(vehicle);
        }
        Iterator<Vehicle> vehicleIterator = AVLTree.reverseIterator();

        // then
        Assertions.assertTrue(vehicleIterator.hasNext());
        Assertions.assertEquals(vehicleIterator.next(), cars[3]);
        Assertions.assertTrue(vehicleIterator.hasNext());
        Assertions.assertEquals(vehicleIterator.next(), cars[4]);
        Assertions.assertTrue(vehicleIterator.hasNext());
        Assertions.assertEquals(vehicleIterator.next(), cars[2]);
        Assertions.assertTrue(vehicleIterator.hasNext());
        Assertions.assertEquals(vehicleIterator.next(), cars[0]);
        Assertions.assertTrue(vehicleIterator.hasNext());
        Assertions.assertEquals(vehicleIterator.next(), cars[1]);
        Assertions.assertFalse(vehicleIterator.hasNext());
    }
    //    Iterator reverseIterator();
}
