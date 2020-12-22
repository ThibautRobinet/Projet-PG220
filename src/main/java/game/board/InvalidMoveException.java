package game.board;


@SuppressWarnings("serial")
public final class InvalidMoveException extends Exception{
    public InvalidMoveException(String message) {
        super(message);
    }
    
}