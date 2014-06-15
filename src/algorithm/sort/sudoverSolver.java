package algorithm.sort;
import java.util.ArrayList;



/*这道题的思路的比较直观，我们先把空着的格子统计出来放到一个ArrayList<int> 里面,
 *  然后开始运用dfs

首先每当填入一个数字的时候我们需要用isValid来验证，只有不冲突的情况下才能添加进格子里
dfs 函数返回值定义为boolean 
if(dfs(empty,board,cur+1,len))运行成功往上一层返回true，如果不成功, 
把刚填入的数字抹去再去试下一个数字，如果这一层的数字都不成功，返回false, 
跳回上一层进行修改，
最后如果cur==len 的时候所有格子都填完返回true，一路返回true上去完成任务*/

//几点注意的地方： 

//1. 验证小九宫格的时候，坐标为｛3*(row/3)+i/3 , 3*(col/3)+i%3｝

//2. char到int的转换 - '0'
public class sudoverSolver {

public class Solution {
    public void solveSudoku(char[][] board) {
        ArrayList<Integer> empty = new ArrayList<Integer>();
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(board[i][j]=='.'){
                    empty.add(i*9+j);
                }
        int len = empty.size();
        dfs(empty,board,0,len);
    }
    
    public boolean dfs(ArrayList<Integer> empty, char[][] board, int cur, int len){
        if(cur==len) return true;
        int index = empty.get(cur);
        int row = index/9;
        int col = index%9;
        for(int v=1;v<=9;v++){
            if(isValid(v,row,col,board)){
                board[row][col] = (char)(v+'0');
                if(dfs(empty,board,cur+1,len))
                    return true;
                board[row][col] = '.';
            }
        }
        return false;
    }
    
    public boolean isValid(int v, int row, int col, char[][] board){
        for(int i=0;i<9;i++){
            if(board[row][i] - '0'==v) return false;
            if(board[i][col] - '0'==v) return false;
            int row_s = 3*(row/3) + i/3;
            int col_s = 3*(col/3) + i%3;
            if(board[row_s][col_s] - '0'==v) return false;
        }
        return true;
    }
}
}