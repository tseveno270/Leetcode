package 力扣;

public class solution_24 {
    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        ListNode l4 = new ListNode(4, null);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode head = new ListNode(1, l2);
        solution24.swapPairs2(head);
        System.out.println(head.val);

    }
}

class Solution24 {
    /**
     * 非递归
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode slow = temp.next;
            ListNode fast = temp.next.next;
            temp.next = fast;
            slow.next = fast.next;
            fast.next = slow;
            temp = slow;
        }
        return dummy.next;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = swapPairs2(temp.next);
        temp.next = head;
        return temp;
    }
}
