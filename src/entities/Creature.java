package entities;

import world.Position;
import world.WorldMap;

public abstract class Creature extends Entity {
    public int speed;
    public int hp;

    public abstract void makeMove(WorldMap worldMap, Position currentPosition);

    public abstract boolean canEat(Entity entity);
}
