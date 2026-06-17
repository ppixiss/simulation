package entities.creatures;

import actions.turn.CreatureMovementAction;
import entities.Entity;
import entities.environment.Wave;
import path.MapPathFinder;
import world.Position;
import world.WorldMap;

import java.util.List;

public class Prey extends Creature {
    public static int speed = 1;
    public int hp = 100;
    private int boostedTurns = 0;

    @Override
    public void makeMove(WorldMap worldMap, Position currentPosition) {
        int count = 0;
        MapPathFinder pathFinder = new MapPathFinder();

        while (count < getSpeed()) {
            List<Position> shortestPath = MapPathFinder.computePathToTarget(currentPosition, worldMap);
            Position nextCell = CreatureMovementAction.getNextCell(
                    currentPosition,
                    shortestPath,
                    pathFinder);

            if (canEat(worldMap.getEntityAt(nextCell))) {
                worldMap.moveEntity(currentPosition, nextCell, this);
                boostedTurns++;

                return;
            } else {
                worldMap.moveEntity(currentPosition, nextCell, this);

                currentPosition = nextCell;

                count++;
            }
        }
        updateEffects();
    }

    public boolean isEaten() {
        return hp <= 0;
    }

    public void takeDamage(int attackPower) {
        hp -= attackPower;
    }

    @Override
    public boolean canEat(Entity entity) {
        return entity instanceof Wave;
    }

    private int getSpeed() {
        return speed + (boostedTurns > 0 ? 1 : 0);
    }

    private void updateEffects() {
        if (boostedTurns > 0) {
            boostedTurns--;
        }
    }
}
