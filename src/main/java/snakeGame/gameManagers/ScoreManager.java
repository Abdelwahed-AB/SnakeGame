package snakeGame.gameManagers;

import snakeGame.gameManagers.entityManager.SnakeEntityManager;

public class ScoreManager {
    private final SnakeEntityManager snakeEntityManager;

    public ScoreManager(SnakeEntityManager snakeEntityManager) {
        this.snakeEntityManager = snakeEntityManager;
    }

    public int getScore(){
        return snakeEntityManager.snake().length();
    }
}
