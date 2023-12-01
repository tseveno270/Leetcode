package 力扣;


/**
 * @author 270
 */
public class ListNode {
    /**
     * 参数
     */
    int val;
    ListNode next;

    /**
     * 无参构造
     * @return
     */
    ListNode() {}

    /**有参构造
     * @param val
     */
    ListNode(int val) {
        this.val = val;
    }

    /**有参构造
     * @param val
     * @param next
     */
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

