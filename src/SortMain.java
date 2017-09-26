import java.util.ArrayList;

public class SortMain {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(23);
        list.add(12);
        list.add(6);

        System.out.println(list);
        System.out.println(new ThreadSorter<Integer>().sort(list));
    }
}
