package world;

import actions.init.EntityConfig;
import actions.init.EntityListCreatorAction;
import actions.init.EntityPlacerAction;
import entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    EntityConfig entityConfig = new EntityConfig(1, 1, 1, 1, 1);
    EntityListCreatorAction entityListCreatorAction = new EntityListCreatorAction();
    List<Entity> entities = new ArrayList<>(entityListCreatorAction.combineAllEntities(entityConfig));

    public void simulation(WorldMap worldMap) {
        EntityPlacerAction.placeEntities(entities, worldMap);
    }

    public void init() {

    }

    public void nextTurn() {  //просимулировать и отрендерить один ход
    }

    public void startSimulation() {  //запустить бесконечный цикл симуляции и рендеринга
    }

    public void pauseSimulation() {  //приостановить бесконечный цикл симуляции и рендеринга
    }
}
