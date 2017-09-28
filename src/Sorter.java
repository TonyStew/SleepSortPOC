import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Sorter<T extends Number>{ //I used generics so that this class works with floats, longs, etc on top of ints
    private ArrayList<T> list;         //it would have been implements comparable rather than extends number but that does not work for certain sorts like sleep sort

    public Sorter(){ list = new ArrayList<>(); }

    public Collection<T> sleepSort(Collection<T> inputList){ return sleepSort(inputList, 100); }

    public synchronized Collection<T> sleepSort(Collection<T> inputList, int precision){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(inputList.size());
        for(T t: inputList) {
            executorService.schedule(() -> list.add(t), t.longValue() * precision, TimeUnit.MICROSECONDS); //using microseconds with a 100 times multiple is 10 time faster than milliseconds
        }                                                                                                 //any faster than this and you start to have concurrent variable modification errors and other dumb thread stuff
        while(true){
            if(list.size() == inputList.size()) return list;
        }
    }

    public ArrayList<T> bubbleSort(ArrayList<T> inputList){
        for(int i = 0; i < inputList.size(); i++){
            for(int j = i; j > 0; j--){
                if(inputList.get(j).doubleValue() < inputList.get(j - 1).doubleValue()){
                    T t = inputList.get(j);
                    inputList.set(j, inputList.get(j - 1));
                    inputList.set(j-1, t);
                }
            }
        }
        return inputList;
    }

    public ArrayList<T> insertionSort(ArrayList<T> inputList){
        for(int i = 1; i < inputList.size(); i++){
            T t = inputList.get(i);
            int j;
            for(j = i - 1; j >= 0 && t.doubleValue() < inputList.get(j).doubleValue(); j--){
                inputList.set(j + 1, inputList.get(j));
            }
            inputList.set(j + 1, t);
        }
        return inputList;
    }

    public ArrayList<T> bogoSort(ArrayList<T> inputList){
        while(!sorted(inputList)){
            Collections.shuffle(inputList);
        }
        return inputList;
    }

    public boolean sorted(ArrayList<T> inputList){
        for(int i = 0; i < inputList.size() - 1; i++){
            if(inputList.get(i).doubleValue() > inputList.get(i + 1).doubleValue()) return false;
        }
        return true;
    }

    public ArrayList<T> shellSort(ArrayList<T> inputList) {
        for(int i = inputList.size()/2; i > 0; i/=2){
            for(int j = i; j < inputList.size(); j++){
                T t = inputList.get(j);
                int k;
                for(k = j; k >= i && inputList.get(k -1).doubleValue() > t.doubleValue(); k -= i){
                    inputList.set(k, inputList.get(k - i));
                }
                inputList.set(k, t);
            }
        }
        return inputList;
    }

    public ArrayList<T> gnomeSort(ArrayList<T> inputList){
        int i = 1, j = 2;
        while(i < inputList.size()){
            if(inputList.get(i -1).doubleValue() <= inputList.get(i).doubleValue()) i = j++;
            else{
                T t = inputList.get(i - 1);
                inputList.set(i - 1, inputList.get(i));
                inputList.set(i--, t);
                i = i == 0 ? j++ : i;
            }
        }
        return inputList;
    }

//    public ArrayList<Integer> radixSort(ArrayList<Integer> inputList) { //unfortunately bitwise operators only work on ints so I cannot use generics without a lot of work
//        for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
//            ArrayList<Integer> tmp = new ArrayList<>();
//            int j = 0;
//            for (int i = 0; i < inputList.size(); i++) {
//                boolean move = inputList.set(i, inputList.get(i) << shift) >= 0;
//                if (shift == 0 ? !move : move) {
//                    tmp.add(j, inputList.get(i));
//                    j++;
//                } else inputList.set(i - j, inputList.get(i));
//            }
//            for (int i = j; i < tmp.size(); i++) {
//                tmp.set(i, inputList.get(i - j));
//            }
//            inputList = tmp;
//        }
//        return inputList;
//    }
}
