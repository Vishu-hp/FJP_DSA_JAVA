// https://leetcode.com/problems/sudoku-solver/description/

class Solution {
    public boolean isValid(char[][] board, int r,int c,char ch){
        // row
        for(int i=0;i<board.length;i++){
            if(board[r][i] == ch){
                return false;
            }
        }

        // column
        for(int i=0;i<board.length;i++){
            if(board[i][c] == ch){
                return false;
            }
        }

        // submatrix 3*3
        r = (r/3)*3;
        c = (c/3)*3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[r+i][c+j] == ch){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve(char[][] board, int r, int c){
        if(r == board.length){
            return true;
        }

        int nr=0, nc=0;

        if(c == board[0].length-1){
            nr = r+1;
            nc = 0;
        }
        else{
            nr = r;
            nc = c+1;
        }

        if(board[r][c] != '.'){
            if(solve(board,nr,nc)){
                return true;
            }
        }
        else{
            for(char v='1';v<='9';v++){
                if(isValid(board,r,c,v)){
                    board[r][c] = v;
                    if(solve(board,nr,nc)){
                        return true;
                    }
                    board[r][c] = '.';
                }
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0 ,0);
        return;
    }
}
