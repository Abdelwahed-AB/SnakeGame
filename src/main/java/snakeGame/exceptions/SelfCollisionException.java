package snakeGame.exceptions;

public class SelfCollisionException extends RuntimeException{
    public SelfCollisionException() {
        super("Snake tried to consume itself");
    }
}
