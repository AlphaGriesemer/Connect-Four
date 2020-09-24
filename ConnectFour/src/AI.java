import java.util.List;

public class AI extends Board{
    private int depth;
    public int minimax(int turn){
        depth = 0;
        if(checkWin(PLAYER_R)){
            return -10;
        }
        else if(checkWin(PLAYER_Y)){
            return 10;
        }

        List<List<Integer>> availableCells = getAvailableCells();

        if(availableCells.isEmpty()){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < getBoardLength() ; i++) {
            List<Integer> point = availableCells.get(i);
            if(turn == PLAYER_Y){
                placeMove((point.get(0) + 1), PLAYER_Y);
                int currentScore = minimax(PLAYER_R);
                max = Math.max(currentScore, max);

                if(currentScore >= 0){

                }
            }
        }




        while(depth!=6){

        }
        return 0;
    }
//    if Red wins
//        return score 10;
//    else if Yellow (opponent) wins
//        return score -10;
//    else if no empty locations (cats game)
//        return score 0;
//    else if depth level is 6;
//    if red "one-away from winning" count > yellow "one-away from winning" count
//        return red count of one-away winning
//    else if yellow "one-away from winning count" > yellow "one-away from winning";
//        return (yellow count of one-away winning) * -1;
//        else
//            return a random value


//if(


//    public int minimax(int depth, int turn){
//        if(hasPlayerWon(PLAYER_X)){
//            return 1;
//        }
//        else if(hasPlayerWon(PLAYER_O)){
//            return -1;
//        }
//
//        List<Point> availableCells = getAvailableCells();
//
//        if(availableCells.isEmpty()){
//            return 0;
//        }
//
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        for (int i = 0; i < availableCells.size(); i++) {
//            Point point = availableCells.get(i);
//
//            if(turn == PLAYER_X){
//                placeMove(point, PLAYER_X);
//                int currentScore = minimax(depth + 1, PLAYER_O);
//                max = Math.max(currentScore, max);
//                if(depth == 0){
//                    //System.out.println("Computer score for position " + point + "=" + currentScore);
//                }
//                if(currentScore >= 0){
//                    if(depth == 0){
//                        computerMove = point;
//                    }
//                }
//                if(currentScore == 1){
//                    board[point.x][point.y] = NO_PLAYER;
//                    break;
//                }
//                if(i == availableCells.size() - 1 && max < 0){
//                    if(depth == 0){
//                        computerMove = point;
//                    }
//                }
//            }
//
//            else if(turn == PLAYER_O){
//                placeMove(point, PLAYER_O);
//                int currentScore = minimax(depth + 1, PLAYER_X);
//                min = Math.min(currentScore, min);
//                if(min == -1){
//                    board[point.x][point.y] = NO_PLAYER;
//                    break;
//                }
//            }
//            board[point.x][point.y] = NO_PLAYER;
//        }
//        return turn == PLAYER_X ? max : min;
//    }

}
