package Sword_offer2;

import java.util.HashSet;
import java.util.Set;

public class solution_349 {
}
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resset = new HashSet<>();
        for (int i: nums1) {
            set.add(i);
        }
        for (int i:nums2) {
            if (set.contains(i)){
                resset.add(i);
            }
        }
        return resset.stream().mapToInt(x -> x).toArray();
    }
}
