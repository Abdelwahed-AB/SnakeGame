package snakeGame.gameManagers.entityManager;

import snakeGame.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityManager {
    public final static List<Entity> GAME_ENTITIES = new ArrayList<>();

    protected void addEntity(Entity entity){
        GAME_ENTITIES.add(entity);
    }

    protected void removeEntity(Entity entity){
        GAME_ENTITIES.remove(entity);
    }
}
