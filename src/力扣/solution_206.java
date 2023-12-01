package 力扣;


/**
 * 反转链表，只需要把相邻两个节点的顺序反转，用双指针迭代
 */
class Solution206 {
    public ListNode reverseList(ListNode head) {
        /**
         * slow 在循环过程中充当新链表的头部，由于反转链表的过程是通过改变节点的指针方向来实现的。
         * 所以在每一步迭代中，当前的 fast 节点的 next 指向了前一个 slow 节点，从而形成了新链表的一部分。
         */
       ListNode slow  = null;
       ListNode fast = head;
       while (fast!=null){
           ListNode temp = fast.next;
           fast.next = slow;
           slow = fast;
           fast = temp;
       }
       return slow;
    }


}
