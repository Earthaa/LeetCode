package Design;
import java.util.*;
class RandomizedSet {

    //每次删除时，与最后一个index的元素进行交换，也可使用ArrayList
    /** Initialize your data structure here. */
    Map<Integer,Integer> valToInd;
    Map<Integer,Integer> indToVal;
    int total;
    public RandomizedSet() {
        valToInd = new HashMap<>();
        indToVal = new HashMap<>();
        total = 0;
        LinkedHashSet<Integer> t;
        t.it
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valToInd.containsKey(val))
            return false;
        total++;
        valToInd.put(val,total);
        indToVal.put(total,val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valToInd.containsKey(val))
            return false;
        int index = valToInd.get(val);
        int lastVal = indToVal.get(total);

        valToInd.put(lastVal,index);
        indToVal.put(index,lastVal);

        valToInd.remove(val);
        indToVal.remove(total);
        total--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(total) % (total - 1 + 1) + 1;

        return indToVal.get(index);
    }
}