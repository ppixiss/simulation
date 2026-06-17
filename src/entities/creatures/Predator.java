package entities.creatures;

import actions.turn.CreatureMovementAction;
import entities.Entity;
import path.MapPathFinder;
import world.Position;
import world.WorldMap;

import java.util.List;

public class Predator extends Creature {
    public static final int SPEED = 2;
    public static final int ATTACK_POWER = 50;

    @Override
    public void makeMove(WorldMap worldMap, Position currentPosition) {
        int count = 0;
        MapPathFinder pathFinder = new MapPathFinder();

        while (count < SPEED) {
            List<Position> shortestPath = MapPathFinder.computePathToTarget(currentPosition, worldMap);
            Position nextCell = CreatureMovementAction.getNextCell(
                    currentPosition,
                    shortestPath,
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

    @Override
    public boolean canEat(Entity entity) {
        return entity instanceof Prey;
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
}
