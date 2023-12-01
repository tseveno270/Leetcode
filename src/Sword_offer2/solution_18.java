package Sword_offer2;

public class solution_18 {
}
class Solution18 {
    /**
     * 单指针，指针指向头节点
     *  while循环条件为next不为空且值不为要删除的节点值。
     *  跳出循环后指针的next指向要删除的节点
     *  执行 cur.next=cur.next.next;删除节点操作
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null){return null;}
        if (head.val==val){return head.next;}
        ListNode cur = head;
        while(cur.next!=null&&cur.next.val!=val){
            cur = cur.next;
        }
        if (cur.next!=null){
            cur.next=cur.next.next;
        }
        return head;
    }
}
