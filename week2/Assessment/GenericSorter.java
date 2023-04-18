import java.util.*;

public class GenericSorter<T extends Comparable<T>> {
    
    public void sort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[i]) < 0) {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Integer[] intArr = {5, 2, 8, 3, 1};
        GenericSorter<Integer> intSorter = new GenericSorter<>();
        intSorter.sort(intArr);
        System.out.println(Arrays.toString(intArr)); // prints [1, 2, 3, 5, 8]
        
        Double[] doubleArr = {3.2, 1.5, 6.8, 2.7, 4.1};
        GenericSorter<Double> doubleSorter = new GenericSorter<>();
        doubleSorter.sort(doubleArr);
        System.out.println(Arrays.toString(doubleArr)); // prints [1.5, 2.7, 3.2, 4.1, 6.8]
        
        Character[] charArr = {'b', 'd', 'a', 'c'};
        GenericSorter<Character> charSorter = new GenericSorter<>();
        charSorter.sort(charArr);
        System.out.println(Arrays.toString(charArr)); // prints [a, b, c, d]
    }
}
