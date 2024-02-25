package snakeGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakeGame.snakeMovement.Direction;

import java.util.ArrayList;
import java.util.List;

public class SnakeMovementTest {

    Snake snake;
    SnakeBodyPart head;

    @BeforeEach
    public void setUpSnake(){
        snake = new Snake();
        head = snake.getHead();
    }

    @Test
    @DisplayName("Should move the snake's head to the right by default")
    public void should_move_snake_head_to_right_default(){
        SnakeBodyPart expected = new SnakeBodyPart(1, 0);
        snake.moveBody();

        Assertions.assertEquals(expected, head);
    }

    @Test
    @DisplayName("Should move the snake's head down")
    public void should_move_snake_down(){
        SnakeBodyPart expected = new SnakeBodyPart(0, -1);
        snake.changeDirection(Direction.DOWN);
        snake.moveBody();

        Assertions.assertEquals(expected, head);
    }

    @Test
    @DisplayName("Should move the snake's head up")
    public void should_move_snake_up(){
        SnakeBodyPart expected = new SnakeBodyPart(0, 1);
        snake.changeDirection(Direction.UP);
        snake.moveBody();

        Assertions.assertEquals(expected, head);
    }

    @Test
    @DisplayName("Should move the snake's head left")
    public void should_move_snake_left(){
        SnakeBodyPart expected = new SnakeBodyPart(-1, 0);
        snake.changeDirection(Direction.UP);
        snake.changeDirection(Direction.LEFT);
        snake.moveBody();

        Assertions.assertEquals(expected, head);
    }

    @Test
    @DisplayName("Should not move the snake's head in the opposite direction")
    public void should_not_move_snake_opposite_direction(){
        SnakeBodyPart expected = new SnakeBodyPart(1, 0);
        snake.changeDirection(Direction.LEFT);
        snake.moveBody();

        Assertions.assertEquals(expected, head);
    }

    @Test
    @DisplayName("Should move all snake body parts")
    public void should_move_all_body_parts(){
        snake.addBodyPart();
        snake.moveBody();

        List<SnakeBodyPart> expected = new ArrayList<>();
        expected.add(new SnakeBodyPart(1, 0));
        expected.add(new SnakeBodyPart(0, 0));

        Assertions.assertEquals(expected, snake.getBody());
    }
}
