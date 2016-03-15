package jr.eecs1022.hexapawn;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class whiteStrategy
{

    // the state is a map that sets the move for a given board
    public Map<String, BoardMove> whiteLogic = new HashMap<String, BoardMove>();

    /**
     * Constructs the strategy by initilizing the state
     */
    public whiteStrategy()
    {
        // set your strategy for White

        this.whiteLogic.put("BBB   WWW", new BoardMove(2,0,1,0));
        this.whiteLogic.put("B BB   WW", new BoardMove(2,1,1,0));
        this.whiteLogic.put("B BWB  WW", new BoardMove(1,0,0,1));
        this.whiteLogic.put("BB W B WW", new BoardMove(1,0,0,1));


    }

    /**
     * Given a current board position (as a string), execute the machine's move
     * @param key The current board position expressed as W-white piece, B-black piece,  ' '-empty.
     *            Board is given in row major order
     */
    public BoardMove move(String key)
    {
        return whiteLogic.get(key);
    }

    public static void main(String[] args) {
        System.out.printf("Strategy Test Method - main()\n");
        whiteStrategy temp = new whiteStrategy();
        temp.sumulator();
    }

    public void findNextStep(Board currentState, Boolean isWhiteTurn, String cacheString, int depth){
        if (currentState.hasBlackWon()) {
            System.out.printf("%s BlackWIN\n", cacheString);
        }else if(currentState.hasWhiteWon()) {
            System.out.printf("%s WhiteWIN\n", cacheString);
        }else {
            //find Next Step
            if (isWhiteTurn) {
                boolean allStuck = true;
                for (int r = 0; r < Board.WIDTH; r++) {
                    for (int c = 0; c < Board.WIDTH; c++) {
                        BoardPos pos = new BoardPos(r, c);
                        if (currentState.getContents(pos) == Board.Contents.WHITE_PIECE){
                            List<BoardPos> moves = currentState.validWhiteMoves(pos);
                            for(BoardPos target: moves){
                                //process white move
                                allStuck = false;
                                Board newBoard = new Board();
                                newBoard.copyBoard(currentState);
                                String action = String.format("[%s] W:%s=>%s (%d) ", newBoard.toStringKey(),pos.toString(), target.toString(), depth);
                                newBoard.setContents(pos, Board.Contents.EMPTY);
                                newBoard.setContents(target, Board.Contents.WHITE_PIECE);
                                findNextStep(newBoard, !isWhiteTurn, cacheString + action, depth + 1);
                            }
                        }
                    }
                }
                if (allStuck){
                    System.out.printf("%s BlackWIN\n", cacheString);
                }
            }else{
                boolean allStuck = true;
                for (int r = 0; r < Board.WIDTH; r++) {
                    for (int c = 0; c < Board.WIDTH; c++) {
                        BoardPos pos = new BoardPos(r, c);
                        if (currentState.getContents(pos) == Board.Contents.BLACK_PIECE){
                            List<BoardPos> moves = currentState.validBlackMoves(pos);
                            for(BoardPos target: moves){
                                //process black move
                                allStuck = false;
                                Board newBoard = new Board();
                                newBoard.copyBoard(currentState);
                                String action = String.format("[%s] B:%s=>%s (%d) ", newBoard.toStringKey(),pos.toString(), target.toString(), depth);
                                newBoard.setContents(pos, Board.Contents.EMPTY);
                                newBoard.setContents(target, Board.Contents.BLACK_PIECE);
                                findNextStep(newBoard, !isWhiteTurn, cacheString + action, depth + 1);
                            }
                        }
                    }
                }
                if (allStuck){
                    System.out.printf("%s WhiteWIN\n", cacheString);
                }
            }
        }
    }

    public void sumulator() {
        Board blankBoard = new Board();
        blankBoard.resetBoard();
        findNextStep(blankBoard, true, "", 1);
    }

}
