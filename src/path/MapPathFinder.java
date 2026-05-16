package path;

import entities.Creature;
import entities.Entity;
import world.Position;
import world.WorldMap;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapPathFinder {
    static Position target;

    public Position findNextCell(List<Position> path) {
        return path.remove(0);
    }

    public static List<Position> createShortestWay(Position position, WorldMap worldMap) {
        List<Position> path = new ArrayList<>();
        Map<Position, Position> parent = findShortestWay(position, worldMap);

        Position current = target;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);

        if (!path.isEmpty()) {
            path.remove(0);
        }
        return path;
    }

    private static Map<Position, Position> findShortestWay(Position start, WorldMap worldMap) {
        Set<Position> visitedCells = new HashSet<>();
        Deque<Position> processingQueue = new ArrayDeque<>();
        Map<Position, Position> parent = new HashMap<>();

        Creature currentCreature = (Creature) worldMap.getEntityAt(start);

        visitedCells.add(start);
        processingQueue.add(start);

        while (hasCellsToVerify(processingQueue)) {
            Position current = processingQueue.poll();

            if (isEatable(current, currentCreature, worldMap)) {
                target = current;
                break;
            }

            for (Position neighborCell : findNeighborCells(current)) {

                if (canCreaturePass(neighborCell, worldMap, currentCreature)) {
                    if (!visitedCells.contains(neighborCell)) {
                        visitedCells.add(neighborCell);
                        processingQueue.add(neighborCell);
                        parent.put(neighborCell, current);
                    }
                }
            }
        }
        return parent;
    }

    private static boolean canCreaturePass(Position neighborCell, WorldMap worldMap, Creature currentCreature) {
        return worldMap.isCellEmpty(neighborCell) || isEatable(neighborCell, currentCreature, worldMap);
    }

    private static boolean hasCellsToVerify(Deque<Position> processingQueue) {
        return !processingQueue.isEmpty();
    }

    private static boolean isEatable(Position position, Creature creature, WorldMap worldMap) {
        Entity target = worldMap.getEntityAt(position);
        return target != null && creature.canEat(target);
    }

    private static Set<Position> findNeighborCells(Position position) {
        Set<Position> neighborCells = new HashSet<>();
        int x = position.getX();
        int y = position.getY();

        Position[] adjacentCells = {
                new Position(x, y + 1),
                new Position(x + 1, y),
                new Position(x, y - 1),
                new Position(x - 1, y)
        };

        for (Position currentCell : adjacentCells) {
            if (x >= 0 && x < WorldMap.HORIZONTAL_SIZE && y >= 0 && y < WorldMap.VERTICAL_SIZE) {
                neighborCells.add(currentCell);
            }
        }
        return neighborCells;
    }
}
