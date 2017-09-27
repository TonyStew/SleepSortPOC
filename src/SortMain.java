import java.util.ArrayList;

public class SortMain {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(5);
        list.add(2);
        list.add(10);

        System.out.println(list);
        System.out.println(new Sorter<Integer>().insertionSort(list));
    }
}
