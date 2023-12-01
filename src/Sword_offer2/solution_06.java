package Sword_offer2;

import java.util.Stack;

public class solution_06 {
}
class Solution06 {
    /**
     * 将链表存入栈中，然后先进后出，依次pop栈作为数组元素即可
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }
}
