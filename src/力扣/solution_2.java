package 力扣;

public class solution_2 {
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null&&carry==0){return null;}
        else if (l1==null&&carry==0){return l2;}
        else if (l2==null&&carry==0){return l1;}
        int sum = (l1==null?0:l1.val)+(l2==null?0:l2.val)+carry;
        carry = sum/10;
        int value = sum%10;
        ListNode node = new ListNode(value);
        node.next = addTwoNumbers(l1==null?null:l1.next,l2==null?null:l2.next);
        return node;
    }
}
