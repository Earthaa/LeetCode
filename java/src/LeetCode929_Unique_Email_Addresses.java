import java.util.*;
public class LeetCode929_Unique_Email_Addresses {
    public int numUniqueEmails(String[] emails) {
        Map<String,Integer> uniqueEmails = new HashMap<>();
        for(int i = 0; i < emails.length; i++){
            String firstPart = "";
            int index = 0;
            boolean flag = false;
            while(emails[i].charAt(index) != '@'){
                if(emails[i].charAt(index) == '+')
                    flag = true;
                if(flag != true && emails[i].charAt(index) != '.')
                    firstPart += emails[i].charAt(index);
                index++;
            }
            String secondPart = "";
            if(index + 1 < emails[i].length())
                secondPart = emails[i].substring(index + 1);
            String unique = firstPart + secondPart;
            if(!uniqueEmails.containsKey(unique))
                uniqueEmails.put(unique,1);
        }
        return uniqueEmails.size();
    }
}
