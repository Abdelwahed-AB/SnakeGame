package snakeGame.snake.snakeMovement;

import snakeGame.snake.Snake;

public abstract class SnakeMovementState {
    protected Snake snake;

    public SnakeMovementState(Snake snake) {
        this.snake = snake;
    }

    public abstract void changeDirection(Direction direction);
    public abstract void moveHead();
}
