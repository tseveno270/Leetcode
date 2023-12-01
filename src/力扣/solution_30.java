import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 270
 */
public class solution_30{
    public static void main(String[] args) {
    }

}
class Solution30 {
    /**
     * 采用滑动窗口
     *      1.先将words数组中的单词和出现次数存入HashMap，构建HashMap：words_map
     *        构建List<Integer>res,用于存放结果
     * 双循环
     *      2.
     *      外循环
     *              遍历字符串s，每次取出 words所有单词长度之和的子字符串tmp
     *              每次外循环都构建与words_map相同的临时HashMap：res_map，
     *              i从零开始，滑动窗口长度为所有单词长度allWords_size,所以限制条件为
     *              i<s.length()-allWords_size+1;
     *      内循环
     *              在子字符串tmp中遍历，一次取出一个words元素的长度
     *              循环下标j每次增加j+=word_size;
     *              若res_map中含有包含此Key，贼将其对应的Value--
     *              遍历结束后如果res_map长度为零，说明子字符串符合条件
     *              则res++
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        //当s为空||长度为零||words长度为零||words为空，返回空集合
        if (s==null||"".equals(s)||words==null||words.length==0){
            return new ArrayList<Integer>();
        }
        //1.将words中出现的所有单词及出现次数记录到HashMap中
        Map<String,Integer> words_map = new HashMap<String,Integer>();
        for (String word:words){
           if (words_map.containsKey(word)){
               words_map.put(word,words_map.get(word)+1);
           }else{
               words_map.put(word,1);
           }
        }
        List<Integer> res = new ArrayList<Integer>();
        //2.双循环
        int word_size = words[0].length();
        int word_nums = words.length;
        int allWord_size = word_size*word_nums;
        for (int i = 0;i<s.length()-allWord_size+1;i++){
            String tmp = s.substring(i,i+allWord_size);
            HashMap<String,Integer> res_map = new HashMap<String,Integer>(words_map);
            for(int j=0;j<tmp.length();j+=word_size){
                String str = tmp.substring(j,j+word_size);
                if (res_map.containsKey(str)){
                    res_map.put(str,res_map.get(str)-1);
                    if (res_map.get(str)==0){
                        res_map.remove(str);
                    }
                    }else{
                    break;
                }
            }
            if (res_map.size()==0) {
                res.add(i);
            }
        }
        return res;
    }
}
