package Sword_offer2;

public class solution_242 {
}
class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] sl = new int[26];
        int[] tl = new int[26];
        for (char c : s.toCharArray()){
            sl[c-'a'] += 1;
        }
        for (char c: t.toCharArray()){
            tl[c-'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (sl[i]!=tl[i]){
                return false;
            }
        }
        return true;
    }
}
