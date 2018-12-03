import java.util.*;

public class TopKFrequentWords {
    private class wordFreq{
        String word;
        int Freq;
        wordFreq(String w,int f){
            this.word = w;
            this.Freq = f;
        }
    }
    private class wordFreqComparator implements Comparator<wordFreq> {
        public int compare(wordFreq a, wordFreq b){
            if(a.Freq == b.Freq)
                return a.word.compareTo(b.word);
            return b.Freq - a.Freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> myMap = new HashMap<String,Integer>();
        for(String word:words){
            if(myMap.get(word) == null)
                myMap.put(word,1);
            else
                myMap.put(word,myMap.get(word) + 1);
        }
        PriorityQueue<wordFreq> wordHeap = new PriorityQueue<wordFreq>(new wordFreqComparator());
        Iterator<String> iter = myMap.keySet().iterator();
        while (iter.hasNext()){
            String str = iter.next();
            wordFreq wf = new wordFreq(str,myMap.get(str));
            wordHeap.add(wf);
        }
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < k; i++)
            res.add(wordHeap.poll().word);
        return res;
    }
}
