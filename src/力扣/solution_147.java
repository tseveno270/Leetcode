package 力扣;
class Solution147 {
    /**
     * 插入排序
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode dummyHead = new ListNode(0,head);
        ListNode lastSorted = head;
        ListNode cur = head.next;
        while (cur!=null){
            if (lastSorted.val<=cur.val){
                lastSorted = lastSorted.next;
            }else{
                ListNode pre = dummyHead;
                while (pre.next.val<=cur.val){
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummyHead.next;
    }

}

