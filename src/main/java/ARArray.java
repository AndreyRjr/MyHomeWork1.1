import java.util.Arrays;
import java.util.Iterator;

public class ARArray<E> implements ARArrayInterface<E> {
    /**
     * @author Рыбалкин Андрей
     * @version 1.1
     */

    private E[] values; // объявление массива
    public ARArray() {
        values = (E[]) new Object[0]; // инициализация массива
    }

    /**
     * 1. add - добавление элемента в конец масиива.
     * Для реализации данного метода создается в массив с количеством элементов +1,
     * и производится копирование из исходного массива в новый, добавляемый элемент
     * помещается в конец.
     */
    @Override
    public boolean add(E e) { // 1.
        E[] temp =  values;
        values = (E[]) new Object[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, temp.length);
        values[values.length - 1] = e;
        return true;
    }

    /**
     *2. addToIndex - добавление элемента по индексу.
     * Для реализации данного метода создается в массив с количеством элементов +1,
     * производится копирование из исходного массива в новый до значения значения индекса добавляемого элемента,
     * добавляемый элемент размещается с необходимым индексом,
     * производится копирование из исходного массива в новый до значения со значения индекса добавляемого элемента +1
     * до конца массива.
     */
    public boolean addToIndex(int index, E e) {  // 2.
        E[] temp =  values;
        values = (E[]) new Object[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, index);
        values[index] = e;
        System.arraycopy(temp, index, values, index + 1, temp.length - index);
        return true;
    }

    /**
     * 3. get - получить значение лемента по индексу.
     * Из уже существующего масивва по необходимому индексу возвращаем значение
     */
    @Override
    public E get(int index) { // 3.
        return values[index];
    }

    /**
     * 4. delete - удаление лемента по индексу.
     * Для реализации данного метода создается в массив с количеством элементов -1,
     * производится копирование из исходного массива в новый до значения значения индекса удаляемого элемента,
     * удаляемый элемент пропускается (не копируется),
     * производится копирование из исходного массива в новый до значения со значения индекса удаляемого элемента +1
     * до конца массива.
     */
    @Override
    public void delete(int index) {  // 4.
        E[] temp =  values;
        values = (E[]) new Object[temp.length - 1];
        System.arraycopy(temp, 0, values, 0, index);
        int amountElAftIndex = temp.length - index - 1;
        System.arraycopy(temp, index + 1, values, index, amountElAftIndex);
    }

    /**
     * 5. clear - очистка всего массива (коллекции).
     * Для реализации данного метода создается в массив с количеством элементов равным нулю.
     */
    public void clear() {   // 5.
        values = (E[]) new Object[0];
    }

    /**
     * 8. size - размер массива (коллекции).
     * Для реализации данного метода получаем значение длянны массыва.
     */
    @Override
    public int size() {  // доп.
        return values.length;
    }

    /**
     * 6. sort - сортировка массива (коллекции).
     * Для реализации данного метода объявляем массив верхний, нижний индексы и инициализируем их
     * и передаем в рекурсивный метод quickSort.
     */
    @Override
    public void sort(){ // 6.
        E[] arr =  values;
        int low = 0;
        int high = values.length - 1;
        quickSort(arr, low, high);
    }

    /**
     * Разделение массива методом partition на две части и вызывается рекурсивный метод quickSort для левой и правой части.
     */
    private void quickSort(E[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Метод partition определяет положение опорного элемента (средний элемент выбран в качестве опорного).
     * Преставляет элементы чтобы меньшие элементы находились слева, а большие справа от опорного элемента.
     */
    private int partition(E[] arr, int low, int high) {
        int middle = low + (high - low) / 2;
        E pivot = arr[middle];

        Comparable<E> comparablePivot = (Comparable<E>) pivot;

        E temp = arr[middle];
        arr[middle] = arr[high];
        arr[high] = temp;

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            Comparable<E> comparableElement = (Comparable<E>) arr[j];

            if (comparableElement.compareTo((E) comparablePivot) < 0) {
                i++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * 7. update - замена элемента по индексу.
     * Для реализации данного метода по заданному индексу производится присвоение нового значения.
     */
    @Override
    public void update(int index, E e) {  // 7.
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }

    @Override
    public String toString() {
        return "ARArray{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}