package snakeGame.gameManagers.collisionManagers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakeGame.exceptions.SelfCollisionException;
import snakeGame.snake.Snake;
import snakeGame.snake.SnakeBodyPart;
import snakeGame.snake.snakeMovement.Direction;

public class SnakeCollisionManagerTest {
    Snake snake;
    SnakeBodyPart head;
    SnakeCollisionManager collisionManager;

    @BeforeEach
    public void setUpSnake(){
        snake = new Snake();
        head = snake.getHead();
        collisionManager = new SnakeCollisionManager(snake);
    }

    @Test
    @DisplayName("Should throw when snake collides with its own body")
    public void should_throw_when_snake_collides_with_its_own_body(){
        for(int i = 0; i < 5; i++){
            snake.addBodyPart();
            snake.move();
        }

        snake.changeDirection(Direction.DOWN);
        snake.move();
        snake.changeDirection(Direction.LEFT);
        snake.move();
        snake.changeDirection(Direction.UP);
        snake.move();

        Assertions.assertThrows(SelfCollisionException.class, ()-> collisionManager.checkCollision());
    }
}
