package actions.turn;

import entities.creatures.Creature;
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
    Set<Creature> movedCreatures = new HashSet<>();

    public void makeCreaturesMove(WorldMap worldMap) {
        creaturesPositions.clear();
        movedCreatures.clear();
        saveCreaturesPositions(worldMap);

        for (Position currentPosition : creaturesPositions) {
            Creature currentCreature = (Creature) worldMap.getEntityAt(currentPosition);

            if (movedCreatures.contains(currentCreature)) {
                continue;
            }

            if (currentCreature == null) {
                continue;
            }

            currentCreature.makeMove(worldMap, currentPosition);
            movedCreatures.add(currentCreature);
        }
    }

    private void saveCreaturesPositions(WorldMap worldMap) {
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
        if (shortestWay.isEmpty()) {
            return position;
        }
        return pathFinder.findNextCell(shortestWay);
    }
}



