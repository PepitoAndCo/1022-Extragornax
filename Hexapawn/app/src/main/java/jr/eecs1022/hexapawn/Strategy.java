package jr.eecs1022.hexapawn;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Strategy
{

    // the state is a map that sets the move for a given board
    public Map<String, BoardMove> blackLogic = new HashMap<String, BoardMove>();

    /**
     * Constructs the strategy by initilizing the state
     */
    public Strategy()
    {
        // set your strategy for BLACK
        this.blackLogic.put("BBBW   WW", new BoardMove(0,1,1,0));
        this.blackLogic.put("B BBW   W", new BoardMove(0,0,1,1));
        this.blackLogic.put("  BBBW   ", new BoardMove(1,0,2,0));
        this.blackLogic.put("  BBW    ", new BoardMove(0,2,1,1));
        this.blackLogic.put("B  BBW   ", new BoardMove(1,0,2,0));
        this.blackLogic.put("B  BW    ", new BoardMove(0,0,1,1));
        this.blackLogic.put("B BW    W", new BoardMove(0,2,1,2));
        this.blackLogic.put("B BB W W ", new BoardMove(1,0,2,0));
        this.blackLogic.put("BBB W W W", new BoardMove(0,0,1,1));
        this.blackLogic.put(" BBWB   W", new BoardMove(0,1,1,0));
        this.blackLogic.put(" BB W   W", new BoardMove(0,2,1,2));
        this.blackLogic.put(" BB BWW  ", new BoardMove(0,1,1,2));
        this.blackLogic.put("  BWBB   ", new BoardMove(1,1,2,1));
        this.blackLogic.put("  B WB   ", new BoardMove(0,2,1,1));
        this.blackLogic.put(" BB W W  ", new BoardMove(0,2,1,2));
        this.blackLogic.put(" B WWB   ", new BoardMove(1,2,2,2));
        this.blackLogic.put("BB WB   W", new BoardMove(0,1,1,0));
        this.blackLogic.put("BB  W   W", new BoardMove(0,0,1,0));
        this.blackLogic.put(" B BWW   ", new BoardMove(1,0,2,0));
        this.blackLogic.put("BB  BWW  ", new BoardMove(0,1,1,2));
        this.blackLogic.put("B  WBB   ", new BoardMove(1,1,2,1));
        this.blackLogic.put("B   WB   ", new BoardMove(0,0,1,1));
        this.blackLogic.put("BB  W W  ", new BoardMove(0,0,1,0));
        this.blackLogic.put("BBB  WWW ", new BoardMove(0,1,1,2));
        this.blackLogic.put("B BW B W ", new BoardMove(1,2,2,2));
        this.blackLogic.put("B B WBW  ", new BoardMove(0,0,1,1));
        this.blackLogic.put("B B  WW  ", new BoardMove(0,0,1,0));
    }

    /**
     * Given a current board position (as a string), execute the machine's move
     * @param key The current board position expressed as W-white piece, B-black piece,  ' '-empty.
     *            Board is given in row major order
     */
    public BoardMove move(String key)
    {
        return blackLogic.get(key);
    }

    public static void main(String[] args) {
        System.out.printf("Strategy Test Method - main()\n");
        Strategy temp = new Strategy();
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
