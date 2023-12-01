package Sword_offer2;

class Solution203 {
    //添加虚拟头节点
    public ListNode removeElements(ListNode head, int val) {
     ListNode dummy = new ListNode(-1,head);
     ListNode slow = dummy;
     ListNode fast = head;
     while (fast!=null){
     if (fast.val==val){
         slow.next = fast.next;
     }else {
         slow = fast;
     }
     fast = fast.next;
     }
     return dummy.next;
    }
}
