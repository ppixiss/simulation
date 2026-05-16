package entities;

import actions.turn.CreatureMovementAction;
import path.MapPathFinder;
import world.Position;
import world.WorldMap;

import java.util.List;

public class Prey extends Creature {
    public static final int SPEED = 1;
    //Стремятся найти ресурс, может потратить свой ход на движение в сторону травы, либо на её поглощение.

    @Override
    public void makeMove(WorldMap worldMap, Position currentPosition) {
        int count = 0;
        MapPathFinder pathFinder = new MapPathFinder();

        while (count < SPEED) {
            List<Position> shortestWay = MapPathFinder.createShortestWay(currentPosition, worldMap);
            Position nextCell = CreatureMovementAction.getNextCell(
                    currentPosition,
                    shortestWay,
                    pathFinder);

            if (canEat(worldMap.getEntityAt(nextCell))) {
                worldMap.removeEntity(currentPosition);
                worldMap.setEntity(nextCell, this);

                return;
            } else {
                worldMap.removeEntity(currentPosition);
                worldMap.setEntity(nextCell, this);

                currentPosition = nextCell;

                count++;
            }
        }
    }

    @Override
    public boolean canEat(Entity entity) {
        return entity instanceof Wave;
    }
}
