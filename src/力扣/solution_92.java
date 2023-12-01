package 力扣;

class Solution92 {
    ListNode succesor = null;
    /**
     * 头插法
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;
        int i;
        //将slow和fast移动到left-1和left两个位置上
        for (i = 1; i < left; i++) {
            slow = slow.next;
            fast = fast.next;
        }
        //头插法翻转链表
        for (; i < right; i++) {
            //删除节点
            ListNode temp = fast.next;
            fast.next = fast.next.next;
            //将删除的节点作为头节点添加
            temp.next = slow.next;
            slow.next = temp;
        }
        return dummy.next;
    }
    public ListNode reverseBetween1(ListNode head, int left, int right) {
       if (left==1){
           return reverseN(head,right);
       }
       head.next = reverseBetween1(head.next,left-1,right-1);
       return head;

    }
    public ListNode reverseN(ListNode head, int n){
        if (n==1){
            //记录第n+1个节点
            succesor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = succesor;
        return last;
    }
}
