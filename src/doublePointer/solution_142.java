package doublePointer;

import Sword_offer2.ListNode;

public class solution_142 {
}

 class Solution {
     /**
      *
      * @param head
      * @return
      */
    public ListNode detectCycle(ListNode head) {
        //不能构成环
        if (head==null||head.next==null){return null;}
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            //当两者相遇时说明忧环，因为fast比slow先进环，所以fast一定多遍历了n圈
            //假设fast走了f，slow走了s。f=2s
            //假设链表长度为a+b，环形长度为b。fast一定多遍历了n圈，f=s+nb
            //那么f = 2nb；s=nb
            //现在只需要求出a即可。从head走a步到环起点，而且f=2nb，所以f再走a步也能到环起点
            //所以当f和head一直向前一步一步走，相等时即为环形入口
            if (fast==slow){
                ListNode temp = head;
                while (fast!=temp){
                    fast = fast.next;
                    temp = temp.next;
                }
                return temp;
            }
        }
        return null;
    }

     public ListNode detectCycle2(ListNode head) {
     if (head==null||head.next==null){
         return null;
     }
     ListNode fast = head;
     ListNode slow = head;
     while(fast!=null&&fast.next!=null){
         fast = fast.next.next;
         slow = slow.next;
         if (fast==slow){
             ListNode temp = head;
             while (fast!=temp){
                 fast = fast.next;
                 temp = temp.next;
             }
             return temp;
         }
     }
     return null;
     }
}
