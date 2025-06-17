import org.eci.MyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void testAddAndSize() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        assertEquals(0, list.size());

        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testGetInvalidIndexThrowsException() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("A");

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    void testIsEmpty() {
        MyLinkedList<Double> list = new MyLinkedList<>();
        assertTrue(list.isEmpty());

        list.add(1.1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testIterator() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("uno");
        list.add("dos");
        list.add("tres");

        Iterator<String> it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals("uno", it.next());
        assertEquals("dos", it.next());
        assertEquals("tres", it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void testIteratorOnEmptyList() {
        MyLinkedList<Object> list = new MyLinkedList<>();
        Iterator<Object> it = list.iterator();
        assertFalse(it.hasNext());
    }
}
