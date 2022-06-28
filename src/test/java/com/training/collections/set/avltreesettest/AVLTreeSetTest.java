package com.training.collections.set.avltreesettest;

import com.training.collections.set.Vehicle;
import com.training.collections.set.treeset.AVLTreeSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AVLTreeSetTest {
    @Test
    void testAVLTreeSetSetCreation() {
        // given:
        AVLTreeSet<Integer> AVLTree = new AVLTreeSet<>();

        // when:
        int size = AVLTree.size();

        // then
        Assertions.assertEquals(0, size);
    }

    @Test
    void testAVLTreeSetSetAddOneElement() {
        // given:
        AVLTreeSet<Vehicle> AVLTree = new AVLTreeSet<>();

        // when:
        AVLTree.add(new Vehicle("Tiida", "Nissan", 2014));
        int size = AVLTree.size();

        // then
        Assertions.assertEquals(1, size);
    }

    @Test
    void testAVLTreeSetSetAddRotateRight() {
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
    void testAVLTreeSetSetAddRotateLeftRight() {
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
    void testAVLTreeSetSetAddRotateLeft() {
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
    void testAVLTreeSetSetAddRotateRightLeft() {
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
    void testAVLTreeSetSetRemoveRotateLeftRight() {
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
    void testAVLTreeSetSetRemoveRotateRightLeft() {
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
    void testAVLTreeSetSetRemoveAll() {
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

    //    Iterator iterator();
    //    Iterator reverseIterator();
}
