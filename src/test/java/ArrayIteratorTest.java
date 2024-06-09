import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;


class ArrayIteratorTest {
    private static ArrayIterator<Integer> arrayIterator;
    private static Integer[] testArray;

    @BeforeEach
    void setUp() {
        testArray = new Integer[]{1, 2, 3, 4};
        arrayIterator = new ArrayIterator<>(testArray);
    }

    @Test
    public void testNext() {
        assertEquals(Integer.valueOf(1), arrayIterator.next());
        assertEquals(Integer.valueOf(2), arrayIterator.next());
        assertEquals(Integer.valueOf(3), arrayIterator.next());
        assertEquals(Integer.valueOf(4), arrayIterator.next());
    }

    @Test
    public void testHasNext() {
        assertTrue(arrayIterator.hasNext());
        arrayIterator.next();
        arrayIterator.next();
        arrayIterator.next();
        arrayIterator.next();
        assertFalse(arrayIterator.hasNext());
    }

    @Test
    public void testNextThrowsExceptions() {
        arrayIterator.next();
        arrayIterator.next();
        arrayIterator.next();
        arrayIterator.next();
        assertThrows(NoSuchElementException.class, arrayIterator::next);
    }
}