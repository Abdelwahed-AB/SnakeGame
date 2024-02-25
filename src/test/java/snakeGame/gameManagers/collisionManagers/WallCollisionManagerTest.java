package snakeGame.gameManagers.collisionManagers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakeGame.GameProperties;
import snakeGame.exceptions.WallCollisionException;
import snakeGame.gameManagers.entityManager.SnakeEntityManager;
import snakeGame.snake.Snake;
import snakeGame.snake.snakeMovement.Direction;

public class WallCollisionManagerTest {

    Snake snake;
    WallCollisionManager wallCollisionManager;

    @BeforeEach
    public void setup(){
        snake = new Snake();
        wallCollisionManager = new WallCollisionManager(new SnakeEntityManager(snake));
    }

    @Test
    @DisplayName("Should throw when snake reaches right wall")
    public void should_throw_when_snake_reaches_right_wall(){
        for (int i = 0; i <= GameProperties.WIDTH.value; i++){
            snake.move();
        }
        Assertions.assertThrows(WallCollisionException.class, ()-> wallCollisionManager.checkCollision());
    }

    @Test
    @DisplayName("Should throw when snake reaches left wall")
    public void should_throw_when_snake_reaches_left_wall(){
        snake.changeDirection(Direction.DOWN);
        snake.changeDirection(Direction.LEFT);
        snake.move();
        Assertions.assertThrows(WallCollisionException.class, ()-> wallCollisionManager.checkCollision());
    }

    @Test
    @DisplayName("Should throw when snake reaches top wall")
    public void should_throw_when_snake_reaches_top_wall(){
        snake.changeDirection(Direction.UP);
        snake.move();
        Assertions.assertThrows(WallCollisionException.class, ()-> wallCollisionManager.checkCollision());
    }

    @Test
    @DisplayName("Should throw when snake reaches bottom wall")
    public void should_throw_when_snake_reaches_bottom_wall(){
        snake.changeDirection(Direction.DOWN);
        for (int i = 0; i <= GameProperties.HEIGHT.value; i++){
            snake.move();
        }
        Assertions.assertThrows(WallCollisionException.class, ()-> wallCollisionManager.checkCollision());
    }
}
