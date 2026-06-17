package entities.creatures;

import actions.turn.CreatureMovementAction;
import entities.Entity;
import path.MapPathFinder;
import world.Position;
import world.WorldMap;

import java.util.List;

public class Predator extends Creature {
    public static final int SPEED = 1;  //Нужно ли делать через psf?
    public static final int ATTACK_POWER = 25;
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
                Entity target = worldMap.getEntityAt(nextCell);

                if (isPreyEaten(target)) {
                    worldMap.moveEntity(currentPosition, nextCell, this);
                    return;
                } else {
                    attack(target);
                    count++;
                }

            } else {
                worldMap.moveEntity(currentPosition, nextCell, this);
                currentPosition = nextCell;
                count++;
            }
        }
    }

    private boolean isPreyEaten(Entity target) {
        if (target instanceof Prey prey) {
            return prey.isEaten();
        }
        return false;
    }

    private void attack(Entity target) {
        if (target instanceof Prey prey) {
            prey.takeDamage(ATTACK_POWER);
        }
    }

    @Override
    public boolean canEat(Entity entity) {
        return entity instanceof Prey;
    }
}
