import java.util.Stack;

public class LeetCode151_Reverse_Word_In_A_String {
    public int findStart(String s, int startFind){
        int res = -1;
        for(int i = startFind; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                res = i;
                break;
            }
        }
        return res;
    }

    public String reverseWords(String s) {
        if(s.length() == 0)
            return "";
        Stack<String> myStack = new Stack<String>();
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            start = findStart(s,start);
            if(start == -1)
                break;
            int end = start;
            while(end < s.length() && s.charAt(end) != ' '){
                end++;
            }
            myStack.push(s.substring(start,end));
            start = end;
        }
        StringBuffer res = new StringBuffer();
        while(!myStack.isEmpty()){
            res.append(myStack.pop() + " ");
        }
        return res.toString().trim();
    }
}
