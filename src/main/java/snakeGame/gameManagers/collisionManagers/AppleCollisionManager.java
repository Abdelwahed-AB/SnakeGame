package snakeGame.gameManagers.collisionManagers;

import snakeGame.collectibles.Apple;
import snakeGame.gameManagers.entityManager.AppleEntityManager;
import snakeGame.gameManagers.entityManager.SnakeEntityManager;
import snakeGame.snake.SnakeBodyPart;

import java.util.List;

public class AppleCollisionManager extends CollisionManager{
    private final AppleEntityManager appleEntityManager;
    private final SnakeEntityManager snakeEntityManager;

    public AppleCollisionManager(AppleEntityManager appleEntityManager, SnakeEntityManager snakeEntityManager) {
        this.appleEntityManager = appleEntityManager;
        this.snakeEntityManager = snakeEntityManager;
    }

    @Override
    public void checkCollision() {
        List<Apple> appleList = appleEntityManager.apples();
        SnakeBodyPart head = snakeEntityManager.snake().getHead();

        for (Apple apple: appleList){
            if (apple.isCollidingWith(head)){
                snakeEntityManager.addSnakeBodyPart();
                appleEntityManager.removeApple(apple);
                appleEntityManager.spawnApple();
                break;
            }
        }
    }
}
