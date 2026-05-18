package world;

import entities.Entity;
import entities.Prey;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WorldMap {
    public static final int HORIZONTAL_SIZE = 15;
    public static final int VERTICAL_SIZE = 10;

    private final HashMap<Position, Entity> worldMap = new HashMap<>();  //<K, V>

    public void setEntity(Position position, Entity entity) {
        worldMap.put(position, entity);
    }

    public void removeEntity(Position position) {
        worldMap.remove(position);
    }

    public boolean isCellEmpty(Position position) { //Возвращает false, если ячейка занята
        return !worldMap.containsKey(position);
    }

    public Entity getEntityAt(Position position) {
        return worldMap.get(position);
    }

    public Set<Map.Entry<Position, Entity>> getEntries() {
        return worldMap.entrySet();
    }

    public boolean hasPrey() {
        for (Map.Entry<Position, Entity> entry : getEntries()) {
            Entity entity = entry.getValue();

            if (entity instanceof Prey) {
                return true;
            }
        }
        return false;
    }

    public void moveEntity(Position currentPosition, Position nextCell, Entity entity) {
        removeEntity(currentPosition);
        setEntity(nextCell, entity);
    }
}