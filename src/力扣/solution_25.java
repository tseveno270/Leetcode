package 力扣;

class Solution25 {
    /**
     * 递归调用反转链表方法
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        for (int i = 1; i <= len / k; i++) {
            head = reverseBetween(head, (i - 1) * k + 1, i * k);
        }
        return head;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;
        int i = 1;
        for (;i < left; i++) {
            slow = slow.next;
            fast = fast.next;
        }
        for (; i < right; i++) {
            ListNode temp = fast.next;
            fast.next = fast.next.next;
            temp.next = slow.next;
            slow.next = temp;

        }
        return dummy.next;
    }
}
