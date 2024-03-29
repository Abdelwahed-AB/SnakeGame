package snakeGame.snake.snakeMovement;

import snakeGame.snake.Snake;
import snakeGame.snake.SnakeBodyPart;

public class SnakeMovementStateRight extends SnakeMovementState {

    public SnakeMovementStateRight(Snake snake) {
        super(snake);
    }

    @Override
    public void changeDirection(Direction direction) {
        switch (direction){
            case UP -> snake.setMovementState(new SnakeMovementStateUp(snake));
            case DOWN -> snake.setMovementState(new SnakeMovementStateDown(snake));
        }
    }

    @Override
    public void moveHead() {
        SnakeBodyPart head = snake.getHead();
        head.setPosX(head.posX() + 1);
    }
}
