package snakeGame.snake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakeGame.snake.SnakeBodyPart;

public class SnakeBodyPartTest {

    @Test
    @DisplayName("Should copy position from other body part")
    public void should_copy_position_from_other_body_part(){
        SnakeBodyPart head = new SnakeBodyPart(0, 0);
        SnakeBodyPart tail = new SnakeBodyPart(1, 1);

        tail.copyPos(head);

        Assertions.assertEquals(head, tail);
    }
}
