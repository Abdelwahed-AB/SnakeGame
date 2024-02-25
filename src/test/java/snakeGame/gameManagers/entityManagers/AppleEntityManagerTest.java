package snakeGame.gameManagers.entityManagers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakeGame.GameProperties;
import snakeGame.collectibles.Apple;
import snakeGame.gameManagers.entityManager.AppleEntityManager;
import snakeGame.gameManagers.entityManager.EntityManager;

public class AppleEntityManagerTest {

    AppleEntityManager appleEntityManager;

    @BeforeEach
    public void setup(){
        appleEntityManager = new AppleEntityManager();
    }

    @Test
    @DisplayName("Should generate an apple at a random position")
    public void should_generate_apple_at_random_pos(){
        Apple apple = appleEntityManager.spawnApple();

        Assertions.assertTrue(apple.posX() < GameProperties.WIDTH.value);
        Assertions.assertTrue(apple.posX() < GameProperties.HEIGHT.value);
    }

    @Test
    @DisplayName("Should remove apple from entities list")
    public void should_remove_apple_from_entities_list(){
        Apple apple = appleEntityManager.spawnApple();
        Apple res = appleEntityManager.removeApple(apple);

        Assertions.assertEquals(res, apple);
        Assertions.assertEquals(0, EntityManager.GAME_ENTITIES.size());
    }
}
