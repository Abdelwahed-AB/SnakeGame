package snakeGame.gameManagers.entityManager;

import snakeGame.Entity;
import snakeGame.GameProperties;
import snakeGame.collectibles.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppleEntityManager extends EntityManager {
    private final List<Apple> apples = new ArrayList<>();

    public Apple spawnApple(){
        Apple apple = findRandomFreePosition();

        apples.add(apple);
        GAME_ENTITIES.add(apple);

        return apple;
    }
    public Apple removeApple(Apple apple){
        apples.remove(apple);
        GAME_ENTITIES.remove(apple);

        return apple;
    }

    private Apple findRandomFreePosition(){
        Random random = new Random();
        int x = random.nextInt(GameProperties.WIDTH.value);
        int y = random.nextInt(GameProperties.HEIGHT.value);

        Apple apple = new Apple(x, y);
        while (isPositionTaken(apple)){
            apple.setPosX(x);
            apple.setPosY(y);
        }

        return apple;
    }
    private Boolean isPositionTaken(Entity pos){
        return GAME_ENTITIES.contains(pos);
    }

    public List<Apple> apples() {
        return apples;
    }
}
