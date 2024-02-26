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
                Apple pos = new Apple(x, y);
                if(!entities.contains(pos)){
                    possibleFreePositions.add(pos);
                }
            }
        }

        Random random = new Random();

        return possibleFreePositions.get(random.nextInt(possibleFreePositions.size()));
    }
    private Boolean isPositionTaken(Entity pos){
        return GAME_ENTITIES.contains(pos);
    }

    public List<Apple> apples() {
        return apples;
    }
}
