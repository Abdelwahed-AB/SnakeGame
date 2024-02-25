package snakeGame.gameManagers.collisionManagers;

import snakeGame.gameManagers.GameManager;

import java.util.LinkedList;
import java.util.List;

public class CompositeCollisionManager extends CollisionManager {

    private final List<CollisionManager> collisionManagers;

    public CompositeCollisionManager() {
        collisionManagers = new LinkedList<>();
    }

    public void addCollisionManager(CollisionManager collisionManager){
        collisionManagers.add(collisionManager);
    }
    public void removeCollisionManager(CollisionManager collisionManager){
        collisionManagers.remove(collisionManager);
    }
    public List<CollisionManager> getCollisionManagers(){
        return collisionManagers;
    }

    @Override
    public void checkCollision() {
        for (CollisionManager collisionManager: collisionManagers) {
            collisionManager.checkCollision();
        }
    }
}
