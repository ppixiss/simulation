package entities;

import actions.turn.CreatureMovementAction;
import path.MapPathFinder;
import world.Position;
import world.WorldMap;

import java.util.List;

public class Prey extends Creature {
    public int SPEED = 1;
    public int hp = 100;
    private int boostedTurns = 0;

    @Override
    public void makeMove(WorldMap worldMap, Position currentPosition) {
        int count = 0;
        MapPathFinder pathFinder = new MapPathFinder();

        while (count < getSPEED()) {
            List<Position> shortestWay = MapPathFinder.createShortestWay(currentPosition, worldMap);
            Position nextCell = CreatureMovementAction.getNextCell(
                    currentPosition,
                    shortestWay,
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

    private int getSPEED() {
        return SPEED + (boostedTurns > 0 ? 1 : 0);
    }

    private void updateEffects() {
        if (boostedTurns > 0) {
            boostedTurns--;
        }
    }
}
