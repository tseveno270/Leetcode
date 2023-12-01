package 力扣;
public class solution_23 {
    class Solution {
        /**
         * 因为都是有序的，可以运用分治思想，从中间开始递归调用merge方法，直到最后下标是相邻的
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists){return merge(lists,0, lists.length-1);}

        /**
         * 分治函数
         * @param lists
         * @param l
         * @param r
         * @return
         */
        public ListNode merge(ListNode[] lists, int l, int r) {
            //下标相同表示找到一个链表
            if (l==r){return lists[l];}
            if (l>r){return null;}
            int mid = (l+r)>>1;
            //这样一直调用merge方法直到边界下标相等返回一个list，根据这个方法可以将列表两两合并后再分别合并，即分治思想
            return mergeList(merge(lists,l,mid),merge(lists,mid+1,r));
        }

        /**
         * 递归合并
         * @param l1
         * @param l2
         * @return
         */
        private ListNode mergeList(ListNode l1, ListNode l2){
            if (l1==null){
                return l2;
            }else if (l2==null){
                return l1;
            }else if (l1.val< l2.val){
                l1.next = mergeList(l1.next,l2);
                return l1;
            }else {
                l2.next = mergeList(l2.next,l1);
                return l2;
            }
        }
        /**
         * 归并排序
         * @param a
         * @param b
         * @return
         */
        public ListNode mergeList2(ListNode a, ListNode b) {
            if (a==null||b==null){return a==null?b:a;}
            ListNode ap = a;
            ListNode bp = b;
            ListNode dummy = new ListNode(0);
            ListNode res = dummy;
            while (ap!=null&&bp!=null){
                if (ap.val>bp.val){
                    dummy.next = bp;
                    bp = bp.next;
                }else {
                    dummy.next = ap;
                    ap = ap.next;
                }
                dummy = dummy.next;
            }
            dummy.next = ap==null?bp:ap;
            return res.next;
        }

    }

}
