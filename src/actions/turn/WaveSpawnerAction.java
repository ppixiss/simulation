package actions.turn;

import entities.Wave;
import world.Position;
import world.WorldMap;

public class WaveSpawnerAction {
    public static final int WAVES_TO_SPAWN = 2;

    public void spawnWave(WorldMap worldMap) {
        if (!worldMap.hasWave()) {
            int count = 0;
            while (count < WAVES_TO_SPAWN) {
                worldMap.setEntity(Position.getRandomPosition(worldMap), new Wave());
                count++;
            }
        }
    }
}
