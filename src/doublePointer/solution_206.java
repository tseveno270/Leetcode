package doublePointer;

import Sword_offer2.ListNode;

public class solution_206 {
}
class Solution206 {
    /**
     * 从前向后遍历，每个节点都插在反转后链表头节点后面reverseHead.next = 新节点
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
       if(head==null||head.next==null){
           return head;
       }
       ListNode slow = null;
       ListNode fast = head;
       ListNode temp = null;
       while (fast!=null){
           temp = fast.next;
           fast.next = slow;
           slow = fast;
           fast = temp;
       }
       return slow;
    }
}
