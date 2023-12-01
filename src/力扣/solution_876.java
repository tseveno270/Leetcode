package 力扣;
/**
 * @author 270
 */

class Solution876{
    /**
     *先确定链表长度，再根据长度的一半确定返回值
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head){
        ListNode start = head;
        ListNode end = head;
        int length  = 0;
        while (end!=null){
            end = end.next;
            length++;
        }
        for (int i = 0; i <length/2; i++) {
            start = start.next;
        }
      return start;
    }
}
