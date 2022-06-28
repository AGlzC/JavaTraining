package com.training.collections.list.stringarraylist;

import com.training.collections.StringIterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringArrayListTest {
    @Test
    void testArrayListCreation()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

        // when:
        int size = arrayList.size();

        // then
        Assertions.assertEquals(0, size);
    }

    @Test
    void testArrayListAddSingleElement()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

        // when:
        arrayList.add("uno");
        int size = arrayList.size();
        String data = arrayList.getAt(0);

        // then
        Assertions.assertEquals(1, size);
        Assertions.assertEquals("uno", data);
    }
    @Test
    void testArrayListAddMultipleElements()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListInsertThrowExceptionOutOfBoundsBelow() {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListInsertThrowExceptionOutOfBoundsAbove() {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListInsertAtStartWithEmptyList()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

        // when:
        arrayList.insert(0,"uno");
        int size = arrayList.size();
        String data = arrayList.getAt(0);

        // then
        Assertions.assertEquals(1, size);
        Assertions.assertEquals("uno", data);
    }

    @Test
    void testArrayListInsertInTheMiddle()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListInsertAtTheLastElement()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListGetAtThrowExceptionOutOfBoundsBelow() {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListGetAtThrowExceptionOutOfBoundsAbove() {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListGetAtFirstElement()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        String data = arrayList.getAt(0);

        // then
        Assertions.assertEquals("uno", data);
    }

    @Test
    void testArrayListGetAtastElement()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        String data = arrayList.getAt(2);

        // then
        Assertions.assertEquals("tri", data);
    }

    @Test
    void testArrayListGetAtMiddleElement()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        String data = arrayList.getAt(1);

        // then
        Assertions.assertEquals("two", data);
    }

    @Test
    void testArrayListSetAtThrowExceptionOutOfBoundsBelow() {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListSetAtThrowExceptionOutOfBoundsAbove() {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListSetAtFirstElement()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListSetAtLastElement()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListSetAtMiddleElement()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListRemoveThrowExceptionOutOfBoundsBelow() {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListRemoveThrowExceptionOutOfBoundsAbove() {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListRemoveAtFirstElement()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListRemoveAtMiddleElement()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListRemoveAtLastElement()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListRemoveAllElements()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.removeAll();
        int size = arrayList.size();

        // then
        Assertions.assertEquals(0, size);
    }

    @Test
    void testArrayListContainsExisting()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListContainsNotExisting()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListIndexOfExisting()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListIndexOfNotExisting()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

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
    void testArrayListIteratorHasNextTrue()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.add("Lilo");
        StringIterator iterator = arrayList.iterator();
        boolean flag = iterator.hasNext();

        // then
        assertTrue(flag);
    }

    @Test
    void testArrayListIteratorHasNextFalse()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

        // when:
        StringIterator iterator = arrayList.iterator();
        boolean flag = iterator.hasNext();

        // then
        assertFalse(flag);
    }

    @Test
    void testArrayListIteratorNext()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.add("Lilo");
        StringIterator iterator = arrayList.iterator();
        String data = iterator.next();

        // then
        Assertions.assertEquals("uno", data);
    }

    @Test
    void testArrayListReversedIteratorHasNextTrue()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.add("Lilo");
        StringIterator iterator = arrayList.reverseIterator();
        boolean flag = iterator.hasNext();

        // then
        assertTrue(flag);
    }

    @Test
    void testArrayReversedListIteratorHasNextFalse()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

        // when:
        StringIterator iterator = arrayList.reverseIterator();
        boolean flag = iterator.hasNext();

        // then
        assertFalse(flag);
    }

    @Test
    void testArrayReversedListIteratorNext()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

        // when:
        arrayList.add("uno");
        arrayList.add("two");
        arrayList.add("tri");
        arrayList.add("for");
        arrayList.add("Lilo");
        StringIterator iterator = arrayList.reverseIterator();
        String data = iterator.next();

        // then
        Assertions.assertEquals("Lilo", data);
    }

    @Test
    void testArrayListReversedIterator3Inserts()
    {
        // given:
        StringArrayList arrayList = new StringArrayList();

        // when:
        arrayList.insert(0, "uno");
        arrayList.insert(1, "dos");
        arrayList.insert(2, "tri");
        arrayList.insert(3, "for");
        StringIterator iterator = arrayList.reverseIterator();
        String data;
        while (iterator.hasNext()) {
            data = iterator.next();
        }
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertFalse(flag);
    }
}