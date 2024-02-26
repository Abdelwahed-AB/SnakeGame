package snakeGame.gameManagers.collisionManagers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakeGame.collectibles.Apple;
import snakeGame.gameManagers.entityManager.AppleEntityManager;
import snakeGame.gameManagers.entityManager.SnakeEntityManager;
import snakeGame.snake.Snake;
import snakeGame.snake.SnakeBodyPart;

public class AppleCollisionManagerTest {
    Snake snake;
    SnakeBodyPart head;
    AppleCollisionManager appleCollisionManager;
    AppleEntityManager appleEntityManager;
    SnakeEntityManager snakeEntityManager;

    @BeforeEach
    void setUp() {
        snake = new Snake();
        head = snake.getHead();
        snakeEntityManager = new SnakeEntityManager(snake);
        appleEntityManager = new AppleEntityManager();
        appleCollisionManager = new AppleCollisionManager(appleEntityManager, snakeEntityManager);
    }

    @Test
    @DisplayName("Should make the snake longer")
    public void should_make_the_snake_longer(){
        appleEntityManager.apples().add(new Apple(0, 0));
        appleCollisionManager.checkCollision();

        Assertions.assertEquals(2, snake.length());
    }
}
