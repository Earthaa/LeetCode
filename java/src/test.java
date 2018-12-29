import Design.LRUCache;

public class test {
    public static void main(String[] args)
    {
        LRUCache t = new LRUCache(2);
        t.put(1,1);
        t.put(2,2);
        System.out.println(t.get(1));
        t.put(3,3);
        System.out.println(t.get(2));
        System.out.println(t.get(3));

        t.put(4,4);
        System.out.println(t.get(1));
        System.out.println(t.get(3));

        System.out.println(t.get(4));


    }
}
