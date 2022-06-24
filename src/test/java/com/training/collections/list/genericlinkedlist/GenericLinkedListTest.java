package com.training.collections.list.genericlinkedlist;

import com.training.collections.list.GenericIterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenericLinkedListTest {

    @Test
    void testLinkedListCreation() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        int size = linkedList.size();

        // then
        Assertions.assertEquals(0, size);
    }

    @Test
    void testLinkedListAddSingleElement() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        int size = linkedList.size();
        String data = linkedList.getAt(0);

        // then
        Assertions.assertEquals(1, size);
        Assertions.assertEquals("uno", data);
    }

    @Test
    void testLinkedListAddMultipleElements() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.add("IV");
        linkedList.add("Lilo");
        int size = linkedList.size();
        String data = linkedList.getAt(4);

        // then
        Assertions.assertEquals(5, size);
        Assertions.assertEquals("Lilo", data);
    }

    @Test
    void testLinkedListInsertThrowExceptionOutOfBoundsBelow() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.insert(0, "uno");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.insert(-1, "uno"),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testLinkedListInsertThrowExceptionOutOfBoundsAbove() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.insert(0, "uno");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.insert(99, "uno"),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testLinkedListInsertAtStartWithEmptyList() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.insert(0, "uno");
        int size = linkedList.size();
        String data = linkedList.getAt(0);

        // then
        Assertions.assertEquals(1, size);
        Assertions.assertEquals("uno", data);
    }

    @Test
    void testLinkedListInsertInTheMiddle() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.insert(1, "dos");
        int size = linkedList.size();
        String data = linkedList.getAt(1);

        // then
        Assertions.assertEquals(4, size);
        Assertions.assertEquals("dos", data);
    }

    @Test
    void testLinkedListInsertAtTheLastElement() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.add("for");
        linkedList.insert(3, "IV");
        int size = linkedList.size();
        String data = linkedList.getAt(3);

        // then
        Assertions.assertEquals(5, size);
        Assertions.assertEquals("IV", data);
    }

    @Test
    void testLinkedListGetAtThrowExceptionOutOfBoundsBelow() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.getAt(-1),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testLinkedListGetAtThrowExceptionOutOfBoundsAbove() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.getAt(99),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testLinkedListGetAtFirstElement() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        String data = linkedList.getAt(0);

        // then
        Assertions.assertEquals("uno", data);
    }

    @Test
    void testLinkedListGetAtLastElement() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        String data = linkedList.getAt(2);

        // then
        Assertions.assertEquals("tri", data);
    }

    @Test
    void testLinkedListGetAtMiddleElement()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        String data = linkedList.getAt(1);

        // then
        Assertions.assertEquals("two", data);
    }

    @Test
    void testLinkedListSetAtThrowExceptionOutOfBoundsBelow() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.setAt(-1, "one"),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testLinkedListSetAtThrowExceptionOutOfBoundsAbove() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.setAt(99, "one"),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testLinkedListSetAtFirstElement()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.setAt(0, "one");
        String data = linkedList.getAt(0);

        // then
        Assertions.assertEquals("one", data);
    }

    @Test
    void testLinkedListSetAtLastElement()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.setAt(2, "tres");
        String data = linkedList.getAt(2);

        // then
        Assertions.assertEquals("tres", data);
    }

    @Test
    void testLinkedListSetAtMiddleElement()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.setAt(1, "dos");
        String data = linkedList.getAt(1);

        // then
        Assertions.assertEquals("dos", data);
    }

    @Test
    void testLinkedListRemoveThrowExceptionOutOfBoundsBelow() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.remove(-1),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testLinkedListRemoveThrowExceptionOutOfBoundsAbove() {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");

        // then:
        IndexOutOfBoundsException thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.remove(99),
                "Expected exception throw by insert with out of bounds index"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Index out of range"));
    }

    @Test
    void testLinkedListRemoveAtFirstElement()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.add("for");
        linkedList.add("Lilo");
        linkedList.remove(0);
        int size = linkedList.size();
        String data = linkedList.getAt(0);

        // then
        Assertions.assertEquals(4, size);
        Assertions.assertEquals("two", data);
    }

    @Test
    void testLinkedListRemoveAtMiddleElement()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.remove(1);
        int size = linkedList.size();
        String data = linkedList.getAt(1);

        // then
        Assertions.assertEquals(2, size);
        Assertions.assertEquals("tri", data);
    }
    @Test
    void testLinkedListRemoveAtLastElement()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.add("for");
        linkedList.add("Lilo");
        linkedList.remove(4);
        int size = linkedList.size();

        // then
        Assertions.assertEquals(4, size);
    }

    @Test
    void testLinkedListRemoveAllElements()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.removeAll();
        int size = linkedList.size();

        // then
        Assertions.assertEquals(0, size);
    }

    @Test
    void testLinkedListContainsExisting()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.add("for");
        linkedList.add("Lilo");
        boolean flag = linkedList.contains("tri");

        // then
        Assertions.assertTrue(flag);
    }

    @Test
    void testLinkedListContainsNotExisting()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.add("for");
        linkedList.add("Lilo");
        boolean flag = linkedList.contains("tres");

        // then
        Assertions.assertFalse(flag);
    }

    @Test
    void testLinkedListIndexOfExisting()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.add("for");
        linkedList.add("Lilo");
        int index = linkedList.indexOf("tri");

        // then
        Assertions.assertEquals(2, index);
    }

    @Test
    void testLinkedListIndexOfNotExisting()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.add("for");
        linkedList.add("Lilo");
        int index = linkedList.indexOf("tres");

        // then
        Assertions.assertEquals(-1, index);
    }

    @Test
    void testLinkedListIteratorHasNextTrue()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.add("for");
        linkedList.add("Lilo");
        GenericIterator<String> iterator = linkedList.iterator();
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertTrue(flag);
    }

    @Test
    void testLinkedListIteratorHasNextFalse()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        GenericIterator<String> iterator = linkedList.iterator();
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertFalse(flag);
    }

    @Test
    void testLinkedListIteratorNext()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.add("for");
        linkedList.add("Lilo");
        GenericIterator<String> iterator = linkedList.iterator();
        String data = iterator.next();

        // then
        Assertions.assertEquals("uno", data);
    }
    @Test
    void testLinkedListReversedIteratorHasNextTrue()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.add("for");
        linkedList.add("Lilo");
        GenericIterator<String> iterator = linkedList.reverseIterator();
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertTrue(flag);
    }

    @Test
    void testLinkedListReversedIteratorHasNextFalse()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        GenericIterator<String> iterator = linkedList.reverseIterator();
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertFalse(flag);
    }

    @Test
    void testLinkedListReversedIteratorNext()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.add("uno");
        linkedList.add("two");
        linkedList.add("tri");
        linkedList.add("for");
        linkedList.add("Lilo");
        GenericIterator<String> iterator = linkedList.reverseIterator();
        String data = iterator.next();

        // then
        Assertions.assertEquals("Lilo", data);
    }

    @Test
    void testLinkedListReversedIterator3Inserts()
    {
        // given:
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();

        // when:
        linkedList.insert(0, "uno");
        linkedList.insert(1, "dos");
        linkedList.insert(2, "tri");
        linkedList.insert(3, "for");
        GenericIterator<String> iterator = linkedList.reverseIterator();
        String data;
        while (iterator.hasNext()) {
            data = iterator.next();
        }
        boolean flag = iterator.hasNext();

        // then
        Assertions.assertFalse(flag);
    }
}
