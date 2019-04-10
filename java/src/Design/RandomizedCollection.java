package Design;
import java.util.*;

class RandomizedCollection {
    int size = 0;
    Map<Integer,LinkedHashSet<Integer>> set;
    ArrayList<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.size = 0;
        this.set = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean flag = ! this.set.containsKey(val);
        if(flag){
            LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
            lhs.add(this.size);
            this.set.put(val,lhs);
        }
        else{
            set.get(val).add(size);
        }
        if(size == this.list.size())
            this.list.add(val);
        else
            this.list.set(size,val);
        // System.out.println("Insert: " + Integer.toString(val));
        //  for(int i = 0; i <= size; i++)
        //     System.out.println(list.get(i));
        this.size++;
        return flag;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        //关键点在于讨论array中最后一个数是否与val相等
        if(!this.set.containsKey(val))
            return false;
        LinkedHashSet<Integer> lhs = set.get(val);
        int index = lhs.iterator().next();
        int lastVal = this.list.get(size - 1);
        if(val != lastVal || index != size - 1){
            this.list.set(index,lastVal);
            LinkedHashSet<Integer> lastlhs = set.get(lastVal);
            lhs.remove(index);
            lastlhs.remove(size - 1);
            lastlhs.add(index);
        }
        else{
            lhs.remove(size - 1);
        }

        if(lhs.size() == 0)
            this.set.remove(val);

        size--;
        // System.out.println("Remove: " + Integer.toString(val));
        // for(int i = 0; i < size; i++)
        //    System.out.println(list.get(i));
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Random random = new Random();
        //System.out.println(size);

        return this.list.get((int)(Math.random() * (size)));
    }
}