package entities;

import actions.turn.CreatureMovementAction;
import path.MapPathFinder;
import world.Position;
import world.WorldMap;

import java.util.List;

public class Predator extends Creature {
    public static final int SPEED = 2;  //Нужно ли делать через psf?
    public int attackPower;

    //Хищник стремится приблизиться к добыче, ход может потратить на перемещение или атаку(соседняя клетка)

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
        return entity instanceof Prey;
    }
}
