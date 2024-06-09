public interface ARArrayInterface<E> extends Iterable<E> {
    /**
     * @author Рыбалкин Андрей
     * @version 1.1
     * В интерфейсе Functionable созданы абстрактные методы:
     */

    /** 1. add - добавление элемента в конец масиива.
     * @see ARArray#add(Object)
     */
    boolean add(E e); // 1. добавить элемент
    /** 2. addToIndex - добавление элемента по индексу.
     * @see ARArray#addToIndex(int, Object)
     */
    boolean addToIndex(int index, E e); // 2. добавить элемент по индексу (не заменить)
    /** 3. get - получить значение лемента по индексу.
     * @see ARArray#get(int)
     */
    E get(int index); // 3. получить элемент
    /** 4. delete - удаление лемента по индексу.
     * @see ARArray#delete(int)
     */
    void delete(int index); // 4. удалить элемент
    /** 5. clear - очистка всего массива (коллекции).
     * @see ARArray#clear()
     */
    void clear();           // 5. очистить всю коллекцию
    /** 6. sort - сортировка массива (коллекции).
     * @see ARArray#sort()
     */
    void sort();       // 6. отсортировать
    /** 7. update - замена элемента по индексу.
     * @see ARArray#update(int, Object)
     */
    void update(int index, E e); // 7. Заменить элемент по индексу
    /** 8. size - размер массива (коллекции).
     * @see ARArray#size()
     */
    int size();
}