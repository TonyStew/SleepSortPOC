import java.util.ArrayList;
import java.util.Collection;
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

        return inputList;
    }
}
