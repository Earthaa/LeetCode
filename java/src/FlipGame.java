import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.String;
public class FlipGame {
    public boolean canWin(String s) {
        if(s == null || s.isEmpty()) return false;
        Map<String, Boolean> map = new HashMap<>();
        return dfs(s, map);
    }
    private boolean dfs(String s, Map<String, Boolean> map) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        char[] ch = s.toCharArray();
        boolean canWin = false;
        for(int i = 0; i<ch.length - 1; i++) {
            if(ch[i] == ch[i + 1] && ch[i] == '+') {
                ch[i] = '-';
                ch[i + 1] = '-';
                canWin |= !dfs(String.valueOf(ch), map);
                if(canWin) {
                    break;
                }
                ch[i] = '+';
                ch[i + 1] = '+';
            }
        }
        map.put(s, canWin);
        return canWin;
    }
}
