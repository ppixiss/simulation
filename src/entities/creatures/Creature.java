package entities.creatures;

import entities.Entity;
import world.Position;
import world.WorldMap;

public abstract class Creature extends Entity {

    public abstract void makeMove(WorldMap worldMap, Position currentPosition);

    public abstract boolean canEat(Entity entity);
}
