package snakeGame;

import java.util.Objects;

public class SnakeBodyPart {
    private int posX, posY;

    public SnakeBodyPart(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    public SnakeBodyPart() {}
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

    public void copyPos(SnakeBodyPart bodyPart){
        this.posX = bodyPart.posX();
        this.posY = bodyPart.posY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnakeBodyPart bodyPart = (SnakeBodyPart) o;
        return posX == bodyPart.posX && posY == bodyPart.posY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }

    @Override
    public String toString() {
        return "SnakeBodyPart{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
