package snakeGame.gameManagers.entityManagers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakeGame.gameManagers.entityManager.EntityManager;
import snakeGame.gameManagers.entityManager.SnakeEntityManager;
import snakeGame.snake.Snake;
import snakeGame.snake.SnakeBodyPart;

public class SnakeEntityManagerTest {
    Snake snake;
    SnakeEntityManager snakeEntityManager;

    @BeforeEach
    public void setup(){
        snake = new Snake();
        snakeEntityManager = new SnakeEntityManager(snake);
    }

    @Test
    @DisplayName("Should create a new snake tail")
    public void should_create_new_snake_tail(){
        SnakeBodyPart snakeBodyPart = snakeEntityManager.addSnakeBodyPart();
        snake.move();

        SnakeBodyPart expected = new SnakeBodyPart(0, 0);
        Assertions.assertEquals(expected, snakeBodyPart);
        Assertions.assertTrue(EntityManager.GAME_ENTITIES.size() >= 2);
    }
}
