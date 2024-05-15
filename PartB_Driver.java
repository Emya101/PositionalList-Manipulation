/**emhenya  Supreme 3132969
 * The PartB_Driver class contains a main method to test the methods defined in the ArrayPositionalList class.
 * It also includes methods to remove consecutive duplicates from a positional list and perform insertion sort on a list of characters.
 */
public class ListDriver {

    /**
     * The main method initializes a positional list, adds elements to it, and tests the methods to remove consecutive duplicates
     * and perform insertion sort.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        System.out.println("Original positional list:");
        ArrayPositionalList<String> set1 = new ArrayPositionalList<>();
        Position<String> positionHarry = set1.addFirst("harry");
        Position<String> positionRon = set1.addAfter(positionHarry, "ron");
        Position<String> positionTom1 = set1.addAfter(positionRon, "tom");
        Position<String> positionTom2 = set1.addBefore(positionTom1, "tom");
        Position<String> positionTom3 = set1.addAfter(positionTom2, "tom");
        set1.set(positionTom3, "tom");
        set1.addLast("hermione");

        System.out.println(set1);
        int removed = removeConsecutiveDuplicates(set1);
        System.out.println("\nNumber of entries after call: " + removed + "\n");
        System.out.println("List with duplicates removed:\n" + set1 + "\n");

        ArrayPositionalList<Character> list = new ArrayPositionalList<>();
        list.addLast('S');
        list.addLast('C');
        list.addLast('R');
        list.addLast('A');
        list.addLast('M');
        list.addLast('B');
        list.addLast('L');
        list.addLast('E');
        list.addLast('G');
        list.addLast('A');
        list.addLast('M');
        list.addLast('E');
        insertionSort(list);
        System.out.println("Sorted characters using Insertion sort algorithm:\n" + list);
    }

    /**
     * Removes consecutive duplicates from the given positional list.
     *
     * @param list The positional list from which consecutive duplicates will be removed.
     * @return The number of entries in the list after removing consecutive duplicates.
     */
    public static int removeConsecutiveDuplicates(ArrayPositionalList<String> list) {
        Position<String> current = list.first();
        while (current != null) {
            Position<String> next = list.after(current);
            if (next != null && current.getElement().equals(next.getElement())) {
                list.remove(next);
            } else {
                current = next;
            }
        }
        return list.size();
    }

    /**
     * Sorts the given positional list of characters using the insertion sort algorithm.
     *
     * @param list The positional list of characters to be sorted.
     */
    public static void insertionSort(ArrayPositionalList<Character> list) {
        Position<Character> current = list.first();
        while (current != list.last()) {
            Position<Character> key = list.after(current);
            char unit = key.getElement();
            if (unit > current.getElement()) {
                current = key;
            } else {
                Position<Character> progress = current;
                while (progress != list.first() && list.before(progress).getElement() > unit) {
                    progress = list.before(progress);
                }
                list.remove(key);
                list.addBefore(progress, unit);
            }
        }
    }
}
