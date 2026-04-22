package world;

import entities.Entity;

import java.util.HashMap;

public class WorldMap {
    private final HashMap<Position, Entity> worldMap = new HashMap<>();  //<K, V>

    public void setEntity(Position position, Entity entity) {
        worldMap.put(position, entity);
    }

    public boolean isCellEmpty(Position position) { //Возвращает false, если ячейка занята
       return !worldMap.containsKey(position);
    }
}

