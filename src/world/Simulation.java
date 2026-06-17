package world;

import actions.init.EntityConfig;
import entities.EntityCollector;
import actions.init.EntityPlacerAction;
import console.SimulationMenu;
import actions.turn.CreatureMovementAction;
import actions.turn.WaveSpawnerAction;
import entities.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Simulation {
    public EntityConfig entityConfig = new EntityConfig(2, 6, 13, 12, 6);
    public static int countMoves = 1;

    private final EntityCollector entityCollector = new EntityCollector();
    private final List<Entity> entities = new ArrayList<>(entityCollector.collectEntities(entityConfig));
    private final MapConsoleRenderer renderer = new MapConsoleRenderer();
    private final CreatureMovementAction movementAction = new CreatureMovementAction();
    private final WaveSpawnerAction waveSpawnerAction = new WaveSpawnerAction();

    private volatile boolean paused = false;
    private volatile boolean running = true;

    private final Scanner scanner = new Scanner(System.in);

    public void start(WorldMap worldMap) {
        SimulationMenu.printWelcomeMessage();
        SimulationMenu.printWorldConfig(entityConfig);
        SimulationMenu.printRules();

        if (SimulationMenu.shouldStartSimulation(scanner)) {
            startInputListener(scanner);
            initSimulation(worldMap);
            runSimulation(worldMap);
        }
    }

    private void runSimulation(WorldMap worldMap) {
        while (worldMap.hasPrey() && running) {
            waitIfPaused();

            System.out.println();
            System.out.println("Ход № " + countMoves);

            renderer.render(worldMap);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.err.println("Симуляция была прервана во время сна");
            }

            nextTurn(worldMap);
            countMoves++;
        }
        System.out.println();
        System.out.println("Ход № " + countMoves);
        renderer.render(worldMap);
    }

    private void initSimulation(WorldMap worldMap) {
        EntityPlacerAction.placeEntities(entities, worldMap);
    }

    private void nextTurn(WorldMap worldMap) {  //просимулировать и отрендерить один ход
        movementAction.makeCreaturesMove(worldMap);
        waveSpawnerAction.spawnWave(worldMap);
    }

    private void startInputListener(Scanner scanner) {
        Thread inputThread = new Thread(() -> {
            while (running) {
                String input = scanner.nextLine();

                if (input.isEmpty()) {
                    paused = !paused;

                    if (paused) {
                        System.out.println("⚓ Симуляция остановлена");
                    } else {
                        System.out.println("⛵Симуляция продолжена");
                    }
                }

                if (!input.isEmpty()) {
                    if (input.equalsIgnoreCase("e")) {
                        running = false;
                        System.out.println("Выход из симуляции");
                    } else {
                        SimulationMenu.printWarning();
                    }
                }
            }
        });
        inputThread.setDaemon(true);
        inputThread.start();
    }

    private void waitIfPaused() {
        while (paused && running) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Ошибка паузы");
            }
        }
    }
}
