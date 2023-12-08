package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月02日 16:49
 */
public class solution_999 {
    public int numRookCaptures(char[][] board) {
        int rm = 0;
        int rn = 0;
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]== 'R'){
                    rm = i;
                    rn = j;
                }
            }
        }
        for (int j = rn; j < board[0].length; j++) {
            if (board[rm][j] == 'p'){
                res++;
                break;
            }else if (board[rm][j] == 'B'){
                break;
            }
        }
        for (int j = rn; j >=0; j--) {
            if (board[rm][j] == 'p'){
                res++;
                break;
            }else if (board[rm][j] == 'B'){
                break;
            }
        }
        for (int i = rm; i < board.length; i++) {
            if (board[i][rn] == 'p'){
                res++;
                break;
            }else if (board[i][rn] == 'B'){
                break;
            }
        }
        for (int i = rm; i >= 0; i--) {
            if (board[i][rn] == 'p'){
                res++;
                break;
            }else if (board[i][rn] == 'B'){
                break;
            }
        }
        return res;
    }
}
