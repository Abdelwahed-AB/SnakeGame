package snakeGame;

import java.util.Objects;

public abstract class Entity {
    protected int posX, posY;

    public Entity(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    public Entity() {}

    public void copyPos(Entity entity){
        this.posX = entity.posX();
        this.posY = entity.posY();
    }

    public int posX() {
        return posX;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public int posY() {
        return posY;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        Entity entity = (Entity) o;
        return posX == entity.posX && posY == entity.posY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }

    public boolean isCollidingWith(Entity e){
        return posX == e.posX && posY == e.posY;
    }
}
