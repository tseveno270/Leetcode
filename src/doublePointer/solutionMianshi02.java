package doublePointer;

import Sword_offer2.ListNode;

class solutionMianshi02 {

    public class Solutionms02 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = new ListNode(0, headA);
            ListNode b = new ListNode(0, headB);
            ListNode temp = b;
            int flag = 0;
            if (a.next == null || b.next == null) {
                return null;
            }
            while (a.next != null) {
                if (a.next == b.next) {
                    flag = 1;
                    break;
                }
                b = b.next;
                if (b.next == null) {
                    b = temp;
                    a = a.next;
                }
            }
            return flag == 0 ? null : a.next;
        }
    }
}
