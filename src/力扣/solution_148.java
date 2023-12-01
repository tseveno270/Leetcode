package 力扣;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null){return head;}
        ListNode mid = middleNode(head);
        ListNode cur = mid.next;
        mid.next = null;
        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(cur);
        return mergeTwoLists(leftNode,rightNode);
    }

    //  找到链表中间节点（876. 链表的中间结点）
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 合并两个有序链表（21. 合并两个有序链表）
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = null;
        ListNode cur = dummy;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = l1==null?l2:l1;
        return cur.next;
    }
}
