package Design;
import java.util.*;
class LFUCache{
    HashMap<Integer,Integer> cache;
    HashMap<Integer,Integer> count;
    HashMap<Integer,LinkedHashSet<Integer>> listCount;
    int capacity = 0;
    int minCount = 1;//保存目前最小频率
    LFUCache(int val){
        this.capacity = val;
        cache = new HashMap<>();//保存键值
        count = new HashMap<>();//保存count，对应key -count
        listCount = new HashMap<>();//保存对应的count所包括的key，与count相对
    }

    public void put(int key, int val){
        if(capacity <= 0)
            return;

        if(this.cache.containsKey(key)){
            this.cache.put(key,val);
            get(key);//如果重复, put相同的key
            return;
        }
        else if(this.cache.size() >= this.capacity){

            int removeKey = listCount.get(this.minCount).iterator().next();
            this.cache.remove(removeKey);

            listCount.get(this.minCount).remove(removeKey);
        }

        this.cache.put(key,val);
        this.count.put(key,1);
        this.minCount = 1;
        if(!this.listCount.containsKey(this.minCount)){
            LinkedHashSet<Integer> ls = new LinkedHashSet<>();
            this.listCount.put(this.minCount,ls);
        }
        this.listCount.get(this.minCount).add(key);

    }

    public int get(int key){
        if(capacity <=0 || !this.cache.containsKey(key))
            return -1;

        int con = this.count.get(key);
        this.count.put(key,con+1);
        this.listCount.get(con).remove(key);
        if(con == this.minCount && this.listCount.get(con).size()==0)//如果最小频率对应的list中一个元素都没有，则更新最小频率
            this.minCount++;
        if(!this.listCount.containsKey(con+1)){
            this.listCount.put(con+1,new LinkedHashSet<Integer>());
        }

        this.listCount.get(con+1).add(key);
        return this.cache.get(key);
    }
}
