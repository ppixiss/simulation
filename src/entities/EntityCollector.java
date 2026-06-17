package entities;

import actions.init.EntityConfig;

import java.util.ArrayList;
import java.util.List;

public class EntityCollector {

    public List<Entity> collectEntities(EntityConfig entityConfig) {
        List<Entity> entities = new ArrayList<>();

        entities.addAll(EntityFactory.createPredators(entityConfig));
        entities.addAll(EntityFactory.createPrey(entityConfig));
        entities.addAll(EntityFactory.createCorals(entityConfig));
        entities.addAll(EntityFactory.createIslands(entityConfig));
        entities.addAll(EntityFactory.createWaves(entityConfig));
        return entities;
    }
}
