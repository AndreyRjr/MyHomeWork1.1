public class Main {
    /**
     * @author Рыбалкин Андрей
     * @version 1.1
     */
    public static void main(String[] args) {
        /**
         * ArrayList showFunctions показывает список реализованных методов
         */
        ARArray<String> showFunctions = new ARArray<>();
        /**
         * Реализованные методы add, addToIndex, get, delete, clear, sort, update описаны в
         * @see ARArray
         */
        showFunctions.add("");
        showFunctions.addToIndex(0, "");
        showFunctions.get(0);
        showFunctions.delete(0);
        showFunctions.clear();
        showFunctions.sort();
        showFunctions.update(0, "");
    }
}