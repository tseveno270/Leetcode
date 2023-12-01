package 力扣;

class Solution143 {
    /**
     * 找到中序节点，然后合并前半部分 和 后半部分的反转
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head==null||head.next==null){return;}
        ListNode mid  = midNode(head);
        ListNode reverseHead = mid.next;
        mid.next = null;
        ListNode reverseNewHead = reverse(reverseHead);
        merge(head,reverseNewHead);
    }

    private void merge(ListNode l1, ListNode l2) {
      while (l1!=null&&l2!=null){
          ListNode temp1 = l1.next;
          ListNode temp2 = l2.next;
          l1.next = l2;
          l1 = temp1;
          l2.next = l1;
          l2 = temp2;
      }
    }

    private ListNode reverse(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;
        while (fast!=null){
            ListNode temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }
        return slow;
    }

    private ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
