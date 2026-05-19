package world;

import actions.init.EntityConfig;
import actions.init.EntityListCreatorAction;
import actions.init.EntityPlacerAction;
import actions.turn.CreatureMovementAction;
import actions.turn.WaveSpawnerAction;
import entities.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Simulation {
    public EntityConfig entityConfig = new EntityConfig(1, 5, 7, 5, 1);

    private final EntityListCreatorAction entityListCreatorAction = new EntityListCreatorAction();
    private final List<Entity> entities = new ArrayList<>(entityListCreatorAction.createAllEntities(entityConfig));
    private final MapConsoleRenderer renderer = new MapConsoleRenderer();
    private final CreatureMovementAction movementAction = new CreatureMovementAction();
    private final WaveSpawnerAction waveSpawnerAction = new WaveSpawnerAction();
    private int countMoves = 1;
    private boolean paused = false;


    public void runSimulation(WorldMap worldMap) {
        initSimulation(worldMap);

        startInputListener();

        while (worldMap.hasPrey()) {

            if (!paused) {
                renderer.render(worldMap);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.err.println("Симуляция была прервана во время сна");
                }
                System.out.println();
                System.out.println("Ход № " + countMoves);
                nextTurn(worldMap);
                countMoves++;
            }
        }
        renderer.render(worldMap);
    }

    private void initSimulation(WorldMap worldMap) {
        EntityPlacerAction.placeEntities(entities, worldMap);
    }

    private void nextTurn(WorldMap worldMap) {  //просимулировать и отрендерить один ход
        movementAction.makeCreaturesMove(worldMap);
        waveSpawnerAction.spawnWave(worldMap);
    }

    private void startInputListener() {
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                scanner.nextLine();

                paused = !paused;

                if (paused) {
                    System.out.println("Пауза");
                } else {
                    System.out.println("Продолжение симуляции");
                }
            }

        }).start();
    }

//    public void startSimulation() {  //запустить бесконечный цикл симуляции и рендеринга
//    }

//    private void pauseSimulation() {  //приостановить бесконечный цикл симуляции и рендеринга
//    }
}
