package Sword_offer2;

import java.util.HashMap;

public class solution_07 {
}
class Solution07{
    /**
     * 全局变量preorder
     * HashMap存放中序遍历的元素和元素下标
     *  前序遍历的第一个元素为根节点
     *  找到根节点之后再中序遍历中找到根节点位置，前面为左子树，后面为右子树，构建关系。
     *  左子树，右子树递归。直到双指针的left>right(说明递归结束)
     */
    int[] preorder;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder){
            this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return recursion(0,0,inorder.length-1);
        }

    private TreeNode recursion(int root, int left, int right){
        if (left>right){
            //结束递归
            return null;

        }
        //根节点
        TreeNode node = new TreeNode(preorder[root]);
        //根节点在中序遍历的下标，下标大小为左子树长度
        int i = map.get(preorder[root]);
        //左子树递归,根节点为前序遍历的根节点后一个。中序遍历的左边界不变，右边界为中序遍历的根节点前一个
        node.left = recursion(root+1,left,i-1);
        //右子树递归，根节点为：根节点索引(root)+左子树长度(i-left)+1(前序遍历中：根节点+左子树后的索引为右子树，右子树也是前序遍历)
        node.right = recursion(i-left+root+1,i+1,right);
        return node;


    }
}

