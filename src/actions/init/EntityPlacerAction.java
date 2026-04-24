package actions.init;

import actions.Action;
import entities.Coral;
import entities.Entity;
import entities.Island;
import entities.Predator;
import entities.Prey;
import entities.Wave;
import world.Position;
import world.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class EntityPlacerAction extends Action {

    public static void placeEntities(List<Entity> entities, WorldMap worldMap) { //<K, V> - K ключ, V значение
        for (Entity entity : entities) {
            worldMap.setEntity(Position.getRandomPosition(worldMap), entity);
        }
    }
}
