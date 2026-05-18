package actions.init;

import entities.Entity;
import world.Position;
import world.WorldMap;

import java.util.List;

public class EntityPlacerAction {

    public static void placeEntities(List<Entity> entities, WorldMap worldMap) {
        for (Entity entity : entities) {
            worldMap.setEntity(Position.getRandomPosition(worldMap), entity);
        }
    }
}
