package Sword_offer2;

import java.util.HashSet;
import java.util.Set;

public class solution_142 {
    /**
     * 双指针，快慢指针
     * fast速度是slow两倍，那么如果存在环，双指针一定相遇
     * 假设两个指针走过的距离分别问f、s，那么有f=2s
     * fast走过了n个环长才能与slow相遇
     * 设fast走过的路为f = s + nb
     * 双指针在环内相遇，所以一定是fast比slow多走了n圈
     * 则f = 2s = s + nb 。则 s = nb
     * 假设从入口到环起点要走共a步，那么a + nb代表环起点
     * 现在slow已经走了nb步，只需再走a步就走到环起点了
     * 所以再设一个指针temp指向虚拟头结点即可
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = new ListNode(0, head);
        ListNode slow = new ListNode(0, head);
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = new ListNode(0, head);
                while (fast != temp) {
                    temp = temp.next;
                    fast = fast.next;
                }
                return temp;
            }
        }
        return null;
    }

    /**
     * 哈希表，如果哈希表中存在当前遍历的节点，证明是环的开始节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode node = head;
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }
}
