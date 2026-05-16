package world;

import java.util.Objects;
import java.util.Random;

public class Position {
    private Integer x;
    private Integer y;
    private static final Random random = new Random();

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }  //Нужен ли этот конструктор?

    public Position() {
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getX() {
        return x;
    }

    public void setY(Integer y) {     //Сеттер для y
        this.y = y;
    }

    public Integer getY() {
        return y;
    }

    public static Position getRandomPosition(WorldMap worldMap) {
        while (true) {
            int x = random.nextInt(15);   //До 10 не включая, то есть до 9
            int y = random.nextInt(10);   //До 15 не включая, то есть до 14

            Position position = new Position();
            position.setX(x);
            position.setY(y);

            if (worldMap.isCellEmpty(position)) {
                return position;
            }
        }
    }

    public String toString() {
        return "X" + x + " " + "Y" + y;
    }

    @Override    //Для того, чтобы использовать ХэшМап
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(x, position.x) && Objects.equals(y, position.y);
    }

    @Override   //Для того, чтобы использовать ХэшМап
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
