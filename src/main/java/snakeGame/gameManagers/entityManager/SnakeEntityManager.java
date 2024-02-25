package snakeGame.gameManagers.entityManager;

import snakeGame.snake.Snake;
import snakeGame.snake.SnakeBodyPart;

import java.util.List;

public class SnakeEntityManager extends EntityManager{
    private Snake snake;
    private List<SnakeBodyPart> snakeBodyParts;

    public SnakeEntityManager(Snake snake) {
        this.snake = snake;
        snakeBodyParts = snake.getBody();
        GAME_ENTITIES.addAll(snakeBodyParts);
    }

    public SnakeBodyPart addSnakeBodyPart(){
        SnakeBodyPart snakeBodyPart = snake.addBodyPart();
        GAME_ENTITIES.add(snakeBodyPart);

        return snakeBodyPart;
    }

    public List<SnakeBodyPart> snakeBodyParts() {
        return snakeBodyParts;
    }

    public Snake snake() {
        return snake;
    }
}
