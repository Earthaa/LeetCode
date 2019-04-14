import java.util.*;
public class LeetCode394_Decode_String {
    public String decodeString(String s) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) <='0' || s.charAt(i) >= '9')
                sb.append(s.charAt(i));
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                StringBuffer numS = new StringBuffer();
                while(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    numS.append(s.charAt(i));
                    i++;
                }
                int num = Integer.parseInt(numS.toString());
                //System.out.println(num);

                Stack<Integer> st = new Stack<>();
                int start = i;
                st.push(i);
                while(!st.isEmpty()){
                    i++;
                    if(s.charAt(i) == '[')
                        st.push(i);
                    else if(s.charAt(i) == ']')
                        st.pop();

                }

                String str = decodeString(s.substring(start + 1,i));
                for(int time = 1; time <= num; time++)
                    sb.append(str);
            }
            i++;
        }
        return sb.toString();
    }
}
