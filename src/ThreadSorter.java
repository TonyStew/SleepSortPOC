import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadSorter<T extends Number>{ //I used generics so that this class works with floats, longs, etc on top of ints
    private ArrayList<T> list;

    public ThreadSorter(){ list = new ArrayList<>(); }

    synchronized Collection<T> sort(Collection<T> inputList){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(inputList.size());
        for(T t: inputList) {
            executorService.schedule(() -> list.add(t), t.longValue() * 100, TimeUnit.MICROSECONDS); //using microseconds with a 100 times multiple is 10 time faster than milliseconds
        }                                                                                                 //any faster than this and you start to have concurrent variable modification errors and other dumb thread stuff
        while(true){
            if(list.size() == inputList.size()) return list;
        }
    }
}
