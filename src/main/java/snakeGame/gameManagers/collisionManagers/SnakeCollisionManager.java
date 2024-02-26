package snakeGame.gameManagers.collisionManagers;

import snakeGame.exceptions.SelfCollisionException;
import snakeGame.snake.Snake;

public class SnakeCollisionManager extends CollisionManager{

    private final Snake snake;

    public SnakeCollisionManager(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void checkCollision() {
        try {
            snake.checkSelfCollision();
        }catch (SelfCollisionException collisionException){
            throw collisionException;
        }
    }
}
