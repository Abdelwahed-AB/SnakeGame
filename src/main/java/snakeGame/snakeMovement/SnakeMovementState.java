package snakeGame.snakeMovement;

import snakeGame.Snake;

public abstract class SnakeMovementState {
    protected Snake snake;

    public SnakeMovementState(Snake snake) {
        this.snake = snake;
    }

    public abstract void changeDirection(Direction direction);
    public abstract void moveHead();
}
