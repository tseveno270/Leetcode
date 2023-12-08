package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月04日 8:28
 */
public class solution_1290 {
    public static void main(String[] args) {
        solution_1290 solution1290 = new solution_1290();
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(1);
        head.next = head1;
        head1.next = head2;
        solution1290.getDecimalValue(head);
    }
    public int getDecimalValue(ListNode head) {
        int length = 0;
        double res = 0;
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        temp = head;
        for (int i = 0; i < length; i++) {
            res+=Math.pow(2,length-i-1)*temp.val;
            temp = temp.next;
        }
        return (int)res;
    }
}
