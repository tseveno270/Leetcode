package doublePointer;

import Sword_offer2.ListNode;

public class solution_19 {
}
class Solution19 {
    /**
     * 双指针，起始位置都是头节点
     * 要删除倒数第n个节点，只需要将n之前那个节点的next指向n的下一个节点
     * 那么只需要将指针指向n的前一个节点即可。
     * 设长度为s，那么n之前的节点就是第s-n个节点
     * 那么只需要将fast = n，slow = -1
     * 当fast遍历到s时，slow就遍历到s-n
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //使用res作为虚拟头节点，好处是删除实际头节点时避免太多逻辑错误
        ListNode res = new ListNode(0,head);
       ListNode fast = head;
       ListNode slow = res;
        for (int i = 1; i <=n; i++) {
            fast = fast.next;
        }
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        head = res.next;
        return head;
    }
}
