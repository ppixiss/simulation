package world;

import entities.Entity;
import entities.creatures.Prey;
import path.MapPathFinder;

import java.util.List;
import java.util.Map;

public class WorldValidator {

    public static boolean isWorldValid(WorldMap worldMap) {
        for (Map.Entry<Position, Entity> entry : worldMap.getEntries()) {
            Position position = entry.getKey();
            Entity entity = entry.getValue();

            if (entity instanceof Prey) {
                List<Position> wayToTarget = MapPathFinder.computePathToTarget(position, worldMap);

                if (wayToTarget.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}
