import java.util.*;
public class TopKFrequentElements {
    private class wordFreq{
        int Element;
        int Freq;
        wordFreq(int w,int f){
            this.Element = w;
            this.Freq = f;
        }
    }
    private class wordFreqComparator implements Comparator<wordFreq> {
        public int compare(wordFreq a, wordFreq b){
            if(b.Freq == a.Freq)
                return b.Element - a.Element;
            return b.Freq - a.Freq;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> myMap = new HashMap<Integer,Integer>();
        for(Integer element:nums){
            if(myMap.get(element) == null)
                myMap.put(element,1);
            else
                myMap.put(element,myMap.get(element) + 1);
        }
        PriorityQueue<wordFreq> wordHeap = new PriorityQueue<wordFreq>(new wordFreqComparator());
        Iterator<Integer> iter = myMap.keySet().iterator();
        while (iter.hasNext()){
            Integer element = iter.next();
            wordFreq wf = new wordFreq(element,myMap.get(element));
            wordHeap.add(wf);
        }
        List<Integer> res = new LinkedList<Integer>();
        for(int i = 0; i < k; i++)
            res.add(wordHeap.poll().Element);
        return res;
    }
}
