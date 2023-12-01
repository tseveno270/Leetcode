package 力扣;

import java.util.Arrays;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年11月10日 16:58
 */
public class solution_274 {
    class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int n = citations.length;
            int left = 0;
            int right = n-1;
            while (left<=right){
                int mid = left + (right-left)/2;
                if (citations[mid]>=n-mid){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            return n - left;
        }
    }
}
