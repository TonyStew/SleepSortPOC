import java.util.ArrayList;

public class SortMain {

    public static void main(String[] args){
        ArrayList<Double> list = new ArrayList<>();
        list.add(5.2);
        list.add(5.1);
        list.add(6.0);
        list.add(10.6);

        System.out.println(list);
        System.out.println(new Sorter<Double>().sleepSort(list));
    }
}
