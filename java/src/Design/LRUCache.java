package Design;
import java.util.*;
public class LRUCache {
    class Node{
        Node prev = null;
        Node next = null;
        int val = 0;
        int key = 0;
        Node(int k ,int v){
            this.key = k;
            this.val = v;
        }
    }
    int capacity;
    Node start;
    Node end;
    Map<Integer,Node> myMap;
    int total;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.start = null;
        this.end = null;
        this.myMap = new HashMap<>();
        this.total = 0;
    }
    private void swimNode(Node resNode){
        if(resNode.prev != null)
            resNode.prev.next = resNode.next;
        if(resNode.next != null)
            resNode.next.prev = resNode.prev;
        if(end == resNode)
            end = resNode.prev;
        resNode.next = start;
        resNode.prev = null;
        start.prev = resNode;
        start = resNode;
    }
    public int get(int key) {
        if(!myMap.containsKey(key))
            return -1;
        Node resNode = myMap.get(key);
        if(resNode != start)
            swimNode(resNode);
        return resNode.val;
    }

    public void put(int key, int value) {
        if(myMap.containsKey(key)){
            Node resNode = myMap.get(key);
            if(resNode != start)
                swimNode(resNode);
            resNode.val = value;
            myMap.put(key,resNode);
        }
        else if (total == 0){
            total++;
            Node newNode = new Node(key,value);
            start = newNode;
            end =start;
            myMap.put(key,newNode);
        }
        else if(total < capacity){
            total++;
            Node newNode = new Node(key,value);
            newNode.next = start;
            start.prev = newNode;
            start = newNode;
            myMap.put(key,newNode);
        }
        else if(total == capacity){
            Node newNode = new Node(key,value);
            newNode.next = start;
            start.prev = newNode;
            start = newNode;
            myMap.put(key,newNode);
            int endKey = end.key;
            end = end.prev;
            end.next = null;
            myMap.remove(endKey);

        }
    }
}
