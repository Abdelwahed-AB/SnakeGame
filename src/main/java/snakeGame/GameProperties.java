package snakeGame;

public enum GameProperties {
    WIDTH(30),
    HEIGHT(20),
    APPLES(1),
    DELTA_TIME(75);

    public final int value;

    GameProperties(int value) {
        this.value = value;
    }
}
