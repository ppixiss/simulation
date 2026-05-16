package world;

import actions.init.EntityConfig;
import actions.init.EntityListCreatorAction;
import actions.init.EntityPlacerAction;
import actions.turn.CreatureMovementAction;
import entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    EntityConfig entityConfig = new EntityConfig(1, 3, 4, 3, 4);
    EntityListCreatorAction entityListCreatorAction = new EntityListCreatorAction();
    List<Entity> entities = new ArrayList<>(entityListCreatorAction.createAllEntities(entityConfig));
    MapConsoleRenderer renderer = new MapConsoleRenderer();
    CreatureMovementAction movementAction = new CreatureMovementAction();

    public void runSimulation(WorldMap worldMap) {

        while (worldMap.hasPrey()) {
            renderer.render(worldMap);
            nextTurn(worldMap);
            System.out.println();
        }
        renderer.render(worldMap);
    }

    public void initSimulation(WorldMap worldMap) {
        EntityPlacerAction.placeEntities(entities, worldMap);
    }

    public void nextTurn(WorldMap worldMap) {  //просимулировать и отрендерить один ход
    movementAction.makeCreaturesMove(worldMap);
    }

    public void startSimulation() {  //запустить бесконечный цикл симуляции и рендеринга
    }

    public void pauseSimulation() {  //приостановить бесконечный цикл симуляции и рендеринга
    }
}
