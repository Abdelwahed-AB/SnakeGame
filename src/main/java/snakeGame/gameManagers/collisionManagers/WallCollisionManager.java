package snakeGame.gameManagers.collisionManagers;

import snakeGame.GameProperties;
import snakeGame.exceptions.WallCollisionException;
import snakeGame.gameManagers.entityManager.SnakeEntityManager;
import snakeGame.snake.SnakeBodyPart;

public class WallCollisionManager extends CollisionManager{

    private SnakeEntityManager snakeEntityManager;

    public WallCollisionManager(SnakeEntityManager snakeEntityManager) {
        this.snakeEntityManager = snakeEntityManager;
    }

    @Override
    public void checkCollision() {
        SnakeBodyPart head = snakeEntityManager.snake().getHead();

        if (head.posX() >= GameProperties.WIDTH.value || head.posX() < 0){
            throw new WallCollisionException();
        }

        if (head.posY() >= GameProperties.HEIGHT.value || head.posY() < 0){
            throw new WallCollisionException();
        }
    }
}
