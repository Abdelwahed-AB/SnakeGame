package snakeGame.snake.snakeMovement;

import snakeGame.snake.Snake;
import snakeGame.snake.SnakeBodyPart;

public class SnakeMovementStateDown extends SnakeMovementState{

    public SnakeMovementStateDown(Snake snake) {
        super(snake);
    }

    @Override
    public void changeDirection(Direction direction) {
        switch (direction){
            case LEFT -> snake.setMovementState(new SnakeMovementStateLeft(snake));
            case RIGHT -> snake.setMovementState(new SnakeMovementStateRight(snake));
        }
    }

    @Override
    public void moveHead() {
        SnakeBodyPart head = snake.getHead();
        head.setPosY(head.posY() + 1);
    }
}
