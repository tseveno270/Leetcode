package 力扣;

/**
 * @author 270
 */
public class solution_19 {
    public static void main(String[] args) {

    }
}
class Solution19 {
    /**
     * 方法一：通过长度求
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
      ListNode dummy = new ListNode(-1,head);
      ListNode temp = dummy;
      ListNode pre = dummy;
      int len = 0;
      while (temp.next!=null){
          temp = temp.next;
          len++;
      }
        for (int i = 0; i < len-n; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    /**
     * 通过快慢指针求
     * 设定两个指针，快指针指向head
     *               慢支针指向哑指针(head的前一个)
     * 当快指针遍历到n时开始同时遍历两个指针
     * 当快指针遍历到链表结尾时，慢支针的next就是要删除的那个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head,int n){
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 1; i <=n; i++){
            first = first.next;
        }
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
