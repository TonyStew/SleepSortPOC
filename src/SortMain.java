import java.util.ArrayList;
import java.util.Arrays;

public class SortMain {

    public static void main(String[] args){
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(23, 5, 2, 10, -12));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(134, 6634, -2957, 568470, 4, 254, 11432, -436, 86));
        ArrayList<Double> list3 = new ArrayList<>(Arrays.asList(-23.0, 1.75, 0.000012822, 999.9999, 0.0000000000000000001, -45.5));
        ArrayList<Long> list4 = new ArrayList<>(Arrays.asList(999999999999999999l, 552l, 2l, 103l));
        ArrayList<Integer> list5 = new ArrayList<>(Arrays.asList(-4, -24, 735, 734 , 1, 6, 8, 45, 345, 2, 2, -9, -2345, -1, 5234, 2, 113, 654, 765, 84, 3, 23,45, 6345, 7));

//        System.out.println(list1);
//        System.out.println(new Sorter<Integer>().radixSort(list1));

        System.out.println(new Sorter<Integer>().sorted(new Sorter<Integer>().gnomeSort(list1))); //test cases
        System.out.println(new Sorter<Integer>().sorted(new Sorter<Integer>().gnomeSort(list2)));
        System.out.println(new Sorter<Double>().sorted(new Sorter<Double>().gnomeSort(list3)));
        System.out.println(new Sorter<Long>().sorted(new Sorter<Long>().gnomeSort(list4)));
        System.out.println(new Sorter<Integer>().sorted(new Sorter<Integer>().gnomeSort(list5)));
    }
}
