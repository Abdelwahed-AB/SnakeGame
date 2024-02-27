package snakeGame.gameManagers.entityManager;

import snakeGame.Entity;
import snakeGame.GameProperties;
import snakeGame.collectibles.Apple;

import java.util.*;

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
        Set<Entity> entities = new HashSet<>(GAME_ENTITIES);

        List<Apple> possibleFreePositions = new ArrayList<>();
        for (int x = 0; x < GameProperties.WIDTH.value; x++){
            for (int y = 0; y < GameProperties.HEIGHT.value; y++){
                Entity pos = new Apple(x, y);
                if(!entities.contains(pos)){
                    Apple apple = new Apple();
                    apple.copyPos(pos);
                    possibleFreePositions.add(apple);
                }
            }
        }

        Random random = new Random();

        return possibleFreePositions.get(random.nextInt(possibleFreePositions.size()));
    }

    public List<Apple> apples() {
        return apples;
    }
}
