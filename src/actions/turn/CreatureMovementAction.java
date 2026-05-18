package actions.turn;

import entities.Creature;
import entities.Entity;
import path.MapPathFinder;
import world.Position;
import world.WorldMap;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CreatureMovementAction {
    Queue<Position> creaturesPositions = new ArrayDeque<>();
    Set<Creature> movedCreature = new HashSet<>();

    public void makeCreaturesMove(WorldMap worldMap) {
        creaturesPositions.clear();
        movedCreature.clear();
        collectCreaturesPositions(worldMap);

        for (Position currentPosition : creaturesPositions) {
            Creature currentEntity = (Creature) worldMap.getEntityAt(currentPosition);

            if (movedCreature.contains(currentEntity)) {
                continue;
            }

            if (currentEntity == null) {
                continue;
            }

            currentEntity.makeMove(worldMap, currentPosition);
            movedCreature.add(currentEntity);
        }
    }

    private void collectCreaturesPositions(WorldMap worldMap) {
        for (Map.Entry<Position, Entity> entry : worldMap.getEntries()) {
            Position currentPosition = entry.getKey();
            Entity currentEntity = entry.getValue();

            if (currentEntity instanceof Creature) {
                creaturesPositions.add(currentPosition);
            }
        }
    }

    public static Position getNextCell(Position position,
                                       List<Position> shortestWay,
                                       MapPathFinder pathFinder) {
        // проверка пустоты пути
        if (shortestWay.isEmpty()) {
            return position;
        }
        return pathFinder.findNextCell(shortestWay);
    }
}



