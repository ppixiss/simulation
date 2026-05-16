package actions.init;

import entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class EntityListCreatorAction {

    public List<Entity> createAllEntities(EntityConfig entityConfig) {
        List<Entity> allEntities = new ArrayList<>();

        allEntities.addAll(EntityCreatorAction.createPredators(entityConfig));
        allEntities.addAll(EntityCreatorAction.createPrey(entityConfig));
        allEntities.addAll(EntityCreatorAction.createCorals(entityConfig));
        allEntities.addAll(EntityCreatorAction.createIslands(entityConfig));
        allEntities.addAll(EntityCreatorAction.createWaves(entityConfig));
        return allEntities;
    }
}
