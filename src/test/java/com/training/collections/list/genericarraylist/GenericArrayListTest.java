package com.training.collections.list.genericarraylist;

import com.training.collections.list.GenericIterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericArrayListTest {
    @Test
    void testArrayListCreation()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        int size = arrayList.size();

        // then
        Assertions.assertEquals(0, size);
    }

    @Test
    void testGenericArrayListAddSingleElement()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        int size = arrayList.size();
        String data = arrayList.getAt(0);

        // then
        Assertions.assertEquals(1, size);
        Assertions.assertEquals("uno", data);
    }
    @Test
    void testGenericArrayListAddMultipleElements()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("IV");
        arrayList.add("Lilo");
        int size = arrayList.size();
        String data = arrayList.getAt(4);

        // then
        Assertions.assertEquals(5, size);
        Assertions.assertEquals("Lilo", data);
    }

    @Test
    void testGenericArrayListInsertThrowExceptionOutOfBoundsBelow() {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.insert(0, "uno");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> arrayList.insert(-1, "uno"),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testGenericArrayListInsertThrowExceptionOutOfBoundsAbove() {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.insert(0, "uno");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> arrayList.insert(99, "uno"),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testGenericArrayListInsertAtStartWithEmptyList()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.insert(0,"uno");
        int size = arrayList.size();
        String data = arrayList.getAt(0);

        // then
        Assertions.assertEquals(1, size);
        Assertions.assertEquals("uno", data);
    }

    @Test
    void testGenericArrayListInsertInTheMiddle()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.insert(1,"dos");
        int size = arrayList.size();
        String data = arrayList.getAt(1);

        // then
        Assertions.assertEquals(4, size);
        Assertions.assertEquals("dos", data);
    }

    @Test
    void testGenericArrayListInsertAtTheLastElement()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.insert(3,"IV");
        int size = arrayList.size();
        String data = arrayList.getAt(3);

        // then
        Assertions.assertEquals(5, size);
        Assertions.assertEquals("IV", data);
    }

    @Test
    void testGenericArrayListGetAtThrowExceptionOutOfBoundsBelow() {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> arrayList.getAt(-1),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testGenericArrayListGetAtThrowExceptionOutOfBoundsAbove() {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> arrayList.getAt(99),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testGenericArrayListGetAtFirstElement()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        String data = arrayList.getAt(0);

        // then
        Assertions.assertEquals("uno", data);
    }

    @Test
    void testGenericArrayListGetAtLastElement()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        String data = arrayList.getAt(2);

        // then
        Assertions.assertEquals("tri", data);
    }

    @Test
    void testGenericArrayListGetAtMiddleElement()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        String data = arrayList.getAt(1);

        // then
        Assertions.assertEquals("two", data);
    }

    @Test
    void testGenericArrayListSetAtThrowExceptionOutOfBoundsBelow() {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> arrayList.setAt(-1, "one"),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testGenericArrayListSetAtThrowExceptionOutOfBoundsAbove() {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> arrayList.setAt(99, "one"),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }


    @Test
    void testGenericArrayListSetAtFirstElement()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.setAt(0, "one");
        String data = arrayList.getAt(0);

        // then
        Assertions.assertEquals("one", data);
    }

    @Test
    void testGenericArrayListSetAtLastElement()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.setAt(2, "tres");
        String data = arrayList.getAt(2);

        // then
        Assertions.assertEquals("tres", data);
    }

    @Test
    void testGenericArrayListSetAtMiddleElement()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.setAt(1, "dos");
        String data = arrayList.getAt(1);

        // then
        Assertions.assertEquals("dos", data);
    }

    @Test
    void testGenericArrayListRemoveThrowExceptionOutOfBoundsBelow() {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> arrayList.remove(-1),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testGenericArrayListRemoveThrowExceptionOutOfBoundsAbove() {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> arrayList.remove(99),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testGenericArrayListRemoveAtFirstElement()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.add("Lilo");
        arrayList.remove(0);
        int size = arrayList.size();
        String data = arrayList.getAt(0);

        // then
        Assertions.assertEquals(4, size);
        Assertions.assertEquals("two", data);
    }

    @Test
    void testGenericArrayListRemoveAtMiddleElement()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.remove(1);
        int size = arrayList.size();
        String data = arrayList.getAt(1);

        // then
        Assertions.assertEquals(2, size);
        Assertions.assertEquals("tri", data);
    }

    @Test
    void testGenericArrayListRemoveAtLastElement()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.add("Lilo");
        arrayList.remove(4);
        int size = arrayList.size();

        // then
        Assertions.assertEquals(4, size);
    }

    @Test
    void testGenericArrayListRemoveAllElements()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.removeAll();
        int size = arrayList.size();

        // then
        Assertions.assertEquals(0, size);
    }

    @Test
    void testGenericArrayListContainsExisting()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.add("Lilo");
        boolean flag = arrayList.contains("tri");

        // then
        assertTrue(flag);
    }

    @Test
    void testGenericArrayListContainsNotExisting()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.add("Lilo");
        boolean flag = arrayList.contains("tres");

        // then
        assertFalse(flag);
    }

    @Test
    void testGenericArrayListIndexOfExisting()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.add("Lilo");
        int index = arrayList.indexOf("tri");

        // then
        Assertions.assertEquals(2, index);
    }

    @Test
    void testGenericArrayListIndexOfNotExisting()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.add("Lilo");
        int index = arrayList.indexOf("tres");

        // then
        Assertions.assertEquals(-1, index);
    }

    @Test
    void testGenericArrayListIteratorHasNextTrue()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.add("Lilo");
        GenericIterator<String> iterator = arrayList.iterator();
        boolean flag = iterator.hasNext();

        // then
        assertTrue(flag);
    }

    @Test
    void testGenericArrayListIteratorHasNextFalse()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        GenericIterator<String> iterator = arrayList.iterator();
        boolean flag = iterator.hasNext();

        // then
        assertFalse(flag);
    }

    @Test
    void testGenericArrayListIteratorNext()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.add("Lilo");
        GenericIterator<String> iterator = arrayList.iterator();
        String data = iterator.next();

        // then
        Assertions.assertEquals("uno", data);
    }

    @Test
    void testGenericArrayListReversedIteratorHasNextTrue()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.add("Lilo");
        GenericIterator<String> iterator = arrayList.reverseIterator();
        boolean flag = iterator.hasNext();

        // then
        assertTrue(flag);
    }

    @Test
    void testArrayReversedListIteratorHasNextFalse()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        GenericIterator<String> iterator = arrayList.reverseIterator();
        boolean flag = iterator.hasNext();

        // then
        assertFalse(flag);
    }

    @Test
    void testArrayReversedListIteratorNext()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.add("Lilo");
        GenericIterator<String> iterator = arrayList.reverseIterator();
        String data = iterator.next();

        // then
        Assertions.assertEquals("Lilo", data);
    }

    @Test
    void testGenericArrayListReversedIterator3Inserts()
    {
        // given:
        GenericArrayList<String> arrayList = new GenericArrayList<>(String[].class);

        // when:
        arrayList.insert(0, "uno");
        arrayList.insert(1, "dos");
        arrayList.insert(2, "tri");
        arrayList.insert(3, "for");
        GenericIterator<String> iterator = arrayList.reverseIterator();
        String data;
        while (iterator.hasNext()) {
            data = iterator.next();
        }
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertFalse(flag);
    }
}