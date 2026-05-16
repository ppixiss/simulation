package actions.init;

import actions.Action;
import entities.Entity;
import world.Position;
import world.WorldMap;

import java.util.List;

public class EntityPlacerAction extends Action {

    public static void placeEntities(List<Entity> entities, WorldMap worldMap) {
        for (Entity entity : entities) {
            worldMap.setEntity(Position.getRandomPosition(worldMap), entity);
        }
    }
}
