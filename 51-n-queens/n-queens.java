class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n == 1){
            List<List<String>> list = new ArrayList<>();
            list.add(Arrays.asList("Q"));
            return list;
        }

        if(n==2 || n==3){
            List<List<String>> list = new ArrayList<>();
            return list;
        }

        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i],'.');
        }

        backtrack(board, 0);
        return res;
    }

    private void backtrack(char[][] board, int row){
        if(row == board.length){
            List<String> list = new ArrayList<>();
            for(int i=0; i<board.length; i++){
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }

        for(int col=0; col<board[row].length; col++){
            if(issafe(board, row, col)){
                board[row][col] = 'Q';
                backtrack(board, row+1);
                board[row][col]='.';
            }
        }
    }

    private boolean issafe(char[][] board, int row, int col){
        //column:
        for(int i=0; i<row; i++){
            if(board[i][col] == 'Q')    return false;
        }

        //diagonal:
        for(int i=0; i<row; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == 'Q'){
                    if(Math.abs(row-i) == Math.abs(col-j))  
                        return false;
                }
            }
        }

        return true;    
    }
}