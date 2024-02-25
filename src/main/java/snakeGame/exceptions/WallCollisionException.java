package snakeGame.exceptions;

public class WallCollisionException extends RuntimeException{
    public WallCollisionException() {
        super("Snake collided with wall");
    }
}
