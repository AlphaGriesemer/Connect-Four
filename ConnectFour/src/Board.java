import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int NO_PLAYER = 0;
    public static final int PLAYER_R = 1;
    public static final int PLAYER_Y = 2;
    private int[][] board = new int[4][4];
    public boolean isGameOver(){
        return checkWin(PLAYER_R) || checkWin(PLAYER_Y) || getAvailableCells().isEmpty();
    }
    public List<List<Integer>> getAvailableCells(){
        List<List<Integer>> availableCells = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length ; j++) {
                if(board[i][j] == NO_PLAYER){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    availableCells.add(pair);
                }
            }
        }
        return availableCells;
    }
    public boolean checkWin(int player){
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == board[3][3] && board[0][0] == player){
            return true;
        }
        else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == board[0][3] && board[0][2] == player){
            return true;
        }

        for (int i = 0; i < 4 ; i++) {
            if((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == board[i][3] && board[i][0] == player)
                    ||
                    (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == board[3][i] && board[0][i] == player))
            {
                return true;
            }
        }
        return false;
    }
    public int getBoardLength(){
        return board.length;
    }
    public void displayBoard(){
        System.out.println("1234");
        int count = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 ; j++) {
                String value = String.valueOf(count);
                if(board[i][j] == PLAYER_R){
                    value = "R";
                }
                else if(board[i][j] == PLAYER_Y){
                    value = "Y";
                }
                else{
                    value = "_";
                }
                System.out.print(value);
                count++;

            }
            System.out.println();
        }
        System.out.println();
    }
    public boolean placeMove(int move, int player){
        int secondNum = getCellBasedOnMove(move);
        if(secondNum == 10){
            return false;
        }
        //System.out.println(secondNum);
        board[secondNum][move-1] = player;
        //System.out.println(board[move][secondNum]);
        return true;
    }
    private int getCellBasedOnMove(int move){
        int column = move-1;
        for (int row = board.length-1; row >= 0; row--) {
            if(board[row][column] == NO_PLAYER){
                System.out.println(row);
                System.out.println(column);
                return row;
            }
        }
        return 10;
    }

}
