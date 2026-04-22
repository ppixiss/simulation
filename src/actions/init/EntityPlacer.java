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

public class EntityPlacer extends Action {

    public static List<Entity> makeListOfEntities(Predator predator, Prey prey, Wave wave, Coral coral, Island island) {
        List<Entity> entities = new ArrayList<>();
        entities.add(predator);
        entities.add(prey);
        entities.add(coral);
        entities.add(island);
        entities.add(wave);
        return entities;
    }

    public static void placeEntities(List<Entity> entities, WorldMap worldMap) { //<K, V> - K ключ, V значение
        for (Entity entity : entities) {
            worldMap.setEntity(Position.getRandomPosition(worldMap), entity);
        }
    }
}
