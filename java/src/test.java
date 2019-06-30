import Design.LRUCache;
import java.util.*;
public class test {
    public static void main(String[] args)
    {
       Value v1 = new Value(3);
       Value v2 = new Value(4);
       PriorityQueue<Value> pq = new PriorityQueue<>();
       pq.add(v1);
       pq.add(v2);
       v1.v +=5;
       pq.
       System.out.println(pq.peek().v);

    }
}
class Value implements Comparable<Value>{
    int v;
    Value(int v){
        this.v = v;

    }

    @Override
    public int compareTo(Value o) {
        return this.v - o.v;
    }
}