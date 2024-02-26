package snakeGame.exceptions;

public class EndGameException extends RuntimeException{
    public EndGameException() {
        super("Game has ended");
    }
}
