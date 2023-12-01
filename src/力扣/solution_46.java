import java.util.ArrayList;
import java.util.List;

public class solution_46 {
}
class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        //长度
        int len = nums.length;
        //返回值
        List<List<Integer>> res = new ArrayList<>();
        //代表集合中的排列变量
        List<Integer> path = new ArrayList<>();
        //表示当前path中各个元素是否已经在排列中
        boolean[] used = new boolean[nums.length];
        //depth表示path的长度
        dfs(nums,0,len,res,path,used);
        return res;

    }
    private void dfs(int[] nums,int depth,int len,List<List<Integer>> res,List<Integer> path,boolean[] used){
        //每次遍历先判断，如果长度等于len说明找到一个排列，加入res中并返回上一层遍历
        if (depth==len){
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < len; i++) {
            //遍历数组下标，如果当前元素没有在path中，说明可以添加到当前排列中

            if (!used[i]){
                path.add(nums[i]);
                used[i] =true;
                //添加当前元素后继续dfs调用下一个元素
                dfs(nums,depth+1,len,res,path,used);
                //当结束递归后说明以当前元素为结尾的排列已经全部加入res中，所以将当前元素从path中删除，for循环向下进行
                path.remove(path.size()-1);
                used[i] = false;
            }
        }
    }

}
