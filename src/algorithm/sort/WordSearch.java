package algorithm.sort;
/*[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.*/

public class WordSearch {
	
	    
    	int row;
		int col;
    public boolean exist(char[][] board, String word) {
   	     row = board.length;
		 col = board[0].length;
    
	
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (dfs(board, word, 0, i, j, visited))
					return true;
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, String word, int index, int rowindex,
			int colindex, boolean[][] visited) {
		if (index == word.length())
			return true;
		if (rowindex < 0 || colindex < 0 || rowindex >= row || colindex >= col)
			return false;
		if (visited[rowindex][colindex])
			return false;
		if (board[rowindex][colindex] != word.charAt(index))
			return false;
		visited[rowindex][colindex] = true;
		boolean res = dfs(board, word, index + 1, rowindex - 1, colindex,
				visited)
				|| dfs(board, word, index + 1, rowindex + 1, colindex, visited)
				|| dfs(board, word, index + 1, rowindex, colindex + 1, visited)
				|| dfs(board, word, index + 1, rowindex, colindex - 1, visited);
		visited[rowindex][colindex] = false;
		return res;
   
    }
}

