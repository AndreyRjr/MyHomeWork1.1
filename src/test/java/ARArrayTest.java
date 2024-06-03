import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ARArrayTest {

    @Test
    public void testAdd() {
        ARArray<Integer> array = new ARArray<>();
        assertTrue(array.add(1));
        assertEquals(1, array.size());
    }

    @Test
    public void testAddToIndex() { // ок
        ARArray<Integer> myArray = new ARArray<>();
        int i, k;
        for (i = 0; i < 1000; i++){
            k = i + 1;
            myArray.addToIndex(i, k);
        }
        assertEquals(1000, myArray.size());
        assertEquals(1, myArray.get(0));
        assertEquals(500, myArray.get(499));
        assertEquals(1000, myArray.get(999));
    }

    @Test
    public void testGet() {
        ARArray<Integer> array = new ARArray<>();
        array.add(1);
        array.add(2147483647);
        array.add(-2147483648);
        assertEquals(1, array.get(0));
        assertEquals(2147483647, array.get(1));
        assertEquals(-2147483648, array.get(2));
    }

    @Test
    public void testDelete() {
        ARArray<Integer> array = new ARArray<>();
        array.add(1);
        array.add(2);
        assertEquals(2, array.size());
        array.delete(0);
        assertEquals(1, array.size());
        assertEquals(2, array.get(0));
    }

    @Test
    public void testClear() {
        ARArray<Integer> array = new ARArray<>();
        array.add(1);
        array.add(2);
        array.clear();
        assertEquals(0, array.size());
    }

    @Test
    public void testSort() {
        ARArray<Integer> array = new ARArray<>();
        array.add(36665);
        array.add(1);
        array.add(2);
        array.add(1);
        array.add(2147483647);
        array.add(-2147483648);
        array.add(0);
        array.add(-1);

        array.sort();

        assertEquals(-2147483648, array.get(0));
        assertEquals(-1, array.get(1));
        assertEquals(0, array.get(2));
        assertEquals(1, array.get(3));
        assertEquals(1, array.get(4));
        assertEquals(2, array.get(5));
        assertEquals(36665, array.get(6));
        assertEquals(2147483647, array.get(7));
    }

    @Test
    public void testUpdate() {
        ARArray<Integer> array = new ARArray<>();
        array.add(1);
        array.update(0, 2);
        assertEquals(2, array.get(0));
    }

    @Test
    public void testWithStrings() {
        ARArray<String> arrayStr = new ARArray<>();
        assertTrue(arrayStr.add("1"));
        assertTrue(arrayStr.add("World"));
        assertTrue(arrayStr.add("Пока"));
        assertTrue(arrayStr.add("Hello!"));

        assertEquals(4, arrayStr.size());
        assertEquals("Hello!", arrayStr.get(3));
        assertEquals("Пока", arrayStr.get(2));
        assertEquals("1", arrayStr.get(0));

        arrayStr.sort();
        assertEquals("1", arrayStr.get(0));
        assertEquals("Hello!", arrayStr.get(1));
        assertEquals("World", arrayStr.get(2));
        assertEquals("Пока", arrayStr.get(3));
    }

    @Test
    public void testWithDoubleValues() {
        ARArray<Double> arrayD = new ARArray<>();
        assertTrue(arrayD.add(0.02));
        assertTrue(arrayD.add(0.03));
        assertTrue(arrayD.add(-0.1));
        assertTrue(arrayD.add(-564.000000004));

        assertEquals(4, arrayD.size());
        assertEquals(-564.000000004, arrayD.get(3));
        assertEquals(-0.1, arrayD.get(2));
        assertEquals(0.02, arrayD.get(0));

        arrayD.sort();
        assertEquals(-564.000000004, arrayD.get(0));
        assertEquals(-0.1, arrayD.get(1));
        assertEquals(0.02, arrayD.get(2));
        assertEquals(0.03, arrayD.get(3));
    }
}