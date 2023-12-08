package 力扣;

import java.util.*;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月06日 15:13
 */
public class solution_1222 {
    class Solution {
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            List<List<Integer>> list = new ArrayList<>();
            int[][] nums = new int[8][8];
            for (int i = 0; i < queens.length; i++) {
                nums[queens[i][0]][queens[i][1]] = 1;
            }
            int mk = king[0];
            int nk = king[1];
            for (int j = nk; j < 8; j++) {
                if (nums[mk][j] == 1) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(mk);
                    list1.add(j);
                    list.add(list1);
                    break;
                }
            }
            for (int j = nk; j >= 0; j--) {
                if (nums[mk][j] == 1) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(mk);
                    list1.add(j);
                    list.add(list1);
                    break;
                }
            }
            for (int i = mk; i >= 0; i--) {
                if (nums[i][nk] == 1) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(i);
                    list1.add(nk);
                    list.add(list1);
                    break;
                }
            }
            for (int i = mk; i < 8; i++) {
                if (nums[i][nk] == 1) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(i);
                    list1.add(nk);
                    list.add(list1);
                    break;
                }
            }
            while (mk < 8 && nk < 8) {
                if (nums[mk][nk] == 1) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(mk);
                    list1.add(nk);
                    list.add(list1);
                    break;
                }
                mk++;
                nk++;
            }
            mk = king[0];
            nk = king[1];
            while (mk >= 0 && nk >= 0) {
                if (nums[mk][nk] == 1) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(mk);
                    list1.add(nk);
                    list.add(list1);
                    break;
                }
                mk--;
                nk--;
            }
            mk = king[0];
            nk = king[1];
            while (mk >= 0 && nk < 8) {
                if (nums[mk][nk] == 1) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(mk);
                    list1.add(nk);
                    list.add(list1);
                    break;
                }
                mk--;
                nk++;
            }
            mk = king[0];
            nk = king[1];
            while (mk < 8 && nk >= 0) {
                if (nums[mk][nk] == 1) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(mk);
                    list1.add(nk);
                    list.add(list1);
                    break;
                }
                mk++;
                nk--;
            }
            return list;
        }

        public List<List<Integer>> queensAttacktheKing1(int[][] queens, int[] king) {
            List<List<Integer>> list = new ArrayList<>();
            boolean[][] board = new boolean[8][8];
            for (int[] queen : queens) {
                board[queen[0]][queen[1]] = true;
            }
            int[] directions = {-1, 0, 1};
            for (int dx : directions) {
                for (int dy : directions) {
                    if (dx == 0 && dy == 0) continue;
                    int x = king[0];
                    int y = king[1];
                    while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                        if (board[x][y]) {
                            list.add(Arrays.asList(x, y));
                            break;
                        }
                        x += dx;
                        y += dy;
                    }
                }
            }
            return list;
        }

    }
}


