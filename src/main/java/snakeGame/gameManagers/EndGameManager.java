package snakeGame.gameManagers;

import snakeGame.GameProperties;
import snakeGame.exceptions.EndGameException;
import snakeGame.gameManagers.entityManager.SnakeEntityManager;

public class EndGameManager {

    private final SnakeEntityManager snakeEntityManager;

    public EndGameManager(SnakeEntityManager snakeEntityManager) {
        this.snakeEntityManager = snakeEntityManager;
    }

    public void check(){
        if(GameProperties.WIDTH.value * GameProperties.HEIGHT.value == snakeEntityManager.snake().length()){
            throw new EndGameException();
        }
    }
}
