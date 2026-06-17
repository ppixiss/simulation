package actions.turn;

import entities.environment.Wave;
import world.Position;
import world.Simulation;
import world.WorldMap;

public class WaveSpawnerAction {
    public static final int WAVES_TO_SPAWN = 3;

    public void spawnWave(WorldMap worldMap) {
        if (Simulation.countMoves % 4 == 0) {
            int count = 0;
            while (count < WAVES_TO_SPAWN) {
                worldMap.setEntity(Position.getRandomPosition(worldMap), new Wave());
                count++;
            }
        }
    }
}
