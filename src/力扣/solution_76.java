import java.util.HashMap;
import java.util.Map;

public class solution_76 {
}
class Solution76 {
    public String minWindow(String s, String t) {
        //记录截取的s字符数量
        Map<Character, Integer> Smap = new HashMap<>();
        //记录t的字符数量
        Map<Character,Integer> Tmap = new HashMap<>();
        for (char c:
             t.toCharArray()) {
            //记录t的字符数量。如果之前没有就返回1，有的话加1
            Tmap.put(c,Tmap.getOrDefault(c,0)+1);
        }
        //total表示s截取字符串中与t数量相同的种类数
        int left = 0;
        int total = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            char Rchar = s.charAt(right);
            if (Tmap.containsKey(Rchar)){
                //如果Tmap存在Rchar,说明Rchar是最后需要的
                Smap.put(Rchar,Smap.getOrDefault(Rchar,0)+1);
                //这里是Integer引用类型，用equals来比较
                if (Tmap.get(Rchar).equals(Smap.get(Rchar))){
                    total++;
                }
            }
            while(total==Tmap.size()){
                //当找到符合子串时，与之前比较长度取短的
                if (len>right-left+1){
                    len = Math.min(len,right-left+1);
                    //记录当前最小子串的起点下标
                    start = left;
                }
                //只有当当前子串满足条件时才不断的右移左指针，缩小窗口
                char Lchar = s.charAt(left++);
                if (Tmap.containsKey(Lchar)){
                    //当相等时说明一旦再次右移左指针，当前Lchar代表的字符数将不相等
                    //当两者数量相等时，减少一个会使种类减1
                    if (Tmap.get(Lchar).equals(Smap.get(Lchar))){
                        total--;
                    }
                    //不论相等不想等都需要数量减1
                    Smap.put(Lchar,Smap.get(Lchar)-1);
            }
            }
        }
        return len == Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
