package world;

import actions.init.EntityPlacer;
import entities.Coral;
import entities.Island;
import entities.Predator;
import entities.Prey;
import entities.Wave;

public class Simulation {

    public void simulation(WorldMap worldMap) {
        EntityPlacer.placeEntities(
                EntityPlacer.makeListOfEntities(
                        new Predator(),
                        new Prey(),
                        new Wave(),
                        new Coral(),
                        new Island()),
                        worldMap
        );
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
